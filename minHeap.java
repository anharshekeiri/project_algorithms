package algraithms_project;
import java.text.DateFormat;

import java.util.*;

public class minHeap {
    int capacity;
    int currentSize;
    HeapNode[] mH;
    int[] indexes; //will be used to decrease the key

    public minHeap(int capacity) {
        this.capacity = capacity;
        mH = new HeapNode[capacity + 1];
        indexes = new int[capacity];
        mH[0] = new HeapNode();
        mH[0].key = Integer.MIN_VALUE;
        mH[0].vertex.label = -1;
        currentSize = 0;
    }

    public void display() {
        for (int i = 0; i <= currentSize; i++) {
            System.out.println(" " + mH[i].vertex + " key " + mH[i].key);
        }
        System.out.println("________________________");
    }

    public void insert(HeapNode x) {
        currentSize++;
        int index = currentSize;
        mH[index] = x;
        indexes[x.vertex.label] = index;
        percolateUp(index);
    }

    public void percolateUp(int position) {
        int parentIdx = position / 2;
        int currentIdx = position;
        while (currentIdx > 0 && mH[parentIdx].key > mH[currentIdx].key) {
            HeapNode currentNode = mH[currentIdx];
            HeapNode parentNode = mH[parentIdx];

            //swap the positions
            indexes[currentNode.vertex.label] = parentIdx;
            indexes[parentNode.vertex.label] = currentIdx;
            swap(currentIdx, parentIdx);
            currentIdx = parentIdx;
            parentIdx = parentIdx / 2;
        }
    }

    public HeapNode extractMin() {
        HeapNode min = mH[1];
        HeapNode lastNode = mH[currentSize];
        // update the indexes[] and move the last node to the top
        indexes[lastNode.vertex.label] = 1;
        mH[1] = lastNode;
        mH[currentSize] = null;
        heapify(1);
        currentSize--;
        return min;
    }

    public void heapify(int k) {
        int smallest = k;
        int leftChildIdx = 2 * k;
        int rightChildIdx = 2 * k + 1;
        if (leftChildIdx < heapSize() && mH[smallest].key > mH[leftChildIdx].key) {
            smallest = leftChildIdx;
        }
        if (rightChildIdx < heapSize() && mH[smallest].key > mH[rightChildIdx].key) {
            smallest = rightChildIdx;
        }
        if (smallest != k) {

            HeapNode smallestNode = mH[smallest];
            HeapNode kNode = mH[k];

            //swap the positions
            indexes[smallestNode.vertex.label] = k;
            indexes[kNode.vertex.label] = smallest;
            swap(k, smallest);
            heapify(smallest);
        }
    }

    public void swap(int a, int b) {
        HeapNode temp = mH[a];
        mH[a] = mH[b];
        mH[b] = temp;
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public int heapSize() {
        return currentSize;
    }

}
