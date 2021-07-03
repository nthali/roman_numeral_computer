package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class RomanNumeralSorterTest {

    @Test
    void sort() {
        String romanNumeral = "IV";
        RomanNumeralSorter sorter = new RomanNumeralSorter();
        String actual = sorter.sort(romanNumeral);
        assertEquals("VI", actual);
    }
}
