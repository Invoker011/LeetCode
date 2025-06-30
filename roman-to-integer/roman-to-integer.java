import java.util.*;

class solution{
    public int romanToInt(String s){
        HashMap<Character, Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V', 5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D',500);
        roman.put('M',1000);

        int total = 0;
        int prevValue = 0;

        for(int i = s.length() -1;i>=0;i--){
            int current = s.charAt(i);
            if(prevValue > current){
                total -= current;
            }else{
                total +=current;
            }
            prevValue = current;
        }
        return total;
        
    }
}

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000