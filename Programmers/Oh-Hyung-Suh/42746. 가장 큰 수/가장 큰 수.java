import java.util.stream.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        int n = numbers.length;
        String[] stringNumbers = new String[n];
        
        for(int i = 0; i < n; i++) {
            stringNumbers[i] = String.valueOf(numbers[i]);
        }
        
        /*
         * String[] stringArray = Arrays.stream(numbers) // IntStream 생성
         *                     .mapToObj(String::valueOf) // int 값을 String으로 변환
         *                     .toArray(String[]::new); // Stream을 String 배열로 수집
         */
        
        Arrays.sort(stringNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        
        // System.out.println(Arrays.toString(stringNumbers));
        
        return getAnswer(stringNumbers);
    }
    
    private String getAnswer(String[] numbers) {
        if(numbers[0].equals("0")) {
            return "0";
        }
        
        return String.join("", numbers);
    }
}