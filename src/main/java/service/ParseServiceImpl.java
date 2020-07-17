package service;

import model.Line;
import model.Question;
import response.ParseResponse;
import response.ParseResponseWrapper;
import response.ParseResult;

import java.util.*;

public class ParseServiceImpl implements ParseService{

    /**
     * This method returns list<>question</> and their respective answers from the paragraph
     * @param questions : List<>questions</>
     * @param statementLines : list of all lines from the paragraph (excluding questions and final answer)
     * @return
     */
    @Override
    public List<ParseResult> getStatementsFromParagraph(List<Question> questions, List<String> statementLines) {

        List<ParseResult> parseResponses = new ArrayList<>();

        if (questions.size() == 0 || statementLines.size() == 0)
            return parseResponses;

        questions.stream().forEach(question -> {
            List<String> keywords = question.getKeyWords();
            PriorityQueue<Line> priorityQueue = createMaxHeap();
            statementLines.stream().forEach(statement -> {

                getValuesToBuildHeap(keywords, priorityQueue, statement, statement);
            });
            Line line = priorityQueue.poll();
            ParseResult parseResult =
                    new ParseResult(question.getQuestion(), line != null ? line.getLine() : "");
            parseResponses.add(parseResult);
        });

        return parseResponses;
    }

    private void getValuesToBuildHeap(List<String> keywords, PriorityQueue<Line> priorityQueue, String statement, String statement2) {
        int score = numKeywordPresent(keywords, statement);
        if (score != 0) {
            Line line = new Line(statement2, score);
            priorityQueue.add(line);
        }
    }

    /**
     * This method calculates maximum matching score between long answers from paragraph obtained in method getStatementsFromParagraph() and
     * List<>answers</> given at the end of the paragraph.
     * @param answers
     * @param parseResults
     * @return
     */
    @Override
    public ParseResponseWrapper getAnswerForQuestion(List<String> answers, List<ParseResult> parseResults) {
        List<ParseResponse> parseResponses = new ArrayList<>();
        ParseResponseWrapper parseResponseWrapper = new ParseResponseWrapper();
        PriorityQueue<Line> priorityQueue = createMaxHeap();
        answers.stream().forEach(answer -> {
            parseResults.stream().forEach(parseResult -> {
                getValuesToBuildHeap(Collections.singletonList(answer), priorityQueue, parseResult.getAnswerFromParagraph(), parseResult.getQuestion());
            });
            Line line = priorityQueue.poll();
            ParseResponse parseResponse = new ParseResponse(line != null ? line.getLine() : "", answer);
            parseResponses.add(parseResponse);
            parseResponseWrapper.setParseResponses(parseResponses);
        });
        return parseResponseWrapper ;
    }

    /**
     * This method creates max heap. Lines having maximum matching keywords comes first.
     * @return
     */
    private PriorityQueue<Line> createMaxHeap() {
        return new PriorityQueue<>(new Comparator<Line>() {
            @Override
            public int compare(Line o1, Line o2) {
                return o2.getScore() - o1.getScore();
            }
        });
    }

    /**
     * This method returns maximum number of matching keyword in a statement.
     * @param keywords
     * @param statement
     * @return
     */
    private int numKeywordPresent(List<String> keywords, String statement) {
        int count = 0;
        for (String key : keywords) {
            if(statement.toLowerCase().indexOf(key.toLowerCase()) != -1)
                count++;
        }
        return count;
    }
}
