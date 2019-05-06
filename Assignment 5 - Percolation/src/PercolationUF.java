/**

 Shivansh Mehta (CS201-Duke Spring 2019)
 NetIDs: sm682

 Percolation Project
 PercolationUF.java

 Main Implemented Class 3 of 3 for this project

 **/

public class PercolationUF implements IPercolate {

    private boolean[][] myGrid;
    private IUnionFind myFinder;
    private int myOpenCount;
    private final int VTOP;
    private final int VBOTTOM;

    /**
     * Constructs a Percolation object for a nxn grid that uses unionThing to
     * store sets representing the cells and the top/source and bottom/sink
     * virtual cells
     */

    public PercolationUF(int size, IUnionFind finder) {

        // Initialize VTOP and VBOTTOM

        VTOP = size * size;
        VBOTTOM = size * size + 1;

        // Initialize myGrid and setting all grid values to False

        myGrid = new boolean[size][size];
        for (int row = 0, col = 0; row < size && col < size; row++, col++) {
            myGrid[row][col] = false;
        }

        // Initialize IUnionFind and storing in myFinder

        finder.initialize(size * size + 2);
        myFinder = finder;
    }


    /**
     * Returns true if and only if site (row, col) is OPEN
     * @param row row index in range [0,N-1]
     * @param col column index in range [0,N-1]
     */

    @Override
    public boolean isOpen(int row, int col) {
        if (!inBounds(row,col)){
            throw new IndexOutOfBoundsException("Cell out of bounds");
        }

        return myGrid[row][col];
    }

    /**
     * Returns true if and only if site (row, col) is FULL
     *@param row row index in range [0,N-1]
     * @param col column index in range [0,N-1]
     */

    @Override
    public boolean isFull(int row, int col){
        if (!inBounds(row,col)){
            throw new IndexOutOfBoundsException("Cell out of bounds");
        }

        if (myFinder.connected(row * myGrid.length + col, VTOP)) return true;
        return false;
    }

    /**
     * Returns true if the simulated percolation actually percolates. What it
     * means to percolate could depend on the system being simulated, but
     * returning true typically means there's a connected path from
     * top-to-bottom.
     * @return true iff the simulated system percolates
     */
    public boolean percolates() {
        if (myFinder.connected(VTOP,VBOTTOM)) return true;
        return false;
    }

    /**
     * Returns the number of distinct sites that have been opened in this
     * simulation
     * @return number of open sites
     */
    public int numberOfOpenSites(){
        return myOpenCount;
    }

    /**
     * Open site (row, col) if it is not already open. By convention, (0, 0)
     * is the upper-left site
     * The method modifies internal state so that determining if percolation
     * occurs could change after taking a step in the simulation.
     * @param row row index in range [0,N-1]
     * @param col column index in range [0,N-1]
     */
    public void open(int row, int col) {
        if (!inBounds(row,col)){
            throw new IndexOutOfBoundsException("Cell out of bounds");
        }

        if (!isOpen(row, col)) {
            myGrid[row][col] = true;
            myOpenCount += 1;
            if (row == 0) {
                myFinder.union(row * myGrid.length + col, VTOP);
            }
            if (row == myGrid.length - 1) {
                myFinder.union(row * myGrid.length + col, VBOTTOM);
            }
            int[] neighbourhood = {-1, -1, 1, 1};
            boolean odd = false;
            for (int k = 0; k < 4; k++) {
                if (!odd) {
                    if (inBounds(row, col + neighbourhood[k]) && isOpen(row, col + neighbourhood[k])) {
                        myFinder.union(row * myGrid.length + (col + neighbourhood[k]), row * myGrid.length + col);
                    }
                } else {
                    if (inBounds(row + neighbourhood[k], col) && isOpen(row + neighbourhood[k], col)) {
                        myFinder.union((row + neighbourhood[k]) * myGrid.length + col, row * myGrid.length + col);
                    }
                }
                odd = !odd;
            }
        }
    }

    /**
     * Determine if (row,col) is valid for given grid
     * @param row specifies row
     * @param col specifies column
     * @return true if (row,col) on grid, false otherwise
     */

    protected boolean inBounds(int row, int col) {
        if (row < 0 || row >= myGrid.length) return false;
        if (col < 0 || col >= myGrid[0].length) return false;
        return true;
    }

}
