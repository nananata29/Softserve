package com.softserve.edu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Natalia on 12.01.2017.
 */
public class task8 {
    public static void main(String[] args) {

        ArrayList fibonacciNumbers = new ArrayList();
        try {
            Scanner s = new Scanner(System.in);
            System.out.print("Conclusion Fibonacci series at a specified interval:");
            int first = s.nextInt();
            int second = s.nextInt();
            int a = 1;
            int b = 1;
            int fib = 2;
            int i = 2;
            System.out.println("The Fibonacci sequence " +(second - first + 1) + ":");

            fibonacciNumbers.add(a);
            fibonacciNumbers.add(b);

            while (i < second) {
                fib = a + b;
                a = b;
                b = fib;
                i++;
                fibonacciNumbers.add(fib);
            }

            for (int j = first - 1; j < second; j++)
                System.out.print(fibonacciNumbers.get(j) + ", ");

            fibonacciNumbers.clear();
            return;
        } catch (Exception e) {
            System.out.println("Not the correct input");
        }
    }
}
