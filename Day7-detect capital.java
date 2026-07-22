class Solution {
    public boolean detectCapitalUse(String word) {
        int capitals = 0;

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capitals++;
            }
        }

        return capitals == word.length() ||
               capitals == 0 ||
               (capitals == 1 && Character.isUpperCase(word.charAt(0)));
    }
}
