import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        int n = queue1.length;

        for (int i = 0; i < n; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }

        long total = sum1 + sum2;
        
        if(total % 2 != 0) {
            return -1;
        }

        long target = total / 2;

        int[] arr = new int[2*n];
        for (int i = 0; i < n; i++) {
            arr[i] = queue1[i];
            arr[i+n] = queue2[i];
        }

        int answer = 0;
        int i = 0, j = n;

        while(i < 2 * n && j < 2 * n){
            if(sum1 == target){
                return answer;
            }
            if(sum1 > target){
                sum1 -= arr[i];
                sum2 += arr[i];
                i++;
                answer++;
            } else {
                sum2 -= arr[j];
                sum1 += arr[j];
                j++;
                answer++;
            }
            if(answer > 3 * n){
                return -1;
            }
        }
        return -1;
    }
}