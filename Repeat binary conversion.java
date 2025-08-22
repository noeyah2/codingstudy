class Solution {
    public int[] solution(String s) {
        int[] ans = new int[2];
        
        while (!s.equals("1")) {
            for(int i=0 ; i<s.length() ; i++) {
                if(s.charAt(i) == '0') {
                    ans[1]++;
                }
            }
            s = s.replace("0", "");
            s = Integer.toBinaryString(s.length());
            ans[0] += 1;
        }
        
        return ans;
    }
}
