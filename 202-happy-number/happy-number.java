class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        
        while(fast!=1 && sum(fast)!=1){
            slow = sum(slow);
             fast = sum(sum(fast));
            if(slow == fast){
                return false;
            }
        }
        return true;
    }
    public int sum(int num){
        int sum =0;
        while(num>0){
            int digit = num%10;
            sum += digit*digit;
            num = num/10;
        }
        return sum;
    }
}