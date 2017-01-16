package com.softserve.edu;
import java.util.Scanner;
import static java.lang.System.in;
import static java.lang.System.setOut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Natalia on 03.01.2017.
 */
public class task2 {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                // the first envelope
                System.out.println("1. Enter the width of the envelope :  ");
                int w1 = Integer.parseInt(sc.readLine());
                System.out.println("1. Enter the height of the envelope :  ");
                int h1 = Integer.parseInt(sc.readLine());

                // the second envelope
                System.out.println("2. Enter the width of the envelope :  ");
                int w2 = Integer.parseInt(sc.readLine());
                System.out.println("2. Enter the height of the envelope :  ");
                int h2 = Integer.parseInt(sc.readLine());

                int senv1 = w1 * h1;
                int senv2 = w2 * h2;
                if (senv1 > senv2) {
                    System.out.println("can inverst");
                } else {
                    System.out.println("can't inverst");
                }
                System.out.println("Do you want to continue yes or no?");
                String yn = sc.readLine();
                if (yn.contains("no")) {
                    return;
                }
            }
            catch (Exception e){
                System.out.println("Not the correct input");
            }
        }
    }
}


