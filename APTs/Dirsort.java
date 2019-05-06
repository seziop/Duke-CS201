import java.util.Arrays;
import java.util.Comparator;

public class Dirsort {
    public String[] sort(String[] dirs) {
        Arrays.sort(dirs,new DirComp());
        return dirs;
    }

    public class DirComp implements Comparator<String> {

        @Override
        public int compare(String a, String b) {
            String[] arr = a.split("/");
            String[] brr = b.split("/");
            if (arr.length == brr.length) {

                for (int k = 0; k < arr.length; k++) {
                    int comp = arr[k].compareTo(brr[k]);
                    if (comp != 0) return comp;
                }
            }

            return (arr.length - brr.length);
        }
    }
}
