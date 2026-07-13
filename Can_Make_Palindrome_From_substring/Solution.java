package Can_Make_Palindrome_From_substring;

import java.util.ArrayList;
import java.util.List;

public class Solution{
    public List<Boolean>possiblePalindrome(String s, int[][]queries){
        int n  =  s.length();

        int[][] prefix = new int[n+1][26];

        for(int i = 0; i < n; i++){
            for(int c =0; c< 26; c++){
                prefix[i+1][c] = prefix[i][c];
            }
            prefix[i+1][s.charAt(i) - 'a']++;
        }

        List<Boolean> answer = new ArrayList<>();
        for(int[] query:queries){
            int left = query[0];
            int right = query[1];
            int allowedReplacement = query[2];
            int oddCount =0;
            for(int c = 0; c<26; c++){
                int frequency = prefix[right +1][c] - prefix[left][c];

                if(frequency%2 ==1) oddCount++;
            }
            answer.add(allowedReplacement >= (oddCount/2));
        }


        return answer;
    }
}