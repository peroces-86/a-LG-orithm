import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        // 옷의 종류를 담을 list
        List<String> sort = new ArrayList<>();
        
        // 각 옷 종류 별 개수를 담을 map
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < clothes.length; i++){
            if(!map.containsKey(clothes[i][1])){
                sort.add(clothes[i][1]);
                map.put(clothes[i][1], 1);
                continue;
            }
            map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
        }
        
        
        // (옷 종류별 갯수 + 1) 을 모두 곱한 후 -1을 return
        for(int i = 0; i < sort.size(); i++){
            answer *= map.get(sort.get(i)) + 1;
        }
        
        return answer-1;
    }
}