/*
* This software is converts the integer in uppercase.
* The program is started through a call to the main class with parameters.
 */

package com.softserve.edu.task5;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ChoiceFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * The class is intended for translation into text format number that is passed in the command line
 * Supports numbers up to Long.MAX_VALUE (max = 9223372036854775807)
 *
 * @author Nataliia Horbulia
 * @version 1.01 11 Jan 2017
 */
public class Task5 {
    /**
     * Utility method intended for translation to text numbers to 1000
     *
     * @param num a number from 1 to 999
     * @param sex the genus, which build value
     * @return uppercase with a number from 1 to 1999
     */
    private static String decToStr1to999(long num, boolean sex) {
        double[] limits1to9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] limits10to900 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70,
                80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900};
        String[] formats1to9Male = {"один", "два", "три", "четыре", "пять", "шесть", "семь"
                , "восемь", "девять"};
        String[] formats1to9Female = {"одна", "две", "три", "четыре", "пять", "шесть", "семь"
                , "восемь", "девять"};
        String[] formats10to900 = {"десять", "одиннадцать", "двенадцать", "тринадцать"
                , "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать"
                , "девятнадцать", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят"
                , "семьдесят", "восемдесят", "девяносто", "сто", "двести", "триста", "четыреста"
                , "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        if (num == 0) return "";
        if (num > 0 && num < 10)
            if (sex)
                return new ChoiceFormat(limits1to9, formats1to9Male).format(num);
            else new ChoiceFormat(limits1to9, formats1to9Female).format(num);
        // recursion
        if (num >= 10 && num < 20)
            return new ChoiceFormat(limits10to900, formats10to900).format(num);
        return new ChoiceFormat(limits10to900, formats10to900).format(num) + " "
                + decToStr1to999(num % ((int) Math.pow(10, (long) Math.log10(num))), sex);
    }

    /**
     * This is the main method, which will parse the number of large orders
     *
     * @param num a number from 1 to 999
     * @return Long number for  1 to 9223372036854775807
     */
    public static String decToStr(long num) {
        /**
         * ChoiceFormat a separate input for each of the nominal degrees
         */
        ChoiceFormat cf1e3 = new ChoiceFormat(new double[]{1, 2, 5}
                , new String[]{"тысяча", "тысячи", "тысяч"});
        ChoiceFormat cf1e6 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"миллион"
                , "миллиона", "миллионов"});
        ChoiceFormat cf1e9 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"миллиард"
                , "миллиарда", "миллиардов"});
        ChoiceFormat cf1e12 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"биллион"
                , "биллиона", "биллионов"});
        ChoiceFormat cf1e15 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"триллион"
                , "триллиона", "триллионов"});
        ChoiceFormat cf1e18 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"квадриллион"
                , "квадриллиона", "квадриллионов"});

        Map<Long, ChoiceFormat> formats = new HashMap<Long, ChoiceFormat>();
        formats.put(3l, cf1e3);
        formats.put(6l, cf1e6);
        formats.put(9l, cf1e9);
        formats.put(12l, cf1e12);
        formats.put(15l, cf1e15);
        formats.put(18l, cf1e18);
        if (num < 1000) return decToStr1to999(num, true);
        // Received the order of the argument, rounded up to 3
        long pow = (long) Math.log10(num) / 3 * 3;
        // The number of orders
        long a = (long) (num / Math.pow(10, pow));
        long lastDigit = a % 100 < 20 ? a % 100 : a % 10;
        // recursion
        String str;
        if (pow == 3)
            str = decToStr1to999(a, false);
        else str = decToStr1to999(a, true);
        return str + " " + formats.get(pow).format(lastDigit) + " "
                + decToStr(num % ((long) Math.pow(10, pow)));
    }

    public static void main(String[] args) {
        if (args.length == 0) System.out.println("Incorrect params");
        else {
            // Parsim number as input, and produce text version.
            Long num = Long.parseLong(args[0]);
            System.out.println(decToStr(num));
        }
        System.out.printf("1 : %s%n", decToStr(1));
        System.out.printf("12 : %s%n", decToStr(12));
        System.out.printf("123 : %s%n", decToStr(123));
        System.out.printf("1234 : %s%n", decToStr(1234));
        System.out.printf("12345 : %s%n", decToStr(12345));
        System.out.printf("123456 : %s%n", decToStr(123456));
        System.out.printf("1234567 : %s%n", decToStr(1234567));
        System.out.printf("12345678 : %s%n", decToStr(12345678l));
        System.out.printf("123456789 : %s%n", decToStr(123456789l));
        System.out.printf("12345678910 : %s%n", decToStr(12345678910l));
        System.out.printf("1234567891011 : %s%n", decToStr(1234567891011l));
        System.out.printf("123456789101112 : %s%n", decToStr(123456789101112l));
        System.out.printf("12345678910111213 : %s%n", decToStr(12345678910111213l));
        System.out.printf("1234567891011121314 : %s%n", decToStr(1234567891011121314l));
        System.out.printf("%d : %s%n", Long.MAX_VALUE, decToStr(Long.MAX_VALUE));
    }
}