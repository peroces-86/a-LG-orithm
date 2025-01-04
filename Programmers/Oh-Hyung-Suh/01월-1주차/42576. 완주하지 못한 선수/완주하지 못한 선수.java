import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {

        // 동명이인이 있을 수 있으므로 HashMap 선언
        HashMap<String, Integer> names = new HashMap<>();

        // participant가 completion 보다 항상 1이 크므로 participant를 HashMap에 넣기
        for (String p : participant) {
            names.put(p, names.getOrDefault(p, 0) + 1);
        }

        // completion 돌면서 HashMap 수정
        for (String c : completion) {
            if (names.get(c) == 1) {
                names.remove(c);
            } else {
                names.put(c, names.get(c) - 1);
            }
        }

        /*
         * 공식 문서 찾아서 keySet을 Array로 바꾼 후, findFirst한 Object를 get후 String으로 변환
         * names는 길이 1이니까 그냥 keySet for문 돌리고 answer 받아도 될 듯...
         */
        return Arrays.stream(names.keySet().toArray()).findFirst().get().toString();
    }
}