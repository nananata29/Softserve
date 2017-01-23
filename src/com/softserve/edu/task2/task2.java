package com.softserve.edu.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Natalia on 03.01.2017.
 */
public class Task2 {

    public static void main(String[] args) throws IOException {

        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        Envelope envelope1 = new Envelope();
        Envelope envelope2 = new Envelope();
        String positive_reply = "can inverst";
        String negative_reply = "can't inverst";
        String resalt;


        while (true) {
            // the first envelope
            System.out.println("1. Enter the width of the first envelope :  ");
            envelope1.Width = Integer.parseInt(sc.readLine());
            System.out.println("1. Enter the height of the first envelope :  ");
            envelope1.Height = Integer.parseInt(sc.readLine());

            // the second envelope
            System.out.println("2. Enter the width of the second envelope :  ");
            envelope2.Width = Integer.parseInt(sc.readLine());
            System.out.println("2. Enter the height of the second  envelope :  ");
            envelope2.Height = Integer.parseInt(sc.readLine());

            boolean firstInsertedToSecond = envelope1.compareEnvelope(envelope2);
            if (firstInsertedToSecond) {
                resalt = positive_reply;
            } else
                resalt = negative_reply;

            System.out.println("Answer is:"+resalt);

            System.out.println("Do you want to continue yes or no?");
            String answer = sc.readLine();
            if (answer.toLowerCase().contains("yes") || (answer.toLowerCase().contains("y")
                    &&answer.length()==1)) {
            } else if (answer.toLowerCase().contains("no") || (answer.toLowerCase().contains("n")
                    &&answer.length()==1))
                break;
            else{
                System.out.println("Incorrect data");
                break;
            }



        }


    }
}