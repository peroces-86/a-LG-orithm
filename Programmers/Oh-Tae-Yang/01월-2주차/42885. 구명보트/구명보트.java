import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people); //정렬
        int index = 0;
        for(int i = people.length - 1; i >= index; i--) { //무거운 사람부터
            //구명보트는 작아서 한 번에 최대 2명씩 밖에 탈 수 없고, 무게 제한도 있습니다.
        	if(people[i] + people[index] <= limit) { //제일 무거운 사람과 제일 가벼운 사람이 같이 탈 수 있는지 체크
        		index++;
        		answer++;
        	}
        	else {
        		answer++;
        	}
        }
        return answer;
    }
}