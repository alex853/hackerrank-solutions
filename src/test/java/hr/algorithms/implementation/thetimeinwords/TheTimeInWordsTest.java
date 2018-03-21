package hr.algorithms.implementation.thetimeinwords;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheTimeInWordsTest {
    @Test
    public void test_5_00() {
        assertEquals("five o' clock", TheTimeInWords.timeInWords(5, 0));
    }

    @Test
    public void test_5_01() {
        assertEquals("one minute past five", TheTimeInWords.timeInWords(5, 1));
    }

    @Test
    public void test_5_10() {
        assertEquals("ten minutes past five", TheTimeInWords.timeInWords(5, 10));
    }

    @Test
    public void test_5_15() {
        assertEquals("quarter past five", TheTimeInWords.timeInWords(5, 15));
    }

    @Test
    public void test_5_28() {
        assertEquals("twenty eight minutes past five", TheTimeInWords.timeInWords(5, 28));
    }

    @Test
    public void test_5_30() {
        assertEquals("half past five", TheTimeInWords.timeInWords(5, 30));
    }

    @Test
    public void test_5_40() {
        assertEquals("twenty minutes to six", TheTimeInWords.timeInWords(5, 40));
    }

    @Test
    public void test_5_45() {
        assertEquals("quarter to six", TheTimeInWords.timeInWords(5, 45));
    }

    @Test
    public void test_5_47() {
        assertEquals("thirteen minutes to six", TheTimeInWords.timeInWords(5, 47));
    }
}