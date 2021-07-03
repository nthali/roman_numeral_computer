package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralEquivalentorTest {

    private RomanNumeralEquivalentor equivalentor;

    @BeforeEach
    void setUp() {
        equivalentor = new RomanNumeralEquivalentor();
    }

    @Test
    void givenIIIII_ThenReturnV() {
        assertEquals( "V", equivalentor.simplify("IIIII", new String[][] { { "IIIII", "V" } }));
    }

    @Test
    void givenVV_ThenReturnX() {
        assertEquals( "X", equivalentor.simplify("VV", new String[][] { { "VV", "X" } } ));
    }

    @Test
    void givenVIIIII_ThenReturnX() {
        assertEquals( "X", equivalentor.simplify("VIIIII",
            new String[][] { {"IIIII", "V"}, { "VV", "X" } }));
    }
}
