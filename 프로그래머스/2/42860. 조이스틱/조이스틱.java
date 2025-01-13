class Solution {
    public int solution(String name) {

        int answer = 0;
        int minMove = name.length() - 1; // 이동 경로 최소값을 저장하는 변수

        for (int i = 0; i < name.length(); i++) {
            // 알파벳 변경 횟수 계산
            int up = name.charAt(i) - 'A'; // 정방향 이동 횟수
            int down = 'Z' - name.charAt(i) + 1; // 역방향 이동 횟수
            answer += Math.min(up, down); // 최소 이동 횟수 추가

            // 커서 이동 횟수 계산
            int next = i + 1;
            while (next < name.length() && name.charAt(next) == 'A') {
                next++; // 연속된 A 구간의 끝까지 이동
            }

            // 왼쪽으로 돌아가는 경우 vs 오른쪽으로 가는 경우
            int move = i + name.length() - next + Math.min(i, name.length() - next);
            minMove = Math.min(minMove, move);
        }

        answer += minMove;

        return answer;
    }
}
