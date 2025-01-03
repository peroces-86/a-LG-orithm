import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int [] a = {1,2,3,4,5};
        int [] b = {2,1,2,3,2,4,2,5};
        int [] c = {3,3,1,1,2,2,4,4,5,5};
        
        int [] score = new int[3];
        
        for(int i = 0; i<answers.length; i++) {
        	if(answers[i] == a[i%a.length]) {
        		score[0] ++;
        	}
        	if(answers[i] == b[i%b.length]) {
        		score[1] ++;
        	}
        	if(answers[i] == c[i%c.length]) {
        		score[2] ++;
        	}
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        int max = Math.max(score[0], Math.max(score[1], score[2]));
        for(int i=0; i<score.length; i++) {
        	if(max == score[i]) {
        		list.add(i+1);
        	}
        }
        
        int [] answer = new int[list.size()];
        int n = 0;
        for(int i : list) {
        	answer[n++] =i;
        }
        return answer;
    }
}