/**

 Shivansh S. Mehta (CS201-Duke Spring 2019)
 NetID: sm682

 EFFICIENT MARKOV PROJECT

 EfficientMarkov.java | Main File 1 of 2 for this project

**/

//___________ Section One: Imports

import java.util.*;

//___________ Section Two: Extending Base Markov and implementing myMap

public class EfficientMarkov extends BaseMarkov {
	private Map<String,ArrayList<String>> myMap;

//___________ Section Three: Implementing General Constructors

	/**
	 * Construct a EfficientMarkov object with the specified order
	 * @param order size of this markov generator
	 */

	public EfficientMarkov(int order) {
		super(order);
		myMap = new HashMap<>();
	}

	/**
	 * Default constructor, in this case, has order of 3
	 */

	public EfficientMarkov() {
		this(3);
	}

//___________ Section Four: Set Training

	/**
	 * The training method using WordGram
	 * @param text Markov Text
	 */

	@Override
	public void setTraining(String text) {
		myMap.clear();
		super.myText = text;

		for (int k = 0; k < super.myText.length() - super.myOrder + 1; k++){
			String order = super.myText.substring(k,k+myOrder);
			myMap.putIfAbsent(order, new ArrayList<>());
			if (super.myText.length() == k + super.myOrder){
				myMap.get(order).add(PSEUDO_EOS);
			}
			else {
				myMap.get(order).add(super.myText.substring(k + myOrder, k + myOrder + 1));
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
	public ArrayList<String> getFollows(String key) throws NoSuchElementException {
		if (!(myMap.containsKey(key))) {
			throw new NoSuchElementException(key + "not present in map");
		}
		return (myMap.get(key));
	}
}	
