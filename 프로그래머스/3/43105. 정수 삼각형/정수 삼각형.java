class Solution {
    /*
    Bottom-up 상향식 접근이 맞다고 생각! 중복 호출로 시간 초과가 발생하는 것을 확인
    
    방법	시간 복잡도	공간 복잡도	비고
    Top-Down (재귀)	O(2^N) (최악)	O(N^2)	중복 호출 발생
    Bottom-Up (2D DP)	O(N^2)	O(N^2)	최적화됨
    Bottom-Up (1D DP)	O(N^2)	O(N)	메모리 최적화
     */
    static int [] dp;
    public static int solution(int[][] triangle) {
        int len = triangle.length;
        dp = new int[len];

        for (int i = 0; i < len; i++) {
            dp[i] = triangle[len - 1][i];
        }

        for (int i = len - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = triangle[i][j] + Math.max(dp[j], dp[j+1]);  // 이전 값 덮어쓰기
            }
        }

        return dp[0];
    }
}