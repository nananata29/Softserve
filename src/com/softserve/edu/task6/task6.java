package com.softserve.edu.task6;

import java.io.*;
import java.nio.file.Path;

import static java.nio.file.Files.exists;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by Natalia on 08.01.2017.
 *Счастливые билеты.

 */
public class task6 {

    public static int bb(String in) throws IOException {
        int t = 0, m = 0, p = 0;
        int sizeOfSerialNumber = 5;


        int min = 1, max = 999999;
        int counter = 0;
        int even = 0;
        int add = 0;


        if (in.contains("Moscow")) {
            for (int i = min; i <= max; i++) {
                char serialNumber[] = {0, 0, 0, 0, 0, 0};
                String temp = Integer.toString(i);
                int k = sizeOfSerialNumber;
                for (int j = temp.length() - 1; j >= 0; j--) {
                    serialNumber[k] = temp.charAt(j);
                    k--;
                }
                //System.out.print(Arrays.toString(serialNumber));
                m = serialNumber[0] + serialNumber[1] + serialNumber[2];
                p = serialNumber[3] + serialNumber[4] + serialNumber[5];


                if (m == p) counter++;
            }
            return counter;

        } else if (in.contains("Piter")) {
            for (int i = min; i <= max; i++) {
                char serialNumber[] = {0, 0, 0, 0, 0, 0};
                String temp = Integer.toString(i);
                int k = sizeOfSerialNumber;
                for (int j = temp.length() - 1; j >= 0; j--) {
                    serialNumber[k] = temp.charAt(j);
                    k--;
                }
                //System.out.print(Arrays.toString(serialNumber));
                add = serialNumber[0] + serialNumber[2] + serialNumber[4];
                even = serialNumber[1] + serialNumber[3] + serialNumber[5];


                if (add == even) counter++;
            }
        }
        return counter;
    }

    public static void main (String[] args) {
        try {
            System.out.println("Enter filename");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String filename = reader.readLine();

            BufferedReader fileReader = new BufferedReader(new FileReader(filename));
            String choice = fileReader.readLine();

            if (Arrays.asList("Moscow", "Piter").contains(choice)) {
                int res = bb(choice);
                System.out.printf("There are %d possible lucky tickets for %s method%n", res, choice);
            }else System.out.printf("Method %s is not supported%n", choice);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Not the correct input");
        }
    }


}



