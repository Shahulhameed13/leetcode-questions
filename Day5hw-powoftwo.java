class Solution {
    public boolean isPowerOfTwo(int n) {
        // A power of two has exactly one set bit in binary
        return n > 0 && (n & (n - 1)) == 0;
    }
}
