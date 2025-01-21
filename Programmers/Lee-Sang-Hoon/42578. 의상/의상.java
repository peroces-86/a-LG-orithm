import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        
        for (String[] cloth : clothes) { //의상의 종류만 필요하므로 cloth[1]만 사용
            String type = cloth[1]; //의상의 종류
            clothesMap.put(type, clothesMap.getOrDefault(type, 0) + 1); //같은 종류의 의상이 있으면 +1
        }
        
        int combinations = 1; //조합의 수
        for (int count : clothesMap.values()) { //의상의 종류별 의상의 수
            combinations *= (count + 1); //해당 종류의 의상을 입지 않는 경우를 포함하기 위해 +1
        }
        
        return combinations - 1; //모두 안 입는 경우는 제외
    }
}
