class Solution {
    public int subarraySum(int[] nums, int k) {
        int count =0;
        int currentSum = 0;

        HashMap<Integer,Integer> prefixCounts = new HashMap<>();

        prefixCounts.put(0,1);

        for(int num: nums){
            currentSum += num;

            if(prefixCounts.containsKey(currentSum-k)){
                count += prefixCounts.get(currentSum -k);
            }
            prefixCounts.put(currentSum,prefixCounts.getOrDefault(currentSum,0)+1);
        }
        return count;
    }
}