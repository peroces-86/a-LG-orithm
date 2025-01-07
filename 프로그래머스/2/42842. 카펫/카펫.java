class Solution {
    public int[] solution(int brown, int yellow) {
        int halfCircum = getHalfCircum(brown);
        
        return getAnswer(halfCircum, yellow);
    }
    
    private int getHalfCircum(int brown) {
        return (brown - 4) / 2;
    }
    
    private int[] getAnswer(int halfCircum, int yellow) {
        int[] answer = new int[2];
        
        for(int height = 1; height <= halfCircum / 2; height++) {
            int width = halfCircum - height;
            
            if(width * height == yellow) {
                answer[0] = width + 2;
                answer[1] = height + 2;
                break;
            }
        }
        
        return answer;
    }
}