class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[n * 2];
        int index = 0;
        
        // FIX 1: Run the loop up to n (the halfway mark)
        // FIX 2: Use .length instead of .lengths
        for (int i = 0; i < n; i++) {
            // FIX 3: Added missing semicolons
            result[index++] = nums[i];     // Places x_i
            result[index++] = nums[i + n]; // Places y_i
        }
        
        return result;
    }
}
