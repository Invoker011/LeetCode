package length_of_Last_word;

public class Solution {
        public int lengthOfLastWord(String s) {
        String newString = s.trim();
        int n = newString.length()-1;
        int length = 0;
        for(int i = n; i>=0;i--){
            length+=1;
            if(newString.charAt(i) ==' ' && i != 0) {
                length -=1;
                break;
            }
        }
        return length;
    }
    
}
