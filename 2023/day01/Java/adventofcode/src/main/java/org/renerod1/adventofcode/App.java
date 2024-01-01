package org.renerod1.adventofcode;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Advent of Code Day 1
 *
 */
public class App {
    public static void main(String[] args) {
        part1();
    }

    /**
     * Part 1
     */
    public static void part1() {
        // List<String> list = readFile("2023\\day01\\Java\\adventofcode\\src\\data\\sample_input.txt");
        List<String> list = readFile("2023\\day01\\Java\\adventofcode\\src\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        int i = 0;
        int j = 0;
        while (itr.hasNext()) {
            i += getTwoDigitNumber(itr.next(), ++j);

            // System.out.print("Running total: ");
            // System.out.print(i);
            // System.out.print(" line: ");
            // System.out.println(j);
        }

        System.out.print("Answer: ");
        System.out.print(i);
        System.out.print(", Lines read: ");
        System.out.println(j);
    }

    private static List<String> readFile(String file) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Integer getTwoDigitNumber(String line, int counter) {
        String number = "";
        String digit1 = "";
        String digit2 = "";
        int i = 0;
        int j = 0;

        // System.out.print("Line: ");
        // System.out.print(counter);
        // System.out.print(" value: ");
        // System.out.print(line);
        // System.out.print(" length: ");
        // System.out.print(line.length());

        for (i = 0; i < line.length(); i++) {
            if (isNumber(line.charAt(i))) {
                digit1 = String.valueOf(line.charAt(i));
                break;
            }
        }

        for (j = line.length() - 1; i <= j; j--) {
            if (isNumber(line.charAt(j))) {
                digit2 = String.valueOf(line.charAt(j));
                break;
            }
        }
        // System.out.print(" digit1: ");
        // System.out.print(digit1);
        // System.out.print(" digit2: ");
        // System.out.print(digit2);

        number = digit1.concat(digit2);

        // System.out.print(" number: ");
        // System.out.println(number);

        return Integer.parseInt(number);
    }

    private static boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
