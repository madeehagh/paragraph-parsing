package response;

import lombok.Data;

import java.util.List;

@Data
public class ParseResponseWrapper {
    List<ParseResponse> parseResponses;

    @Override
    public String toString() {
        return "ParseResponseWrapper{" +
                "parseResultList=" + parseResponses +
                '}';
    }
}
