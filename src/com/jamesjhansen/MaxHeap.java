package com.jamesjhansen;

import java.util.Arrays;

/**
 * array-based implementation of MaxHeap
 * @param <T> generically-typed
 */
public class MaxHeap<T extends Comparable<? super T>>
        implements MaxHeapInterface<T> {

    /**
     * MaxHeap instance variables
     */
    private T[] heap;
    private int lastIndex;
    private static final int DEFAULT_INITIAL_CAPACITY = 101;
    private int swaps;

    /**
     * default constructor
     * calls parameterized constructor with default initial capacity
     */
    public MaxHeap() { this(DEFAULT_INITIAL_CAPACITY); }

    /**
     * parameterized constructor
     * creates new array-based heap (instantiates head)
     * @param initialCapacity initial capacity for heap array
     */
    public MaxHeap(int initialCapacity) {
        @SuppressWarnings("unchecked")
        T[] tempHeap =(T[]) new Comparable[initialCapacity+1];
        this.heap = tempHeap;
        this.lastIndex = 0;
    }

    /**
     * doubles capacity of heap array if full
     */
    private void ensureCapacity()
    {
        if ((heap.length - 1) == this.lastIndex)
            heap = Arrays.copyOf(heap, 2 * heap.length);
    }

    /**
     * pretty-prints this max heap
     * for purposes of project, only prints first 10 entries
     */
    @Override
    public String toString() {
        String o = "";
        for (int i=1; i<=10; i++) {
            o += this.heap[i] + ",";
        }
        return o;
    }

    /**
     * class methods
     */

    @Override
    public void add(T newEntry) {
        lastIndex++;
        ensureCapacity();
        int newIndex = lastIndex;
        int parentIndex = newIndex / 2;
        while ( (parentIndex > 0) && newEntry.compareTo(heap[parentIndex]) > 0)
        {
            heap[newIndex] = heap[parentIndex];
            newIndex = parentIndex;
            parentIndex = newIndex / 2;
            swaps++;
        }
        heap[newIndex] = newEntry;
    }

    /**
     * sorts entries to ensure heap structure
     * @param rootIndex index of root entry
     */
    private void reheap(int rootIndex) {
        boolean done = false;
        T orphan = heap[rootIndex];
        int leftChildIndex = 2 * rootIndex;
        while (!done && (leftChildIndex <= lastIndex)) {
            int largerChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if ((rightChildIndex <= lastIndex) &&
                    heap[rightChildIndex].compareTo(heap[largerChildIndex]) > 0) {
                largerChildIndex = rightChildIndex;
            } // end if
            if (orphan.compareTo(heap[largerChildIndex]) < 0) {
                heap[rootIndex] = heap[largerChildIndex];
                rootIndex = largerChildIndex;
                leftChildIndex = 2 * rootIndex;
            } else
                done = true;
        }
        heap[rootIndex] = orphan;
    }

    /**
     * removes max entry from heap
     * @return the (max) entry removed
     */
    @Override
    public T removeMax() {
        T root = null;
        if (!isEmpty())
        {
            root = heap[1];
            heap[1] = heap[lastIndex];
            lastIndex--;
            reheap(1);
        }
        return root;
    }

    /**
     * returns max entry in heap
     * @return entry with max value
     */
    @Override
    public T getMax() {
        T root = null;
        if (!isEmpty())
            root = this.heap[1];
        return root;
    }

    /**
     * checks if heap is empty
     * @return true if heap empty, false otherwise
     */
    @Override
    public boolean isEmpty() { return this.lastIndex < 1; }

    /**
     * returns number of entries in heap
     * @return integer size of heap
     */
    @Override
    public int getSize() { return this.lastIndex; }

    /**
     * removes all entries from heap
     */
    @Override
    public void clear() {
        for (; lastIndex > -1; lastIndex--)
            heap[lastIndex] = null;
        lastIndex = 0;
    }

    /**
     * returns number of swaps a method did
     * @return private integer of swaps
     */
    public int getSwaps() {
        return swaps;
    }

    /**
     * TODO
     * given integer array, build max heap using sequential insertions
     */
    public void sequentialHeap(T[] elements) {

        for (int i = 0; i < elements.length; i++) {
            this.add(elements[i]);
        }
    }

    /**
     * TODO
     * given integer array, build max heap using 'optimal' method
     */
    public MaxHeap<T> optimalHeap(int[] elements) {

        return null;
    }
}
