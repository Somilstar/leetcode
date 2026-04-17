class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int val = m+n;
        int j = 0;
            for(int i = m; i<val; i++){
                nums1[i] = nums2[j];
                j++;
            }
        bubleSort(nums1);
    }
      public static int [] bubleSort(int [] array){
        int n = array.length;
        for(int i =0; i<array.length-1; i++){
            for(int j=0; j<array.length-i-1; j++){
                if(array[j]> array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}