import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        
        int add = 0;
        for(int i : numbers){
            add += i;
        }
        if(add == 0) return "0";
        
        String answer = "";
        
        int len = numbers.length;
        
        // int 배열을 str배열로
        String[] strArr = new String[len];
        for(int i = 0; i < len; i++){
            strArr[i] = String.valueOf(numbers[i]);
        }
        
        // str배열을 이어붙었을 때 큰 수대로 정열
        Arrays.sort(strArr, (str1, str2) -> (str2 + str1).compareTo(str1 + str2));
        
        for(String str : strArr){
            answer += str;
        }
        
        return answer;
    }
}