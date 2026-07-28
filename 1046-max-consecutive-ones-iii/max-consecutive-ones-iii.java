class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // 1. Add the new element to our window
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // 2. If the window is invalid, shrink it from the left
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            
            // 3. The window is guaranteed valid here, record the max length
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}