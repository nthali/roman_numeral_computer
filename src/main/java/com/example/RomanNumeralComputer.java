package com.example;

import java.util.Map;

/**
 * The steps:
 * 1. Convert any subtractive notation to additive
 * 2. Combine the two numerals
 * 3. Sort symbols highest to lowest
 * 4. Simplify by replacing symbols right to left (VV to X etc.)
 * 5. Convert any additive to subtractive (IIII to IV etc)
 */
public class RomanNumeralComputer {

    // Compacts repeated numerals
    private final Map<String, String> compactor = Map.of(
        "IIII", "IV",
        "IIIII", "V",
        "VIIII", "IX",
        "VV", "X"
    );
    private final Map<String, String> uncompactor = Map.of(
        "IV", "IIII",
        "IX", "VIIII"
    );

    private static final String[][] equivalents = new String[][] {
        { "IIIII", "V" }
        , { "VV", "X" }
    };

    private static final String[][] toSubtractive = new String[][] {
        { "VIIII", "IX" }
        , { "IIII", "IV" }
    };

    private final RomanNumeralSorter sorter = new RomanNumeralSorter();
    private final RomanNumeralEquivalentor equivalentor = new RomanNumeralEquivalentor();

    public String add(String op1, String op2) {
        String rawSum = subtractiveToAdditive(op1) + subtractiveToAdditive(op2);
        String sortedRawSum = sorter.sort(rawSum);
        String compacted = equivalentor.simplify(sortedRawSum, equivalents);
        return equivalentor.simplify(compacted, toSubtractive);
    }

    /**
     * "Uncompacts" subtractive notations
     */
    private String subtractiveToAdditive(String op) {
        String uncompacted = uncompactor.get(op);
        if (uncompacted != null)
            return uncompacted;
        return op;
    }

}
