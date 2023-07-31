import static org.junit.jupiter.api.Assertions.*;

import org.example.PowerOf2MaxHeap;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

public class MaxHeapTests {

//    @Test
//    void test() {
//        fail("Not yet implemented");
//    }

    static PowerOf2MaxHeap max_heap;
//    static PowerOf2MaxHeap.M
    @BeforeEach
    void setup() {
        max_heap = new PowerOf2MaxHeap(15, 4);
        max_heap.MaxHeap = new int[15];
    }

    @Test
    void testSizeofMaxHeap() {
//      the initial size of the heap when it is created.
        assertEquals(0, max_heap.getSizeOfMaxHeap());
    }
    @Test
    void TestIsEmpty() {
        assertTrue(max_heap.isEmpty());
    }
    @Test
    void testIsFull() {
        assertFalse(max_heap.isFull());
    }
    @Test
    void testSwap() {

        max_heap.insertNodeItem(10);
        max_heap.insertNodeItem(4);
        assertEquals(2, max_heap.getSizeOfMaxHeap());

        assertEquals(4, max_heap.MaxHeap[0]);
        assertEquals(10, max_heap.MaxHeap[1]);
        max_heap.swapPosition(1,0);
        assertEquals(10, max_heap.MaxHeap[0]);
        assertEquals(4, max_heap.MaxHeap[1]);
    }
    @Test
    void testInsertNodeItem() {
//      insert few items into the heap and check if the size increases ...
        max_heap.insertNodeItem(10);
        max_heap.insertNodeItem(5);
        assertEquals(2, max_heap.getSizeOfMaxHeap());
        assertEquals(5, max_heap.MaxHeap[0]);
        assertEquals(10, max_heap.MaxHeap[1]);
    }

    @Test
    void testDeleteNodeItem() {
        max_heap.insertNodeItem(20);
        max_heap.insertNodeItem(10);
        max_heap.insertNodeItem(2);
        max_heap.insertNodeItem(19);
        assertEquals(4, max_heap.getSizeOfMaxHeap());

        assertEquals(2, max_heap.MaxHeap[0]);
        assertEquals(20, max_heap.MaxHeap[1]);
        assertEquals(19, max_heap.MaxHeap[3]);
        assertEquals(10, max_heap.MaxHeap[2]);

        max_heap.deleteNodeItem(1);
        assertEquals(3, max_heap.getSizeOfMaxHeap());
        assertEquals(2, max_heap.MaxHeap[0]);
        assertEquals(19, max_heap.MaxHeap[1]);
        assertEquals(10, max_heap.MaxHeap[2]);

        max_heap.deleteNodeItem(0);
        assertEquals(2, max_heap.getSizeOfMaxHeap());
        assertEquals(10, max_heap.MaxHeap[0]);
        assertEquals(19, max_heap.MaxHeap[1]);
    }

}
