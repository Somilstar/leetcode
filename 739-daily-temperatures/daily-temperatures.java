import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        
       
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            int currentTemp = temperatures[i];
            
         
            while (!stack.isEmpty() && temperatures[stack.peek()] < currentTemp) {
               
                int prevDayIndex = stack.pop();
                
                
                answer[prevDayIndex] = i - prevDayIndex;
            }
          
            stack.push(i);
        }
        
        return answer;
    }
}