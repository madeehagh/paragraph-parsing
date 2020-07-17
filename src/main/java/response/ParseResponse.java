package response;

import lombok.Data;

@Data
public class ParseResponse {
    String question;
    String answer;

    public ParseResponse(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "ParseResponse{" +
                "question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }
}
