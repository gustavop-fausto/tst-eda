package algorithms;

import java.util.Arrays;

class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
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

        return i;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
