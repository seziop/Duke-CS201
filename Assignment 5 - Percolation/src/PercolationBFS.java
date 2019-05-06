/**

 Shivansh Mehta (CS201-Duke Spring 2019)
 NetIDs: sm682

 Percolation Project
 PercolationBFS.java

 Main Implemented Class 2 of 3 for this project

 **/


import java.util.LinkedList;
import java.util.Queue;

public class PercolationBFS extends PercolationDFSFast {



    /**
     * This class extends the PercolationDFSFast.
     * Constructor with an int/size parameter calls super to
     * initialize the state in the parent class.
     * @param n is the size of the simulated (square) grid
     */
    public PercolationBFS(int n) {super(n);}


    /**
     * Override the dfs method inherited from PercolationDFS
     * to use a Queue and a breadth-first-search (BFS) approach.
     * @param row is the row coordinate of the cell being checked/marked
     * @param col is the col coordinate of the cell being checked/marked
     */

    @Override
    protected void dfs(int row, int col) {

        if (! inBounds(row,col)) return;
        if (isFull(row, col) || !isOpen(row, col)) return;

        myGrid[row][col] = FULL;
        int[] neighbourhood = {-1,-1,1,1};

        Queue<Integer> iterativeQueue = new LinkedList<>();
        iterativeQueue.add(row * myGrid.length + col);

        while (iterativeQueue.size() != 0){
            int removeTester = iterativeQueue.remove();
            row = removeTester / myGrid.length;
            col = removeTester % myGrid.length;

            boolean odd = false;
            for (int k = 0; k < 4; k ++) {
                if (!odd) {
                    if ((inBounds(row,col + neighbourhood[k])) && (!isFull(row, col +
                            neighbourhood[k])) && (isOpen(row, col + neighbourhood[k]))) {
                        iterativeQueue.add(row * myGrid.length + (col + neighbourhood[k]));
                        myGrid[row][col + neighbourhood[k]] = FULL;
                    }
                }
                else {
                    if ((inBounds(row + neighbourhood[k],col)) && (!isFull(row +
                            neighbourhood[k],col)) && (isOpen(row + neighbourhood[k],col))){
                        iterativeQueue.add((row + neighbourhood[k]) * myGrid.length + col);
                        myGrid[row + neighbourhood[k]][col] = FULL;
                    }
                }
                odd = !odd;
            }
        }
    }

}
