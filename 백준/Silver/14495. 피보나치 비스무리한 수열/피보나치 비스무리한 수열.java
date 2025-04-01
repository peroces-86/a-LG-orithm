import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] f = new long[117]; // 1-based index, 최대 n = 116

        f[1] = f[2] = f[3] = 1;

        for (int i = 4; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 3];
        }

        System.out.println(f[n]);
    }
}
