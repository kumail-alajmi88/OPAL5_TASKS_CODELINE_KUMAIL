package ToolboxApp;
import java.util.Scanner;

public class ToolboxApp {

    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        int choice;

        do {
            menu();
            choice = readInt("Please enter a number between 0 and 9 (optional 10): ");
            switch (choice) {
                case 1:
                    celsiusToFahrenheit();
                    break;
                case 2:
                    evenOrOdd();
                    break;
                case 3:
                    maxOfThree();
                    break;
                case 4:
                    factorial();
                    break;
                case 5:
                    multiplicationTable();
                    break;
                case 6:
                    starTriangle();
                    break;
                case 7:
                    isPrime();
                    break;
                case 8:
                    reverseNumber();
                    break;
                case 9:
                    numberPyramid();
                    break;
                case 10:
                    starLoop();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println();

        } while (choice != 0);

        input.close();
    }

    static void menu() {
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Even or odd");
        System.out.println("3. Maximum of three numbers");
        System.out.println("4. Factorial");
        System.out.println("5. Multiplication table");
        System.out.println("6. Triangle of stars");
        System.out.println("7. Prime check");
        System.out.println("8. Reverse a number");
        System.out.println("9. Number pyramid");
        System.out.println("10. Print Star Diamond");
        System.out.println("0. Exit");
    }

    static void celsiusToFahrenheit() {
        double cel = readDouble("Please enter temperature in Celsius: ");
        double fahre = cel * 9 / 5 + 32;
        System.out.println("The temp in fahrenheit = " + fahre);
    }

    static void evenOrOdd() {
        int num = readInt("Please enter an integer: ");
        if (num % 2 == 0) {
            System.out.println("it's Even");
        }
        else {
            System.out.println("it's Odd");
        }
    }

    static void maxOfThree() {
        int n1 = readInt("Please enter the first number: ");
        int n2 = readInt("Please enter the second number: ");
        int n3 = readInt("Please enter the third number: ");
        
        int max = n1;

        if (n2 > max) {
            max = n2;
        }

        if (n3 > max) {
            max = n3;
        }

        System.out.println(max  + " It's the largest number");
    }

    static void factorial() {
        int number = readInt("Please enter a non-negative number (0 to 15): ");

        if (number < 0 || number > 15) {
            System.out.println("Invalid number. Enter a number from 0 to 15.");
            return;
        }

        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        System.out.println(number + "! = " + result);
    }

    static void multiplicationTable() {
        int number = readInt("Enter a number: ");
    
            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
    }

    static void starTriangle() {
        int rows = readInt("Enter number of rows: ");

        if (rows <= 0) {
            System.out.println("Please enter a positive number of rows.");
            return;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("* ");

            }
            System.out.println();
        }
    }

    static void isPrime() {
        int number = readInt("Enter an integer greater than 1: ");

        if (number <= 1) {
            System.out.println("Please enter a number greater than 1.");
            return;
        }

        boolean prime = true;

        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.println(number + " is prime.");
         } else {
            System.out.println(number + " is not prime.");
            }
        }

    static void reverseNumber() {
        int number = readInt("Enter a positive integer: ");

        if (number <= 0) {
            System.out.println("Please enter a positive integer.");
            return;
        }

        int reversed = 0;

        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }

            System.out.println("Reversed number = " + reversed);
    }

    static void numberPyramid() {
        int rows = readInt("Enter number of rows: ");

        if (rows <= 0) {
            System.out.println("Please enter a positive number of rows.");
            return;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static int readInt(String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextInt()) {
                return input.nextInt();
            }

            System.out.println("Invalid input. Please enter an integer.");
            input.next();
        }
    }

    static double readDouble(String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextDouble()) {
            return input.nextDouble();
            }

            System.out.println("Invalid input. Please enter a number.");
            input.next();
        }
    }
    static void starLoop() {

        for (int i = 1; i <= 5; i++) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 4; i >= 1; i--) {
            for (int j = 5; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (2 * i - 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

}




    

