import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}