import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<Integer> prefixes = new HashSet<>();
        
        // Step 1: Store all possible prefixes from arr1
        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10; // Chop off the last digit to get the next prefix
            }
        }
        
        int maxLength = 0;
        
        // Step 2: Check prefixes of arr2 against our set
        for (int num : arr2) {
            while (num > 0) {
                // If the set has this prefix, we found a match!
                if (prefixes.contains(num)) {
                    // Calculate how many digits long this prefix is
                    int currentLength = String.valueOf(num).length();
                    
                    // Update our overall maximum length
                    if (currentLength > maxLength) {
                        maxLength = currentLength;
                    }
                    
                    // Stop chopping this number, we already found its longest match
                    break; 
                }
                
                // If no match, chop off the last digit and try again
                num /= 10; 
            }
        }
        
        return maxLength;
    }
}