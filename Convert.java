package main_package;

public class Convert
{
    private static int tryParse(String element,int defvalue)
    {
        try
        {
            return Integer.parseInt(element);
        }
        catch (NumberFormatException e)
        {
            return defvalue;
        }
    }

    private static double tryParse(String element,double defvalue)
    {
        try
        {
            return Double.parseDouble(element);
        }
        catch (NumberFormatException e)
        {
            return defvalue;
        }
    }

    public static int toInteger(String element)
    {
        return tryParse(element,0);
    }

    public static double toDouble(String element)
    {
        return tryParse(element,0.0);
    }

    public static boolean toBoolean(String element)
    {
        return Boolean.parseBoolean(element);
    }
}
