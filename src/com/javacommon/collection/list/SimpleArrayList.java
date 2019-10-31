package com.javacommon.collection.list;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private int currentSize = 0;
    private int realSize = 0;
    private int maxSize = 32;

    private boolean hasFree = false;
    private Object[] internalArray;

    public SimpleArrayList() {
        this(32);
    }

    private SimpleArrayList(int capacity){
        internalArray = new Object[capacity];
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return currentSize == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <E> E[] toArray(E[] array) {
        if(hasFree) {
            free();
        }

        for (var i = 0; i < array.length; i++) {
            array[i] = (E) internalArray[i];
        }
        return array;
    }

    @Override
    public void add(T element) {
        if(!(realSize < maxSize)) {
            resize();
        }

        internalArray[realSize] = element;
        currentSize++;
        realSize++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        Object element = null;
        if(hasFree) {
            int currentIndex = 0;

            for (Object item : internalArray) {
                if(item != null) {
                    if(currentIndex == index) {
                        element = item;
                    }
                    currentIndex++;
                }
            }
        }
        else {
            element = internalArray[index];
        }
        return (T)element;
    }

    @Override
    public void set(int index, T element) {
        if(hasFree){
            int currentIndex = 0;

            for (Object item : internalArray) {
                if(item != null) {
                    if(currentIndex == index) {
                        internalArray[index] = element;
                    }
                    currentIndex++;
                }
            }
        }
        internalArray[index] = element;
    }

    @Override
    public void remove(T element) {
        int index = -1;

        for(var i=0;i<internalArray.length;i++){
            if(element == this.get(i)){
                index = i;
            }
        }
        if(index != -1){
            this.removeAt(index);
        }
    }

    @Override
    public void removeAt(int index) {
        internalArray[index] = null;
        hasFree = true;
        currentSize--;
    }

    @Override
    public void clear() {
        internalArray = new Object[32];
        currentSize = 0;
        maxSize = 0;
    }

    @Override
    public boolean contains(T element) {
        boolean result = false;
        for (Object item : internalArray) {
            if(item == element) {
                result = true;
                break;
            }
        }
        return result;
    }

    @Override
    public int indexOf(T element) {
        return 0;
    }

    @Override
    public int lastIndexOf(T element) {
        return 0;
    }

    private void free() {
        int free = 0;
        Object[] newarray = new Object[maxSize];
        for (Object item : internalArray) {
            if(item != null) {
                newarray[free] = item;
                free++;
            }
        }
        internalArray = newarray;
        realSize = currentSize = free;
        hasFree = false;
    }

    private void resize() {
        maxSize *= 2;

        if(!hasFree) {
            internalArray = Arrays.copyOf(internalArray, maxSize);
        }
        else {
            free();
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < realSize;
            }

            @Override
            public T next() {
                if(hasFree) {
                    free();
                }
                return (T) internalArray[currentIndex++];
            }
        };
    }
}
