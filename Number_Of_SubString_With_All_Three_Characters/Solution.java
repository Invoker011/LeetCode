package Number_Of_SubString_With_All_Three_Characters;
import java.util.Arrays;
public class Solution {
    public int numberOfSubStrings(String s){
        int count = 0;
        int r = 0;
        int[] hash = new int[3];
        Arrays.fill(hash,-1);
        while(r < s.length()){
            hash[s.charAt(r) - 'a'] = r;
            if(hash[0] >= 0 && hash[1] >= 0 && hash[2] >=0){
                int minIndex = Math.min(hash[0], Math.min(hash[1], hash[2]));
                count += minIndex+1;
            }
            r++;
        }

        return count;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        String que = "bbacba";
        int result = sol.numberOfSubStrings(que);
        System.out.println(result);
    }
    
}
