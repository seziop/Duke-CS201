/**

 Oliver Rodas & Shivansh Mehta (CS201-Duke Spring 2019)
 NetIDs: oar5, sm682

 DNA LinkStrand Project

 Edited File 2 of 2 for this project

 **/

import java.util.*;

public class CodonProfiler {
	
	/**
	 * Count how many times each codon in an array of codons occurs
	 * in a strand of DNA. Return int[] such that int[k] is number
	 * of occurrences of codons[k] in strand. Strand codons can start
	 * at all valid indexes that are multiples of 3: 0, 3, 6, 9, 12, ...
	 * @param strand is DNA to be analyzed for codon occurrences.
	 * @param codons is an array of strings, each has three characters
	 * @return int[] such that int[k] is number of occurrences of codons[k] in 
	 * strand. 
	 */

	public int[] getCodonProfile(IDnaStrand strand, String[] codons) {
		HashMap<String,Integer> map = new HashMap<>();
		int[] ret = new int[codons.length];

		for(int k=0; k < strand.size() - 2; k += 3) {
			String temp = "" + strand.charAt(k) + strand.charAt(k + 1) + strand.charAt(k + 2);
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}

		for(int k=0; k < codons.length; k++) {
			if (map.get(codons[k]) == null){
				ret[k] = 0;
			}
			else {
				ret[k] = map.get(codons[k]);
			}
		}
		return ret;
	}
}


