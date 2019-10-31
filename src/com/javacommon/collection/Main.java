package com.javacommon.collection;

import com.javacommon.collection.list.SimpleArrayList;


public class Main {

    public static void main(String[] args) {

        SimpleArrayList<Integer> my_list = new SimpleArrayList<>();
        for(var i=0;i<136;i++){
            my_list.add(i);

        }

        my_list.removeAt(33);
        System.out.println(my_list.get(33));

        for (Integer item: my_list) {
            System.out.println(item);
        }

    }
}
