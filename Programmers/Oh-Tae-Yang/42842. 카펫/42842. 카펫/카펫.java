import java.util.*;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // 전체 개수 무조건 3 * 3 이상
        int total = brown + yellow;
        
        Queue<Integer> queue = new LinkedList<>();
        
        // 가능한 가지수를 큐에 저장
        for(int i = total/3; i >= 3 ; i--){
            if (total%i == 0) queue.add(i);
        }
        
        // 가로세로 값을 이용해 노란색 칸 갯수 구하고 비교해서 맞으면 정답 return
        while(!queue.isEmpty()){
            int temp = queue.poll();
            System.out.println(temp);
            
            if(total - 2 * (temp + total/temp - 2) == yellow){
                answer[0] = temp;
                answer[1] = total/temp;
                return answer;
            }
        }
    
        
        return answer;
    }
}