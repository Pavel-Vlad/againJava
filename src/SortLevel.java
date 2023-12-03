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
}
