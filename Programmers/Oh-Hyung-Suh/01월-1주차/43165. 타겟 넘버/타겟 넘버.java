class Solution {
    
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private static void dfs(int[] numbers, int target, int depth, int cal) {
        if(depth == numbers.length) {
            if(cal == target) {
                answer++;
            }
            return;
        }

        dfs(numbers, target, depth+1, cal+numbers[depth]);
        dfs(numbers, target, depth+1, cal-numbers[depth]);
    }
    
    
}