import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();

        String pattern = sc.nextLine();

        String[] parts = pattern.split("\\*");
        String prefix = parts[0];
        String suffix = parts[1];

        for (int i = 0; i < N; i++) {
            String fileName = sc.nextLine();
			
            if (fileName.startsWith(prefix) && fileName.endsWith(suffix) && fileName.length() >= prefix.length() + suffix.length()) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }

        sc.close();
    }
}
