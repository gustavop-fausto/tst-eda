import java.util.Arrays;
import java.util.Scanner;

class ElementosDuplicados{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] array = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        System.out.println(verificaDuplicados(array));
    }

	private static boolean verificaDuplicados(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j]) 
                    return true;
            }
        }

        return false;
	}
}
