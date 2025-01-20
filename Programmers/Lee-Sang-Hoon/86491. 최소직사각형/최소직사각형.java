class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int maxW = 0;
        int maxH = 0;

        for (int[] size: sizes) {
            int w = size[0];
            int h = size[1];


            int larger = Math.max(w, h);
            int smaller = Math.min(w, h);

            maxW = Math.max(maxW, larger); // 가로 최대값
            maxH = Math.max(maxH, smaller); // 세로 최대값
        }

        answer = maxW * maxH; // 모든 명함을 수납하기 위해 최대값 끼리의 곱을 구함

        return answer;
    }
}