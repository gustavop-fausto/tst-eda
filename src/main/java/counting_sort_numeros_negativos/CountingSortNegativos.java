import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

class CountingSortNegativo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int maiorElemento = Integer.parseInt(sc.nextLine());
        int menorElemento = Integer.parseInt(sc.nextLine());

        countingSort(array, maiorElemento, menorElemento);
    }

    private static void countingSort(int[] array, int maiorElemento, int menorElemento) {
        int[] arrayIntermediario = frequencia(array, maiorElemento, menorElemento);
        cumulativa(arrayIntermediario);

        int[] finalArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            finalArray[arrayIntermediario[array[i] - menorElemento] - 1] = array[i];
            arrayIntermediario[array[i] - menorElemento] -= 1;
         }

        System.out.println(Arrays.toString(arrayIntermediario));
        System.out.println(Arrays.toString(finalArray));
    }

    private static int[] frequencia(int[] array, int maiorElemento, int menorElemento) {
        int[] arrayIntermediario = new int[maiorElemento - menorElemento + 1];

        for (int i = 0; i < array.length; i++) {
            arrayIntermediario[array[i] - menorElemento] += 1;
            System.out.println(Arrays.toString(arrayIntermediario));
        }
        return arrayIntermediario;
    }

    private static void cumulativa(int[] intermediario) {
        int total = 0;
        for (int i = 0; i < intermediario.length; i++) {
            total += intermediario[i];
            intermediario[i] = total;
        }

        System.out.println("Cumulativa do vetor de contagem - " + Arrays.toString(intermediario));
    }
}
