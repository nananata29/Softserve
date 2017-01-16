package com.softserve.edu;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.setOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Natalia on 04.01.2017.
 */
public class task7 {
    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the number n = ");
            int n = Integer.parseInt(sc.readLine());
            System.out.println("The number of square which is less than the specified n:");
            for (int i = 0; i < n; i++) {
                int k = (int) Math.pow(i, 2);
                if (k < n) {
                    System.out.print(k + ",");
                }
            }
        }
        catch (Exception e){
            System.out.println("Not the correct input");

        }
    }
}