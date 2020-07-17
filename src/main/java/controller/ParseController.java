package controller;

import model.Question;
import response.ParseResponseWrapper;
import response.ParseResult;
import service.ParseService;
import service.ParseServiceImpl;

import java.util.List;

public class ParseController {

    ParseService parseService;

    public ParseController() {
        this.parseService = new ParseServiceImpl();
    }

    public ParseResponseWrapper getMatchingLineForQuestion(List<Question> questions,
                                                           List<String> statementLines,
                                                           List<String> answers) {

        ParseResponseWrapper parseResponseWrapper = new ParseResponseWrapper();

        List<ParseResult> parseResults = parseService.getStatementsFromParagraph(questions, statementLines);

        if (parseResults.size() == 0 || parseResults.isEmpty())
            return parseResponseWrapper;

        parseResponseWrapper = parseService.getAnswerForQuestion(answers, parseResults);

        return parseResponseWrapper;
    }
}
