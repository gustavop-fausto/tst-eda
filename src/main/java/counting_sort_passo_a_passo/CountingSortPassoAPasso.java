import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountingSortPassoAPasso {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maiorElemento = Integer.parseInt(sc.nextLine());

        countingSort(array, maiorElemento);
    }

    private static void countingSort(int[] array, int maiorElemento) {
        int[] arrayIntermediario = frequencia(array, maiorElemento);
        cumulativa(arrayIntermediario);

        int[] finalArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            finalArray[arrayIntermediario[array[i]] - 1] = array[i];
            arrayIntermediario[array[i]] -= 1;
        }

        System.out.println(print(arrayIntermediario));
        System.out.println(print(finalArray));
    }

    private static int[] frequencia(int[] array, int maiorElemento) {
        int[] arrayIntermediario = new int[maiorElemento + 1];

        for (int i = 0; i < array.length; i++) {
            arrayIntermediario[array[i]] += 1;
            System.out.println(print(arrayIntermediario));
        }
        return arrayIntermediario;
    }

    private static void cumulativa(int[] intermediario) {
        int total = 0;
        for (int i = 0; i < intermediario.length; i++) {
            total += intermediario[i];
            intermediario[i] = total;
        }

        System.out.println("Cumulativa do vetor de contagem - " + print(intermediario));
    }

    private static String print(int[] array) {
        String values = Arrays.stream(array)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(" "));

        return values;
    }
}
