class Solution {
    public boolean isNumber(String s) {
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean expSeen = false;
        boolean digitAfterExp = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                digitSeen = true;

                if (expSeen) {
                    digitAfterExp = true;
                }

            } else if (c == '+' || c == '-') {
                // Sign is only allowed at the beginning or immediately after e/E
                if (i != 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }

            } else if (c == '.') {
                // Decimal point cannot appear after exponent or twice
                if (dotSeen || expSeen) {
                    return false;
                }
                dotSeen = true;

            } else if (c == 'e' || c == 'E') {
                // Exponent must have digits before it and only appear once
                if (expSeen || !digitSeen) {
                    return false;
                }
                expSeen = true;
                digitAfterExp = false;

            } else {
                return false;
            }
        }

        // Must have digits, and if exponent exists it must have digits after it
        return digitSeen && digitAfterExp;
    }
}
