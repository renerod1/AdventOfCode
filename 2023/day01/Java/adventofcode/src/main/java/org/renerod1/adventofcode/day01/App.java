package org.renerod1.adventofcode.day01;

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
        part2();
    }

    /**
     * Part 1
     */
    public static void part1() {
        // List<String> list =
        // readFile("2023\\day01\\Java\\adventofcode\\src\\data\\sample_input.txt");
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

        System.out.print("Part 1: ");
        System.out.print("Answer: ");
        System.out.print(i);
        System.out.print(", Lines read: ");
        System.out.println(j);
    }

    /**
     * Part 2
     */
    public static void part2() {
        // List<String> list =
        // readFile("2023\\day01\\Java\\adventofcode\\src\\data\\sample_input2.txt");
        List<String> list = readFile("2023\\day01\\Java\\adventofcode\\src\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        int i = 0;
        int j = 0;
        while (itr.hasNext()) {
            String line = itr.next();
            // System.out.print("Line: ");
            // System.out.print(line);

            line = convertedLine(line.toLowerCase());

            // System.out.print(", Converted line: ");
            // System.out.print(line);

            // System.out.print(", Running total: ");
            // System.out.print(i);
            // System.out.print(" line: ");
            // System.out.println(j);

            i += getTwoDigitNumber(line, ++j);
        }

        System.out.print("Part 2: ");
        System.out.print("Answer: ");
        System.out.print(i);
        System.out.print(", Lines read: ");
        System.out.println(j);
    }

    private static String convertedLine(String line) {
        String newLine = line;
        int i = 0;
        int j = 0;

        // System.out.print("\nLine: ");
        // System.out.print(line);
        // System.out.print(" newLine: ");
        // System.out.print(newLine);
        // System.out.print(" newLine.length: ");
        // System.out.print(newLine.length());
        // System.out.print(" ");

        if (line.length() == 0) {
            return "0";
        }

        boolean i_break = false;
        for (i = 0; i + 5 <= newLine.length(); i++) {
            boolean j_break = false;
            for (j = 0; j < 10; j++) {
                switch (j) {
                    case 0:
                        try {
                            if (line.substring(i, i + 5).contains("zero")) {
                                // System.out.print("\n0 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("zero", "z0o");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 1:
                        try {
                            if (line.substring(i, i + 5).contains("one")) {
                                // System.out.print("\n1 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("one", "o1e");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 2:
                        try {
                            if (line.substring(i, i + 5).contains("two")) {
                                // System.out.print("\n2 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("two", "t2o");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 3:
                        try {
                            if (line.substring(i, i + 5).contains("three")) {
                                // System.out.print("\n3 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("three", "t3e");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 4:
                        try {
                            if (line.substring(i, i + 5).contains("four")) {
                                // System.out.print("\n4 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("four", "f4r");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 5:
                        try {
                            if (line.substring(i, i + 5).contains("five")) {
                                // System.out.print("\n5 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("five", "f5e");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 6:
                        try {
                            if (line.substring(i, i + 5).contains("six")) {
                                // System.out.print("\n6 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("six", "s6x");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 7:
                        try {
                            if (line.substring(i, i + 5).contains("seven")) {
                                // System.out.print("\n7 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("seven", "s7n");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 8:
                        try {
                            if (line.substring(i, i + 5).contains("eight")) {
                                // System.out.print("\n8 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("eight", "e8t");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                    case 9:
                        try {
                            if (line.substring(i, i + 5).contains("nine")) {
                                // System.out.print("\n9 line: ");
                                // System.out.print(line);
                                // System.out.print(" newLine(5): ");
                                // System.out.print(newLine.substring(i, i + 5));
                                newLine = line.replaceFirst("nine", "n9e");
                                newLine = convertedLine(newLine);
                                if (line.length() != newLine.length()) {
                                    i_break = true;
                                }
                                j_break = true;
                            }
                        } catch (Exception e) {
                            i_break = true;
                            break;
                        }
                        break;
                }
                if (i_break || j_break) {
                    break;
                }
            }
            if (i_break) {
                break;
            }
        }
        return newLine;
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

        // System.out.print(" Line: ");
        // System.out.print(counter);
        // System.out.print(", value: ");
        // System.out.print(line);
        // System.out.print(", length: ");
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
        // System.out.print(", digit1: ");
        // System.out.print(digit1);
        // System.out.print(", digit2: ");
        // System.out.print(digit2);

        number = digit1.concat(digit2);

        // System.out.print("\tnumber: ");
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
