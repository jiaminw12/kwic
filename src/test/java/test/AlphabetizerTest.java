package test;

import CS3213.Alphabetizer;
import CS3213.RequiredWords;
import org.junit.Test;

import static org.junit.Assert.*;

public class AlphabetizerTest {

    @Test
    public void testGetSortedLines() throws Exception {
        Alphabetizer alphabetizer = new Alphabetizer();

        String[] lines = {"test a line", "a simple line", "this is test", "easy task"};
        alphabetizer.addLines(lines);
        String[] output = alphabetizer.getSortedLines();
        assertTrue(output.length == 4);
        assertEquals("a simple line", output[0]);
        assertEquals("easy task", output[1]);
        assertEquals("test a line", output[2]);
        assertEquals("this is test", output[3]);
        
        alphabetizer = new Alphabetizer();
        String[] lines2 = {"The Day after Tomorrow", "Fast and Furious", "Man of Steel", "Star Trek", "2001: a Space Odyssey"};
        RequiredWords requiredWords = RequiredWords.getRequiredWords();
        String required = "Star, Space";
        requiredWords.addRequiredWord(required);
        alphabetizer.addLines(lines2);
        output = alphabetizer.getSortedLines();
        assertTrue(output.length == 2);
        assertEquals("Space Odyssey 2001: a", output[0]);
        assertEquals("Star Trek", output[1]);
    }
}