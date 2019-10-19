package com.javacommon;

public class Convert
{
    private static Integer tryParse(String element,int defaultValue)
    {
        try
        {
            return Integer.parseInt(element);
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }

    private static Double tryParse(String element,double defaultValue)
    {
        try
        {
            return Double.parseDouble(element);
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }

    public static Integer toInteger(String element)
    {
        return tryParse(element,0);
    }

    public static Double toDouble(String element)
    {
        return tryParse(element,0.0);
    }

    public static boolean toBoolean(String element)
    {
        return Boolean.parseBoolean(element);
    }
}
