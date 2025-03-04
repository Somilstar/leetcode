package Set_Mismatch_645;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findErrorNums(int[] nums) {
        List<Integer> ans = new ArrayList<>();
          int i =0;
         
        while(i<nums.length){

            
int correct = nums[i]-1;
            if(nums[i]!=nums[correct]){
swap(nums,i,correct);
            }
            else{ 
                i++;
            }
              
        }

for(int j =0; j<nums.length; j++){
            if(nums[j]!=j+1){
               return new int []{nums[j],j+1};
            }
           
        }
        return new int []{-1,-1};

    }


public void swap(int []nums, int i, int correct){
        int temp = nums[i];
        nums[i] = nums[correct];
        nums[correct] = temp;
    }


}