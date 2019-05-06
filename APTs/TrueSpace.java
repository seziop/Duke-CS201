public class TrueSpace {
    public long calculateSpace(int[] sizes, int clusterSize) {
        long num = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i] != 0) {
                if (sizes[i] > clusterSize) {
                    if (sizes[i] % clusterSize == 0) num += Long.valueOf(sizes[i]) / Long.valueOf(clusterSize);
                    else num += Long.valueOf(sizes[i]) / Long.valueOf(clusterSize) + 1;
                } else num += 1;
            }
        }
        long ret = Long.valueOf(num) * Long.valueOf(clusterSize);
        return ret;
    }
    /*
    public static void main(String[] args) {
        TrueSpace tester1 = new TrueSpace();
        int[] sizes = {372361287, 933996130, 763061840, 851140573, 405763439, 758605145, 617122336, 110539089, 797820511, 405789569, 746695239};
        long ans = (tester1.calculateSpace(sizes, 1));
        System.out.print(ans);
       */
}
