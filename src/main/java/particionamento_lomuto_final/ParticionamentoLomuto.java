package particionamento_lomuto_final;

import java.util.Arrays;
import java.util.Scanner;

public class ParticionamentoLomuto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        partition(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static int partition(int[] array, int ini, int fim) {
        int j = fim;

        for (int i = fim - 1; i >= ini; i--) {
            if (array[i] > array[fim]) {
                j--;
                swap(array, i, j);
                System.out.println(Arrays.toString(array));
            }
        }

        swap(array, j, fim);
        System.out.println(Arrays.toString(array));

        return j;
    } 

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
