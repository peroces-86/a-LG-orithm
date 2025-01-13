//자바 힙 검색하니까 priorityQueue가 나와 우선순위 큐로 문제를 해결함

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        // 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) {
            pq.offer(s); // 모든 스코빌 지수를 우선순위 큐로 삽입
        }

        int count = 0; // 섞은 횟수 카운트

        while (pq.size() > 1) { // 음식이 2개 이상 남은 경우
            // 가장 작은 두 값을 꺼내어 섞음
            int first = pq.poll();
            if (first >= K) { // 모든 음식이 K 이상인 경우
                return count;
            }
            int second = pq.poll();
            int temp = first + (second * 2);
            pq.offer(temp); // 음식을 섞은 결과를 다시 큐에 삽입
            count++;
        }

        // 마지막으로 남은 음식이 K 이상인지 확인
        if (pq.peek() >= K) {
            return count;
        }
        return -1; // 모든 음식을 K 이상으로 만들 수 없는 경우
    }
}
