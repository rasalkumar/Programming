package mines;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Mines {

	public static int nComp;
	public static int mMines;
	public static int x[] = new int[20];
	public static int CompAlloc[] = new int[20];

	public static int findFairness(int x[]) {

		int nAverage = 0;
		for (int i = 0; i < mMines; i++) {
			nAverage += x[i];
		}
		nAverage = nAverage / nComp;

		int iStart = findStartPoint(nAverage);

		findMinimum(iStart, nAverage);

		System.out.println("Allocation");
		for (int k = 0; k < nComp; k++) {
			System.out.print(CompAlloc[k] + ",");
		}

		System.out.println("");

		return 0;
	}

	public static int findStartPoint(int nAverage) {
		int nMin = 100000000;
		int iStart = 0;
		for (int k = 0; k < mMines; k++) {
			int nfinMin = findMinimum(k, nAverage);
			if (nMin >= nfinMin) {
				nMin = nfinMin;
				iStart = k;
			}
		}

		System.out.println("Start Point: " + iStart);
		return iStart;

	}

	public static int findMinimum(int iStart, int nAverage) {
		int nthComp = 0;
		int Sum = 0;
		int nMinimum = 100000000;
		for (int j = iStart, k = 0; k < mMines; k++) {
			Sum += x[j];

			if ((nComp - 1 - nthComp) == (mMines - 1 - k)) {
				int sum = Math.abs(Sum - nAverage);
				if (sum < nMinimum) {
					nMinimum = sum;
				}
				CompAlloc[nthComp++] = Sum;
				Sum = 0;
			} else if (nthComp == nComp - 1) {
				if (k == mMines - 1) {
					int sum = Math.abs(Sum - nAverage);
					if (sum < nMinimum) {
						nMinimum = sum;
					}

					CompAlloc[nthComp++] = Sum;
				}
			}

			else if (Sum >= nAverage) {
				int sum1 = 0;
				int sum2 = 0;
				sum1 = Math.abs(Sum - nAverage);
				sum2 = Math.abs(Sum - x[j] - nAverage);

				if (sum1 < sum2) {
					CompAlloc[nthComp++] = Sum;
					if (sum1 < nMinimum) {
						nMinimum = sum1;
					}
				} else {
					CompAlloc[nthComp++] = (Sum - x[j]);
					j--;
					k--;
					if (sum2 < nMinimum) {
						nMinimum = sum2;
					}
				}

				Sum = 0;
			}

			j++;
			if (j >= mMines) {
				j = 0;
			}
		}

		return nMinimum;
	}

	public static void main(String args[]) throws FileNotFoundException {

		Scanner sc = new Scanner(new File("C:\\Users\\USER\\workspace\\Samsung\\src\\mines\\sample3.txt"));

		int testcasecount = sc.nextInt();
		for (int i = 0; i < testcasecount; ++i) {
			nComp = sc.nextInt();
			mMines = sc.nextInt();

			for (int j = 0; j < mMines; ++j) {
				x[j] = sc.nextInt();

			}

			findFairness(x);
		}

		sc.close();
		return;
	}

}
