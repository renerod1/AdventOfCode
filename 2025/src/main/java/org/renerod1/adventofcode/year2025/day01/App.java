package org.renerod1.adventofcode.year2025.day01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        part2();
    }

    /**
     * Part 1
     */
    public static void part1() {
        // List<String> list = readFile("2025\\src\\main\\resources\\day01\\data\\sample_input.txt");
        List<String> list = readFile("2025\\src\\main\\resources\\day01\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        Integer password = 0;
        ArrayList<String> i = new ArrayList<>();
        ArrayList<Integer> j = new ArrayList<>();

        while (itr.hasNext()) {
            String line = itr.next();
            // System.out.println("Line: " + line);
            i.add(line.substring(0,1));
            j.add(Integer.parseInt(line.substring(1)));
        }

        password = getPassword(i, j, 0, 99, 50);

        System.out.print("Part 1: ");
        System.out.print("Answer: ");
        System.out.print(password);
        System.out.print(", Lines read: ");
        System.out.println(j.size());
    }

    /**
     * Part 2
     */
    public static void part2() {
        // List<String> list = readFile("2025\\src\\main\\resources\\day01\\data\\sample_input.txt");
        List<String> list = readFile("2025\\src\\main\\resources\\day01\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        Integer password = 0;
        ArrayList<String> i = new ArrayList<>();
        ArrayList<Integer> j = new ArrayList<>();

        while (itr.hasNext()) {
            String line = itr.next();
            // System.out.println("Line: " + line);
            i.add(line.substring(0,1));
            j.add(Integer.parseInt(line.substring(1)));
        }

        password = getPassword2(i, j, 0, 99, 50);

        System.out.print("Part 2: ");
        System.out.print("Answer: ");
        System.out.print(password);
        System.out.print(", Lines read: ");
        System.out.println(j.size());
    }

    private static Integer getPassword(ArrayList<String> i, ArrayList<Integer> j, Integer min, Integer max, Integer seed) {

        Integer total = 0;
        Integer value = seed;

        // System.out.println("The dial starts by pointing at " + value);
        for (int k = 0; k < j.size(); k++) {
            // System.out.print("The dial is rotated " + i.get(k) + j.get(k));
            switch (i.get(k)) {
                case "L":
                    value -= j.get(k);
                    while (value < min) { 
                        value += (max+1);
                    }
                    break;
                case "R":
                    value += j.get(k);
                    while (value > max) { 
                        value -= (max+1);
                    }
                    break;            
                default:
                    break;
                    
            }
            // System.out.print(" to point at " + value);
            if (value == 0) { 
                total++;
            }
            // System.out.println(" running password " + total);
        }

        return total;
    }

    private static Integer getPassword2(ArrayList<String> i, ArrayList<Integer> j, Integer min, Integer max, Integer seed) {

        Integer total = 0;
        Integer value = seed;

        // System.out.println("The dial starts by pointing at " + value);
        for (int k = 0; k < j.size(); k++) {
            // System.out.print("The dial is rotated " + i.get(k) + j.get(k));
            switch (i.get(k)) {
                case "L":
                    // System.out.print(" value " + value);
                    for (int l = 0; l < j.get(k); l++) {
                        value--;
                        if (value < min) {
                            value = max;
                        }
                        if (value == 0) { 
                            total++;
                        }
                    }
                    // System.out.print(", value " + value);
                    break;
                case "R":
                    // System.out.print(" value " + value);
                    for (int l = 0; l < j.get(k); l++) {
                        value++;
                        if (value > max) {
                            value = min;
                        }
                        if (value == 0) { 
                            total++;
                        }
                    }
                    // System.out.print(", value " + value);
                    break;            
                default:
                    break;
                    
            }
            // System.out.println(" running password " + total);
        }

        return total;
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
