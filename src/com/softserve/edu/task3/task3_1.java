package com.softserve.edu.task3;

import java.awt.geom.Arc2D;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Natalia on 17.01.2017.
 */
public class Task3_1 {
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Double, String> map = new TreeMap<Double, String>(Collections.<Double>reverseOrder());
        while (true) {
            try {
                //  System.out.println("Enter name and a length of Triangle side : ");
                String str = reader.readLine();
                if (str.equals("")) break;

                Triangle triangle1 = new Triangle(str);
                String name = triangle1.getName();


                //a = triangle.getA();
                // b = triangle.getB();
                // c = triangle.getC();
                map.put(Heron(triangle1), name);

                System.out.println("================= Triangles list: ===================");
                //Sort
                for (Map.Entry<Double, String> entry : map.entrySet()) {
                    System.out.println(String.format("[Triangle %s] %f cm", entry.getValue(), entry.getKey()));
                }

                System.out.println("Do you want to continue yes or no?");
                String yn = sc.readLine();
                if (yn.contains("no")) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Not the correct input");
            }

        }
    }

    public static double Heron(Triangle triangle1) {
        Double p = (triangle1.getA() + triangle1.getB() + triangle1.getC()) / 2;
        Double s = Math.sqrt(p * (p - triangle1.getA()) * (p - triangle1.getB()) * (p -
                triangle1.getC()));
        return s;
    }
    }

