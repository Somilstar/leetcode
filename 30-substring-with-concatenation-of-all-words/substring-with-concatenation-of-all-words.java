class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int numWords = words.length;
        
        // 1. Build the reference "scoreboard" for our target words
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        // 2. Run the sliding window for each possible alignment
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int wordsUsed = 0;
            Map<String, Integer> windowCount = new HashMap<>();

            // Slide the window by wordLen chunks
            while (right + wordLen <= s.length()) {
                // Extract the next word chunk
                String currentWord = s.substring(right, right + wordLen);
                right += wordLen;

                // Case A: The word is one of our target words
                if (wordCount.containsKey(currentWord)) {
                    windowCount.put(currentWord, windowCount.getOrDefault(currentWord, 0) + 1);
                    wordsUsed++;

                    // If we have more copies of the word than needed, shrink from the left
                    while (windowCount.get(currentWord) > wordCount.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        windowCount.put(leftWord, windowCount.get(leftWord) - 1);
                        wordsUsed--;
                        left += wordLen;
                    }

                    // If our window size matches the total words required, it's a match!
                    if (wordsUsed == numWords) {
                        result.add(left);
                    }
                } 
                // Case B: The word is NOT a target word. The streak is broken.
                else {
                    windowCount.clear();
                    wordsUsed = 0;
                    left = right; // Fast-forward the left pointer
                }
            }
        }

        return result;
    }
}