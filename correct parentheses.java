import java.util.*;

class Solution {
    boolean solution(String s) {
        
        int cnt = 0;
        
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i=0 ; i<s.length() ; i++){
            
            char c = s.charAt(i);
            
            if(c == ')') {
                if (cnt == 0){
                    return false;
                }
                cnt--;
            } 
            
            if(c == '(') {
                cnt++;
            }
        }
        
        if (cnt != 0){
            return false;
        }

        return true;
    }
}
