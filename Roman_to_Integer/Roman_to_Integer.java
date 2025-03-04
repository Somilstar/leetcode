package Roman_to_Integer;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int romanToInt(String s) {
        Map<Character,Integer> m = new HashMap<>();

m.put('I',1);
m.put('V',5);
m.put('X',10);
m.put('L',50);
m.put('C',100);
m.put('D',500);
m.put('M',1000);
int total=0;
for(int i=0; i<s.length()-1; i++){
    if(m.get(s.charAt(i))<m.get(s.charAt(i+1))){
        total = total- m.get(s.charAt(i));
    }
    else{
        total= total + m.get(s.charAt(i));
    }
    
}
return total = total+ m.get(s.charAt(s.length()-1));





    }
}