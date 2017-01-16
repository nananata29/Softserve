package com.softserve.edu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Created by Natalia on 29.12.2016.
 */
public class task1 {
    public static void main(String[] args) throws FileNotFoundException {
        try {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            for (int i = 0; i < n; i++) {
                if (i % 2 == 0)
                    System.out.print("*");
                for (int j = 0; j < m; j++) {
                    System.out.print("  *");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Not the correct input");
        }
    }
    }


