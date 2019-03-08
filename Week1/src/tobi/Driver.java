package tobi;

import java.io.*;

public class Driver {

	public static void main(String[] args) throws IOException {
		InputStreamReader xyz = new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(xyz);

		// TODO Auto-generated method stub
		int N = Integer.parseInt(in.readLine());
		UF uf = new UF(N);
		int p, q;
		String date,time;
		int i = 0;
		while (i < N) {
			p = Integer.parseInt(in.readLine());
			q = Integer.parseInt(in.readLine());
			date = in.readLine();
            time = in.readLine();
			if (!uf.isConnected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);

			}
			 		}

	}

}
