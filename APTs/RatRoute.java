public class RatRoute {

    int chRow = 0;
    int chCol = 0;


    public int numRoutes(String[] enc) {
        int rowLim = enc.length;
        int colLim = enc[0].length();

        int rtRow = 0;
        int rtCol = 0;

        char[][] experimentBoard = new char[rowLim][colLim];

        for (int col = 0; col < colLim; col++) {
            for (int row = 0; row < rowLim; row++) {
                experimentBoard[row][col] = enc[row].charAt(col);
                if (experimentBoard[row][col] == 'R') {
                    rtRow = row;
                    rtCol = col;
                }
                if (experimentBoard[row][col] == 'C') {
                    chRow = row;
                    chCol = col;
                }
            }
        }
        int distance = (Math.abs(chRow - rtRow) + Math.abs(chCol - rtCol));
        return recursiveHelper(rtRow,rtCol,distance,experimentBoard,rowLim,colLim);
    }

    public int recursiveHelper(int rtRow, int rtCol, int distance, char[][] experimentBoard, int rowLim, int colLim){
        if (rtRow >= rowLim || rtCol >= colLim || rtCol < 0 || rtRow <0) return 0;
        int newdistance = (Math.abs(chRow - rtRow) + Math.abs(chCol - rtCol));
        if (experimentBoard[rtRow][rtCol] == 'X') return 0;
        if (experimentBoard[rtRow][rtCol] == 'C') return 1;
        if (newdistance > distance) return 0;
        return recursiveHelper(rtRow +1, rtCol, newdistance, experimentBoard, rowLim, colLim)
                + recursiveHelper(rtRow -1, rtCol, newdistance, experimentBoard, rowLim, colLim) +
                + recursiveHelper(rtRow, rtCol+1, newdistance, experimentBoard, rowLim, colLim) +
                + recursiveHelper(rtRow, rtCol-1, newdistance, experimentBoard, rowLim, colLim);

    }
}