import java.util.Arrays;
import java.util.Scanner;

public class Hoare {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int ini, int fim) {
        if (ini < fim) {
            int idx = hoare(array, ini, fim);
            quickSort(array, ini, idx - 1);
            quickSort(array, idx + 1, fim);
        }
    }

    private static int hoare(int[] array, int ini, int fim) {
        int pivot = array[ini];
        int i = ini + 1;
        int j = fim;

        while (i <= j) {
            while (i <= j && array[i] <= pivot) 
                i++;
            
            while (i <= j && array[j] > pivot) 
                j--;

            if (i < j)
                swap(array, i, j);

            System.out.println(Arrays.toString(array));
        }
        swap(array, ini, j);

        return j;
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}

