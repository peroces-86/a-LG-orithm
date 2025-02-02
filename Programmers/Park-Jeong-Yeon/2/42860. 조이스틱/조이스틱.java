class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        // 위아래 커서 합
        for (int i = 0; i < len; i++) {
            int alpha = name.charAt(i) - 'A';
            answer += Math.min(alpha, 26 - alpha);
        }
        
        // 좌우 커서 합 : default = 기본이 len-1
        int min = len - 1;
        
        // 중간에 A 있는거 생각해야됨
        for(int i = 0; i < len; i++){
            int next = i+1;
            while(next < len && name.charAt(next) == 'A'){
                next++;
            }
            
            // 0~i번째 + next~마지막 + 앞부터 가기 vs 뒤부터 가기 중 작은거
            min = Math.min(min, i + (len - next) + Math.min(i, (len-next)));
        }
        
        
        answer += min;
        return answer;
    }
}