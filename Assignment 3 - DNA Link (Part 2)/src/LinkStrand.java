/**

 Oliver Rodas & Shivansh Mehta (CS201-Duke Spring 2019)
 NetIDs: oar5, sm682

 DNA LinkStrand Project

 Edited File 1 of 2 for this project

 **/

//Oliver [oar5] was here
//Tho Shivansh [sm682] has always been here
// There's always bigger fish... very big indeed dddd

public class LinkStrand implements IDnaStrand {
	
	private class Node {
	   	String info;
	   	Node next;
	   	
		public Node(String s) {
			info = s;
		    next = null;
		}
	}

	// PART ONE: INSTANCE VARIABLES
	
	private Node myFirst,myLast; // First and last node
	private long mySize; // Chars in Strand
	private int myAppends; // Number of times appended
	private int myIndex; // Index at last call to charAt()
	private int myLocalIndex;// Index stored in node
	private Node myCurrent; // Node at last call to charAt()

	// PART TWO: CONSTRUCTORS

	/**
	 * LinkStrand is the default constructor of this file
	 * Creates a LinkStrand object with empty string
	 */

	public LinkStrand() {
		this("");
	}

	/**
	 * Overloaded constructor
	 * Creates a LinkStrand object with string Source
	 * @param source
	 */
	public LinkStrand(String source) {
		initialize(source);
	}

	// PART THREE: METHODS

	/**
	 * Copies DNA data from string source into the strand
	 * replacing data stored.
	 * @param source contains only valid DNA chars and is used to initialize the strand.
	 */

	@Override
	public void initialize(String source) {
		myFirst = new Node(source);
		myLast = myFirst;
		mySize = source.length();
		myAppends = 0;
		myCurrent = myFirst;
	}

	/**
	 * getInstance method works similar to implementation in StringStrand and StringBuilder
	 * @param source
	 * @return a new instance of linkStrand object
	 */

	@Override
	public IDnaStrand getInstance(String source) {
		return new LinkStrand(source);
	}

	/**
	 * A single line method that runs in O(1) time complexity
	 * @return the number of characters in the strand
	 */
	@Override
	public long size() {
		return mySize;
	}

	/**
	 * Apends DNA to the end of the strand
	 * @param dna is the string appended to this strand
	 * @return the strand after the data has been added
	 */
	@Override
	public IDnaStrand append(String dna) {
		myLast.next = new Node(dna);
		myLast = myLast.next;
		mySize += dna.length();
		myAppends += 1;
		
		return this;
	}

	/**
	 * Method that returns an DNAStrand that is the reverse of this strand
	 * @return the reverse strand
	 */

	@Override
	public IDnaStrand reverse() {
				
		if (myFirst == null) {
			return new LinkStrand(null);
		}
		
		if (myFirst.next == null) {
			StringBuilder ss = new StringBuilder(myFirst.info);
			return new LinkStrand(ss.reverse().toString());
		}
				
		Node reversed = new Node(myFirst.info);
		Node node = myFirst.next;
		reversed.next = null;
		
		while (node != null) {
			
			Node toAdd = new Node(node.info);
			node = node.next;
			
			toAdd.next = reversed;
			reversed = toAdd;
			
		}
		
		node = reversed;

		StringBuilder ss = new StringBuilder(node.info);
		ss.reverse();
		LinkStrand reverse = new LinkStrand(ss.toString());
		
		node = node.next;
		
		
		while(node != null) {
			
			ss = new StringBuilder(node.info);
			ss.reverse();
			reverse.append(ss.toString());
			
			node = node.next;
			
		}
		
		reverse.myLast.next = null;
		
		return reverse;
	}

	/**
	 * Returns the number of times that append is called
	 * @return number of appends
	 */
	@Override
	public int getAppendCount() {
		return myAppends;
	}

	/**
	 * Returns the char at a specific index which is less than the size()
	 * @param index specifies which character will be returned
	 * @return the character at index
	 * @throws IndexOutOfBoundsException if index < 0 or index >= size()
	 */
	@Override
	public char charAt(int index) {

		if (index < 0 || index >= mySize) {
			throw new IndexOutOfBoundsException();
		}

		if (index > myIndex) {
			while (myIndex < index) {
				myIndex = myIndex + 1;
				myLocalIndex = myLocalIndex + 1;
				if (myLocalIndex == myCurrent.info.length()) {
					myCurrent = myCurrent.next;
					myLocalIndex = 0;
				}
			}
		}

		else if (index < myIndex){
			myIndex = 0;
			myLocalIndex = 0;
			myCurrent = myFirst;
			while (myIndex < index){
				myIndex = myIndex + 1;
				myLocalIndex = myLocalIndex + 1;
				if (myLocalIndex == myCurrent.info.length()){
					myCurrent = myCurrent.next;
					myLocalIndex = 0;
				}
			}
		}

		return myCurrent.info.charAt(myLocalIndex);
	}

	/**
	 * Method that returns the String representation of LinkStrand and runs in O(N) time complexity
	 * @return string representation of LinkStrand
	 */

	public String toString() {
		Node node = myFirst;
		StringBuilder ret = new StringBuilder("");
		while(node != null) {
			ret.append(node.info);
			node = node.next;
		}

		return ret.toString();
	}
}