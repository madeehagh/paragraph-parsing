package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Line {
    String line;
    int score;

    public Line(String line, int score) {
        this.line = line;
        this.score = score;
    }
}
