import controller.ParseController;
import model.Question;
import response.ParseResponseWrapper;
import util.ParseUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ParsingMain {
    static int counter = 0;
    public static void main(String[] args) {

        String fileLoc = "src/main/resources/input.txt";

        Stream<String> lines = null;
        ParseResponseWrapper parseResponseWrapper = extractFileContent(fileLoc, lines);

        System.out.println("response " + parseResponseWrapper.toString());
    }

    private static ParseResponseWrapper extractFileContent(String fileLoc, Stream<String> lines) {

        List<Question> questions = new ArrayList<>();
        List<String> statementLines = new ArrayList<>();
        List<String> answers = new ArrayList<>();

        try {
            lines = Files.lines(Paths.get(fileLoc));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lines.forEach(line -> {
            counter++;
            switch (counter) {
                case 1:
                    statementLines.addAll(ParseUtil.parseStatement(line));
                    break;

                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    List<String> keywords = ParseUtil.getKeywordsFromQuestion(line.replace("?",""));
                    Question quest = new Question(line, keywords);
                    questions.add(quest);
                    break;

                case 7:
                    answers.addAll(ParseUtil.parseAnswer(line.trim()));
                    break;

                default:
                    break;
            }
        });

        ParseController parseController = new ParseController();
        ParseResponseWrapper parseResponseWrapper = parseController.getMatchingLineForQuestion(questions, statementLines, answers);
        return parseResponseWrapper;
    }


}
