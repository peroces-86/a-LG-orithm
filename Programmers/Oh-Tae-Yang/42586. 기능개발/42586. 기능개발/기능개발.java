import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        int len = progresses.length;
        int[] answer1 = new int[100];
        
        // progresses에 남은 일수 저장
        for(int i = 0; i < len; i++){
           int temp = progresses[i];
           int speed = speeds[i];
           progresses[i] = (100-temp + speed -1)/speed;
        }
        
        int day = 0;
        for(int i = 0; i < len; i++){
            int p = progresses[i];
            // 남은 일수 p가 day보다 크면 day를 p로 업데이트
            if(p > day) day = p; 
            // answer1[day]에 개수 추가
            answer1[day]++;
        }
        
        // 구한 값들을 queue에 담아서 배열로 반환하여 return
        Queue<Integer> q = new LinkedList<>();
        for(int i : answer1) if (i != 0) q.add(i);
        
        int size = q.size();
        int[] answer = new int[size];
        for(int i=0; i < size; i++) answer[i] = q.poll();
        
        return answer;
    }
}