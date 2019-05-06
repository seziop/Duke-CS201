import java.util.*;

public class ErdosNumber {

    TreeMap<String, Set<String>> myGraph = new TreeMap<>();
    TreeMap<String, Integer> myDistance = new TreeMap<>();

    public String[] calculateNumbers(String[] pubs) {
        makeGraph(pubs);
        ArrayList<String> list = new ArrayList<>();
        bfsErdos();
        for (String s : myGraph.keySet()){
            if (myDistance.containsKey(s)){
                s = s + " " + myDistance.get(s);
            }
            list.add(s);
        }

        return list.toArray(new String[0]);
    }

    private void makeGraph(String[] pubs) {
        HashSet<String> setOfName = new HashSet<>();
        for (String s : pubs){
            String[] split = s.split(" ");
            for (String v : s.split(" ")) setOfName.add(v);
            }
        for (String name : setOfName){
            myGraph.put(name,new HashSet<>());
            for (String s : pubs) {
                if (Arrays.asList(s.split(" ")).contains(name)) {
                    for (String v : s.split(" ")) if (!v.equals(name)) myGraph.get(name).add(v);
                }
            }

        }
    }

    private void bfsErdos() {
        String start = "ERDOS";
        myDistance.put("ERDOS", 0);
        Set<String> visited = new TreeSet<String>();
        Queue<String> qu = new LinkedList<>();
        visited.add(start);
        qu.add(start);

        while (qu.size() > 0) {
            String v = qu.remove();
            if (myGraph.containsKey(v)){
                for (String adj : myGraph.get(v)) {
                        visited.add(adj);
                        myDistance.putIfAbsent(v,0);
                        myDistance.put(v, myDistance.get(v) + 1);
                        qu.add(adj);
                    }
                }
            }
        }

    public static void main(String[] args) {
        ErdosNumber tester1 = new ErdosNumber();
        String[] test = {"ERDOS KLEITMAN", "CHUNG GODDARD KLEITMAN WAYNE", "WAYNE GODDARD KLEITMAN",
                "ALON KLEITMAN", "DEAN GODDARD WAYNE KLEITMAN STURTEVANT"};
        String[] ans = (tester1.calculateNumbers(test));
        for (String s : ans){
            System.out.print(s + "  , ");
        }
    }

}