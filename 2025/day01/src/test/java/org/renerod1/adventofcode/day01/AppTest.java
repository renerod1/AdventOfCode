package org.renerod1.adventofcode.day01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Advent of Code Day 1
 */
public class AppTest {
    /**
     * Part 1
     */
    @Test
    public void part1Test() {
        assertEquals(3, App.part1("src\\test\\resources\\data\\sample_input.txt").intValue());
    }

    /**
     * Part 2
     */
    @Test
    public void part2Test() {
        assertEquals(6, App.part2("src\\test\\resources\\data\\sample_input.txt").intValue());
    }
}
