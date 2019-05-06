
/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * @author Shivansh Mehta (sm682)
 */
public class WordGram {

	private String[] myWords;
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */

	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		myToString = "";
		myHash = 5;
		System.arraycopy(source, start, myWords, 0, size);
	}

	/**
	 * Return string at a specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */

	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 * Returns int that represents the length of String Array myWord
	 * @return length of myWord
	 */

	public int length(){
		return myWords.length;
	}

	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null)
		{
			return false;
		}
		if(this.toString().length() != o.toString().length())
		{
			return false;
		}
		for (int k=0; k < this.length(); k++)
		{
			if(!(this.wordAt(k).equals(((WordGram) o).wordAt(k))))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode(){
		int myHash = this.toString().hashCode();
		return myHash;
	}
	/**
         * @param last is last String of returned WordGram
         * @return a new Wordgram where the first k-1 elements are the last k-1 elements of the old wordgram
         */

	public WordGram shiftAdd(String last) {
		String [] words = new String[myWords.length];
		if(myWords.length > 1)
		{
			for(int k = 0; k < myWords.length-1; k++)
			{
				words[k]=myWords[k+1];
			}
			words[words.length-1] = last;
		}
		else if(myWords.length == 1)
		{
			words[0] = last;
		}
		return new WordGram(words, 0, myWords.length);
	}

	@Override
	public String toString(){
		String myToString = String.join(" ", myWords);
		return myToString;
	}
}