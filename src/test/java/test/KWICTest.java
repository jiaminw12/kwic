package test;

import CS3213.Alphabetizer;
import CS3213.CircularShift;
import CS3213.RequiredWords;
import CS3213.WordsToIgnore;
import org.junit.Test;

import static org.junit.Assert.*;

public class KWICTest {

    @Test
    public void testGetSortedLines() throws Exception {
        
        
        String[] lines = {"The Day after Tomorrow", "Fast and Furious", "Man of Steel", "Star Trek", "2001: a Space Odyssey"};
        
        WordsToIgnore wordsToIgnore = WordsToIgnore.getWordsToIgnore();
        wordsToIgnore.addWordToIgnore("is");
        wordsToIgnore.addWordToIgnore("the");
        wordsToIgnore.addWordToIgnore("of");
        wordsToIgnore.addWordToIgnore("and");
        wordsToIgnore.addWordToIgnore("as");
        wordsToIgnore.addWordToIgnore("a");
        wordsToIgnore.addWordToIgnore("after");
        
        Alphabetizer alphabetizer = new Alphabetizer();
        for (String str : lines) {
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }
        String[] output = alphabetizer.getSortedLines();
        assertTrue(output.length == 11);
        assertEquals("2001: a Space Odyssey", output[0]);
        assertEquals("Day after Tomorrow the", output[1]);
        assertEquals("Fast and Furious", output[2]);
        assertEquals("Furious Fast and", output[3]);
        assertEquals("Man of Steel", output[4]);
        assertEquals("Odyssey 2001: a Space", output[5]);
        assertEquals("Space Odyssey 2001: a", output[6]);
        assertEquals("Star Trek", output[7]);
        assertEquals("Steel Man of", output[8]);
        assertEquals("Tomorrow the Day after", output[9]);
        assertEquals("Trek Star", output[10]);
        
        RequiredWords requiredWords = RequiredWords.getRequiredWords();
        requiredWords.addRequiredWord("Star, Space");
        alphabetizer = new Alphabetizer();
        for (String str : lines) {
            CircularShift shifter = new CircularShift(str);
            alphabetizer.addLines(shifter.getCircularShifts());
        }
        String[] output2 = alphabetizer.getSortedLines();
        assertTrue(output2.length == 2);
        assertEquals("Space Odyssey 2001: a", output2[0]);
        assertEquals("Star Trek", output2[1]);
        
        wordsToIgnore.removeWordToIgnore("is");
        wordsToIgnore.removeWordToIgnore("the");
        wordsToIgnore.removeWordToIgnore("of");
        wordsToIgnore.removeWordToIgnore("and");
        wordsToIgnore.removeWordToIgnore("as");
        wordsToIgnore.removeWordToIgnore("a");
        wordsToIgnore.removeWordToIgnore("after");
        
        requiredWords.removeRequiredWords("Star");
        requiredWords.removeRequiredWords("Space");

    }
}