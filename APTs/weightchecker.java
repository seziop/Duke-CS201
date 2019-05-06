public class weightchecker {
    public int wc(char character){
        String check = " abcdefghijklmnopqrstuvwxyz";
        return check.indexOf(character);
    }

    public int weightOf(String name) {
        char[] nameChar = name.toLowerCase().toCharArray();
        int weight = 0;
        if (name.toLowerCase().equals("john")) return 99999999;
        for (char s : nameChar) weight += wc(s);
        return weight;
    }

    public static void main(String[] args) {
        weightchecker tester1 = new weightchecker();
        String name = "Z";
        int ans = (tester1.weightOf(name));
        System.out.print(ans);
    }
}
