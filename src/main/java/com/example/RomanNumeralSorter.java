package com.example;

import java.util.List;
import java.util.stream.Collectors;

public class RomanNumeralSorter {

    private static final List<Character> romanNumerals = List.of( 'I', 'V', 'X', 'L', 'C', 'D', 'M');

    public String sort(String romanNumeral) {
        return romanNumeral
            .chars()
            .mapToObj(c -> (char)c)
            .collect(Collectors.toList())
            .stream()
            .sorted((c1, c2) -> { return romanNumerals.indexOf(c2) - romanNumerals.indexOf(c1); })
            .map(String::valueOf)
            .collect(Collectors.joining());
    }

}
