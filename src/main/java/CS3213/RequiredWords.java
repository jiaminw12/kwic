package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RequiredWords {
    private HashSet<String> _requiredWords;
    
    public RequiredWords() {
        this._requiredWords = new HashSet<String>();
    }

    public void addRequiredWord(String word) {
        assert(word != null);
        this._requiredWords.addAll(splitWord(word));
    }

    public boolean isWordRequired(String word) {
        assert(word != null);
        return this._requiredWords.contains(word);
    }
    
    public int getRequiredWordsSize(){
        return this._requiredWords.size();
    }
    
    private static ArrayList<String> splitWord(String stringToBeSplit) {
        ArrayList<String> tempArray = new ArrayList<String>();
        String[] temp =  stringToBeSplit.split(", ");
        tempArray.addAll(new ArrayList<String>(Arrays.asList(temp)));
        return tempArray;
    }
}
