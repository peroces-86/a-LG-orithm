//문제 조건 상 무조건 최대 2인
//무게로 정렬한 뒤 양 끝을 포인터로 삼아 무게를 limit와 비교

import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int weight, answer = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;
        while (left <= right) {
            weight = people[right];
            right--;
            if (weight + people[left] <= limit) {
                left++;
            }
            answer++;
        }
        return answer;
    }
}