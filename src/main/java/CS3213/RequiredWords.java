package CS3213;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class RequiredWords {
    private static RequiredWords _instatnce;
    private HashSet<String> _requiredWords;
    
    private RequiredWords() {
        this._requiredWords = new HashSet<String>();   
    }
    
    public static RequiredWords getRequiredWords() {
        if (_instatnce == null) {
            _instatnce = new RequiredWords();
        }

        return _instatnce;
    }

    public void addRequiredWord(String word) {
        if (word == null || word.equalsIgnoreCase("")){
            return;
        } else {
            this._requiredWords.addAll(removeWordsToIgnore(splitWord(word)));
        }
    }

    public boolean isWordRequired(String word) {
        assert(word != null);
        return this._requiredWords.contains(word);
    }
    
    public void removeRequiredWords(String word) {
        assert(word != null);
        this._requiredWords.remove(word);
    }
    
    public int getRequiredWordsSize(){
        return this._requiredWords.size();
    }
    
    private static ArrayList<String> removeWordsToIgnore (ArrayList<String> afterSplit){
        WordsToIgnore wordIgnore = WordsToIgnore.getWordsToIgnore();
        ArrayList<String> tempArray = new ArrayList<String>();
        for (int i = 0; i < afterSplit.size(); i++){
            if(!(wordIgnore.isWordIgnored(afterSplit.get(i)))){
                tempArray.add(afterSplit.get(i));
            }
        }
        return tempArray;
    }
    
    private static ArrayList<String> splitWord(String stringToBeSplit) {
        ArrayList<String> tempArray = new ArrayList<String>();
        String[] temp =  stringToBeSplit.split(", ");
        tempArray.addAll(new ArrayList<String>(Arrays.asList(temp)));
        return tempArray;
    }
    
}
