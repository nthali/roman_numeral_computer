package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class RomanNumeralComputerTest {

    RomanNumeralComputer rnc;

    @BeforeEach
    void setUp() {
        rnc = new RomanNumeralComputer();
    }

    static Stream<Arguments> romanNumeralProvider() {
        return Stream.of(
            arguments("I", "I", "II")
            , arguments("I", "II", "III")
            , arguments("I", "III", "IV")
            , arguments("II", "III", "V")
            , arguments("I", "IV", "V")
            , arguments("I", "V", "VI")
            , arguments("IV", "IV", "VIII")
            , arguments("V", "IV", "IX")
            , arguments("III", "VI", "IX")
            , arguments("V", "V", "X")
            , arguments("I", "IX", "X")
            , arguments("VII", "IX", "XVI")
            , arguments("IX", "IX", "XVIII") // no code change was needed
            , arguments("X", "X", "XX") // no code change was needed
            , arguments("XII", "XII", "XXIV") // no code change was needed
        );
    }

    @ParameterizedTest
    @MethodSource("romanNumeralProvider")
    void testRomanNumeralAddition(String op1, String op2, String romanSum) {
        assertEquals(romanSum, rnc.add(op1, op2));
    }
}
