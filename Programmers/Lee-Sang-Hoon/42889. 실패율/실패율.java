import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int total = stages.length;
        double[] fail = new double[N + 1];

        int player = total;

        for(int i = 0; i <= N; i++) {
            int count = 0;
            for(int stage : stages) {
                if(stage == i) {
                    count++;
                }
            }

            if(player == 0) {
                fail[i] = 0;
            } else {
                fail[i] = (double)count / player;
            }
            player -= count;
        }

        List<Stage> stageList = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            stageList.add(new Stage(i, fail[i]));
        }

        Collections.sort(stageList, new Comparator<Stage>() {
            public int compare(Stage o1, Stage o2) {
                if(o1.fail == o2.fail) {
                    return o1.num - o2.num;
                } else {
                    return Double.compare(o2.fail, o1.fail);
                }
            }
        });

        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = stageList.get(i).num;
        }
        return answer;
    }
    class Stage{
        int num;
        double fail;
        public Stage(int num, double fail) {
            this.num = num;
            this.fail = fail;
        }
    }
}