import java.util.HashSet;

public class FriendScore {
    public int highestScore(String[] friends) {
        HashSet<Integer> friendTracker = new HashSet<>();
        int count = 0;
        for (int k = 0; k < friends.length; k++) {
            for (int v = 0; v < friends[k].length(); v++) {
                if (friends[k].charAt(v) == 'Y') friendTracker.add(v);
                for (int d = 0; d < friends[v].length(); d++) {
                    if (friends[v].charAt(d) == 'Y' && (d != k)) friendTracker.add(d);
                }
            }
            int numfriends = friendTracker.size();
            if (numfriends > count) count = numfriends;
            friendTracker.clear();
        }
        return count;
    }
}