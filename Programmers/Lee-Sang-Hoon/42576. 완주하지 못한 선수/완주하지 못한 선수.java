import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> hash = new HashMap<String, Integer>(); //크기를 participant.size로 하려다가 동명이인 때문에

        for (int i = 0; i < participant.length; i++) { //참가자 명단으로 작성
            hash.put(participant[i], hash.getOrDefault(participant[i], 0) + 1);
        }        

        for(int i = 0; i < completion.length; i++){ //작성된 해시맵을 탐색
            hash.put(completion[i],hash.get(completion[i]) - 1);
        }

        for(int i = 0; i<participant.length; i++){ //완주하지 못한 사람을 찾아서 반환
            if(hash.get(participant[i]) != 0){
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}
