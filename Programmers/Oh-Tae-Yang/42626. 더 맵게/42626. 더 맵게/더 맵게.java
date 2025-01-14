import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        // 우선순위 큐에 배열 넣기
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int i : scoville) {
            queue.add(i);
        }
        
        // 큐에서 뺀 값이 k보다 작으면 음식 만들고 answer +1 하기
        while(!queue.isEmpty()){
            int temp1 = queue.poll();
            
            if(temp1 < K){
                if(queue.isEmpty()){
                    return -1;
                }
                int temp2 = queue.poll();
                int scov = temp1 + temp2 * 2;
                queue.add(scov);
                answer++;
            }
            else return answer;
        }
        
        return answer;
    }
}