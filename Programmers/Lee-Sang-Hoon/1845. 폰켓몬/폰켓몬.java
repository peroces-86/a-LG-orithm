import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        Set<Integer> set = new HashSet<>(); // 중복 제거를 위한 Set
        for(int num : nums) {
            set.add(num);
        }

        int max = nums.length / 2; // 최대로 가져갈 수 있는 폰켓몬 수

        answer = Math.min(set.size(), max); // 중복 제거한 폰켓몬 수와 최대로 가져갈 수 있는 폰켓몬 수 중 작은 값이 정답

        return answer;
    }
}