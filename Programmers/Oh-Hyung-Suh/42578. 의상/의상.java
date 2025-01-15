import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;

        HashMap<String, Integer> clothesMap = new HashMap<>();

        // 입고, 안 입고 때문에 '+1' 해준다
        for(String[] cloth : clothes){
            clothesMap.put(cloth[1], clothesMap.getOrDefault(cloth[1], 0) + 1);
        }

        for(String variety : clothesMap.keySet()){
            answer *= (clothesMap.get(variety) + 1);
        }

        // 아무것도 안 입는 경우 제외
        return answer - 1;
    }
}