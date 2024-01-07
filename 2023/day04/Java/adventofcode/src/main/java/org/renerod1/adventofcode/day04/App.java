package org.renerod1.adventofcode.day04;

import java.io.IOException;
import java.net.CacheRequest;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Advent of Code Day 4
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
        // List<String> list = readFile("2023\\day04\\Java\\adventofcode\\src\\data\\sample_input.txt");
        List<String> list = readFile("2023\\day04\\Java\\adventofcode\\src\\data\\input.txt");

        Iterator<String> itr = list.iterator();
        double i = 0;
        int j = 0;
        while (itr.hasNext()) {
            i += getGamePoints(itr.next(), ++j);

            // System.out.print(" Running total: ");
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

    private static List<String> readFile(String file) {
        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    private static Double getGamePoints(String line, int counter) {
        String game = "";
        String gameCard = "";
        String gameNumbers = "";
        List<Integer> cardNumbers = new ArrayList<Integer>();
        String gameWinners = "";
        List<Integer> cardWinners = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        double winCount = 0;

        // System.out.print(" Line: ");
        // System.out.print(counter);
        // System.out.print(", value: ");
        // System.out.print(line);

        game = line.split(":")[0];
        gameCard = line.split(":")[1];
        gameNumbers = gameCard.split("\\|")[0];
        gameWinners = gameCard.split("\\|")[1];

        // System.out.print(", game: ");
        // System.out.print(game);
        // System.out.print(", gameCard: ");
        // System.out.print(gameCard);
        // System.out.print(", gameNumbers: ");
        // System.out.print(gameNumbers.replace("  ", " ").trim().split(" ").length);
        // System.out.print(", gameWinners: ");
        // System.out.println(gameWinners.replace("  ", " ").trim().split(" ").length);

        gameNumbers = gameNumbers.replace("  ", " ").trim();
        gameWinners = gameWinners.replace("  ", " ").trim();

        // System.out.println();

        for (i = 0; i < gameNumbers.split(" ").length; i++) {
            // System.out.print(", cardNumber: ");
            // System.out.print(Integer.parseInt(gameNumbers.split(" ")[i]));
            cardNumbers.add(Integer.parseInt(gameNumbers.split(" ")[i]));
        }

        // System.out.println();

        for (i = 0; i < gameWinners.split(" ").length; i++) {
            // System.out.print(", cardWinner: ");
            // System.out.print(Integer.parseInt(gameWinners.split(" ")[i]));
            cardWinners.add(Integer.parseInt(gameWinners.split(" ")[i]));
        }

        // System.out.println();

        // System.out.print(", cardNumbers: ");
        // System.out.print(cardNumbers);
        // System.out.print(", cardWinners: ");
        // System.out.print(cardWinners);

        for (i = 0; i < cardNumbers.size(); i++) {
            for (j = 0; j < cardWinners.size(); j++) {
                if (cardNumbers.get(i) == cardWinners.get(j)) {
                    winCount++;
                    break;
                }
            }
        }

        // System.out.print(", winCount: ");
        // System.out.println(winCount);

        return winCount > 2 ? Math.pow(2,--winCount)  : winCount;
    }
}
