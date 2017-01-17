package com.softserve.edu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Natalia on 17.01.2017.
 */
public class task3_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Double, String> map = new TreeMap<Double, String>(Collections.<Double>reverseOrder());
        while (true) {
            try {
                System.out.println("Enter name and a length of triangle side : ");
                String str = reader.readLine();
                if (str.equals("")) break;
                String[] sides = str.split(",");
                String name = sides[0];
                Double a = Double.parseDouble(sides[1]);
                Double b = Double.parseDouble(sides[2]);
                Double c = Double.parseDouble(sides[3]);
                Double p = (a + b + c) / 2;
                Double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                map.put(s, name);
                System.out.println("================= Triangles list: ===================");
                //Sort
                for (Map.Entry<Double, String> entry : map.entrySet()) {
                    System.out.println(String.format("[Triangle %s] %f cm", entry.getValue(), entry.getKey()));
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


