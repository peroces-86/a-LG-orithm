import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        // set으로 중복 제거
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }
        
        // set의 크기가 N/2 보다 크면 N/2가 정답
        int size = set.size();
        if (size > (nums.length)/2) return (nums.length)/2;
        return size;
    }
}