package com.softserve.edu.task4;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
        * Created by Natalia on 07.01.2017.
 * Нужно написать программу, которая будет иметь два режима:
 1.	Считать количество вхождений строки в текстовом файле.
 2.	Делать замену строки на другую в указанном файле
 Программа должна принимать аргументы на вход при запуске:
 1.	<путь к файлу> <строка для подсчёта>
 2.	<путь к файлу> <строка для поиска> <строка для замены>
 C:\Program Files\Java\jdk1.8.0_111
 */

public class Task4 {

    public static void main(String[] args) {

        List<String> content = new ArrayList<String>();
        if (args.length == 2) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(args[0]));
                String target = args[1];
                int cnt = 0;
                Pattern pat = Pattern.compile(target);
                String readLine = reader.readLine();
                while (readLine != null)
                {
                    Matcher matcher = pat.matcher(readLine);
                    while (matcher.find()) {
                        cnt++;
                    }
                    readLine = reader.readLine();
                }
                reader.close();
                System.out.printf("Found %d entries%n", cnt);
                return;
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Not the correct input");
            }
        } else if (args.length == 3) {
            try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
                String target = args[1];
                String replacement = args[2];
                String readLine = reader.readLine();
                while (readLine != null) {
                    String line = readLine;
                    String replacedString = readLine.replaceAll(target, replacement);
                    content.add(replacedString);
                    readLine = reader.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Not the correct input");

            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(args[0]))) {
                for (String line : content) {
                    writer.write(line + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error");
                return;


            }
            System.out.println("Usage: \tprogram [file] [target] \n\t\tprogram [file] [target] [replacement]");
        }
    }

}