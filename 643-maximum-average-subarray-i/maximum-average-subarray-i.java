class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int currentSum = 0;
        for(int i=0;i<k;i++){
            currentSum = currentSum + nums[i];
        }
        int maxSum = currentSum;
        for(int i=k;i<nums.length;i++){
            currentSum = currentSum - nums[i-k] + nums[i];
            maxSum = Math.max(maxSum,currentSum);
        }
        return (double) maxSum/k;
    }
}