import java.util.Arrays;
import java.util.HashSet;

public class FreeZone {
    public int[] uncovered(int zones, String[] covered){
        HashSet<Integer> coveredArea = new HashSet<Integer>();
        HashSet<Integer> totalArea = new HashSet<Integer>();
        for (String set : covered) {
            String[] minMax = set.split(" ");
            int min = Integer.parseInt(minMax[0]);
            int max = Integer.parseInt(minMax[1]);
            for (int i = min; i <= max; i++) {
                coveredArea.add(i);
            }
        }
        for (int i = 0; i < zones; i++){
            totalArea.add(i);
        }
        totalArea.removeAll(coveredArea);
        int reqSize = totalArea.size();
        int[] retList = new int[reqSize];
        int tracker = 0;
        for (int i = 0; i < zones; i ++) {
            if (!coveredArea.contains(i)) {
                retList[tracker] = i;
                tracker += 1;
            }
        }
        return retList;
    }
    public static void main(String[] args) {
        FreeZone tester1 = new FreeZone();
        int zones = 10;
        String[] covered = {"6 6"};
        int[] ans = (tester1.uncovered(zones, covered));
        System.out.print(Arrays.toString(ans));
    }
}