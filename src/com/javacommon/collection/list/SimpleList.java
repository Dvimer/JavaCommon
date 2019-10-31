package com.javacommon.collection.list;

import java.util.Iterator;

public interface SimpleList<T> extends Iterable<T> {

    int size();

    boolean isEmpty();

    public <E> E[] toArray(E[] array);

    void add(T element);

    public Object get(int index);

    public void set(int index, T element);

    public void removeAt(int index);

    void remove(T element);

    public void clear();

    boolean contains(T element);

    public int indexOf(T element);

    public int lastIndexOf(T element);

    Iterator<T> iterator();

}
