import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        Set<String> set = new HashSet<>();
        set.add(words[0]);

        for(int i=1; i<words.length; i++) {
            String prev = words[i-1];
            String cur = words[i];

            if(cur.length() == 1) {
                return new int[]{i%n+1, i/n+1};
            }

            if(cur.charAt(0) != prev.charAt(prev.length()-1)) {
                return new int[]{i%n+1, i/n+1};
            }

            if(set.contains(cur)) {
                return new int[]{i%n+1, i/n+1};
            }

            set.add(cur);
        }

        return answer;
    }
}