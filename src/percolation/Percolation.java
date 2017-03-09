package percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private WeightedQuickUnionUF wquf;
    private WeightedQuickUnionUF wqufFull;
    private int n;
    private int numOfOpenSite = 0;
    private boolean[] siteState;

    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        if (n < 1) {
            throw new IllegalArgumentException();
        }
        this.n = n;
        wquf = new WeightedQuickUnionUF(n * n + 2);
        wqufFull = new WeightedQuickUnionUF(n * n + 1);
        siteState = new boolean[n * n + 1];
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) {
            throw new IndexOutOfBoundsException();
        }
        if (isOpen(row, col)) {
            return;
        }

        int p = n * (row - 1) + col;
        siteState[p] = true;
        numOfOpenSite++;

        // connect with left site
        if (col > 1 && n > 1 && isOpen(row, col - 1)) {
            int q = p - 1;
            wquf.union(p, q);
            wqufFull.union(p, q);
        }

        // connect with right site
        if (col < n && n > 1 && isOpen(row, col + 1)) {
            int q = p + 1;
            wquf.union(p, q);
            wqufFull.union(p, q);
        }

        // connect with upper site
        if (row > 1 && isOpen(row - 1, col)) {
            int q = p - n;
            wquf.union(p, q);
            wqufFull.union(p, q);
        }

        // connect with lower site
        if (row < n && isOpen(row + 1, col)) {
            int q = p + n;
            wquf.union(p, q);
            wqufFull.union(p, q);
        }

        // connect with top site
        if (row == 1) {
            wquf.union(p, 0);
            wqufFull.union(p, 0);
        }

        // connect with bottom site
        if (row == n) {
            wquf.union(p, n * n + 1);
        }

    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) {
            throw new IndexOutOfBoundsException();
        }
        int p = n * (row - 1) + col;
        return siteState[p];
    }

    // is site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 1 || col < 1 || row > n || col > n) {
            throw new IndexOutOfBoundsException();
        }
        int id = n * (row - 1) + col;
        return wqufFull.connected(0, id);
    }

    // number of open sites
    public int numberOfOpenSites() {
        return numOfOpenSite;
    }

    // does the system percolate?
    public boolean percolates() {
        return wquf.connected(0, n * n + 1);
    }

    // test client (optional)
    public static void main(String[] args) {

    }

}