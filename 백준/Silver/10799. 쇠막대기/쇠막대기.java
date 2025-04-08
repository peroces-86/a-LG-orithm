import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.nextLine();
    sc.close();

    int result = 0;
    Stack<Character> stack = new Stack<>();
    for(int i = 0; i < input.length(); i++) {
        char c = input.charAt(i);
        if (c == '(') {
            stack.push(c);
        } else {
            stack.pop();
            if (input.charAt(i - 1) == '(') {
                result += stack.size();
            } else {
                result++;
            }
        }
    }
    System.out.println(result);
    }

}