package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParseUtil {

    //TODO: Implement logic to derive base/root words in the list, say, zebra(s) in the given paragraph.
    // Hard-coded zebra(s) as it is frequent word for now.
    static String[] skipKeyWords = {"WHICH", "WHO", "WHAT", "THE", "IS", "ARE", "A", "OF", "THEIR", "TO", "ZEBRAS", "ZEBRA", "AND"};
    static List<String> skipKeys = Arrays.asList(skipKeyWords);


    /**
     * This method takes question as parameter and returns list<>keywords</> present in question.
     * @param question : question from the paragraph
     * @return
     */
    public static List<String> getKeywordsFromQuestion(String question) {

        List<String> keyWords = new ArrayList<>();
        if (ParseUtil.isEmpty(question))
            return keyWords;
        String[] quest = question.split("\\s");
        for (String str : quest) {
            if (skipKeys.contains(str.toUpperCase()))
                continue;
            keyWords.add(str);
        }
        return keyWords;
    }

    /**
     * This method tranforms String answer to List of Strings
     * @param answer : answer string from the paragraph ie; last line in paragraph
     * @return
     */
    public static List<String> parseAnswer(String answer) {
        List<String> answers = new ArrayList<>();
        if (ParseUtil.isEmpty(answer))
            return answers;
        String[] ansArray = answer.split(";");
        for (String str : ansArray) {
            answers.add(str);
        }
        return answers;
    }

    /**
     * This method tranforms String statement to List of Strings
     * @param statement : lines before question starts
     * @return
     */
    public static List<String> parseStatement(String statement) {
        List<String> statements = new ArrayList<>();
        if (ParseUtil.isEmpty(statement))
            return statements;
        String[] statementArray = statement.split("\\.");
        for (String st : statementArray)
            statements.add(st);

        return statements;
    }

    public static boolean isEmpty(String str) {
        if (str == null || str.length() == 0 || str.isEmpty())
            return true;
        return false;
    }
}
