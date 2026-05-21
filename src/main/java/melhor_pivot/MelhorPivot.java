package melhor_pivot;

import java.util.Arrays;
import java.util.Scanner;

class MelhorPivot{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        int[] nums = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        System.out.println(melhorPivot(array, nums[0], nums[1]));
    }

    private static int melhorPivot(int[] array, int num1, int num2) {
        int idxPivot1 = partition(array, num1, array.length - 1);
        int idxPivot2 = partition(array, num2, array.length - 1);

        int meio = array.length / 2;

        if (Math.abs(meio - idxPivot1) <= Math.abs(meio - idxPivot2)) {
            return num1;
        }

        return num2;
    }

    private static int partition(int[] array, int ini, int fim) {
        int i = ini;

        for (int j = ini + 1; j <= fim; j++) {
            if (array[j] <= array[ini])
                swap(array, ++i, j);
        }

        swap(array, ini, i);
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
