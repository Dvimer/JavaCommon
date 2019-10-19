package com.javacommon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtils
{

    public static Integer getInt(String message) {

        Integer result = null;
        Scanner scan = new Scanner(System.in);

        System.out.print(message);
        if(scan.hasNextInt()) {

            result = scan.nextInt();
        }
        else {
            result = getInt(message);
        }

        return result;
    }

    public static Double getDouble(String message)
    {
        Double result = null;
        Scanner scan = new Scanner(System.in);

        System.out.print(message);
        if(scan.hasNextInt()) {

            result = scan.nextDouble();
        }
        else {
            result = getDouble(message);
        }

        return result;
    }

    public static String getString(String message)
    {
        String result = null;
        Scanner scan = new Scanner(System.in);

        System.out.print(message);
        result = scan.nextLine();

        return result;
    }

    public static char getChar(String message)
    {
        Scanner scan = new Scanner(System.in);
        System.out.print(message);
        return scan.next().charAt(0);
    }


}



