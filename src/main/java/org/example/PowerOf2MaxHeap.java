package org.example;
import java.util.Arrays;
import java.lang.Math;
import static java.lang.Math.pow;

public class PowerOf2MaxHeap {
    private int size = 0;
//    private  int d;
    private int numberOfChildren;
    public int[] MaxHeap; // array
    private int capacity;

    // constructor ...
    public PowerOf2MaxHeap(int capacity, int n) {
        this.numberOfChildren = (int) pow(2, n);
        this.capacity = capacity;
        MaxHeap = new int[this.capacity];
        Arrays.fill(MaxHeap, -1);
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
        return size == capacity;
    }

    // return the parent node position ...
    private int getParentPosition(int i) {
        return (i - 1)/numberOfChildren;
    }
    // get the nth child of node a position i ...
    private int get_nthChildPosition(int i, int n) {
        return numberOfChildren * i + n;
    }
    // re-arrange the heap going upward from children to parent ...
    // to make sure that the heap properties are respected ...
    private void reArrangeMaxHeapUpward(int index) {
        int tmp = MaxHeap[index];
        while (index > 0 && tmp < MaxHeap[getParentPosition(index)]) {
            MaxHeap[index] = MaxHeap[getParentPosition(index)];
            index = getParentPosition(index);
        }
        MaxHeap[index] = tmp;
    }

    private int get_smallestChild(int index) {
        int i = 2;
        int smallestChild = get_nthChildPosition(index, 1);
        int pos = get_nthChildPosition(index, i);
        while ((i <= numberOfChildren) && (pos < getSizeOfMaxHeap())) {
            if (MaxHeap[pos] < MaxHeap[smallestChild]) {
                smallestChild = pos;
            }
            i++;
            pos = get_nthChildPosition(index, i);
        }
        return smallestChild;
    }
    // re-arrange the heap going downward from parent to children ...
    private void reArrangeMaxHeapDownward(int index) {
        int tmp = MaxHeap[index];
        while (get_nthChildPosition(index, 1) < getSizeOfMaxHeap()) {
            if (MaxHeap[get_smallestChild(index)] < tmp) {
                MaxHeap[index] = MaxHeap[get_smallestChild(index)];
            } else {
                break;
            }
            index = get_smallestChild(index);
        }
        MaxHeap[index] = tmp;
    }
    // swap 2 element ...
    public void swapPosition(int i, int j) {
        int tmp;
        tmp = MaxHeap[i];
        MaxHeap[i] = MaxHeap[j];
        MaxHeap[j] = tmp;
    }
    // insert a new node item into the heap and re-arrange the heap ...
    public void insertNodeItem(int item) {
        MaxHeap[getSizeOfMaxHeap()] = item;
        int currIndex = getSizeOfMaxHeap();
        reArrangeMaxHeapUpward(currIndex);
        size = getSizeOfMaxHeap() + 1;
    }
    // delete node at a specific index and re-arrange the maxheap ...
    public int deleteNodeItem(int index) {
        int i = MaxHeap[index];
        MaxHeap[index] = MaxHeap[getSizeOfMaxHeap() - 1];
        size = getSizeOfMaxHeap() - 1;
        reArrangeMaxHeapDownward(index);

        return i;
    }

    public  int findMinimum() {
        int minim = -1;
        try {
            minim = MaxHeap[0];
        } catch (Exception e) {

        }
       return  minim;
    }
}
