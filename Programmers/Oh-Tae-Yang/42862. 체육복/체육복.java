import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] student = new int[n];
        for (int i : reserve) {
            student[i-1]++;
        }
        for (int i : lost) {
            student[i-1]--;
        }
        for (int i = 0; i < n; i++) {
            if (student[i] < 0) {
                int preNum = i -1;
                int nextNum = i + 1;
                if (preNum >= 0 && student[preNum] > 0) {
                    student[preNum]--;
                    student[i]++;
                } else if (nextNum < n && student[nextNum] > 0) {
                    student[nextNum]--;
                    student[i]++;
                }
            }
        }
        int answer = (int) Arrays.stream(student).filter(num -> num >= 0).count();
        return answer;
    }
}