import java.util.ArrayList;
import java.util.Arrays;

public class VoteRigging {
    public int minimumVotes(int[] votes) {
        int ret = 0;
        if (votes.length == 1) return 0;

        int[] otherVotes = new int[votes.length-1];
        for (int v = 0; v < otherVotes.length; v ++){
            otherVotes[v] = votes[v + 1];
        }
        Arrays.sort(otherVotes);

        while (ret + votes[0] <= otherVotes[otherVotes.length -1]){
            otherVotes[otherVotes.length -1] --;
            ret ++;
            Arrays.sort(otherVotes);
        }
        return ret;
    }
}