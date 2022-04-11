package com.jamesjhansen;

import java.util.Arrays;

/**
 * array-based implementation of MaxHeap
 * @param <T> generically-typed
 */
public class MaxHeap<T> implements Heap {

    /**
     * MaxHeap instance variables
     */
    private T[] heap;
    private int count;
    private static final int DEFAULT_INITIAL_CAPACITY = 100;

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
        T[] tempHeap =(T[]) new Object[initialCapacity];
        heap = tempHeap;
    }

    /**
     * doubles capacity of heap array if full
     */
    private void ensureCapacity()
    {
        if ((heap.length - 1) == this.count)
            heap = Arrays.copyOf(heap, 2 * heap.length);
    }

    /**
     * getters and setters
     */
    public T[] getHeap() {
        return heap;
    }

    public void setHeap(T[] heap) {
        this.heap = heap;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * TODO
     * pretty-prints this max heap
     */
    @Override
    public String toString() {
        String o = "";

        return o;
    }

    /**
     * class methods
     */

    /**
     * TODO
     * sets *this* to a max heap using given integers using sequential insertions
     */
    public void sequentialHeapify(int[] elements) {

    }

    /**
     * TODO
     * sets *this* to a max heap using given integers using the optimal method
     */
    public void optimalHeapify(int[] elements) {

    }

}
