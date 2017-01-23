package com.softserve.edu.task3;

import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Natalia on 17.01.2017.
 */
public class Triangle {

    private String name;
    private double a;
    private double b;
    private double c;

    public Triangle(String triangl) {
        String[] triangleenter = triangl.split(",");
        this.name = triangleenter[0];
        this.a = Double.parseDouble(triangleenter[1]);
        this.b = Double.parseDouble(triangleenter[2]);
        this.c = Double.parseDouble(triangleenter[3]);

        tringlevalid(triangleenter);
    }

    public String getName() {
        return name;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    private void tringlevalid(String[] triangleenter) {

        if (triangleenter.length != 4) {
            throw new IllegalArgumentException("Wrong number of arguments. " +
                    "You must enter a name and a length of 3 sides of Triangle.");
        }
        String name = triangleenter[0];
        if (name.isEmpty()) {
            throw new IllegalArgumentException("No name of the Triangle!");
        }
        try {
            a = Double.parseDouble(triangleenter[1]);
            b = Double.parseDouble(triangleenter[2]);
            c = Double.parseDouble(triangleenter[3]);
        } catch (NumberFormatException numbFormatExc) {
            throw new IllegalArgumentException("Side of the Triangle is not a number!");
        }
        if (a<=0 || b<=0 || c<=0) {
            throw new IllegalArgumentException("Side +");
        }

        //whether there is a Triangle
        if ((a > (c + b)) || (b > (a + b)) || (c > (a + b))) {
            throw new IllegalArgumentException("This Triangle does not exist");
        }
    }
}
