package service;

import model.Question;
import response.ParseResponseWrapper;
import response.ParseResult;

import java.util.List;

public interface ParseService {

    public List<ParseResult> getStatementsFromParagraph(List<Question> questions, List<String> statementLines);

    public ParseResponseWrapper getAnswerForQuestion(List<String> answer, List<ParseResult> parseResults);
}
