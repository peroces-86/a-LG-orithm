import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);
        List<Integer> lostList = new ArrayList<>();
        List<Integer> reserveList = new ArrayList<>();
        
        for (int l : lost) { // 체육복을 도난당한 학생 array -> list
            lostList.add(l);
        }
        
        for (int r : reserve) { // 여벌의 체육복을 가져온 학생 array -> list
            if (lostList.contains(r)) { // 여벌의 체육복을 가져온 학생이 체육복을 도난당한 경우
                lostList.remove(Integer.valueOf(r));
            } else {
                reserveList.add(r);
            }
        }
        
        for (Iterator<Integer> iterator = lostList.iterator(); iterator.hasNext(); ) {
            int l = iterator.next();
            if (reserveList.contains(l - 1)) {
                reserveList.remove(Integer.valueOf(l - 1)); // 앞번호에서 빌려줌
                iterator.remove();
            } else if (reserveList.contains(l + 1)) {
                reserveList.remove(Integer.valueOf(l + 1)); // 뒷번호에서 빌려줌
                iterator.remove();
            }
        }
        
        // 전체 학생 수에서 최종적으로 체육복을 못 빌린 학생 수를 뺌
        return n - lostList.size();
    }
}
