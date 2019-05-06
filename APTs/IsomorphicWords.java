public class IsomorphicWords {

    public String encrypt(String message) {
        char track = 'a';
        char[] encrypted = new char[256];
        for (int k = 0; k < message.length(); k++) {
            char var = message.charAt(k);
            if (encrypted[var] == 0) {
                encrypted[var] = track;
                track += 1;
            }
        }
        String retVal = "";
        for (int k = 0; k < message.length(); k++) {
            char val = message.charAt(k);
            retVal += encrypted[val];
        }
        return retVal;
    }

    public int countPairs(String[] words) {
        int total = 0;
        for (int j = 0; j < words.length; j++){
            String jword = encrypt(words[j]);
            for (int k = 0; k < words.length; k++){
                if (k == j) continue;
                String kword = encrypt(words[k]);
                if (jword.equals(kword)) {
                    total += 1;
                }
            }
        }
        return total/2;
    }
    public static void main(String[] args) {
        IsomorphicWords tester1 = new IsomorphicWords();
        String[] test1 = { "cacccdaabc", "cdcccaddbc", "dcdddbccad", "bdbbbaddcb",
                "bdbcadbbdc", "abaadcbbda", "babcdabbac", "cacdbaccad",
                "dcddabccad", "cacccbaadb", "bbcdcbcbdd", "bcbadcbbca" };
        int ans = tester1.countPairs(test1);
        System.out.print(ans);
    }
}
