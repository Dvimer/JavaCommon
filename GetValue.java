package main_package;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetValue
{
    public static int getInt()
    {
        int result = 0;
        boolean trigger = true;
        Scanner scan = new Scanner(System.in);

        while (trigger)
        {
            try
            {
                System.out.print("Введите целое число: ");
                result = scan.nextInt();
                trigger = false;
            }
            catch (InputMismatchException e)
            {
                trigger = false;
                result = getInt();
            }
        }

        return result;
    }

    public static double getDouble()
    {
        double result = 0.0;
        boolean trigger = true;
        Scanner scan = new Scanner(System.in);

        while (trigger)
        {
            try
            {
                System.out.print("Введите вещественное число: ");
                result = scan.nextDouble();
                trigger = false;
            }
            catch (InputMismatchException e)
            {
                trigger = false;
                result = getDouble();
            }
        }

        return result;
    }

    public static String getString()
    {
        String result = "";
        Scanner scan = new Scanner(System.in);

        System.out.print("Введите строку: ");
        result = scan.nextLine();

        return result;
    }

    public static char getChar()
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите символ: ");
        return scan.next().charAt(0);
    }


}



