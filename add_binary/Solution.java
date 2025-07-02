package add_binary;

public class Solution {
    public String addBinary(String a, String b) {
                StringBuilder result = new StringBuilder();

        int i = a.length() - 1;  // pointer for string a
        int j = b.length() - 1;  // pointer for string b
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0) {
                sum += a.charAt(i) - '0'; // convert char to int
                i--;
            }

            if (j >= 0) {
                sum += b.charAt(j) - '0'; // convert char to int
                j--;
            }

            result.append(sum % 2);     // add current binary digit
            carry = sum / 2;            // compute carry for next digit
        }

        return result.reverse().toString(); 
        
    }
    
}
