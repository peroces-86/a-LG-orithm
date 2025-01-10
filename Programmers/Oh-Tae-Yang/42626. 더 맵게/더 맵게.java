import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //우선순위 큐의 경우 작은 수를 우선순위로 지정
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int i : scoville) {
        	heap.add(i);
        }
        
        while(heap.peek() < K) {
        	if(heap.size() < 2) return -1;
        	int f1 = heap.poll();
        	int f2 = heap.poll();
        	int new_f = f1 +(f2 * 2);
        	heap.add(new_f);
        	answer++;
        }
        return answer;
    }
}