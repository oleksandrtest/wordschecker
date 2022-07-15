package edu.learning.words.controllers;

import edu.learning.words.controllers.request.InputRequest;
import edu.learning.words.controllers.response.InputResponse;
import edu.learning.words.services.WordsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class WordsController {

    private final WordsService wordsService;

    public WordsController(WordsService wordsService) {
        this.wordsService = wordsService;
    }

    @PostMapping("/words")
    public InputResponse check(@RequestBody InputRequest model) {
        return new InputResponse(wordsService.check(model.getWords()));
    }
}
