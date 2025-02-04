import java.util.*;

class Solution {
    
    // 주어진 n개의 주사위 중에서 n/2개를 선택하는 모든 조합을 생성
    public List<int[]> getCombinations(int n, int r) {
        List<int[]> result = new ArrayList<>();
        combinationHelper(new int[r], 0, 0, n, result);
        return result;
    }

    private void combinationHelper(int[] temp, int depth, int start, int n, List<int[]> result) {
        if (depth == temp.length) {
            result.add(temp.clone());
            return;
        }
        for (int i = start; i < n; i++) {
            temp[depth] = i;
            combinationHelper(temp, depth + 1, i + 1, n, result);
        }
    }

    // 선택된 주사위 조합의 가능한 모든 합을 계산
    public List<Integer> getAllSums(int[][] dice, int[] chosen) {
        List<Integer> sums = new ArrayList<>();
        generateSums(dice, chosen, 0, 0, sums);
        Collections.sort(sums);  // 이진 탐색을 위해 정렬
        return sums;
    }

    private static void generateSums(int[][] dice, int[] chosen, int index, int sum, List<Integer> sums) {
        if (index == chosen.length) {
            sums.add(sum);
            return;
        }
        for (int value : dice[chosen[index]]) {
            generateSums(dice, chosen, index + 1, sum + value, sums);
        }
    }

    // A 조합이 B 조합을 상대로 이긴 횟수를 계산
    public int countWins(List<Integer> A, List<Integer> B) {
        int wins = 0;
        for (int a : A) {
            int pos = binarySearch(B, a); // B에서 a보다 작은 값의 개수 찾기
            wins += pos;
        }
        return wins;
    }

    // 이진 탐색
    private int binarySearch(List<Integer> B, int a) {
        int left = 0, right = B.size();
        while (left < right) {
            int mid = (left + right) / 2;
            if (B.get(mid) < a) left = mid + 1;
            else right = mid;
        }
        return left; // a보다 작은 값의 개수
    }

    // 주어진 주사위 배열에서 승률이 가장 높은 조합을 찾는 함수
    public int[] solution(int[][] dice) {
        int n = dice.length;
        int r = n / 2;
        List<int[]> combinations = getCombinations(n, r);
        
        int maxWins = -1;
        int[] bestChoice = null;

        for (int[] A_choice : combinations) {
            // B는 A가 선택하지 않은 나머지 주사위를 가져감
            Set<Integer> A_set = new HashSet<>();
            for (int num : A_choice) A_set.add(num);

            int[] B_choice = new int[r];
            int index = 0;
            for (int i = 0; i < n; i++) {
                if (!A_set.contains(i)) B_choice[index++] = i;
            }

            // A와 B의 합 리스트 생성 및 정렬
            List<Integer> A_sums = getAllSums(dice, A_choice);
            List<Integer> B_sums = getAllSums(dice, B_choice);

            // 승리 횟수 계산
            int wins = countWins(A_sums, B_sums);

            // 최대 승리 확률 조합 갱신
            if (wins > maxWins) {
                maxWins = wins;
                bestChoice = A_choice.clone();
            }
        }

        // 결과 조합을 1부터 시작하는 인덱스로 변환
        for (int i = 0; i < bestChoice.length; i++) {
            bestChoice[i]++;
        }
        return bestChoice;
    }

}
