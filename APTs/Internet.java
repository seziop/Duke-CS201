import java.util.*;

public class Internet {
    Map<String, Set<String>> myGraph = new HashMap<>();

    public int articulationPoints(String[] routers) {
        makeGraph(routers);
        int retCounter = 0;
        for (int k = 0; k < routers.length; k++){
            String vertex = "" + k;
            String start = "0";
            if (k == 0) start = "1";
            Set<String> set = dfs(start, vertex);
            if (set.size() != routers.length - 1) retCounter ++;
        }
        return retCounter;
    }

    public Set<String> dfs(String start, String avoid){
        Set<String> visited = new TreeSet<>();
        Stack<String> qu = new Stack<>();
        visited.add(start);
        qu.push(start);
        while(qu.size() > 0){
            String v = qu.pop();
            for (String adj : myGraph.get(v)){
                if (! visited.contains(adj) && !adj.equals(avoid)){
                    visited.add(adj);
                    qu.push(adj);
                }
            }
        }
        return visited;
    }

    public void makeGraph(String[] routers){
        for (int k = 0; k < routers.length; k++){
            myGraph.putIfAbsent("" + k, new HashSet<>());
            for (int j = 0; j < routers[k].split(" ").length; j++)
                for (String v : routers[k].split(" ")) {
                    myGraph.putIfAbsent("" + v, new HashSet<>());
                    myGraph.get("" + k).add(v);
                    myGraph.get(v).add("" + k);
                }
        }
        String input = "hello";
        for (char v : input){

        }
    }
}