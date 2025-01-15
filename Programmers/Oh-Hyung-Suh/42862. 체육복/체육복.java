import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = init(n, lost, reserve);
        
        for(int i = 1; i < n-1; i++) {
            if(students[i] == 2) {
                if(students[i-1] == 0) {
                    students[i]--;
                    students[i-1]++;
                }else if(students[i+1] == 0) {
                    students[i]--;
                    students[i+1]++;
                }
            }
        }
        
        return (int) Arrays.stream(students)
                .filter(student -> student != 0)
                .count();
    }
    
    private int[] init(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        
        Arrays.fill(students, 1);
        
        for(int l : lost) {
            students[l-1]--;
        }
        
        for(int r : reserve) {
            students[r-1]++;
        }
        
        if(students[0] == 2 && students[1] == 0) {
            students[0]--;
            students[1]++;
        }
        
        if(students[n-1] == 2 && students[n-2] == 0) {
            students[n-1]--;
            students[n-2]++;
        }
        
        return students;
    }
}