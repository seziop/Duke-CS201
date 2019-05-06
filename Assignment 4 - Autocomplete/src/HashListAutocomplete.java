/**

 Shivansh Mehta (CS201-Duke Spring 2019)
 NetIDs: sm682

 AutoComplete Project
 HashListAutocomplete.java

 Main Implemented Class 4 of 4 for this project

 **/

import java.util.*;

public class HashListAutocomplete implements Autocompletor {

    // STEP ONE: INITIALIZE VARIABLES

    private Term[] myTerms;
    private int mySize;
    private static final int MAX_PREFIX = 10;
    private Map<String, List<Term>> myMap;

    // STEP TWO: INITIALIZE THE  MAP

    /**
     * Initializes the Map and Create immutable instance with terms constructed from parameter
     *
     * @param terms   words such that terms[k] is part of a word pair 0 <= k < terms.length
     * @param weights weights such that weights[k] corresponds to terms[k]
     * @throws NullPointerException     if either parameter is null
     * @throws IllegalArgumentException if terms.length != weights.length
     * @throws IllegalArgumentException if any elements of weights is negative
     * @throws IllegalArgumentException if any elements of terms is duplicate
     */

    public HashListAutocomplete(String[] terms, double[] weights) {

        if (terms == null || weights == null) {
            throw new NullPointerException("One or more arguments null");
        }

        if (terms.length != weights.length) {
            throw new IllegalArgumentException("terms and weights are not the same length");
        }
        initialize(terms, weights);
    }

    /**
     * creates a list of matches when provided a prefix
     *
     * @param prefix contains the first letters of a term
     * @param k      is the number of desired matches.
     * @return list of terms with prefix
     */

    public List<Term> topMatches(String prefix, int k) {
        List<Term> ret = myMap.get(prefix);
        if (ret != null) {
            return ret.subList(0, Math.min(k, ret.size()));
        }
        return new LinkedList<>();

    }

    /**
     * Create internal state needed to store Term objects
     * from the parameters. Should be called in implementing
     * constructors
     *
     * @param terms   is array of Strings for words in each Term
     * @param weights is corresponding weight for word in terms
     */

    public void initialize(String[] terms, double[] weights) {

        myMap = new HashMap<String, List<Term>>();
        for (int k = 0; k < terms.length; k++) {
            int min = Math.min(terms[k].length(), MAX_PREFIX);
            for (int v = 0; v <= min; v++) {
                myMap.putIfAbsent(terms[k].substring(0, v), new ArrayList<Term>());
                myMap.get(terms[k].substring(0, v)).add(new Term(terms[k], weights[k]));
            }
        }
        for (String key : myMap.keySet()) {
            Collections.sort(myMap.get(key), new Term.ReverseWeightOrder());
            myMap.put(key, myMap.get(key));

        }
    }

    /**
     * Return size in bytes of all Strings and doubles
     * stored in implementing class. To the extent that
     * other types are used for efficiency, there size should
     * be included too
     *
     * @return number of bytes used after initialization
     */
    public int sizeInBytes() {

        if (mySize == 0) {
            for (String key : myMap.keySet()) {
                mySize = mySize + key.length() * BYTES_PER_CHAR;

            }

            for (Term t : myMap.get("")) {
                mySize += BYTES_PER_DOUBLE +
                        BYTES_PER_CHAR * t.getWord().length();
            }
        }
        return mySize;
    }
}
