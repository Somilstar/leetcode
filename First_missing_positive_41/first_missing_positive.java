package First_missing_positive_41;

class Solution {
    public int firstMissingPositive(int[] nums) {
           int i =0;
           int count  =1;

         
        while(i<nums.length){

            
int correct = nums[i]-1;
            if(nums[i]>0&& nums[i]<nums.length&& nums[i]!=nums[correct]){
swap(nums,i,correct);
            }
            else{ 
                i++;
            }
              
        }

for(int j =0; j<nums.length; j++){
          if(j+1!=nums[j]){
              return j+1;
          }
         
           
        }
       return nums.length+1;
    }
    public void swap(int []nums, int i, int correct){
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
    }
}