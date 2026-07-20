class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Removed trailing semicolons
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // Fixed typo: changed numsa to nums
                if (nums[i] + nums[j] == target) {
                    // Correct Java syntax for returning a new array
                    return new int[]{i, j};
                }
            }
        }
        // Return an empty array if no match is found
        return new int[0]; 
    }
}
