import java.util.*;

class Solution {
   static int N;
    static int[] answer;
    static int [][] dices;
    static List<Integer> choice = new ArrayList<>();
    static List<Integer> arrA;
    static List<Integer> arrB;
    static int max = Integer.MIN_VALUE;

    public int[] solution(int[][] dice) {
        N = dice.length;
        answer = new int[N/2];
        dices = dice;
        combi(0, 0);
        return answer;
    }

    public static void combi(int depth, int s) {
        if (depth == N/2) {
            //승률 계산
            int winning = cal();
            if (max < winning) {
                max = winning;
                for (int i = 0; i < choice.size(); i++) {
                    answer[i] = choice.get(i) + 1;
                }
            }
            return;
        }
        for (int i = s; i < N; i++) {
            choice.add(i);
            combi(depth + 1, i + 1);
            choice.remove(choice.size() - 1);
        }
    }

    public static int cal() {
        int count = 0;
        //경우의 수 저장
        makeArrAB();

        Collections.sort(arrB);
        for (int i = 0; i < arrA.size(); i++) {
            int number = arrA.get(i);

            int left = 0, right = arrB.size() - 1;

            int index = Integer.MIN_VALUE;

            while (left <= right) {
                int mid = (left + right) / 2;

                if (arrB.get(mid) < number) {
                    left = mid + 1;
                    index = Math.max(index, mid);
                } else {
                    right = mid - 1;
                }
            }
            if (index != Integer.MIN_VALUE) {
                count += index + 1;
            }
        }
        return count;
    }
    public static void makeArrAB() {
        arrA = new ArrayList<>();
        arrB = new ArrayList<>();

        int[][] diceA = new int[N / 2][6];
        int[][] diceB = new int[N / 2][6];
        int a = 0;
        int b = 0;

        for (int i = 0; i < N; i++) {
            if (choice.contains(i)) {
                diceA[a] = dices[i];
                a++;
            } else {
                diceB[b] = dices[i];
                b++;
            }
        }
        makeArr(0, diceA, 0, arrA);
        makeArr(0, diceB, 0, arrB);
    }

    public static void makeArr(int depth, int[][] dice, int sum, List<Integer> arr) {
        if (depth == N / 2) {
            arr.add(sum);
            return;
        }
        for (int i = 0; i < 6; i++) {
            int newSum = sum + dice[depth][i];
            makeArr(depth + 1, dice, newSum, arr);
        }
    }
}