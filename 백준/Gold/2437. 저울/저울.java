import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] weights = new int[N];
        for (int i = 0; i < N; i++) {
            weights[i] = scanner.nextInt();
        }

        Arrays.sort(weights);

        int maxWeight = 0;

        for(int weight : weights){
            if(weight > maxWeight + 1){
                break;
            }
            maxWeight += weight;
        }
        System.out.println(maxWeight + 1);
    }
}