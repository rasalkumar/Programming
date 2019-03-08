package week1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
	private int T;
	private double[] fractionOpened;

	
	public PercolationStats(int N, int T) {
		if (N <= 0 || T <= 0)
			throw new IllegalArgumentException();

		this.T = T;
		this.fractionOpened = new double[T];

		
		for (int run = 0; run < T; run++) {

		
			Percolation perc = new Percolation(N);
			int openLocal = 0;
			double fracLocal;

			while (!perc.percolates()) {

				
				int i = StdRandom.uniform(1, N + 1);
				int j = StdRandom.uniform(1, N + 1);

				if (!perc.isOpen(i, j)) {
					perc.open(i, j);
					openLocal++; 
					
				}
			}

			fracLocal = (double) openLocal / (N * N);
			this.fractionOpened[run] = fracLocal;
		}
	}

	
	public double mean() {
		double sum = 0.0;

		for (int i = 0; i < this.T; i++) {
			sum += this.fractionOpened[i];
		}
		return sum / ((double) this.T);
	}

	
	public double stddev() {
		double mu = this.mean();
		double sum = 0.0;

		for (int i = 0; i < this.T; i++) {
			sum += (this.fractionOpened[i] - mu)
					* (this.fractionOpened[i] - mu);
		}
		return sum / ((double) T - 1);
	}

	
	public double confidenceLo() {
		double cLow;
		double mu = this.mean();
		double sd = this.stddev();

		cLow = mu - ((1.96 * sd) / (Math.sqrt(T)));
		return cLow;
	}

	
	public double confidenceHi() {
		double cHigh;
		double mu = this.mean();
		double sd = this.stddev();

		cHigh = mu + ((1.96 * sd) / (Math.sqrt(T)));
		return cHigh;
	}

	
	public static void main(String[] args) {

		// PercolationStats stats = new PercolationStats(800, 30);
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		PercolationStats ps = new PercolationStats(N, T);

		String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
		StdOut.println("mean                    = " + ps.mean());
		StdOut.println("stddev                  = " + ps.stddev());
		StdOut.println("95% confidence interval = " + confidence);

	}

}