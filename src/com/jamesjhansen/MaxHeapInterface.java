package com.jamesjhansen;

/**
 * TODO
 * basic Heap interface
 */
public interface MaxHeapInterface<T extends Comparable<? super T>> {
    public void add(T newEntry);
    public T removeMax();
    public T getMax();
    public boolean isEmpty();
    public int getSize();
    public void clear();
}
