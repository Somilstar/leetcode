package Two_Sum;

class Solution {
    
    public int[] twoSum(int[] nums, int target) {
        
        int [] jj = new int [2];
        for(int i =0;i<nums.length-1; i++){
            for(int j = i+1; j<nums.length;j++){
             if(nums[i]+nums[j]==target){
                 jj[0] = i;
                 jj[1] = j;
             }
            }
            
        }
        return jj;
    }
}