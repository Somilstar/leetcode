import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        
        for (String token : tokens) {
           
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    
                    int bSub = stack.pop();
                    int aSub = stack.pop();
                    stack.push(aSub - bSub);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                   
                    int bDiv = stack.pop();
                    int aDiv = stack.pop();
                    stack.push(aDiv / bDiv);
                    break;
                default:
                  
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        
       
        return stack.pop();
    }
}