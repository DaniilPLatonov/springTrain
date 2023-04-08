package jacksonTrain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Post post = new Post(
                1,
                new Date(),
                "I learned how to use jackson!",
                10,
                Arrays.asList("Well done!", "Great job!")
        );

        ObjectMapper objectMapper = new ObjectMapper();
        String postAsString = null;
        try {
            postAsString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(post);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(postAsString);

        String inputJson = "{\"id\":1,\"createdDate\":1654027200000,\"content\":\"I learned how to use jackson!\",\"likes\":10,\"comments\":[\"Well done!\",\"Great job!\"]}\n";
        ObjectMapper objectMapper2 = new ObjectMapper();
        Post post2;
        try {
             post2 = objectMapper2.readValue(inputJson, Post.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(post2.toString());

    }
}
