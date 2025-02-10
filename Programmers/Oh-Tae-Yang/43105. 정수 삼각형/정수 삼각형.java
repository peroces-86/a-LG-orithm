class Solution {
    /*
    1. Bottom-up 상향식 접근이 맞다고 생각! 중복 호출로 시간 초과가 발생하는 것을 확인
     */
    static int [][] dp;
    public static int solution(int[][] triangle) {
        int len = triangle.length;
        dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[len - 1][i] = triangle[len - 1][i];
        }
        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}