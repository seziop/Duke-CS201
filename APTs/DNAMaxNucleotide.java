public class DNAMaxNucleotide {
    public String max(String[] strands, String nuc) {
        String maxString = "";
        int maxOccurances = 0;
        for (int i = 0; i < strands.length; i = i + 1) {
            String DNA = strands[i];

            String[] chars = DNA.split("");
            int numOccurances = 0;
            for (int v = 0; v < chars.length; v = v + 1) {
                if (chars[v].equals(nuc)) {
                    numOccurances += 1;
                }
            }

            if (numOccurances > maxOccurances) {
                maxString = DNA;
                maxOccurances = numOccurances;
            }

            if (numOccurances == maxOccurances) {
                if (DNA.length() > maxString.length()) {
                    maxString = DNA;
                    maxOccurances = numOccurances;
                }
            }
        }
        if (maxOccurances == 0) {
            return "";
        }
        return maxString;

    }
}
