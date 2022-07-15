package edu.learning.words.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class WordsServiceTest {

    private WordsService wordsService;

    @BeforeEach
    public void before() {
        wordsService = new WordsService();
    }

    @Test
    void check1() {
        List<String> input = Arrays.asList(
                "fish",
                "horse",
                "egg",
                "goose",
                "eagle");

        List<String> expected = Arrays.asList(
                "fish",
                "horse",
                "egg",
                "goose",
                "eagle");

        List<String> result = wordsService.check(input);

        assertIterableEquals(expected, result);
    }

    @Test
    void check2() {
        List<String> input = Arrays.asList(
                "fish",
                "horse",
                "snake",
                "goose",
                "eagle");

        List<String> expected = Arrays.asList(
                "fish",
                "horse");

        List<String> result = wordsService.check(input);

        assertIterableEquals(expected, result);
    }

    @Test
    void check3() {
        List<String> input = Arrays.asList(
                "fish",
                "horse",
                "",
                "goose",
                "eagle");

        List<String> expected = Arrays.asList(
                "fish",
                "horse");

        List<String> result = wordsService.check(input);

        assertIterableEquals(expected, result);
    }

    @Test
    void check4() {
        List<String> input = Arrays.asList(
                "",
                "horse",
                "",
                "goose",
                "eagle");

        List<String> expected = Collections.emptyList();

        List<String> result = wordsService.check(input);

        assertIterableEquals(expected, result);
    }
}