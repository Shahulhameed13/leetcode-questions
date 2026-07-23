class Solution {
    public boolean squareIsWhite(String coordinates) {
        // Parentheses ensure addition happens before the modulo operation
        return (coordinates.charAt(0) + coordinates.charAt(1)) % 2 != 0;
    }
}

