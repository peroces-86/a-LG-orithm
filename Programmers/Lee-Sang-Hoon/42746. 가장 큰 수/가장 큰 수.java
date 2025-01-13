//숫자를 문자열로 변환하여 정렬

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        // 숫자 배열을 문자열 배열로 변환
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }

        // 문자열로 변환한 숫자를 연결하여 비교 후 정렬
        Arrays.sort(strNumbers, (x, y) -> (y + x).compareTo(x + y));

        // 최종 결과를 StringBuilder 통해 연결
        StringBuilder result = new StringBuilder();
        for (String num : strNumbers) {
            result.append(num);
        }

        // 배열이 모두 0일 경우
        if (result.charAt(0) == '0') {
            return "0";
        }

        return result.toString();
    }
}
