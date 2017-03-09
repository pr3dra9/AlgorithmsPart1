package percolation;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] x;
    private int t;

    // perform trials independent experiments on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n < 1 || trials < 1) {
            throw new IllegalArgumentException();
        }
        this.x = new double[trials];
        this.t = trials;
        int i = 0;
        while (trials > 0) {
            trials--;
            Percolation p = new Percolation(n);
            double xi = 0;
            while (!p.percolates()) {
                int row = StdRandom.uniform(n) + 1;
                int col = StdRandom.uniform(n) + 1;
                if (!p.isOpen(row, col)) {
                    xi++;
                    p.open(row, col);
                }
            }
            x[i++] = xi / n / n;
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(x);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(x);
    }

    // low  endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * StdStats.stddev(x) / Math.sqrt(t));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * StdStats.stddev(x) / Math.sqrt(t));
    }

    // test client (described below)
    public static void main(String[] args) {
        PercolationStats ps = new PercolationStats(20, 10000);
        System.out.println(ps.mean());
    }

}