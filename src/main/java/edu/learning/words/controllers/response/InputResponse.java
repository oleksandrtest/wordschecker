package edu.learning.words.controllers.response;

import java.util.List;

public class InputResponse {
    private List<String> words;

    public InputResponse(List<String> words) {

        this.words = words;
    }

    public InputResponse() {
    }

    public List<String> getWords() {

        return words;
    }
}
