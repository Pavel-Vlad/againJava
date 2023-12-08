import java.util.ArrayList;
import java.util.Arrays;

public class SortLevel {
    public static void SelectionSortStep(int[] array, int i) {
        if (i < 0 || i > array.length - 2) return;

        int min = array[i];
        int indexMin = 0;
        for (int index = i + 1; index < array.length; index++) {
            if (array[index] < min) {
                min = array[index];
                indexMin = index;
            }
        }
        if (array[i] != min) {
            int tempVar = array[i];
            array[i] = array[indexMin];
            array[indexMin] = tempVar;
        }
    }

    public static boolean BubbleSortStep(int[] array) {
        boolean result = true;
        for (int index = 0; index < array.length - 1; index++) {
            if (array[index] > array[index + 1]) {
                int tempEl = array[index];
                array[index] = array[index + 1];
                array[index + 1] = tempEl;
                result = false;
            }
        }
        return result;
    }

    public static void InsertionSortStep(int[] array, int step, int i) {
        if (step < 1 || step > array.length - 1) return;
        if (i < 0 || i > array.length - 1) return;


        for (; i < array.length; i += step) {
            int min = array[i];
            int indexMin = i;
            for (int j = i + step; j < array.length; j += step) {
                if (array[j] < min) {
                    min = array[j];
                    indexMin = j;
                }
            }
            if (min != array[i]) {
                int tempVar = array[i];
                array[i] = array[indexMin];
                array[indexMin] = tempVar;
            }
            System.out.println(Arrays.toString(array));
        }
    }

    /**
     * интервальная последовательность кнута
     *
     * @param array_size - размер сортируемого массива
     * @return ArrayList<Integer>
     */
    public static ArrayList<Integer> KnuthSequence(int array_size) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();

        int elSequence = 1;
        while (elSequence < array_size) {
            resultList.add(0, elSequence);
            elSequence = 3 * resultList.get(0) + 1;
        }

        return resultList;
    }

    /**
     * сортировка Шелла
     *
     * @param array - сортируемый массив целых чисел
     */
    public static void SortShell(int[] array) {
        ArrayList<Integer> listSteps = KnuthSequence(array.length);
        for (int step: listSteps) {
            for (int i = 0; i < step; i++) {
                InsertionSortStep(array, step, i);
            }
        }
    }

}
