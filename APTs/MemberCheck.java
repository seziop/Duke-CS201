import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class MemberCheck {
    public String[] whosDishonest(String[] club1,
                                  String[] club2,
                                  String[] club3) {
        // TODO: fill in code here
        Set<String> result = new HashSet<>();
        Set<String> s1 = new HashSet<>(Arrays.asList(club1));
        Set<String> s2 = new HashSet<>(Arrays.asList(club2));
        Set<String> s3 = new HashSet<>(Arrays.asList(club3));

        Set<String> int1 = new HashSet<>(Arrays.asList(club1));
        Set<String> int2 = new HashSet<>(Arrays.asList(club2));
        Set<String> int3 = new HashSet<>(Arrays.asList(club3));

        int1.retainAll(s2);
        int2.retainAll(s3);
        int3.retainAll(s1);

        result.addAll(int1);
        result.addAll(int2);
        result.addAll(int3);

        String[] ret = result.toArray(new String[0]);
        Arrays.sort(ret);
        return ret;
    }


    public static void main(String[] args) {
        MemberCheck tester1 = new MemberCheck();
        String[] club1 = {"BOBBY", "HUGH", "LIZ", "GEORGE"};
        String[] club2 = {"ELIZABETH", "WILL" };
        String[] club3 = {"BOB", "BOBBY", "BOBBY", "PAM", "LIZ", "BOBBY", "BOBBY", "WILL"};
        String[] ans = tester1.whosDishonest(club1,club2,club3);
        System.out.print(Arrays.toString(ans));
    }
}
