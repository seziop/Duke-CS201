public class Encryption {
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

    public static void main(String[] args) {
        Encryption tester1 = new Encryption();
        String ans = tester1.encrypt("hello");
        System.out.print(ans);
    }
}