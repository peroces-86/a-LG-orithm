import java.util.*;
import java.lang.*;

class Solution {
    
    public int solution(String name) {
        int n = name.length();
        int move = n - 1;
        int idx;
        
        // 'A'와 비교해서 위아래 최소 이동 구하기
        int answer = getAlphaMoveCount(name);
        
        System.out.println(answer);
        
        for(int i=0; i<n; i++) {
            idx = i+1;
            while(idx < n && name.charAt(idx) == 'A') {
                idx++;
            }
            
            move = Math.min(move, i * 2 + (n - idx));
            move = Math.min(move, (n - idx) * 2 + i);
        }
        
        return answer + move;
    }
    
    // 'A': 65
    // 'N': 78 - 'A' = 13
    // 'O': 26 - (79 - 'A') = 12
    private int getAlphaMoveCount(String name) {
        int alphaMoveCount = 0;
        
        for(char c : name.toCharArray()) {
            alphaMoveCount += Math.min(c - 'A', 'Z' - c + 1);
        }
        
        return alphaMoveCount;
    }
    
}