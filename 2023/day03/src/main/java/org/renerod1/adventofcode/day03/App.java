package org.renerod1.adventofcode.day03;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Advent of Code Day 3
 *
 */
public class App {
    public static void main(String[] args) {
        part1("2023\\day03\\resources\\data\\main\\input.txt");
        part2("2023\\day03\\resources\\data\\main\\input.txt");
    }

    /**
     * Part 1
     * 
     */
    public static int part1(String file) {
        List<String> list = readFile(file);

        Iterator<String> itr = list.iterator();
        int i = 0;
        int j = 0;
        while (itr.hasNext()) {
            // System.out.print("Running total: ");
            // System.out.print(i);
            // System.out.print(" line: ");
            // System.out.println(j);
        }

        System.out.print("Part 1: ");
        System.out.print("Answer: ");
        System.out.print(i);
        System.out.print(", Lines read: ");
        System.out.println(j);

        return i;

    }

    /**
     * Part 2
     * 
     */
    public static int part2(String file) {
        List<String> list = readFile(file);

        Iterator<String> itr = list.iterator();
        int i = 0;
        int j = 0;
        while (itr.hasNext()) {
            // System.out.print("Running total: ");
            // System.out.print(i);
            // System.out.print(" line: ");
            // System.out.println(j);
        }

        System.out.print("Part 2: ");
        System.out.print("Answer: ");
        System.out.print(i);
        System.out.print(", Lines read: ");
        System.out.println(j);

        return i;

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
}
