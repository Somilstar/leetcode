import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        
       
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int height = heights[stack.pop()];
                
               
                int width;
                if (stack.isEmpty()) {
                    width = i;
                } else {
                    width = i - stack.peek() - 1;
                }
                
                maxArea = Math.max(maxArea, height * width);
            }
           
            stack.push(i);
        }
        
        
        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            
            int width;
            if (stack.isEmpty()) {
                width = n;
            } else {
                width = n - stack.peek() - 1;
            }
            
            maxArea = Math.max(maxArea, height * width);
        }
        
        return maxArea;
    }
}