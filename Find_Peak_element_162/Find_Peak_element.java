package Find_Peak_element_162;

class Solution {
    public int findPeakElement(int[] nums) {
          int max= (nums.length-1)/2;
        int start = 0;
        int end = nums.length-1;
        

        while(start<end){
            int mid = start+(end-start)/2;
            
             if(nums[mid]<nums[mid+1]){
                start = mid+1;

            }
            else{
                end = mid;
            }
         
        }
        // for(int i =1;i<nums.length;i++){
        //     if(nums[i]>=nums[i-1]){
        //         max = i;
        //     }
        // }
        return start;
    }
}

