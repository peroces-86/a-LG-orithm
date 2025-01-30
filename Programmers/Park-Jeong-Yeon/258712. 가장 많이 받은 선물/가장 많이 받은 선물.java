import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int n = friends.length;
        // 각 friend의 index를 map에 저장한다.
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(friends[i], i);
        }
        
        int[][] arr = new int[n][n];
        // gifts에서 공백으로 나누어 준사람과 받은사람을 구분한 뒤 arr에 값을 채운다.
        for(String gift : gifts){
            String[] fromTo = gift.split(" ");
            int from = map.get(fromTo[0]);
            int to = map.get(fromTo[1]);
            arr[from][to] += 1;
        }
        
        // 선물지수를 구한다.
        int[] give = new int[n];
        int[] get = new int[n];
        int[] score = new int[n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                give[i] += arr[i][j];
                get[i] += arr[j][i];
            }
            score[i] = give[i] - get[i];
        }
        
        // 본이이 준 선물과 받은 선물을 비교하며 받을 선물의 수를 계산
        int[] total = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if (arr[i][j] > arr[j][i]) total[i]++;
                else if(arr[i][j] == arr[j][i]){
                    if(score[i] > score[j]) total[i]++;
                }
            }
        }
        
        // 받을 선물의 수를 정렬하여 가장 큰 값을 반환
        Arrays.sort(total);
        
        return total[n-1];
    }
}