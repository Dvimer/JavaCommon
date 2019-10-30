package com.javacommon.collection.list;

import java.util.Iterator;

public interface SimpleList<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    public <T> T[] toArray(T[] array);

    void add(T element);

    public T get(int index);

    public void set(int index, T element);

    public void removeAt(int index);

    void remove(T element);

    public void clear();

    boolean contains(T element);

    public int indexOf(Object o);

    public int lastIndexOf(Object o);

    Iterator<T> iterator();

}
