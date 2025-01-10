class Solution {
    public int[] solution(int brown, int yellow) {
        int [] answer = new int[2]; //가로, 세로를 담을 배열 생성
        int x, y;
        //가로 길이는 세로 길이와 같거나, 세로 길이보다 길다고 했으니 세로의 최댓값
        for (int i = 1; i <= Math.sqrt(yellow); i++) {
            //세로 길이는 +2
            y = i + 2;
            //가로 길이도 + 2
            x = (yellow/i) + 2;
            //가로 * 세로 == 전체의 합과 같다면?
            if (x * y == brown + yellow) {
                answer[0] = x;
                answer[1] = y;
            }
        }
        return answer;
    }
}