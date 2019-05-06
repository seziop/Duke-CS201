public class GridGame {
    private char[][] myGrid = new char[4][4];

    public int winningMoves(String[] grid) {
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                myGrid[row][col] = grid[row].charAt(col);
            }
        }
        return scoreEngine();
    }

    public int scoreEngine() {
        int retTotal = 0;
        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 4; row++) {
                if (validMove(row, col)) {
                    myGrid[row][col] = 'X';
                    if (scoreEngine() == 0) retTotal++;
                    myGrid[row][col] = '.';
                }
            }
        }
        return retTotal;
    }

    public boolean validMove(int row, int col) {
        if (myGrid[row][col] == 'X') return false;
        if (row > 0 && myGrid[row - 1][col] == 'X') return false;
        if (row <= 2 && myGrid[row + 1][col] == 'X') return false;
        if (col > 0 && myGrid[row][col - 1] == 'X') return false;
        if (col <= 2 && myGrid[row][col + 1] == 'X') return false;
        return true;
    }
}
