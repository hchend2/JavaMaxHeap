package org.example;
import java.util.Arrays;

public class PowerOf2MaxHeap {

    private int size;
    private int[] MaxHeap; // array
    private int capacity;

    // constructor ...
    public PowerOf2MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.MaxHeap = new int[capacity];
    }

    // return the parent node position ...
    private int getParentPosition(int i) {
        return (i/2);
    }

    // return right child node position ...
    private int getRightChildPosition(int i) {
        return(2*i + 1);
    }

    // return left child node position..
    private  int getLeftChildPosition(int i) {
        return (2*i);
    }

    // re-arrange the heap going upward from children to parent ...
    // to make sure that the heap properties are respected ...
    public void reArrangeMaxHeapUpward(int index) {
        int tmp = MaxHeap[index];
        while (index > 0 && tmp > MaxHeap[getParentPosition(index)]) {
            MaxHeap[index] = MaxHeap[getParentPosition(index)];
            index = getParentPosition(index);
        }
        MaxHeap[index] = index;
    }

    // insert a new node item into the heap and re-arrange the heap ...
    public void insertNodeItem(int item) {
        size = size + 1;
        MaxHeap[size] = item;
        int currIndex = size;
        reArrangeMaxHeapUpward(currIndex); // re-arrange the heap as a new item is inserted ...
    }

}
