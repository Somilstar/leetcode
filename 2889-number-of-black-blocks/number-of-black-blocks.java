import java.util.HashMap;
import java.util.Map;

class Solution {
    public long[] countBlackBlocks(int m, int n, int[][] coordinates) {
        // Map to store the number of black cells in a specific 2x2 block
        // Key: A unique Long ID for the block's top-left corner
        // Value: How many black cells are in this block
        Map<Long, Integer> blockCounts = new HashMap<>();
        
        for (int[] coord : coordinates) {
            int r = coord[0];
            int c = coord[1];
            
            // The 4 potential top-left corners of blocks that include this black cell
            int[][] possibleTopLefts = {
                {r, c}, 
                {r, c - 1}, 
                {r - 1, c}, 
                {r - 1, c - 1}
            };
            
            for (int[] topLeft : possibleTopLefts) {
                int x = topLeft[0];
                int y = topLeft[1];
                
                // Ensure the block is fully within the grid boundaries
                if (x >= 0 && x < m - 1 && y >= 0 && y < n - 1) {
                    // Create a unique ID for this block (x * columns + y)
                    long blockId = (long) x * n + y;
                    
                    // Increment the black cell count for this specific block
                    blockCounts.put(blockId, blockCounts.getOrDefault(blockId, 0) + 1);
                }
            }
        }
        
        // result[i] will store the number of blocks with exactly 'i' black cells
        long[] result = new long[5];
        
        // Tally up the blocks that have 1, 2, 3, or 4 black cells
        for (int count : blockCounts.values()) {
            result[count]++;
        }
        
        // Total possible 2x2 blocks in an m x n grid
        long totalBlocks = (long) (m - 1) * (n - 1);
        
        // Blocks with 0 black cells is just the total minus the ones we actually counted
        result[0] = totalBlocks - result[1] - result[2] - result[3] - result[4];
        
        return result;
    }
}