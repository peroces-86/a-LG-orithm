class Solution {
    public int solution(int[] numbers, int target) { //DFS solution with recursion
        return dfs(numbers, target, 0, 0);
    }
    
    private int dfs(int[] numbers, int target, int idx, int currentSum) {
        if (idx == numbers.length) {
            return currentSum == target ? 1 : 0;
        }
        
        return dfs(numbers, target, idx + 1, currentSum + numbers[idx]) 
             + dfs(numbers, target, idx + 1, currentSum - numbers[idx]);
    }
}
