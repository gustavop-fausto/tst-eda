import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = Arrays.stream(sc.nextLine().split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();

        int numDigitos = Integer.parseInt(sc.nextLine());

        int expoente = 100;
        for (int i = 0; i < numDigitos / 2; i++) {
            counting(array, expoente);
            expoente *= 100;
        }
    }
    
    private static void counting(int[] array, int expoente) {
        int[] arrayFinal = new int[array.length];
        int[] frequencia = new int[100];

        for (int i = 0; i < array.length; i++) {
            int digito = array[i] % expoente / (expoente / 100);
            frequencia[digito]++;
        }

        int cumulativa = 0;
        for (int i = 0; i < frequencia.length; i++) {
            cumulativa += frequencia[i];
            frequencia[i] = cumulativa;
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int digito = array[i] % expoente / (expoente / 100);
            arrayFinal[frequencia[digito] - 1] = array[i];
            frequencia[digito]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = arrayFinal[i];
        }

        System.out.println(Arrays.toString(arrayFinal));
    }
}
