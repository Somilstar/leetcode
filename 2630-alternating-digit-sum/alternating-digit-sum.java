class Solution {
    public int alternateDigitSum(int n) {
        String s = String.valueOf(n);
        int sum = 0;
        int sign = 1;
        for(char c: s.toCharArray()){
            int digit = c - '0';
            sum += digit * sign;
            sign = sign * -1;
        }
        return sum;
    }
}