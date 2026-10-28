import java.util.Scanner;

public class OddNumTriangle {
    public static void main(String[] args) {
        System.out.print("Please enter n: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int num = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num + " ");
                num = num + 2;

            }
            System.out.println();
        }
    }
}
