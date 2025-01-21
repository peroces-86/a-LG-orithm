class Solution {
    public int solution(String s) {
        String[] numberWords = { // 0 ~ 9 까지의 영어단어
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
        };

        for (int i = 0; i < numberWords.length; i++) { // 0 ~ 9 까지의 영어단어를 숫자로 변환
            s = s.replace(numberWords[i], String.valueOf(i));
        }

        return Integer.parseInt(s);
    }
}

