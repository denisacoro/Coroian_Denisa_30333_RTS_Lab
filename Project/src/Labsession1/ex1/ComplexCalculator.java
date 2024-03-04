package Labsession1.ex1;
import java.util.Scanner;

public class ComplexCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ComplexNumber num1 = new ComplexNumber(2, 5);
        ComplexNumber num2 = new ComplexNumber(4, -1);

        while (true) {
            System.out.println("Select operation:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Addition: ");
                    System.out.println(num1.add(num2));
                    break;
                case 2:
                    System.out.print("Subtraction: ");
                    System.out.println(num1.subtract(num2));
                    break;
                case 3:
                    System.out.print("Multiplication: ");
                    System.out.println(num1.multiply(num2));
                    break;
                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}

