package com.softserve.edu.task3;
import java.text.DecimalFormat;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Natalia on 17.01.2017.
 */
public class triangle{

    private String name;
    private double a;
    private  double b;
    private  double c;
    private String[] splittedString;

    triangle (String triangl){
        String[] triangleenter = triangl.split(",");
        this.name = triangleenter[0];
        this.a = Double.parseDouble(triangleenter[1]);
        this.b = Double.parseDouble(triangleenter[2]);
        this.c = Double.parseDouble(triangleenter[3]);

        tringlevalid (triangleenter);
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

    private  void  tringlevalid (String[] triangleenter) {

        if(triangleenter.length != 4){
            System.out.println("Wrong number of arguments. " +
                    "You must enter a name and a length of 3 sides of triangle.");
        }
         String name = triangleenter[0];
        if(name.isEmpty()){
            System.out.println("No name of the triangle!");
        }
        try {
            Double a = Double.parseDouble(triangleenter[1]);
            Double b = Double.parseDouble(triangleenter[2]);
            Double c = Double.parseDouble(triangleenter[3]);
        }
        catch (NumberFormatException numbFormatExc){
            System.out.println("Side of the triangle is not a number!");

        }
        //whether there is a triangle
            if( (a > (c + b)) || (b > (a + b)) || (c > (a+b)) ){
                System.out.println("This triangle does not exist");
            }
    }
}
