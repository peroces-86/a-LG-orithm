class Solution {
    public int solution(String s) {

        String[] numbers = {"zero", "one", "two", "three", "four",
                            "five", "six", "seven", "eight", "nine"};
        
        // zero부터 nine까지 숫자로 대체
        for(int i = 0; i < 10; i++){
           s = s.replace(numbers[i], String.valueOf(i));
        }
        
        return Integer.parseInt(s);
    }
}