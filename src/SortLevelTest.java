import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import structures.Heap;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortLevelTest {
    int[] array;

    @BeforeEach
    void setUp() {
        array = new int[]{7, 6, 5, 4, 3, 2, 1};
    }

    @Test
    void insertionSortStep() {
        SortLevel.InsertionSortStep(array, 3, 0);
        assertArrayEquals(new int[]{1, 6, 5, 4, 3, 2, 7}, array);
        SortLevel.InsertionSortStep(array, 3, 1);
        assertArrayEquals(new int[]{1, 3, 5, 4, 6, 2, 7}, array);
        SortLevel.InsertionSortStep(array, 3, 2);
        assertArrayEquals(new int[]{1, 3, 2, 4, 6, 5, 7}, array);
        SortLevel.InsertionSortStep(array, 3, 3);
        assertArrayEquals(new int[]{1, 3, 2, 4, 6, 5, 7}, array);
        SortLevel.InsertionSortStep(array, 1, 0);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, array);

    }

    @Test
    void KnuthSequence() {
        assertEquals(0, SortLevel.KnuthSequence(-1).size());
        assertEquals(3, SortLevel.KnuthSequence(15).size());
        assertEquals(6, SortLevel.KnuthSequence(400).size());
        assertEquals(1, SortLevel.KnuthSequence(1).size());


    }

    @Test
    void SortShell() {
        SortLevel.SortShell(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, array);
    }

    @Test
    void QuickSort() {
        SortLevel.QuickSort(array, 2, 5);
        assertArrayEquals(new int[]{7, 6, 2, 3, 4, 5, 1}, array);
        SortLevel.QuickSort(array, 0, 6);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, array);
    }

    @Test
    void QuickSortTailOptimization() {
        SortLevel.QuickSortTailOptimization(array, 2, 5);
        assertArrayEquals(new int[]{7, 6, 2, 3, 4, 5, 1}, array);
        SortLevel.QuickSort(array, 0, 6);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6, 7}, array);
    }

    @Test
    void KthOrderStatisticsStep() {
        array = new int[]{3, 5, 2, 4, 1, 55, 43, 22, 6, 7, 8, 53};
        ArrayList<Integer> list = SortLevel.KthOrderStatisticsStep(array, 0, 11, 0);
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(0, 8));
        assertArrayEquals(list.toArray(), list2.toArray());
    }

    @Test
    void MergeSort() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(3, 5, 2, 4, 1, 55, 43, 22, 6, 7, 8, 53));
        ArrayList<Integer> list = SortLevel.MergeSort(array);
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 22, 43, 53, 55));
        assertArrayEquals(expected.toArray(), list.toArray());
    }

    @Test
    void GetNextMax() {
        array = new int[]{3, 5, 2, 4, 1, 55, 55, 43, 22, 6, 7, 8, 53};
        HeapSort testHeap1 = new HeapSort(array);
        assertEquals(55, testHeap1.GetNextMax());
        assertEquals(55, testHeap1.GetNextMax());
        assertEquals(53, testHeap1.GetNextMax());
        assertEquals(43, testHeap1.GetNextMax());
        assertEquals(22, testHeap1.GetNextMax());
        assertEquals(8, testHeap1.GetNextMax());
        assertEquals(7, testHeap1.GetNextMax());
        assertEquals(6, testHeap1.GetNextMax());
        assertEquals(5, testHeap1.GetNextMax());
        assertEquals(4, testHeap1.GetNextMax());
        assertEquals(3, testHeap1.GetNextMax());
        assertEquals(2, testHeap1.GetNextMax());
        assertEquals(1, testHeap1.GetNextMax());
        assertEquals(-1, testHeap1.GetNextMax());

        array = new int[]{};
        HeapSort testHeap2 = new HeapSort(array);
        assertEquals(-1, testHeap2.GetNextMax());
    }
}