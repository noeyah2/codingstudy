class Solution {
    public int solution(String word) {
        int cnt = 0;
        String vowel = "AEIOU";
        
        int[] arr = new int[vowel.length() + 1];
        
        for(int i=vowel.length() - 1 ; i>=0 ; i--){
            arr[i] = arr[i+1] * 5 + 1;
        }
        
        for(int i=0 ; i<word.length() ; i++){
            cnt += arr[i] * vowel.indexOf(word.charAt(i));
        }
        
        return cnt + word.length();
    }
}
