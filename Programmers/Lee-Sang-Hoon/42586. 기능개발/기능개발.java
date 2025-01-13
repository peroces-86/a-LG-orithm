import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        int n = progresses.length;

        // 각 작업의 남은 일수 계산
        int[] days = new int[n];
        for (int i = 0; i < n; i++) {
            days[i] = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }

        // 배포 횟수 계산
        int count = 1; // 첫 번째 작업 포함
        int currentMaxDay = days[0]; // 첫 작업이 완료되는 날이 첫 기준

        for (int i = 1; i < n; i++) {
            if (days[i] <= currentMaxDay) {
                count++; // 현재 배포 가능한 작업 추가
            } else {
                result.add(count); // 이전 배포 그룹 저장
                count = 1; // 새로운 배포 그룹 시작
                currentMaxDay = days[i]; // 새로운 기준 업데이트
            }
        }
        result.add(count); // 마지막 그룹 저장

        // 결과를 배열로 변환
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}
