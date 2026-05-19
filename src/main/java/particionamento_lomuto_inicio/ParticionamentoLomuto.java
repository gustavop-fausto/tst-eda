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

    private static void partition(int[] array, int ini, int fim) {
        int i = ini;

        for (int j = ini + 1; j < array.length; j++) {
            if (array[j] < array[ini]) {
                i++;
                swap(array, i, j);
                System.out.println(Arrays.toString(array));
            }
        }

        swap(array, i, ini);
        System.out.println(Arrays.toString(array));
    } 

    private static void swap(int[] array, int i, int j) {
        int aux = array[i];
        array[i] = array[j];
        array[j] = aux;
    }
}
