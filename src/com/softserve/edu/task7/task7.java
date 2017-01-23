package com.softserve.edu.task7;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Natalia on 04.01.2017.
 */
public class Task7 {

    public static void  natural_number(int n) {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        try {
           int k=0;
            System.out.println("Enter the number n = ");
            //int n = Integer.parseInt(sc.readLine());
            System.out.println("The number of square which is less than the specified n:");
            for (int i = 0; i < n; i++) {
                k = (int) Math.pow(i, 2);
                String str = "Test";
                if (k < n) {
                  // String k = Integer.toString(i);
                    System.out.println(k + ",");
                }
            }
        } catch (Exception e) {
            System.out.println("Not the correct input");
        }
    }
}


