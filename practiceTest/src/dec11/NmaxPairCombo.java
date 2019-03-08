package dec11;
import java.util.*;
public class NmaxPairCombo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		for( int i = 0 ; i < n ; i++ )
			a.add(in.nextInt());
		for( int i = 0 ; i < n ; i++ )
			b.add(in.nextInt());
		Collections.sort(a, Collections.reverseOrder());
		Collections.sort(b, Collections.reverseOrder());
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i : a)
		{
			for(int j : b)
			{
				if(pq.size() < n )
				{
					pq.add( i + j );
				}
				else
				{
					System.out.println(pq.peek());
					if( pq.peek() < i + j )
					{
						pq.poll();
						pq.add(i +j);
					}
				}
			}
		}
		ArrayList<Integer> result = new ArrayList<>(pq);
		//System.out.println(result);
		Collections.sort(result,Collections.reverseOrder());
		System.out.println(result);
	}

}
