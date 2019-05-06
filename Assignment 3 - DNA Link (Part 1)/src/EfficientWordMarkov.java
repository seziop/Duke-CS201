/**

 Shivansh S. Mehta (CS201-Duke Spring 2019)
 NetID: sm682

 EFFICIENT MARKOV PROJECT

 EfficientWordMarkov.java | Main File 2 of 2 for this project

 **/

//___________ Section One: Imports

import java.util.*;

//___________ Section Two: Extending Base Word Markov and implementing myMap

public class EfficientWordMarkov extends BaseWordMarkov {
    private Map<WordGram,ArrayList<String>> myMap;

//___________ Section Three: Implementing General Constructors

    /**
     * Construct a EfficientWordMarkov object with the specified order
     * @param order size of this markov generator
     */

    public EfficientWordMarkov(int order) {
        super(order);
        myMap = new HashMap<>();
    }

    /**
     * Default constructor, in this case, has order of 2
     */

    public EfficientWordMarkov() {
        this(2);
    }

//___________ Section Four: Set Training

    /**
     * The training method using WordGram
     * @param text Markov Text
     */

    @Override
    public void setTraining(String text) {
        myMap = new HashMap<>();
        myWords = text.split("\\s+");

        for (int k = 0; k < super.myWords.length - super.myOrder + 1; k++){
            WordGram currentWordGram = new WordGram(myWords,k,myOrder);

            myMap.putIfAbsent(currentWordGram, new ArrayList<>());
            if (super.myWords.length == k + super.myOrder){
                myMap.get(currentWordGram).add(PSEUDO_EOS);
            }
            else {
                myMap.get(currentWordGram).add(myWords[k + super.myOrder]);
            }
        }
    }

//___________ Section Five: Get Follows

    /**
     * returns a list of following characters
     * Simply looks up the key and returns the associated value
     * Throws NoSuchElementException if key is not present
     */

    @Override
    public ArrayList<String> getFollows(WordGram currentWordGram) throws NoSuchElementException {
        if (!(myMap.containsKey(currentWordGram))) {
            throw new NoSuchElementException(currentWordGram + "not present in map");
        }
        return (myMap.get(currentWordGram));
    }
}