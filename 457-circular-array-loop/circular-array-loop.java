class Solution {
public boolean circularArrayLoop(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            int slow = i;
            int fast = i;
            boolean isForward = nums[i] > 0;
            while (true) {
                slow = getNextIndex(slow, nums);
                fast = getNextIndex(fast, nums);
                if ((nums[fast] > 0) != isForward) {
                    break; 
                }
                fast = getNextIndex(fast, nums);
                if (nums[slow] == 0 || nums[fast] == 0 || (nums[slow] > 0) != isForward || (nums[fast] > 0) != isForward) {
                    break;
                }
                if (slow == getNextIndex(slow, nums)) {
                    break;
                }
                if (slow == fast) {
                    return true;
                }
            }
            nums[i] = 0;
        }
        
        return false;
    }
    private int getNextIndex(int i, int[] nums) {
        int n = nums.length;
        int next = (i + nums[i]) % n;
        if (next < 0) {
            next = next + n;
        }
        return next;
    }
}