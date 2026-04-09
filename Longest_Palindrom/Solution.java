public class Solution {
    public int longestPalindrome(String s){
        int[] freq = new int[128];

        for(char c : s.toCharArray()){
            freq[c]++;
        }

        int length = 0;
        boolean isOdd = false;
        for(int count: freq){
            if(count % 2 ==0){
                length+= count;
            }else{
                length+=count-1;
                isOdd = true;
            }
        }
        
        return isOdd ? length+1: length;

    }
    
}
