package com.javacommon.collection.list;

import java.util.*;

public class SimpleArrayList<T> implements SimpleList<T> {

    private int currentSize = 0;
    private int realSize = 0;
    private int maxSize = 32;
    private final int START_SIZE = 32;
    private boolean hasFree = false;
    Object[] internalArray;

    public SimpleArrayList(){
        internalArray = new Object[START_SIZE];
    }

    public SimpleArrayList(int capacity){
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
    public <T> T[] toArray(T[] array) {
        resize();

        for (var i = 0; i < array.length; i++) {
                array[i] = (T) internalArray[i];
        }
        return array;
    }

    @Override
    public void add(T element) {
        if(!(realSize < maxSize)) {
            resize();
        }

        internalArray[realSize] = (Object)element;
        currentSize++;
        realSize++;
    }

    @Override
    public T get(int index) {
        T element = null;
        if(hasFree != false) {
            int currentIndex = 0;

            for (var i=0;i<internalArray.length;i++) {
                if(internalArray[i] != null) {
                    if(currentIndex == index) {
                        element = (T)internalArray[i];
                    }
                    currentIndex++;
                }
            }
        }
        else {
            element = (T)internalArray[index];
        }
        return element;
    }

    @Override
    public void set(int index, T element) {
        if(hasFree != false){
            int currentIndex = 0;

            for (var i=0;i<internalArray.length;i++){
                if(internalArray[i] != null) {
                    if(currentIndex == index) {
                        internalArray[index] = (T)element;
                    }
                    currentIndex++;
                }
            }
        }
        internalArray[index] = (T)element;
    }

    @Override
    public void removeAt(int index) {
        internalArray[index] = null;
        hasFree = true;
        currentSize--;
    }

    @Override
    public void remove(T element) {

    }

    @Override
    public void clear() {
        internalArray = new Object[START_SIZE];
        currentSize = 0;
        maxSize = 0;
    }

    @Override
    public boolean contains(T element) {
        return false;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    private void resize() {
        maxSize *= 2;

        if(hasFree == false) {
            internalArray = Arrays.copyOf(internalArray, maxSize);
        }
        else{
            int free = 0;
            Object[] newarray = new Object[maxSize];
            for (var i=0;i<internalArray.length;i++) {
                if(internalArray[i] != null) {
                    newarray[free] = internalArray[i];
                    free++;
                }
            }
            internalArray = newarray;
            realSize = currentSize = free;
            hasFree = false;
        }
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < realSize;
            }

            @Override
            public T next() {
                if(hasFree != false) {
                    resize();
                }
                return (T) internalArray[currentIndex++];
            }
        };
        return it;
    }
}
