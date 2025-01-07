import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> pq = new PriorityQueue<>();
        
        for(int s : scoville) {
            pq.add(s);
        }
        
        /*
         * (o1, o2) -> o2 - o1 적용시 예상 출력: [12, 10, 9, 3, 2, 1], 실제 출력: [12, 9, 10, 1, 3, 2]
         * 이유는? 완전 이진 트리 형식이라서
         * System.out.println(Arrays.toString(pq.stream().mapToInt(Integer::intValue).toArray()));
         
         * peek()과 poll()의 순서는 우선순위 보장...
         * 그리고 앞에서부터 뽑으므로 Comparator 이용해서 내림차순 필요X
         */
        
        while(pq.size() > 1 && pq.peek() < K) {
            pq.add(pq.poll() + pq.poll() * 2);
            answer++;
        }
        
        return pq.peek() >= K ? answer : -1;
    }
}