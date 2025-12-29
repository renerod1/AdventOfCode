package org.renerod1.adventofcode.day02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

/**
 * Advent of Code Day 2
 */
public class App {
    public static void main(String[] args) {
        part1("2025\\day02\\src\\main\\resources\\data\\input.txt");
        // part2("2025\\day02\\src\\main\\resources\\data\\input.txt");
    }

    /**
     * Part 1
     */
    public static Long part1(String file) {
        String list = readFile(file).get(0);

        Long invalidTotal = 0L;
        String[] i = {};
        
        // System.out.println("list: " + list);
        i = list.split(",");

        // System.out.println("i.length: " + i.length);
        for(int x = 0; x < i.length; x++) {
            // System.out.println("i[" + x + "] " + i[x]);
            invalidTotal += getInvalid(i[x]);
        }

        System.out.print("Part 1: ");
        System.out.print("Answer: ");
        System.out.println(invalidTotal);

        return invalidTotal;
    }

    private static Long getInvalid(String i) {

        Long total = 0L;
        Long min = Long.parseLong(i.split("-")[0]);
        Long max = Long.parseLong(i.split("-")[1]);
        for (long j = min; j <= max; j++) {
            Integer strLength = String.valueOf(j).length();
            String temp1 = String.valueOf(j).substring(0,strLength/2);
            String temp2 = String.valueOf(j).substring(strLength/2);
            if (temp1.equals(temp2)) {
                total += j;
                // System.out.print("min: " + min);
                // System.out.print(" max: " + max);
                // System.out.print(" invalid ID: " + j);
                // System.out.print(" strLength: " + strLength);
                // System.out.print(" temp1: " + temp1);
                // System.out.print(" temp2: " + temp2);
                // System.out.println(" total: " + total);    
            }            
        }
        // System.out.println("Total: " + total);
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
