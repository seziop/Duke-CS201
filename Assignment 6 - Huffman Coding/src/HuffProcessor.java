import java.util.PriorityQueue;

/**
 * Although this class has a history of several years,
 * it is starting from a blank-slate, new and clean implementation
 * as of Fall 2018.
 * <P>
 * Changes include relying solely on a tree for header information
 * and including debug and bits read/written information
 *
 * @author Owen Astrachan
 */

public class HuffProcessor {

	public static final int BITS_PER_WORD = 8;
	public static final int BITS_PER_INT = 32;
	public static final int ALPH_SIZE = (1 << BITS_PER_WORD);
	public static final int PSEUDO_EOF = ALPH_SIZE;
	public static final int HUFF_NUMBER = 0xface8200;
	public static final int HUFF_TREE  = HUFF_NUMBER | 1;

	private final int myDebugLevel;

	public static final int DEBUG_HIGH = 4;
	public static final int DEBUG_LOW = 1;

	public HuffProcessor() {
		this(0);
	}

	public HuffProcessor(int debug) {
		myDebugLevel = debug;
	}

	// HELPER METHODS FOR COMPRESS ---------------------------------

	private int[] readForCounts(BitInputStream input) {
		int[] count = new int[ALPH_SIZE + 1];
		boolean iterator = true;
		int x;
		while (iterator) {
			x = input.readBits(BITS_PER_WORD);
			if (x == -1) break;
			count[x] += 1;
		}
		count[ALPH_SIZE] = 1;
		return count;
	}

	private void writeCompressedBits(String[] codings, BitInputStream input, BitOutputStream output) {
		input.reset();
		boolean iterator = true;
		String code;
		int x;

		while (iterator) {
			x = input.readBits(BITS_PER_WORD);
			if (x == -1) break;
			code= codings[x];
			output.writeBits(code.length(), Integer.parseInt(code, 2));
		}

		code = codings[PSEUDO_EOF];
		output.writeBits(code.length(), Integer.parseInt(code, 2));
	}


	/**
	 * Using a greedy algorithm and a priority queue of HuffNode
	 * objects to create the trie. Since HuffNode implements Comparable (using weight)
	 * the code will remove the minimal-weight nodes when
	 * pq.remove() is called.
	 * @param counts the returned value from readForCounts(input)
	 * @return tree converted from the input.
	 */

	private HuffNode makeTreeFromCounts(int[] counts) {

		PriorityQueue<HuffNode> pq = new PriorityQueue<>();
		for (int k = 0; k < counts.length; k++) {
			if (counts[k] > 0) pq.add(new HuffNode(k, counts[k], null, null));
		}

		while (pq.size() > 1) {
			HuffNode left = pq.remove();
			HuffNode right = pq.remove();
			HuffNode t = new HuffNode(0, left.myWeight + right.myWeight, left, right);
			pq.add(t);
		}

		HuffNode root = pq.remove();
		return root;
	}

	/**
	 * Method returns an array of Strings such that a[val] is the encoding of the 8-bit chunk val.
	 * The recursive helper method will have the array of encodings as one parameter,
	 * a node that's the root of a subtree as another parameter, and a string that's the path
	 * to that node as a string of zeros and ones.
	 * @param root tree made from counts
	 * @return String[] output encoding.
	 */

	private String[] makeCodingsFromTree(HuffNode root) {
		String[] codings = new String[ALPH_SIZE + 1];
		codingHelper(root, "", codings);
		return codings;
	}

	/**
	 * Helper method for MakeCodingsFromTree above
	 * @param root tree made from counts
	 * @param path is manipulated within the method and "0" or "1" added depending
	 *             on the position of the next tree node.
	 * @param codings is the String[] encoding returned in makeCodingFromTree
	 */

	private void codingHelper(HuffNode root, String path, String[] codings) {
		if (root == null) return;
		if (root.myLeft == null && root.myRight == null) {
			codings[root.myValue] = path;
			return;
		}
		codingHelper(root.myLeft, path + "0", codings);
		codingHelper(root.myRight, path + "1", codings);
	}

	private void writeHeader(HuffNode root, BitOutputStream output) {
		if (root == null) return;
		if (root.myLeft == null && root.myRight == null) {
			output.writeBits(1, 1);
			output.writeBits(BITS_PER_WORD + 1, root.myValue);
		}
		else {
			output.writeBits(1,0);
			writeHeader(root.myLeft, output);
			writeHeader(root.myRight, output);
		}
	}

	// COMPRESS ---------------------------------

	/**
	 * Compresses a file. Process must be reversible and loss-less.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be compressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */

	public void compress(BitInputStream in, BitOutputStream out) {

		int[] counts = readForCounts(in);
		HuffNode root = makeTreeFromCounts(counts);
		String[] codings = makeCodingsFromTree(root);

		out.writeBits(BITS_PER_INT, HUFF_TREE);
		writeHeader(root, out);

		in.reset();
		writeCompressedBits(codings, in, out);
		out.close();

	}

// -------------------------------------------- DECOMPRESS--------------------------

	// HELPER METHODS FOR DECOMPRESS ---------------------------------


	private HuffNode readTree(BitInputStream in) {
		HuffNode left;
		HuffNode right;
		int value;
		int bit = in.readBits(1);
		if (bit == -1)
			throw new HuffException("Stream ended prematurely");
		if (bit == 0) {
		    left = readTree(in);
		    right = readTree(in);
		    return new HuffNode(0,0,left,right);
		}
		else {
		    value = in.readBits(BITS_PER_WORD + 1);
		    return new HuffNode(value,0,null,null);
		}

	}

	private void readCompressedBits(HuffNode root, BitInputStream in, BitOutputStream out) {

		HuffNode current = root;
		while(true) {
			int bits = in.readBits(1);
			if(bits == -1) {
				throw new HuffException("No PSUEDO_EOF");
			}
			else {
				if (bits == 0)
					current = current.myLeft;
				else
					current = current.myRight;

				if (current.myLeft == null && current.myRight == null) {
					if (current.myValue == PSEUDO_EOF)
						break;
					else {
						out.writeBits( 8, current.myValue);
						current = root;
					}
				}
			}
		}
	}

	// DECOMPRESS ---------------------------------

	/**
	 * Decompresses a file. Output file must be identical bit-by-bit to the
	 * original.
	 *
	 * @param in
	 *            Buffered bit stream of the file to be decompressed.
	 * @param out
	 *            Buffered bit stream writing to the output file.
	 */
	public void decompress(BitInputStream in, BitOutputStream out){

		int bits = in.readBits(BITS_PER_INT);
		if(bits != HUFF_TREE) {
			throw new HuffException("illegal header starts with " +bits);
		}

		HuffNode root = readTree(in);
		readCompressedBits(root, in , out);
		out.close();
	}
}