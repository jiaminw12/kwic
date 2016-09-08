package test;

import CS3213.RequiredWords;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequiredWordsTest {

    @Test
    public void testRequiredWords() throws Exception {
        
        RequiredWords requiredWords = RequiredWords.getRequiredWords();

        assertFalse(requiredWords.isWordRequired("Star"));
        
        String required = "Star, Space";
        requiredWords.addRequiredWord(required);
        
        assertTrue(requiredWords.isWordRequired("Star"));
        assertTrue(requiredWords.isWordRequired("Space"));
        assertFalse(requiredWords.isWordRequired("Man"));
        assertFalse(requiredWords.isWordRequired("Day"));

        required = "Star, Day, Fast, Man";
        requiredWords.addRequiredWord(required);
        assertTrue(requiredWords.isWordRequired("Space"));
        assertTrue(requiredWords.isWordRequired("Day"));
        assertTrue(requiredWords.isWordRequired("Man"));
        assertTrue(requiredWords.isWordRequired("Fast"));
        assertTrue(requiredWords.isWordRequired("Star"));
        assertFalse(requiredWords.isWordRequired("Trek"));
    }
}