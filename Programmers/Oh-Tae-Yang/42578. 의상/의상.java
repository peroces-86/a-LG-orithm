import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (String[] clothe : clothes) {
            String s1 = clothe[0];
            String s2 = clothe[1];
            
            map.put(s2, map.getOrDefault(s2, 1) + 1);
        }

        int answer = 1;
        for (int value : map.values()) {
                answer *= value;
        }
        return answer -1;

    }
}