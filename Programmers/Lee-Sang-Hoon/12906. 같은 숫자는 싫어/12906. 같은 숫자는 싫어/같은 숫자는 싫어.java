//stack 이용하여 풀기로 함
//arr[0]은 무조건 answer에 넣어야 함
//stack에 arr[0]을 넣고, arr[1]부터 비교 시작
//stack의 top과 arr[i]가 같지 않으면(peek 통해 확인) stack에 push
//주어진 answer는 배열로 return해야 하므로 stack의 size만큼 배열 생성
//stack의 top부터 answer에 넣어주기 위해 stack.size() - 1부터 0까지 반복문 돌면서 answer에 넣어줌

import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int [stack.size()];
        
        for (int i = stack.size() - 1; i >= 0; i--) {
            answer[i] = stack.pop();
        }

        return answer;
    }
}