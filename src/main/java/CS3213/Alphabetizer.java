package CS3213;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by junchao on 8/23/2014.
 */
public class Alphabetizer {
    private List<String> _lines;
    private RequiredWords _requiredWords;

    public Alphabetizer() {
        this._lines = new ArrayList<String>();
        this._requiredWords = RequiredWords.getRequiredWords();
    }

    public void addLines(String[] lines) {
        for (String str : lines) {
            if (this._requiredWords.getRequiredWordsSize() > 0){
                if (!(isStartingWithRequiredWords(getFirstWord(str)))){
                    continue;
                }
            }
            this._lines.add(str);
        }
    }

    public String[] getSortedLines() {
        Collections.sort(this._lines);
        return this._lines.toArray(new String[this._lines.size()]);
    }
    
    private boolean isStartingWithRequiredWords(String word){
        return this._requiredWords.isWordRequired(word);
    }
    
    private String getFirstWord(String word){
        String arr[] = word.split(" ", 2);
        return arr[0];
    }
}
