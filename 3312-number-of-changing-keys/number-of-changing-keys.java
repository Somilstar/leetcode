class Solution {
    public int countKeyChanges(String s) {
        int changes = 0;
        for(int i = 1; i<s.length(); i++){
            char current = Character.toLowerCase(s.charAt(i));
            char previous = Character.toLowerCase(s.charAt(i-1));
            if(current!=previous){
                changes++;
            }
        }
        return changes;
    }
}