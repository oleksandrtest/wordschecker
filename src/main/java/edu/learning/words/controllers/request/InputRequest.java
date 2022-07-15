package edu.learning.words.controllers.request;

import java.util.List;

public class InputRequest {
    private List<String> words;

    public InputRequest(List<String> words) {

        this.words = words;
    }

    public InputRequest() {

    }

    public List<String> getWords() {

        return words;
    }
}
