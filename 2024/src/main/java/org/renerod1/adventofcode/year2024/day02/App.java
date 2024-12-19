package org.renerod1.adventofcode.year2024.day02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Advent of Code Day 2
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
        // List<String> list = readFile("2024\\src\\main\\resources\\day02\\data\\sample_input.txt");
        List<String> list = readFile("2024\\src\\main\\resources\\day02\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        Integer safeReports = 0;
        ArrayList<String> i = new ArrayList<>();

        while (itr.hasNext()) {
            String line = itr.next();
            // System.out.println("Line: " + line);
            i.add(line);
        }

        safeReports = processReports(i);

        System.out.print("Part 1: ");
        System.out.print("Answer: ");
        System.out.print(safeReports);
        System.out.print(", Lines read: ");
        System.out.println(i.size());
    }

    /**
     * Part 2
     */
    public static void part2() {
        // List<String> list = readFile("2024\\src\\main\\resources\\day02\\data\\sample_input.txt");
        List<String> list = readFile("2024\\src\\main\\resources\\day02\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        Integer safeReports = 0;
        ArrayList<String> i = new ArrayList<>();

        while (itr.hasNext()) {
            String line = itr.next();
            // System.out.println("Line: " + line);
            i.add(line);
        }

        safeReports = processReports2(i);

        System.out.print("Part 2: ");
        System.out.print("Answer: ");
        System.out.print(safeReports);
        System.out.print(", Lines read: ");
        System.out.println(i.size());
    }

    private static Integer processReports(ArrayList<String> i) {

        Integer total = 0;

        for (int k = 0; k < i.size(); k++) {
            // System.out.println("i.get(k): " + i.get(k));
            total += checkReport(i.get(k).split(" "));
        }

        return total;
    }

    private static Integer processReports2(ArrayList<String> i) {

        Integer total = 0;

        for (int k = 0; k < i.size(); k++) {
            // System.out.println("\ni.get(k): " + i.get(k));
            total += checkDampener(i.get(k), -1);
        }

        return total;
    }

    private static Integer checkReport(String[] i) {
        int difference = 0;
        boolean increasing = false;
        boolean decreasing = false;
        boolean same = false;
        boolean moreThanThree = false;

        for (int j = 1; j < i.length; j++) {
            // System.out.println("i: " + i[j - 1] + ", i: " + i[j]);
            difference = Integer.parseInt(i[j - 1]) - Integer.parseInt(i[j]);

            switch (difference) {
                case -1:
                case -2:
                case -3:
                    increasing = true;
                    break;
                case 0:
                    same = true;
                    break;
                case 1:
                case 2:
                case 3:
                    decreasing = true;
                    break;
                default:
                    moreThanThree = true;
                    break;
            }

            if (moreThanThree || same || (increasing && decreasing)) {
                // System.out.println("moreThanThree: " + moreThanThree + ", same: " + same + ",
                // increasing: " + increasing
                // + ", decreasing: " + decreasing);
                return 0;
            }
        }

        // System.out.println("moreThanThree: " + moreThanThree + ", same: " + same + ",
        // increasing: " + increasing
        // + ", decreasing: " + decreasing);
        return 1;
    }

    private static Integer checkDampener(String og, int position) {
        int difference = 0;
        boolean increasing = false;
        boolean decreasing = false;
        boolean same = false;
        boolean moreThanThree = false;

        String i = "";
        String[] list = og.split(" ");

        if (position != -1) {
            list[position] = "";
            i = String.join(" ", list).replaceAll("  ", " ").trim();
            list = i.split(" ");
        }

        for (int j = 0; j + 1 < list.length; j++) {

            difference = Integer.parseInt(list[j]) - Integer.parseInt(list[j + 1]);
            // System.out.println("left: " + list[j] + ", right: " + list[j+1] + ",
            // difference: " + difference);

            switch (difference) {
                case -1:
                case -2:
                case -3:
                    increasing = true;
                    break;
                case 0:
                    same = true;
                    break;
                case 1:
                case 2:
                case 3:
                    decreasing = true;
                    break;
                default:
                    moreThanThree = true;
                    break;
            }

            if (moreThanThree || same || (increasing && decreasing)) {
                // System.out.println("position: " + position + ", list.length: " + list.length
                // + ", moreThanThree: " + moreThanThree + ", same: " + same + ", increasing: "
                // + increasing + ", decreasing: " + decreasing);

                if (position >= list.length) {
                    return 0;
                }

                position++;

                return checkDampener(og, position);
            }
        }

        // System.out.println("moreThanThree: " + moreThanThree + ", same: " + same + ",
        // increasing: " + increasing + ", decreasing: " + decreasing);
        return 1;
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
