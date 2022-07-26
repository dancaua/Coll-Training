package p2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] source = new int[]{1, 2, 4, -1, 5, 3, 56, 89, 90, 0, -1, 3, 67, 45};
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number to be searched is: ");
        int inputTarget = scanner.nextInt();
        NumberCounter.countIterations(source, inputTarget);
    }
}
