package Labsession1.ex3;
import java.util.Arrays;
import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        int[] randomNumbers = new int[10];

        Random random = new Random();
        for (int i = 0; i < randomNumbers.length; i++) {
            randomNumbers[i] = random.nextInt(100); // Generates random numbers between 0 and 99
        }

        Arrays.sort(randomNumbers);

        System.out.println("Sorted random numbers:");
        for (int i = 0; i < randomNumbers.length; i++) {
            System.out.println(randomNumbers[i]);
        }
    }
}
