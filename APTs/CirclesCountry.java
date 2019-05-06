public class CirclesCountry {
    public int leastBorders(int[] x, int[] y, int[] r,int x1, int y1, int x2, int y2) {
        int ret = 0;
        for (int i = 0; i < x.length; i = i + 1) {
            if ((inCircles(x[i],y[i],r[i],x1,y1)) ^ (inCircles(x[i],y[i],r[i],x2,y2))) {
                ret += 1;
            }
        }
        return ret;
    }

    public boolean inCircles(int x, int y, int r, int a, int b) {
        double distance = Math.sqrt((Math.pow(a-x,2) + Math.pow(b-y,2)));
        double radius = (double) r;
        if (distance < radius) {
            return true;
        }
        else {
            return false;
        }
    }
/*
    public static void main(String[] args) {
        CirclesCountry tester1 = new CirclesCountry();
        int[] x = {-107,-38,140,148,-198,172,-179,148,176,153,-56,-187};
        int[] y = {175,-115,23,-2,-49,-151,-52,42,0,68,109,-174};
        int[] r = {135,42,70,39,89,39,43,150,10,120,16,8};
        int x1 = 102;
        int y1 = 16;
        int x2 = 19;
        int y2 = -108;
        int ans = tester1.leastBorders(x, y, r,x1, y1, x2, y2);
        System.out.print(ans);
    }
*/
}
