class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isincreasing = true;
        boolean isdecreasing = true;
        for(int i=1; i<nums.length; i++){
            if(nums[i]<nums[i-1]){
                isincreasing = false;
            }
            if(nums[i]>nums[i-1]){
                isdecreasing = false;
            }
        }
        return isincreasing || isdecreasing;
    }
}