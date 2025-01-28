import java.util.*;


class Solution {
    
    static List<Set<Integer>> setAList = new ArrayList<>();
    static List<Set<Integer>> setBList = new ArrayList<>();
    
    // setAList, setBList에 가능한 주사위 경우의 수 채우기
    static void makeSetList(Set<Integer> setA, Set<Integer> setB, int i, int n){
        if(i > n || setA.size() > n/2 || setB.size() > n/2) return;
        // 만약 n/2 개씩 분배 완료되면 setList에 추가한다.
        if(setA.size() == n/2 && setB.size() == n/2){
            Set<Integer> addA = new HashSet<>();
            Set<Integer> addB = new HashSet<>();
            Iterator<Integer> iterA = setA.iterator();
            Iterator<Integer> iterB = setB.iterator();
            for(int j = 0; j < n/2; j++){
                addA.add(iterA.next());
                addB.add(iterB.next());
            }
            setAList.add(addA);
            setBList.add(addB);
            return;
        }
        
        // A가 i번째 주사위를 가져가는 경우
        setA.add(i);
        makeSetList(setA, setB, i+1, n);
        setA.remove(i);
        
        // B가 i번째 주사위를 가져가는 경우
        setB.add(i);
        makeSetList(setA, setB, i+1, n);
        setB.remove(i);
    }
    
    
    // 보유한 주사위 set로 가능한 점수 만들기
    static void getScore(Set<Integer> set, int idx,
                              Map<Integer, Integer> map, int[][] dice, int total){
        // idx가 set의 크기보다 커지면 retur
        if(idx > set.size()) return;
        
        if(idx < set.size()){
            
            for(int i = 0; i < 6; i++){
                Object[] list = set.toArray();
                int realIdx = (Integer)list[idx];
                int sum = dice[realIdx][i];
                getScore(set, idx+1, map, dice, total + sum);
            }
        }
        
        else {
            if(map.containsKey(total)){
                int tempTotal = map.get(total);
                map.put(total, tempTotal+1);
            }
            else{
                map.put(total, 1);
            }
            
        }
    }
    
    
    public int[] solution(int[][] dice) {
        
        // 주사위 개수
        int n = dice.length;
        
        boolean[] visited = new boolean[n];
                
        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();
        
        makeSetList(setA, setB, 0, n);
        
        // size = 보유 주사위 경우의 수 : n! / (n/2)! * (n/2)!
        int size = setAList.size();
        Set<Integer> answerSet = new HashSet<>();
        
        // 총 승리 횟수 Max 경우
        int answerCount = 0;
        
        // 총 승리 횟수 Max일 때 index 번호
        int answerIndex = 0;
        
        for(int i = 0; i < size; i++){
            Map<Integer, Integer> mapA = new HashMap<>();
            Map<Integer, Integer> mapB = new HashMap<>();
            getScore(setAList.get(i), 0, mapA, dice, 0);
            getScore(setBList.get(i), 0, mapB, dice, 0);
            
            int sumTotal = 0;
            Iterator<Map.Entry<Integer, Integer>> iterA = mapA.entrySet().iterator();
            while (iterA.hasNext()) {
                int sum = 0;
                Map.Entry<Integer, Integer> entryA = (Map.Entry<Integer, Integer>) iterA.next();
                Integer keyA = entryA.getKey();
                Iterator<Map.Entry<Integer, Integer>> iterB = mapB.entrySet().iterator();
                while (iterB.hasNext()) {
                    Map.Entry<Integer, Integer> entryB = (Map.Entry<Integer, Integer>) iterB.next();
                    if(keyA > entryB.getKey()){
                        sum += entryB.getValue();
                    }
                }
                sumTotal += sum * entryA.getValue();
            }
            
            if(answerCount <= sumTotal){
                answerCount = sumTotal;
                answerIndex = i;
            }
            
        }
        
        int[] answer = new int[n/2];
        int i = 0;
        Iterator<Integer> iterator = setAList.get(answerIndex).iterator();
        while(iterator.hasNext()){
            answer[i] = iterator.next() + 1;
            i++;
        }
        
        Arrays.sort(answer);
        return answer;
    }
}