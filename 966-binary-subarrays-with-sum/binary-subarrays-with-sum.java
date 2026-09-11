class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count =0;
        int currentSum =0;

        int[] prefixCounts = new int[nums.length+1];
        prefixCounts[0] =1;

        for(int num:nums){
            currentSum += num;

            if(currentSum - goal >=0){
                count += prefixCounts[currentSum - goal];
            }
            prefixCounts[currentSum]++;
        }
        return count;
    }
}