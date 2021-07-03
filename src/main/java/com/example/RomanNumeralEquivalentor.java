package com.example;

public class RomanNumeralEquivalentor {
    public String simplify(String sortedRawSum, String[][] equivalents) {
        StringBuilder intermediate = new StringBuilder();
        for ( String[] equivalent: equivalents ) {
            final int repeatedDigitPos = sortedRawSum.indexOf(equivalent[0]);
            if ( repeatedDigitPos != -1 ) {
                final int repeatedDigitLen = equivalent[0].length();
                intermediate
                        .append(stringBeforeEquivalentMatch(sortedRawSum, repeatedDigitPos))
                        .append(equivalent[1])
                        .append(stringAfterEquivalentMatch(sortedRawSum, repeatedDigitPos, repeatedDigitLen));
                sortedRawSum = intermediate.toString();
                intermediate = new StringBuilder();
            }
        }
        return sortedRawSum;
    }

    private String stringAfterEquivalentMatch(String sortedRawSum, int repeatedDigitPos, int repeatedDigitLen) {
        return repeatedDigitPos + repeatedDigitLen < sortedRawSum.length() ? sortedRawSum.substring(repeatedDigitPos + repeatedDigitLen) : "";
    }

    private String stringBeforeEquivalentMatch(String sortedRawSum, int repeatedDigitPos) {
        return repeatedDigitPos > 0 ? sortedRawSum.substring(0, repeatedDigitPos) : "";
    }
}
