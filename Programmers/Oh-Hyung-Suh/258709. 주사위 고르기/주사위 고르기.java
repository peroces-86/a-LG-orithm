/*
 * 주사위 n개(2의 배수, 2 <= n <= 10)
 * 주사위 번호는 1~100, 면은 6개, 각각 나올 확률은 1/6 동일
 */

/*
 * 무조건 고르긴 해야됨
 * 정렬해서 고르는건 의미가 없음
 * 최대: 10C5 = 252가지 경우의 수, 근데 반만 보면 나머지 반은 똑같아서 반만 탐색하면 됨
 * 한 가지 경우의 수에 대한 조합은 6 * 6 * 6 * 6 * 6 = 7776 가지, 7776 * 2(A, B) = 15552 가지
 * 1959552번 돎. 얼마 안 걸림.
 */

import java.util.*;
import java.util.stream.*;

class Solution {
    
    private List<List<Integer>> diceComb = new ArrayList<>();
    private List<Integer> answer = new ArrayList<>();
    private int maxWin = Integer.MIN_VALUE;
    
    public int[] solution(int[][] dice) {
        int n = dice.length;
        boolean[] visited = new boolean[n];
        
        /*
         * 4개인 경우, (12, 13, 14, 23, 24, 34)
         * 여기서 반만 돌면 됨
         */
        getAllComb(0, n, 0, visited);
        int combLen = diceComb.size();
        
        for(int i = 0; i < combLen/2; i++) {
            List<Integer> diceA = diceComb.get(i); // (12, 13, 14)
            List<Integer> diceB = diceComb.get(combLen - i - 1); // (23, 24, 34)
            
            int[] result = getResult(dice, diceA, diceB);
            // System.out.println("A승: " + result[0] + " B승: " + result[1]);
            // System.out.println("A Comb: " + diceComb.get(i));
            // System.out.println("B Comb: " + diceComb.get(combLen - i - 1));
            
            if(result[0] > result[1] && result[0] > maxWin) {
                answer = diceA;
                maxWin = result[0];
            }else if(result[1] > result[0] && result[1] > maxWin) {
                answer = diceB;
                maxWin = result[1];
            }
        }
        
        return answer.stream()
            .map(a -> a + 1)
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    
    // 두 개의 조합 중 승 횟수가 큰 경우 구하기
    private int[] getResult(int[][] dice, List<Integer> diceA, List<Integer> diceB) {
        HashMap<Integer, Integer> resultA = new HashMap<>();
        HashMap<Integer, Integer> resultB = new HashMap<>();
        
        getDiceMap(0, 0, dice, diceA, resultA);
        getDiceMap(0, 0, dice, diceB, resultB);
        
        return calResult(resultA, resultB);
    }
    
    private int[] calResult(HashMap<Integer, Integer> resultA, HashMap<Integer, Integer> resultB) {
        int winA = 0, winB = 0;
        
        for(Map.Entry<Integer, Integer> entryA : resultA.entrySet()) {
            for(Map.Entry<Integer, Integer> entryB : resultB.entrySet()) {
                if (entryA.getKey() > entryB.getKey()) {
                    winA += entryA.getValue() * entryB.getValue();
                } else if (entryA.getKey() < entryB.getKey()) {
                    winB += entryA.getValue() * entryB.getValue();
                }
            }
        }
        
        return new int[]{winA, winB};
    }
    
    private void getDiceMap(int depth, int sum, 
                             int[][] dice, List<Integer> diceNums, HashMap<Integer, Integer> result) {
        if(depth == diceNums.size()) {
            result.put(sum, result.getOrDefault(sum, 0) + 1);
            return;
        }
        
        for(int i = 0; i < 6; i++) {
            getDiceMap(depth + 1, sum + dice[diceNums.get(depth)][i], 
                      dice, diceNums, result);
        }
    }

    
    // 조합 구하기 - 1,2 / 1,3 / 1,4 / 2,3 / 2,4 / 3,4
    private void getAllComb(int start, int n, int r, boolean[] visited) {
        if(r == n/2) {
            addComb(n, visited);
            return;
        }
        
        for(int i = start; i < n; i++) {
            visited[i] = true;
            getAllComb(i + 1, n, r + 1, visited);
            visited[i] = false;
        }
    }
    
    private void addComb(int n, boolean[] visited) {
        List<Integer> comb = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            if (visited[i]) {
                comb.add(i);
            }
        }
        
        diceComb.add(comb);
    }
}