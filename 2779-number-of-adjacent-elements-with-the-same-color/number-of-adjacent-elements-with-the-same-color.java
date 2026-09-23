class Solution {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n]; // Defaults to 0 (uncolored)
        int[] answer = new int[queries.length];
        
        int matchingPairs = 0;
        
        for (int i = 0; i < queries.length; i++) {
            int index = queries[i][0];
            int newColor = queries[i][1];
            int oldColor = colors[index];
            
            // If the color isn't actually changing, the pair count won't change
            if (oldColor != newColor) {
                
                // 1. Check if we are breaking any existing matches (Ignore uncolored 0s)
                if (oldColor != 0) {
                    // Check Left
                    if (index > 0 && colors[index - 1] == oldColor) {
                        matchingPairs--;
                    }
                    // Check Right
                    if (index < n - 1 && colors[index + 1] == oldColor) {
                        matchingPairs--;
                    }
                }
                
                // 2. Change the color
                colors[index] = newColor;
                
                // 3. Check if we are creating any new matches
                if (newColor != 0) {
                    // Check Left
                    if (index > 0 && colors[index - 1] == newColor) {
                        matchingPairs++;
                    }
                    // Check Right
                    if (index < n - 1 && colors[index + 1] == newColor) {
                        matchingPairs++;
                    }
                }
            }
            
            // Record the running total for this query
            answer[i] = matchingPairs;
        }
        
        return answer;
    }
}