package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 8, 2, 4, 1, 3, 6 };
		int n = a.length;
		for (int i = 1; i < n; i++) {
			int hole = i;
			int temp = a[hole];
			while (hole > 0 && a[hole - 1] > temp) {
				a[hole] = a[hole - 1];
				hole--;
			}
			a[hole] = temp;
		}

		for (int i = 0; i < n; i++) {
			System.out.println(a[i] + " ");
		}
	}
}
