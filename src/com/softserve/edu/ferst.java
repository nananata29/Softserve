package com.softserve.edu;
//test
import javax.swing.*;
import java.util.Scanner;
import java.io.File;

/**
 * Created by Natalia on 16.01.2017.
 */
public class ferst {
    private static Scanner scn;
    static String [][] m = new String[5][3];

    public  static void main (String args []){
    openFile();
    readerFile();
    outFile();


    }

    private static void outFile() {
        for (int i=0; i< m.length; i++)
        {
            for (int j=0;j<m[i].length; j++){
                System.out.print(m[i][j]+ "");
            }
            System.out.println();
        }
    }

    private static void readerFile() {
        while (scn.hasNext()){
            for (int i=0; i< m.length; i++)
            {
                for (int j=0;j<m[i].length; j++){
                    m [i][j] = scn.next();
                }

            }
        }
    }

    private static void openFile() {
        try {
            scn = new Scanner (new File("1.txt"));
        }catch (Exception e){JOptionPane.showMessageDialog(null,"Not faund");}

    }
}
