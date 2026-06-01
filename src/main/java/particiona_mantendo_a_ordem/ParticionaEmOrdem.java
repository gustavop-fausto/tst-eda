import java.util.Arrays;
import java.util.Scanner;

public class ParticionaEmOrdem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays.stream(sc.nextLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array, int ini, int fim) {
        int pivot = ini;
        
        for (int j = 1; j <= fim; j++) {
            if (array[j] <= array[pivot]) {
                int i = j;
                while(i > 1 && array[i] <= array[pivot]) {
                    swap(array, i, i - 1);
                    i--;
                }

                if (array[i] != array[pivot]) {
                    pivot++;
                }
            }

            
        }
    }

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
