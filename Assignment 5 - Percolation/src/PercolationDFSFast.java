/**

 Shivansh Mehta (CS201-Duke Spring 2019)
 NetIDs: sm682

 Percolation Project
 PercolationDFSFast.java

 Main Implemented Class 1 of 3 for this project

 **/


public class PercolationDFSFast extends PercolationDFS {


    /**
     * This class extends the PercolationDFS.
     * Constructor with an int/size parameter calls super to
     * initialize the state in the parent class.
     * @param n is the size of the simulated (square) grid
     */

    public PercolationDFSFast(int n) {super(n);}


    /**
     * Overrides updateOnOpen method inherited from PercolationDFS to be more efficient
     * Changes inherited updateOnOpen so it does not clear all cells,
     * but instead calls dfs once if the newly open cell should be marked as FULL because
     * it's in the top row or because it's adjacent to an already FULL cell.
     * @param row is the row coordinate of the cell being checked/marked
     * @param col is the col coordinate of the cell being checked/marked
     */


    @Override
    protected void updateOnOpen(int row, int col) {

        //General Base Cases

        if (inBounds(row,col) != true){
            return;
        }
        if (row == 0){
            dfs(row,col);
            return;
        }

        //Iterative Method

        int[] neighbourhood = {-1, -1, 1, 1};

        boolean odd = false;
        for (int k = 0; k < 4; k ++) {
            if (!odd) {
                if ((inBounds(row,col + neighbourhood[k])) && (myGrid[row][col + neighbourhood[k]] == FULL)){
                    dfs(row, col);
                    return;
                }
            }
            else {
                if ((inBounds(row + neighbourhood[k],col)) && (myGrid[row + neighbourhood[k]][col] == FULL)){
                    dfs(row, col);
                    return;
                }
            }
            odd = !odd;
        }
        return;
    }
}
