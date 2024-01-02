package org.renerod1.adventofcode.day02;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
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
        // List<String> list = readFile("2023\\day02\\Java\\adventofcode\\src\\data\\sample_input.txt");
        List<String> list = readFile("2023\\day02\\Java\\adventofcode\\src\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        int i = 0;
        int j = 0;
        while (itr.hasNext()) {
            i += getValidGameId(itr.next(), ++j);

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
        // List<String> list = readFile("2023\\day02\\Java\\adventofcode\\src\\data\\sample_input.txt");
        List<String> list = readFile("2023\\day02\\Java\\adventofcode\\src\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        int i = 0;
        int j = 0;
        while (itr.hasNext()) {
            i += getGamePower(itr.next(), ++j);

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

    private static Integer getValidGameId(String line, int counter) {
        String game = "";
        String[] gameMoves;
        int gameNumber = 0;
        int redCubes = 0;
        int greenCubes = 0;
        int blueCubes = 0;
        int i = 0;

        // System.out.print(" Line: ");
        // System.out.print(counter);
        // System.out.print(", value: ");
        // System.out.print(line);

        game = line.split(":")[0];
        gameNumber = Integer.parseInt(game.split(" ")[1]);
        gameMoves = line.split(":")[1].split(";");

        // System.out.print(", gameId: ");
        // System.out.print(game);
        // System.out.print(", gameNumber: ");
        // System.out.println(gameNumber);

        for (String turn : gameMoves) {
            // System.out.print("turn: ");
            // System.out.println(turn);
            String[] move = turn.split(",");
            for (i = 0; i < move.length; i++) {
                // System.out.print("move: ");
                // System.out.println(move[i]);

                int count = Integer.parseInt(move[i].trim().split(" ")[0]);
                String color = move[i].trim().split(" ")[1];

                // System.out.print("count: ");
                // System.out.print(count);
                // System.out.print(", color: ");
                // System.out.println(color);

                switch (color) {
                    case "red":
                        if (redCubes < count) {
                            redCubes = count;
                        }
                        ;
                        break;
                    case "green":
                        if (greenCubes < count) {
                            greenCubes = count;
                        }
                        ;
                        break;
                    case "blue":
                        if (blueCubes < count) {
                            blueCubes = count;
                        }
                        ;
                        break;
                }
            }
        }

        // System.out.print("redCubes: ");
        // System.out.print(redCubes);
        // System.out.print(", greenCubes: ");
        // System.out.print(greenCubes);
        // System.out.print(", blueCubes: ");
        // System.out.print(blueCubes);

        if ((redCubes <= 12) && (greenCubes <= 13) && (blueCubes <= 14)) {
            // System.out.print(", gameNumber Added: ");
            // System.out.print(gameNumber);
            return gameNumber;
        } else {
            // System.out.print(", gameNumber Not Added: ");
            // System.out.print(gameNumber);
            return 0;
        }
    }
    
    private static Integer getGamePower(String line, int counter) {
        String game = "";
        String[] gameMoves;
        int gameNumber = 0;
        int redCubes = 0;
        int greenCubes = 0;
        int blueCubes = 0;
        int i = 0;

        // System.out.print(" Line: ");
        // System.out.print(counter);
        // System.out.print(", value: ");
        // System.out.print(line);

        game = line.split(":")[0];
        gameNumber = Integer.parseInt(game.split(" ")[1]);
        gameMoves = line.split(":")[1].split(";");

        // System.out.print(", gameId: ");
        // System.out.print(game);
        // System.out.print(", gameNumber: ");
        // System.out.println(gameNumber);

        for (String turn : gameMoves) {
            // System.out.print("turn: ");
            // System.out.println(turn);
            String[] move = turn.split(",");
            for (i = 0; i < move.length; i++) {
                // System.out.print("move: ");
                // System.out.println(move[i]);

                int count = Integer.parseInt(move[i].trim().split(" ")[0]);
                String color = move[i].trim().split(" ")[1];

                // System.out.print("count: ");
                // System.out.print(count);
                // System.out.print(", color: ");
                // System.out.println(color);

                switch (color) {
                    case "red":
                        if (redCubes < count) {
                            redCubes = count;
                        }
                        ;
                        break;
                    case "green":
                        if (greenCubes < count) {
                            greenCubes = count;
                        }
                        ;
                        break;
                    case "blue":
                        if (blueCubes < count) {
                            blueCubes = count;
                        }
                        ;
                        break;
                }
            }
        }

        // System.out.print("redCubes: ");
        // System.out.print(redCubes);
        // System.out.print(", greenCubes: ");
        // System.out.print(greenCubes);
        // System.out.print(", blueCubes: ");
        // System.out.println(blueCubes);

        return redCubes * greenCubes * blueCubes;
    }
}
