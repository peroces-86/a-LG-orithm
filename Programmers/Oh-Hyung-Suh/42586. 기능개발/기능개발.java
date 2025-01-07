import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> features = new Stack<>();
        
        int takeDay = 0, maxDay = 0;
        
        for(int i = 0; i < progresses.length; i++) {
            takeDay = getTakeDay(progresses[i], speeds[i]);
            
            if(features.isEmpty()) {
                maxDay = takeDay;
            }else if(maxDay < takeDay) {           
                answer.add(features.size());
                features.clear();
                maxDay = takeDay;
            }
            
            features.push(takeDay);
        }
        
        answer.add(features.size());
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int getTakeDay(int progress, int speed) {
        if((100 - progress) % speed != 0) {
            return (100 - progress) / speed + 1;
        }
        
        return (100 - progress) / speed;
    }
}