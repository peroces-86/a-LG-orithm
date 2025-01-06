import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i : arr) {
            if (stack.isEmpty()) { //초기 상태 push
                stack.push(i);
            } else if (stack.peek() == i) { //반복되는 경우 pass
                continue;
            } else {
                stack.push(i);
            }
        }
        
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}