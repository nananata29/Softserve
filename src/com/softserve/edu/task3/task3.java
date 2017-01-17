package com.softserve.edu.task3;
import javax.lang.model.element.Name;
import javax.management.ObjectName;
import java.awt.*;
import java.awt.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.System.in;
import static javax.xml.bind.DatatypeConverter.parseDouble;
import static javax.xml.bind.DatatypeConverter.parseString;

/**
 * Created by Natalia on 06.01.2017.
 */
public class task3 {
    private String name;
    private double a;
    private  double b;
    private  double c;
    private String[] splittedString;
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<Double, String> map = new TreeMap<Double, String>(Collections.<Double>reverseOrder());
        while (true) {
            try {
                System.out.println("Enter name and a length of triangle side : ");
                String str = reader.readLine();
                if (str.equals("")) break;
                String[] splittedString = str.split(",");
                String name = splittedString[0];
                if(name.isEmpty()){
                    System.out.println("No name of the triangle!");
                }
                if(splittedString.length != 4){
                    System.out.println("Wrong number of arguments. " +
                            "You must enter a name and a length of 3 sides of triangle.");
                }
                try {
                    Double a = Double.parseDouble(splittedString[1]);
                    Double b = Double.parseDouble(splittedString[2]);
                    Double c = Double.parseDouble(splittedString[3]);
                    Double p = (a + b + c) / 2;
                    Double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    map.put(s, name);
                    if (a > (c + b)) {
                        System.out.println("This triangle does not exist");
                    }
                    if(b > (a+b)){
                        System.out.println("This triangle does not exist");
                    }
                    if (c > (a+b)){
                        System.out.println("This triangle does not exist");
                    }
                }
                catch (NumberFormatException numbFormatExc){
                    System.out.println("Side of the triangle is not a number!");
                }

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




