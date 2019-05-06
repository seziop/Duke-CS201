import java.util.Arrays;

public class OlympicCandles{
    public int numberOfNights(int[] candles){
        int num = 1;
        while (true){
            Arrays.sort(candles);
            for (int v = 0; v < num; v ++){
                int dex = candles.length - v -1;
                if (dex < 0) return num -1;
                if (candles[dex] == 0) return num -1;
                else candles[dex] --;
            }
            num ++;
        }
    }
}