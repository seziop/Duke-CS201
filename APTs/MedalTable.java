import java.util.*;

public class MedalTable {
    public String[] generate(String[] results) {
        Map<String, int[]> myMap = new HashMap<>();
        checkMedal(results, myMap);

        ArrayList<String> list = new ArrayList<>(myMap.keySet());
        Comparator<String> comp = Comparator.comparingInt(s -> myMap.get(s)[0]);
        comp = comp.thenComparingInt(s -> myMap.get(s)[1]);
        comp = comp.thenComparingInt(s -> myMap.get(s)[2]);
        comp = comp.reversed();
        comp = comp.thenComparing(String::compareTo);

        Collections.sort(list,comp);

        String[] ret = new String[list.size()];
        int index = 0;
        for (String s : list){
            int[] val = myMap.get(s);
            String retVal = s + " " + val[0] + " " + val[1]+ " " + val[2];
            ret[index] = retVal;
            index ++;
        }
        return ret;
    }

    public void checkMedal(String[] results, Map<String,int[]> myMap){
        for (String result : results){
            String[] country = result.split(" ");
            for (int k = 0; k < 3; k++){
                int[] insertVal = new int[3];
                String thisCountry = country[k];
                myMap.putIfAbsent(thisCountry, insertVal);
                insertVal = myMap.get(thisCountry);
                insertVal[k] += 1;
                myMap.put(thisCountry, insertVal);
            }
        }
    }
    public static void main(String[] args) {
        MedalTable tester1 = new MedalTable();
        String[] test = {"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"};
        String[] ans = (tester1.generate(test));
        for (String s : ans){
            System.out.print(s + "  , ");
        }
    }
}