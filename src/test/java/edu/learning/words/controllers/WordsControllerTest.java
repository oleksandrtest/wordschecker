package edu.learning.words.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import edu.learning.words.controllers.request.InputRequest;
import edu.learning.words.services.WordsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class WordsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private WordsService wordService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void check() throws Exception {
        InputRequest request = new InputRequest(Arrays.asList("horse", "egg", "dolphin"));
        given(wordService.check(any()))
                .willAnswer((invocation) -> invocation.getArgument(0));

        ResultActions response = mockMvc.perform(post("/words")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)));

        response.andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.words", is(request.getWords())));
    }
}
