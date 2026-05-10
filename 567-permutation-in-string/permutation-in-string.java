class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] s1Counts = new int[26];
        int[] windowCounts = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Counts[s1.charAt(i) - 'a']++;
            windowCounts[s2.charAt(i) - 'a']++;
        }
        for(int i = s1.length(); i<s2.length();i++){
            if (Arrays.equals(s1Counts, windowCounts)) {
                return true;
            }
            char charEntering = s2.charAt(i);
            windowCounts[charEntering - 'a']++;
            char charLeaving = s2.charAt(i - s1.length());
            windowCounts[charLeaving - 'a']--;
        }
        return Arrays.equals(s1Counts, windowCounts);
    }
}