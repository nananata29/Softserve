package com.softserve.edu.task2;

import java.awt.geom.Arc2D;
import java.util.Scanner;

/**
 * Created by Natalia on 19.01.2017.
 */
public class Envelope {
    public double Width = 0;
    public double Height = 0;

    public double getWidth() {
        return Width;
    }

    public double getHeight() {
        return Height;
    }

    public void correctly_Envelope(Double arg) {
        if ((Width <= 0) || (Height <= 0) )
            throw new IllegalArgumentException("Error: do not put the long side");

        try {
            Scanner scanner = new Scanner(System.in);
            Width = scanner.nextDouble();
            Height = scanner.nextDouble();
        } catch (NumberFormatException numbFormatExc) {
            throw new IllegalArgumentException("Error: side of the envelope  is not a number!");


        }

    }

    public boolean compareEnvelope( Envelope otherEnvelope) {
        boolean compareWidth = false;
        boolean compareHeight = false;

        if(this.getWidth()> otherEnvelope.getWidth()&&this.getHeight()>otherEnvelope.getHeight())
            return true;
        else if(this.getWidth()< otherEnvelope.getWidth()&&this.getHeight()<otherEnvelope.getHeight())
            return true;
        else if(this.getWidth()< otherEnvelope.getHeight()&&this.getHeight()<otherEnvelope.getWidth())
            return true;
        else if(this.getWidth()> otherEnvelope.getHeight()&&this.getHeight()>otherEnvelope.getWidth())
            return true;
        else return false;

    }
}
