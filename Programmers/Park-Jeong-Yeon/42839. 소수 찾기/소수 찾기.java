class Solution {
    static int answer = 0;
    static boolean[] visited;
    static boolean[] intArr = new boolean[10000000];
    static int len = 0;
    static String[] numArr;
    
    // temp에 다른 수를 붙여 소수의 개수 확인하는 메서드
    static void check(String temp){
        
        // 0번째 수부터 len-1번째 수까지 완전탐색
        for(int i = 0; i < len; i++){
            // 만약 이미 사용한 수면 통과
            if(!visited[i]){
                visited[i] = true;
                
                // 새로 만든 수 = 기존 넘어온 수 + i번째 수
                String newString = temp + numArr[i];
                int num = Integer.parseInt(newString);
                
                // 만약 이미 만들어졌었던 수면 통과
                if(!intArr[num]) {
                    intArr[num] = true;
                    if(num == 2) answer++;
                    else{
                        // 2부터 차례대로 나눠 소수인지 확인
                        for(int j = 2; j < num; j++){
                            if(num%j != 0){
                                if(j == num-1) answer ++;
                                continue;
                            }
                            else break;
                        }
                    }
                    
                }
                // 만들어진 수에 다시 다른 수들을 붙여서 확인
                check(newString);
                visited[i] = false;
            }
        }
    }
    
    public int solution(String numbers) {
        numArr = numbers.split("");
        len = numbers.length();
        visited = new boolean[len];
        
        check("");
        
        return answer;
    }
}