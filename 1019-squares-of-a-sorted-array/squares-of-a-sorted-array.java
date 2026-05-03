class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] sample = new int[nums.length];
        int start =0;
        int end = nums.length-1;
        int insertIndex = nums.length - 1;
        while(start<=end){
            if(nums[start]*nums[start] > nums[end]*nums[end]){
                sample[insertIndex] = nums[start]*nums[start];
                start++;
            }
            else{
                sample[insertIndex] = nums[end]*nums[end];
                end--;
            }
            insertIndex--;
            
        }
        return sample;

    }
}