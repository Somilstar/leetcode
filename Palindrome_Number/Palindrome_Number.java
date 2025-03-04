package Palindrome_Number;

class Solution {
    public boolean isPalindrome(int x) {
             if(x<0){
                 return false;
             }
             if(x==0){
                 return true;
             }
        String j = "";
        
        String jj = Integer.toString(x);
        while(x>0){
            int s = x%10;
            j = j + Integer.toString(s);
            x = x/10;
    }
    
    return j.equals(jj);
}
}