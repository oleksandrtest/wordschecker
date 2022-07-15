package edu.learning.words.services;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WordsService {
    public List<String> check(List<String> list) {
        String previous = "";
        int quantity = 0;
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);

            boolean isEmpty = current.isEmpty();

            if (isEmpty) {
                break;
            }

            if (i == 0 || current.substring(0, 1).equalsIgnoreCase(previous)) {
                previous = current.substring(current.length() - 1);
                quantity++;
            } else {
                break;
            }
        }
        return list.subList(0, quantity);
    }
}
