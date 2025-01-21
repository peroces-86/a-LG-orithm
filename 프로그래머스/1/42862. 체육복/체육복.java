import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        int lostLen = lost.length;
        int reserveLen = reserve.length;
        
        
        // arr에 도난당한 사람과 여분이 있는 사람을 표시
        int[] arr = new int[n+1];
        Arrays.fill(arr, 1);
        for(int i : lost) --arr[i];
        for(int i : reserve) arr[i] += 1;
        
        
        for(int i = 1; i <= n; i++){
            if(arr[i] == 0){
                // arr[i-1] == 2인 경우에 빌려줌
                if(arr[i - 1] == 2){
                    // 빌려주면 answer + 1
                    arr[i]++;
                    --arr[i - 1];
                }
                // arr[i+1] == 2인 경우에 빌려줌
                else if(i + 1 <= n && arr[i + 1] == 2){
                    arr[i]++;
                    --arr[i + 1];
                }
            }
        }
        
        int answer = 0;
        for(int i : arr) {
            if(i > 0) answer++;
        }
        
        return answer-1;
    }
}