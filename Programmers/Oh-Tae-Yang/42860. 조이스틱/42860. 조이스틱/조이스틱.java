class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int idx; //다음 값 확인을 위한 idx
        int move = length - 1; //좌우 움직임 수를 체크, 가장 많은 이동 횟수인 오른쪽으로 정직하게 이동

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);

            idx = i + 1;

            while (idx < length && name.charAt(idx) == 'A') {
                idx ++; // 다음 문자가 'A'라서 조작 안해도 되는 경우
            }

            move = Math.min(i * 2 + length - idx, move); //오른쪽에서 왼쪽
            
            move = Math.min((length - idx) * 2 + i, move);//왼쪽에서 오른쪽
        }
        answer += move;
        
        return answer;
    }
}