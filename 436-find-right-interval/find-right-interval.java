class Solution {
    public int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        int[][] startsWithIndex = new int[n][2]; 

        for (int i = 0; i < n; i++) {
            startsWithIndex[i][0] = intervals[i][0];
            startsWithIndex[i][1] = i;
        }

       
        Arrays.sort(startsWithIndex, (a, b) -> a[0] - b[0]);

        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int target = intervals[i][1];
            int idx = binarySearchLowerBound(startsWithIndex, target);
            result[i] = (idx == -1) ? -1 : startsWithIndex[idx][1];
        }

        return result;
    }

   
    private int binarySearchLowerBound(int[][] startsWithIndex, int target) {
        int lo = 0, hi = startsWithIndex.length - 1;
        int result = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (startsWithIndex[mid][0] >= target) {
                result = mid;     
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return result;
    }
}