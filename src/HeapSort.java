import structures.Heap;

public class HeapSort {
    public Heap HeapObject;

    public HeapSort(int[] notSortArray) {
        HeapObject = new Heap();
        HeapObject.MakeHeap(notSortArray, notSortArray.length);
        for (int el: notSortArray) {
            HeapObject.Add(el);
        }
    }

    public int GetNextMax() {
        return HeapObject.GetMax();
    }
}
