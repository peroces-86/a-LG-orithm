class Solution {
    public int solution(int n) {
        int answer = n+1;
        int countOne = Integer.bitCount(n);
        while(Integer.bitCount(answer) != countOne){
            answer++;
        }

        return answer;
    }
}