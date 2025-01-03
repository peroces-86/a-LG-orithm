import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 모의고사 {
    private static final int[] first = {1, 2, 3, 4, 5};
    private static final int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
    private static final int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] score = new int[3];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) score[0]++;
            if (answers[i] == second[i % second.length]) score[1]++;
            if (answers[i] == third[i % third.length]) score[2]++;
        }

        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));

        for (int i = 0; i < 3; i++) {
            if (score[i] == maxScore) result.add(i + 1);
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
