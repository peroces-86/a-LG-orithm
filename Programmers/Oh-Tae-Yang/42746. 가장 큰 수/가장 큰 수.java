import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String [] str_num = new String[numbers.length];

        for (int i=0; i< numbers.length; i++) {
            str_num[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(str_num, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //문자열을 합쳤을 때 더 큰 경우
                return (o2+o1).compareTo(o1+o2);
            }
        });
        String answer = "";
        
        //실패한 테스트 케이스 처리
        if (str_num[0].equals("0")) return "0";
        
        for (String s : str_num) {
            answer += s;
        }
        
        return answer;
    }
}