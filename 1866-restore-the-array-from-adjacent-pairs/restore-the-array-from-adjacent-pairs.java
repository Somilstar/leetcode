import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        // Step 1: Build the adjacency list graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for (int[] pair : adjacentPairs) {
            // computeIfAbsent is a great Java shortcut to avoid writing if-statements for missing keys
            graph.computeIfAbsent(pair[0], k -> new ArrayList<>()).add(pair[1]);
            graph.computeIfAbsent(pair[1], k -> new ArrayList<>()).add(pair[0]);
        }
        
        // Step 2: Find the starting node (a node with only 1 neighbor)
        int startNode = 0;
        for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            if (entry.getValue().size() == 1) {
                startNode = entry.getKey();
                break;
            }
        }
        
        // Step 3: Reconstruct the original array
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        
        // Set the first item
        result[0] = startNode;
        
        // Set the second item (since the start node only has 1 neighbor, it's safe to grab index 0)
        if (n > 1) {
            result[1] = graph.get(startNode).get(0);
        }
        
        // Loop through the rest of the array
        for (int i = 2; i < n; i++) {
            List<Integer> neighbors = graph.get(result[i - 1]);
            
            // Every node (except ends) has exactly 2 neighbors. 
            // We just need to pick the neighbor that ISN'T the one we just came from.
            // The node we just came from is stored at result[i - 2].
            if (neighbors.get(0) == result[i - 2]) {
                result[i] = neighbors.get(1);
            } else {
                result[i] = neighbors.get(0);
            }
        }
        
        return result;
    }
}