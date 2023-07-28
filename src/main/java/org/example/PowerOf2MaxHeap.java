package org.example;
import java.util.Arrays;
import java.lang.Math;

import static java.lang.Math.pow;

public class PowerOf2MaxHeap {
    private int size = 0;
//    private  int d;
    private int numberOfChildren;
    private int[] MaxHeap; // array
    private int capacity;

    // constructor ...
    public PowerOf2MaxHeap(int capacity, int n) {
        this.numberOfChildren = (int) pow(2, n);
        this.capacity = capacity;
        MaxHeap = new int[this.capacity];
    }

    // get size of the heap array ...
    public int getSizeOfMaxHeap() {
        return size;
    }

    // return true if heap is empty ...
    public boolean isEmpty() {
        return size == 0;
    }

    // return true if heap is full ...
    public boolean isFull() {
        return size == MaxHeap.length;
    }

    // return the parent node position ...
    private int getParentPosition(int i) {
        return (i - 1)/2;
    }

    // return right child node position ...
    private int getRightChildPosition(int i) {
        return (2*i + 2);
    }

    // return left child node position ...
    private  int getLeftChildPosition(int i) {
        return (2*i + 1);
    }

    // re-arrange the heap going upward from children to parent ...
    // to make sure that the heap properties are respected ...
    public void reArrangeMaxHeapUpward(int index) {
        int tmp = MaxHeap[index];
        while (index > 0 && tmp < MaxHeap[getParentPosition(index)]) {
            MaxHeap[index] = MaxHeap[getParentPosition(index)];
            index = getParentPosition(index);
        }
        MaxHeap[index] = tmp;
    }

    // swap 2 element ...
    private void swapPosition(int i, int j) {
        int tmp;
        tmp = MaxHeap[i];
        MaxHeap[i] = MaxHeap[j];
        MaxHeap[j] = tmp;
    }

    // insert a new node item into the heap and re-arrange the heap ...
    public void insertNodeItem(int item) {
        MaxHeap[size] = item;
        int currIndex = size;
        while (MaxHeap[currIndex] > MaxHeap[getParentPosition(currIndex)]) {
            swapPosition(currIndex, getParentPosition(currIndex)); // swap elements ...
            currIndex = getParentPosition(currIndex); // update current position ...
        }
        size++;
    }

}
