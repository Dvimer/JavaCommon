package com.javacommon;

import java.util.List;

public class ListUtils {

    public static int[] toIntArray(List<Integer> list){
        int[] result = new int[list.size()];

        for(var i=0;i<list.size();i++)
        {
            result[i] = (int)list.get(i);
        }
        return result;
    }

    public static double[] toDoubleArray(List<Double> list){
        double[] result = new double[list.size()];

        for(var i=0;i<list.size();i++)
        {
            result[i] = (double)list.get(i);
        }
        return result;
    }

    public static long[] toLongArray(List<Long> list){
        long[] result = new long[list.size()];

        for(var i=0;i<list.size();i++)
        {
            result[i] = (long)list.get(i);
        }
        return result;
    }
}
