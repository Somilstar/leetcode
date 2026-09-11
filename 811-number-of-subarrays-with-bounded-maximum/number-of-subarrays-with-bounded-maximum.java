class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int ans =0;
        int invalidIdx = -1;
        int validIdx = -1;

        for(int i =0; i<nums.length; i++){
            if(nums[i]>right){
                invalidIdx = i;
                validIdx = -1;

            }else if(nums[i]>=left){
                validIdx = i;
            }
            if (validIdx != -1) {
                ans += validIdx - invalidIdx;
            }
        }
        return ans;
    }
}