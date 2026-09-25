package Group_Anagram;
import java.util.*;
public class Solution {
    public List<List<String>> Group_Anagram_Up(String[] strgs){
        Map<String,List<String>> map = new HashMap<>();
        for(String str :  strgs){
            String sortstr = SortStr(str);
            map.putIfAbsent(sortstr,new ArrayList<>());
            map.get(sortstr).add(str);
        }
        return computeString(map);
    }

    private String SortStr(String str){
        char[] sortarray = str.toCharArray();
        Arrays.sort(sortarray);
        return new String(sortarray);
    }

    private List<List<String>> computeString(Map<String,List<String>>map){
        List<List<String>>result = new ArrayList<>();
        for(List<String> anagram : map.values()){
            result.add(anagram);
        }
        return result;
    }
}
