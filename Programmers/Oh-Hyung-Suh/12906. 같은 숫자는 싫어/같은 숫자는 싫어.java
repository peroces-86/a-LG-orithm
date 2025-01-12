import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList();
        Stack<Integer> numbers = new Stack<>();
        
        for(int i = arr.length-1; i >= 0; i--) {
            if(numbers.isEmpty() || numbers.peek() != arr[i]) {
                numbers.push(arr[i]);
            }
        }

        while(!numbers.isEmpty()) {
            answer.add(numbers.pop());
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}