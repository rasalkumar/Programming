package week1;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

	private static final int CLOSED = 0;
	private static final int OPEN = 1;

	private int[][] sites;
	private int N;
	private int c = 0;
	private WeightedQuickUnionUF wqUF;
	private int top;
	private int bot;

	public Percolation(int N) {
		if (N <= 0) {
			throw new IllegalArgumentException("n<=0");
		}
		this.N = N + 2;
		this.wqUF = new WeightedQuickUnionUF((this.N) * (this.N));
		this.sites = new int[this.N][this.N];

		this.top = this.N / 2;
		this.bot = (this.N * this.N) - (this.N / 2);

		for (int i = 1; i < this.N; i++) {
			for (int j = 1; j < this.N; j++) {
				this.sites[i][j] = CLOSED;
			}
		}
	}
	

	public int numberOfOpenSites() {
		
		return c;
	}

	public void open(int i, int j) {
		c++;
		this.validateInput(i, j);

		int n = this.xyTo1D(i, j);

		if (this.isInTopRow(i, j)) {
			wqUF.union(top, n);
		}

		if (this.isInBottomRow(i, j)) {
			wqUF.union(bot, n);
		}

		if (!this.isOpen(i, j)) {
			this.sites[i][j] = OPEN;

			// If neighbors are open then union them
			if (this.isOpen(i, j + 1)) {
				wqUF.union(n, n + 1);
			}
			if (this.isOpen(i, j - 1)) {
				wqUF.union(n, n - 1);
			}
			if (this.isOpen(i + 1, j)) {
				wqUF.union(n, n + this.N);
			}
			if (this.isOpen(i - 1, j)) {
				wqUF.union(n, n - this.N);
			}

		}
	}

	public boolean isOpen(int i, int j) {
		this.validateInput(i, j);

		return this.sites[i][j] == OPEN;
	}

	public boolean isFull(int i, int j) {
		this.validateInput(i, j);
		int n = this.xyTo1D(i, j);
		if (wqUF.connected(top, n)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean percolates() {
		if (wqUF.connected(bot, top)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean validateInput(int i, int j) {
		if (i < 0 || i > this.N) {
			System.out.println("i: " + i);
			throw new IndexOutOfBoundsException("row index i out of bounds");
		}
		if (j < 0 || j > this.N) {
			System.out.println("j: " + j);
			throw new IndexOutOfBoundsException("col index j out of bounds");
		}
		return true;
	}

	private int xyTo1D(int i, int j) {
		return (i * this.N) + j;
	}

	private boolean isInTopRow(int i, int j) {
		if (i == 1) {
			return true;
		}
		return false;
	}

	private boolean isInBottomRow(int i, int j) {
		if (i == this.N - 2) {
			return true;
		}
		return false;
	}

}