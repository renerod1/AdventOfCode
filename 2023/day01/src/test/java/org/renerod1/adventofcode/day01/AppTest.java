package org.renerod1.adventofcode.day01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest {

    /**
     * Part 1
     * 
     */
    @Test
    public void part1Test() {
        assertEquals(142, App.part1("resources\\data\\test\\sample_input.txt"));
    }

    /**
     * Part 2
     * 
     */
    @Test
    public void part2Test() {
        assertEquals(281, App.part2("resources\\data\\test\\sample_input2.txt"));
    }
}
