package org.renerod1.adventofcode.day02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Advent of Code Day 2
 */
public class AppTest {
    /**
     * Part 1
     */
    @Test
    public void part1Test() {
        assertEquals(1227775554L, App.part1("src\\test\\resources\\data\\sample_input.txt").longValue());
    }
}
