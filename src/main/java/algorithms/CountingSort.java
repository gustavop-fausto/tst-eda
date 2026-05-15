package algorithms;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        // int[] array = new int[]{-3, 5, 2, 10, 22};
        // int[] array = new int[]{-3, -5, 2, 13, 4};
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        countingSort(array, 10, 1);
    }

    private static void countingSort(int[] array, int greater, int lower) {
        int[] helper = new int[greater - lower + 1];

        for (int i = 0; i < array.length; i++) 
            helper[array[i] - lower] += 1;

        int total = 0;
        for (int i = 0; i < helper.length; i++) {
            total += helper[i];
            helper[i] = total;
        }

        int[] finalArray = new int[array.length];

        for (int i = array.length - 1; i >= 0; i--) {
            finalArray[helper[array[i] - lower] - 1] = array[i];
            helper[array[i] - lower] -= 1;
        }

        System.out.println(Arrays.toString(finalArray));
    }
}
