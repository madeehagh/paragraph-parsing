package model;

import lombok.Data;

import java.util.List;

@Data
public class Question {
    String question;
    List<String> keyWords;

    public Question(String question, List<String> keyWords) {
        this.question = question;
        this.keyWords = keyWords;
    }
}
