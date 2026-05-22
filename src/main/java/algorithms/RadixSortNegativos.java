import java.util.Arrays;
import java.util.Scanner;

public class RadixSortNegativos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = new int[]{-123, -200, -400, 400, 000, 230, 999, 123, 500};
        int digitos = 3;
        radixSort(array, digitos);
    }

    private static void radixSort(int[] array, int digitos) {
        int[] positives = positives(array);
        int[] negatives = negatives(array);

        int expoPos = 1;
        int expoNeg = 1;

        for (int i = 0; i < digitos; i++) {
            sort(positives, expoPos);
            sort(negatives, expoNeg);

            expoNeg *= 10;
            expoPos *= 10;
        }

        merge(positives, negatives, array.length);
    }

    private static void sort(int[] array, int expo) {
        int[] arrayAux = new int[10];

        for (int i = 0; i < array.length; i++) {
            int digito = (array[i] / expo) % 10;
            arrayAux[digito]++;
        }

        int cumulativa = 0;
        for (int i = 0; i < arrayAux.length; i++) {
            cumulativa += arrayAux[i];
            arrayAux[i] = cumulativa;
        }

        int[] arrayFinal = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int digito = (array[i] / expo) % 10;
            arrayFinal[arrayAux[digito] - 1] = array[i];
            arrayAux[digito]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = arrayFinal[i];
        }
    }

    private static int[] positives(int[] array) {
        int numPos = 0;
        for (int i = 0; i < array.length; i++) 
            if (array[i] >= 0) numPos++;

        int[] positives = new int[numPos];
        int idxPos = 0;
        for (int num : array) {
            if (num >= 0) {
                positives[idxPos] = num;
                idxPos++;
            }
        }
        return positives;
    }

    private static int[] negatives(int[] array) {
        int numNeg = 0;
        for (int i = 0; i < array.length; i++) 
            if (array[i] < 0)
                numNeg++;

        int[] negatives = new int[numNeg];
        int idxNeg = 0;
        for (int num : array) {
            if (num < 0) {
                negatives[idxNeg] = -1 * num;
                idxNeg++;
            }
        }

        return negatives;
    }

    private static int[] merge(int[] positives, int[] negatives, int length) {
        int[] array = new int[length];

        int j = 0;
        for (int i = negatives.length - 1; i >= 0; i--) {
            array[j] = -1 * negatives[i];
            j++;
        }

        for (int i = 0; i < positives.length; i++) {
            array[j] = positives[i];
            j++;
        }

        System.out.println(Arrays.toString(array));
        return array;
    }
}
