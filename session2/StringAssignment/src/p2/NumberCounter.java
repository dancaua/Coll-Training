package p2;

public class NumberCounter {

    public static int countIterations(int[] source, int target) {
        int counter = 0;
        for (int i = 0; i < source.length; i++) {
            if (source[i] == target) {
                counter = i;
                System.out.println("Item found in iteration " + i);
                break;
            }
        }
        return counter;
    }
}
