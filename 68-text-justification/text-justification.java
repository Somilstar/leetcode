import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int numOfLetters = 0;

        for (String word : words) {
            // Phase 1: Check if adding this word (and 1 space per existing word) exceeds maxWidth
            if (numOfLetters + word.length() + currentLine.size() > maxWidth) {
                
                // Phase 2: Format the full line
                int spacesToAdd = maxWidth - numOfLetters;
                StringBuilder lineBuilder = new StringBuilder();

                // Edge case: Only one word on the line, left-justify and pad the right
                if (currentLine.size() == 1) {
                    lineBuilder.append(currentLine.get(0));
                    for (int i = 0; i < spacesToAdd; i++) {
                        lineBuilder.append(" ");
                    }
                } else {
                    int gaps = currentLine.size() - 1;
                    int baseSpaces = spacesToAdd / gaps;
                    int extraSpaces = spacesToAdd % gaps;

                    for (int i = 0; i < gaps; i++) {
                        lineBuilder.append(currentLine.get(i));
                        
                        // Add the standard evenly-divided spaces
                        for (int j = 0; j < baseSpaces; j++) {
                            lineBuilder.append(" ");
                        }
                        
                        // Deal out the remainder spaces to the left-most gaps
                        if (extraSpaces > 0) {
                            lineBuilder.append(" ");
                            extraSpaces--;
                        }
                    }
                    // Add the final word of the line (no spaces after it)
                    lineBuilder.append(currentLine.get(currentLine.size() - 1));
                }

                result.add(lineBuilder.toString());
                currentLine.clear();
                numOfLetters = 0;
            }

            // Add the current word to the line tracker
            currentLine.add(word);
            numOfLetters += word.length();
        }

        // Phase 3: Format the very last line
        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < currentLine.size(); i++) {
            lastLine.append(currentLine.get(i));
            if (i < currentLine.size() - 1) {
                lastLine.append(" ");
            }
        }
        
        // Pad the right side until it hits maxWidth
        int remainingSpaces = maxWidth - lastLine.length();
        for (int i = 0; i < remainingSpaces; i++) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result;
    }
}