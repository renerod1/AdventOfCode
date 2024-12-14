package org.renerod1.adventofcode.day01;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
        // List<String> list =
        // readFile("2024\\day01\\Java\\adventofcode\\src\\data\\sample_input.txt");
        List<String> list = readFile("2024\\day01\\Java\\adventofcode\\src\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        Integer distance = 0;
        ArrayList<Integer> i = new ArrayList<>();
        ArrayList<Integer> j = new ArrayList<>();

        while (itr.hasNext()) {
            String line = itr.next();
            // System.out.println("Line: " + line);
            i.add(Integer.parseInt(line.split("   ")[0]));
            j.add(Integer.parseInt(line.split("   ")[1]));
        }

        Collections.sort(i);
        Collections.sort(j);

        distance = getDistance(i, j);

        System.out.print("Part 1: ");
        System.out.print("Answer: ");
        System.out.print(distance);
        System.out.print(", Lines read: ");
        System.out.println(j.size());
    }

    /**
     * Part 2
     */
    public static void part2() {
        // List<String> list =
        // readFile("2024\\day01\\Java\\adventofcode\\src\\data\\sample_input.txt");
        List<String> list = readFile("2024\\day01\\Java\\adventofcode\\src\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        Integer similarity = 0;
        ArrayList<Integer> i = new ArrayList<>();
        ArrayList<Integer> j = new ArrayList<>();

        while (itr.hasNext()) {
            String line = itr.next();
            // System.out.println("Line: " + line);
            i.add(Integer.parseInt(line.split("   ")[0]));
            j.add(Integer.parseInt(line.split("   ")[1]));
        }

        Collections.sort(i);
        Collections.sort(j);

        similarity = getSimilarity(i, j);

        System.out.print("Part 2: ");
        System.out.print("Answer: ");
        System.out.print(similarity);
        System.out.print(", Lines read: ");
        System.out.println(j.size());
    }

    private static Integer getDistance(ArrayList<Integer> i, ArrayList<Integer> j) {

        Integer total = 0;

        for (int k = 0; k < j.size(); k++) {
            // System.out.println("i.get(k), j.get(k): " + i.get(k) + "," + j.get(k));
            total += Math.abs(Math.subtractExact(i.get(k), j.get(k)));
        }

        return total;
    }

    private static Integer getSimilarity(ArrayList<Integer> i, ArrayList<Integer> j) {

        Integer total = 0;
        Map<Integer, Integer> mapJ = new HashMap<>();

        for (int k = 0; k < j.size(); k++) {
            // System.out.println("j.get(k): " + j.get(k));
            mapJ.put(j.get(k), mapJ.getOrDefault(j.get(k),0)+1);
        }

        // System.out.println("mapJ: " + mapJ);        

        for (int k = 0; k < i.size(); k++) {
            // System.out.println("i.get(k), mapJ.getOrDefault(i.get(k),0): " + i.get(k) + "," + mapJ.getOrDefault(i.get(k),0));
            total += (i.get(k) * mapJ.getOrDefault(i.get(k),0));
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
