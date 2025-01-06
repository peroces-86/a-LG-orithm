import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant); //정렬
        Arrays.sort(completion); //정렬

        String answer = participant[participant.length-1];
        for (int i = 0; i < participant.length -1; i++) {
            if (!participant[i].equals(completion[i])) { //사전순 정렬을 하였는데 다른 경우, 해당 참가자가 미완주
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}