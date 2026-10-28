import java.util.Scanner;

public class DescendAlphTriangle {
    public static void main(String[] args) {
        System.out.print("Please enter n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print((char)('A' + n - 1 - j));
            }
            System.out.println();
        }
    }
}
