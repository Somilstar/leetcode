class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> seen = new HashMap<>();

        for(int i =0; i<nums.length; i++){
            int current = nums[i];
            int complement = target - current;

            if(seen.containsKey(complement)){
                return new int []{seen.get(complement),i};
            }
            seen.put(current,i);
        }
        return new int[]{};
    }
}