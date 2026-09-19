class Solution {
    public boolean isPalindrome(int x) {
        if(x<0 || (x%10==0 && x!=0)){
            return false;
        }
        int orignalnum = x;
        int newnum = 0;
        while(x>0){
            int lastdigit = x%10;
            newnum = (newnum *10) + lastdigit;
            x = x/10;
        }
        return orignalnum == newnum;
    }
}