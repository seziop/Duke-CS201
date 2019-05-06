public class AccessLevel {
    public String canAccess(int[] rights, int minPermission) {
        String ret = "";
        for (int i = 0; i < rights.length; i = i + 1) {
            if (rights[i] >= minPermission) {
                ret += "A";
            }
            else {
                ret += "D";
            }
        }
        return ret;
    }
    /*
    public static void main(String[] args) {
        AccessLevel tester1 = new AccessLevel();
        int[] rights = {5,3,2,10,0};
        int minPermission = 20;
        String ans = tester1.canAccess(rights,minPermission);
        System.out.print(ans);
    }
    */
}
