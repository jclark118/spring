package com.squares.example.squares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.squares.Greeting;

@RestController
public class GreetingController {

    /* Take in a list of names, create a 10x10 list of those names shuffled into random order */
    @GetMapping("/greeting")
    public List<List<String>> greeting(@RequestParam(value = "names", defaultValue = "John,Jane,Bob") List<String> names) {
        Collections.shuffle(names);
        List<List<String>> rows = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            List<String> shuffledNames = new ArrayList<>(names);
            Collections.shuffle(shuffledNames);
            rows.add(shuffledNames);
        }

        return rows;
      }
}