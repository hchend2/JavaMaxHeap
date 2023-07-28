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
    @BeforeEach
    void setup() {
        max_heap = new PowerOf2MaxHeap(10, 2);
    }

    @Test
    void testSizeofMaxHeap() {
//      the initial size of the heap when it created.
        assertEquals(0, max_heap.getSizeOfMaxHeap());
    }
    @Test
    void testInsertNodeItem() {
//      insert few items into the heap and check if the size increases ...
        max_heap.insertNodeItem(10);
        max_heap.insertNodeItem(5);
        assertEquals(2, max_heap.getSizeOfMaxHeap());
    }


}
