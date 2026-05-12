package algorithms;

import java.util.Arrays;

class MergeSort {
   public static void main(String[] args) {
      int[] array = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
      sort(array, 0, array.length - 1);
      System.out.println(Arrays.toString(array));
   }

   private static void sort(int[] array, int ini, int fim) {
      if (ini < fim) {
         int middle = (fim + ini) / 2;
         sort(array, ini, middle);
         sort(array, middle + 1, fim);
         merge(array, ini, fim);
      }
   }

   private static void merge(int[] array, int ini, int fim) {
      int[] helper = copy(array, ini, fim);

      int rightHelper = fim - ini;
      int middle = rightHelper / 2;

      int i = 0;
      int j = middle + 1;
      int k = ini;

      while(i <= middle && j <= rightHelper) {
         if (helper[i] <= helper[j]) {
            array[k] = helper[i];
            i++;
         } else {
            array[k] = helper[j];
            j++;
         }
         k++;
      }

      while(i <= middle) {
         array[k] = helper[i];
         i++;
         k++;
      }
   }

   private static int[] copy(int[] array, int ini, int fim) {
      int lengthHelper = fim - ini + 1;
      int[] helper = new int[lengthHelper];

      for (int i = 0; i < lengthHelper; i++) {
         helper[i] = array[ini + i];
      }
      return helper;
   }
}
