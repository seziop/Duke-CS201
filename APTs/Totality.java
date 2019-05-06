public class Totality {
    public int sum(int[] a, String stype) {
        int ret = 0;

        if (stype.equals("even")) {
            for (int i = 0; i < a.length; i += 2) {
                ret += a[i];
            }
        }

        if (stype.equals("odd")) {
            for (int i = 1; i < a.length; i += 2) {
                ret += a[i];
            }
        }

        if (stype.equals("all")) {
            for (int i = 0; i < a.length; i++) {
                ret += a[i];
            }
        }
        return ret;
    }
/*
    public static void main(String[] args) {
        Totality tester1 = new Totality();
        int[] a = {1, 2, 3, 4, 5};
        String stype = "even";
        int ans = tester1.sum(a, stype);
        System.out.print(ans);
    }
*/
}

