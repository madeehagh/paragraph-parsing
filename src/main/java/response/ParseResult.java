package response;

import lombok.Data;

@Data
public class ParseResult {
    String question;
    String answerFromParagraph;

    public ParseResult(String question, String answerFromParagraph) {
        this.question = question;
        this.answerFromParagraph = answerFromParagraph;
    }
}
