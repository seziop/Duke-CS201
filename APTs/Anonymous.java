public class Anonymous {
    public int howMany(String[] headlines, String[] messages) {
        int counts[] = new int[256];
        for (String s : headlines) {
            for (char ch : s.toLowerCase().toCharArray()) {
                if (ch == ' ') continue;
                counts[ch] = counts[ch] + 1;
            }
        }
        int retVal = messages.length;
        for (String s : messages) {
            int countsMessages[] = new int[256];
            for (char ch : s.toLowerCase().toCharArray()) {
                if (ch == ' ') continue;
                countsMessages[ch] = countsMessages[ch] + 1;
            }
            for (int i = 0; i < countsMessages.length; i++) {
                if (countsMessages[i] > counts[i]) {
                    retVal -= 1;
                    break;
                }
            }
        }
        return retVal;
    }


    public static void main(String[] args) {
        Anonymous tester1 = new Anonymous();
        String[] headlines =

                {"Earthquake in San Francisco ", " Burglary at musuem in Sweden ", " Poverty "};
        String[] messages =

                {"Give me my money back ", " I am the best coder ", " TOPCODER "};
        int ans = tester1.howMany(headlines,messages);
        System.out.print(ans);
    }
}
