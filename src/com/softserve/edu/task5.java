package com.softserve.edu;

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
 * Created by Natalia on 12.01.2017.
 *
 */
public class task5 {
    private static String decToStr1to999 (long num, boolean sex) {
        double[] limits1to9 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        double[] limits10to900 = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900};
        String[] formats1to9Male = {"один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] formats1to9Female = {"одна", "две", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
        String[] formats10to900 = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать",
                "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемдесят", "девяносто",
                "сто", "двести", "триста", "четыреста", "пятьсот", "шестьсот", "семьсот", "восемьсот", "девятьсот"};
        if (num == 0) return "";
        if (num > 0 && num < 10) return sex?new ChoiceFormat(limits1to9, formats1to9Male).format(num):new ChoiceFormat(limits1to9, formats1to9Female).format(num);
        if (num >= 10 && num < 20) return new ChoiceFormat(limits10to900, formats10to900).format(num);
        return new ChoiceFormat(limits10to900, formats10to900).format(num) + " " + decToStr1to999(num % ((int)Math.pow(10, (long)Math.log10(num))), sex);
}
    public static String decToStr(long num) {
        ChoiceFormat cf1e3 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"тысяча", "тысячи", "тысяч"});
        ChoiceFormat cf1e6 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"миллион", "миллиона", "миллионов"});
        ChoiceFormat cf1e9 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"миллиард", "миллиарда", "миллиардов"});
        ChoiceFormat cf1e12 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"биллион", "биллиона", "биллионов"});
        ChoiceFormat cf1e15 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"триллион", "триллиона", "триллионов"});
        ChoiceFormat cf1e18 = new ChoiceFormat(new double[]{1, 2, 5}, new String[]{"квадриллион", "квадриллиона", "квадриллионов"});
        Map<Long, ChoiceFormat> formats = new HashMap<Long, ChoiceFormat>();
        formats.put(3l, cf1e3);
        formats.put(6l, cf1e6);
        formats.put(9l, cf1e9);
        formats.put(12l, cf1e12);
        formats.put(15l, cf1e15);
        formats.put(18l, cf1e18);
        if (num < 1000) return decToStr1to999(num, true);
        // Получаем порядок аргумента, округленный до 3
        long pow = (long)Math.log10(num) / 3 * 3;
        //количество порядков
        long a = (long) (num / Math.pow(10, pow));
        long lastDigit = a % 100 < 20 ? a % 100 : a % 10;
        return (pow==3 ? decToStr1to999(a, false) : decToStr1to999(a, true)) + " " + formats.get(pow).format(lastDigit) + " " + decToStr(num % ((long)Math.pow(10, pow)));
}
    public static void main(String[] args) {
        if (args.length == 0) System.out.println("Incorrect params");
        else {
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
}
}