package Peak_Index_Mountain_852;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int max= (arr.length-1)/2;
        int start = 0;
        int end = arr.length-1;
        

        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[mid]>arr[mid+1]&&arr[mid]>arr[mid-1]){
                return mid;
            }
            else if(arr[mid]<arr[mid+1]){
                start = mid+1;

            }
            else{
                end = mid;
            }
         
        }
        // for(int i =1;i<arr.length;i++){
        //     if(arr[i]>=arr[i-1]){
        //         max = i;
        //     }
        // }
        return -1;
    
    }
       
}
