import java.util.*;
import java.lang.*;

class Solution {
    private static HashMap<String, String> numbers = new HashMap<>();
    
    public int solution(String s) {
        init();
        
        return getAnswer(s);
    }
    
    private int getAnswer(String s) {
        StringBuilder sb = new StringBuilder(s);
        
        for(Map.Entry<String, String> entry : numbers.entrySet()) {
            while(true) {
                int position = sb.indexOf(entry.getKey());
                
                if(position == -1) {
                    break;
                }
                sb.replace(position, position + entry.getKey().length(), entry.getValue());
            
            }
            
        }
        
        return Integer.parseInt(sb.toString());
    }
    
    private void init() {
        numbers.put("zero", "0");
        numbers.put("one", "1");
        numbers.put("two", "2");
        numbers.put("three", "3");
        numbers.put("four", "4");
        numbers.put("five", "5");
        numbers.put("six", "6");
        numbers.put("seven", "7");
        numbers.put("eight", "8");
        numbers.put("nine", "9");
    }
}