package algorithms;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int ini, int fim) {
        if (ini < fim) {
            int idxPivot = partition(array, ini, fim);
            quickSort(array, ini, idxPivot - 1);
            quickSort(array, idxPivot + 1, fim);
        }
    }

    private static int partition(int[] array, int ini, int fim) {
        int i = ini;

        for (int j = ini + 1; j <= fim; j++) {
            if (array[j] <= array[ini])
                swap(array, ++i, j);
        }

        swap(array, ini, i);

        System.out.println(Arrays.stream(array).mapToObj(String::valueOf).collect(Collectors.joining(" ")));
        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
