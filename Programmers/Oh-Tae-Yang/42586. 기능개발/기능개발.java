import java.util.*;


class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> array = new ArrayList<>();

        for (int i=0; i<progresses.length; i++) {
            //남은 일수를 queue에 삽입
            queue.offer((int) Math.ceil((double)(100 - progresses[i])/speeds[i]));
        }
        while (!queue.isEmpty()) {
            //queue.peek()을 최대로 지정
            int max_num = queue.peek();
            if(queue.peek() <= max_num) {
                int cnt = 0;
                while(queue.peek() != null && queue.peek() <= max_num) {
                    //최대일수보다 작은 수들은 전부 하루에 배포 가능하니 ++
                    queue.poll();
                    cnt++;
                }
                array.add(cnt);
            }
        }
        int[] answer = array.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}