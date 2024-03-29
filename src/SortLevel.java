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
        while (elSequence <= array_size) {
            resultList.add(0, elSequence);
            elSequence = 3 * elSequence + 1;
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
        for (int step : listSteps) {
            for (int i = 0; i < step; i++) {
                InsertionSortStep(array, step, i);
            }
        }
    }

    /**
     * Алгоритм разбиения массива на две группы
     * - шаг к классической быстрой сортировке
     *
     * @param M - массив
     * @return int - нидекс опорного элемента
     */

    public static int ArrayChunk(int[] M) {
        return ArrayChunk(M, 0, M.length - 1);
    }

    /**
     * Модификация для QuickSort
     *
     * @param M
     * @param left
     * @param right
     * @return
     */
    public static int ArrayChunk(int[] M, int left, int right) {
        int length = right - left + 1;
        if (length <= 1) return 0;
        int iN, N, i1, i2;
        iN = left + length / 2;
        N = M[iN];
        i1 = left;
        i2 = right;
        while (i1 != i2) {
            while (M[i1] < N) i1++;
            while (M[i2] > N) i2--;
            if (i1 == i2 - 1 && M[i1] > M[i2]) {
                int tempEl = M[i1];
                M[i1] = M[i2];
                M[i2] = tempEl;
                N = M[iN];
                i1 = left;
                i2 = right;
                continue;
            }

            int tempEl1 = M[i1];
            M[i1] = M[i2];
            M[i2] = tempEl1;

            if (M[i1] == N) iN = i1;
            if (M[i2] == N) iN = i2;
        }
        return iN;
    }

    /**
     * Быстрая сортировка Хоара
     *
     * @param array - массив
     * @param left  - левый индекс в алгоритме разбиения
     * @param right - правый индекс в алгоритме разбиения
     */
    public static void QuickSort(int[] array, int left, int right) {
        if (left >= right || right >= array.length || left < 0) return;
        int iN = ArrayChunk(array, left, right);
        QuickSort(array, left, iN - 1);
        QuickSort(array, iN + 1, right);
    }

    /**
     * Элиминация хвостовой рекурсии
     *
     * @param array
     * @param left
     * @param right
     */
    public static void QuickSortTailOptimization(int[] array, int left, int right) {
        if (left >= right || right >= array.length || left < 0) return;
        while (left < right) {
            int N = ArrayChunk(array, left, right);
            if (N - left < right - N) {
                QuickSortTailOptimization(array, left, N - 1);
                left = N + 1;
            } else {
                QuickSortTailOptimization(array, N + 1, right);
                right = N - 1;
            }
        }
    }

    /**
     * Поиск порядковых статистик - один шаг
     *
     * @param Array
     * @param L
     * @param R
     * @param k
     * @return
     */
    public static ArrayList<Integer> KthOrderStatisticsStep(int[] Array, int L, int R, int k) {
        if (L > R) return new ArrayList<>();
        int N = ArrayChunk(Array, L, R);
        if (N == k) return new ArrayList<>(Arrays.asList(N, N));
        if (N < k) return new ArrayList<>(Arrays.asList(N + 1, R));
        return new ArrayList<>(Arrays.asList(L, N - 1));
    }


    /**
     * Сортировка слиянием
     *
     * @param Array
     * @return
     */
    public static ArrayList<Integer> MergeSort(ArrayList<Integer> Array) {
        int length = Array.toArray().length;
        if (length <= 1) return Array;

        ArrayList<Integer> ArrayA = new ArrayList<>(Array.subList(0, length / 2));
        ArrayList<Integer> ArrayB = new ArrayList<>(Array.subList(length / 2, length));

        ArrayA = MergeSort(ArrayA);
        ArrayB = MergeSort(ArrayB);

        ArrayList<Integer> result = new ArrayList<>(length);

        while (ArrayA.toArray().length > 0 && ArrayB.toArray().length > 0) {
            int elA = ArrayA.iterator().next();
            int elB = ArrayB.iterator().next();

            if (elA < elB) {
                result.add(elA);
                ArrayA.remove(0);
            } else {
                result.add(elB);
                ArrayB.remove(0);
            }
        }

        while (ArrayA.toArray().length > 0) {
            result.add(ArrayA.iterator().next());
            ArrayA.remove(0);
        }
        while (ArrayB.toArray().length > 0) {
            result.add(ArrayB.iterator().next());
            ArrayB.remove(0);
        }

        return result;
    }

}
