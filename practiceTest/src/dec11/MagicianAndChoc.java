package dec11;
import java.util.*;
public class MagicianAndChoc {
	static int ans = 0;
	static int mod = (int)Math.pow(10,9) + 7;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		ArrayList<Integer> a = new ArrayList<>();
		for( int i = 0 ; i < n ; i++ )
			a.add(in.nextInt());
		int k = in.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for( int i = 0  ; i < a.size() ; i++ )
		{
			pq.add(a.get(i));
		}
		
		for( int i = 0 ; i < k ; i++ )
		{
			int temp = pq.poll();
			ans = ( ( ans % mod ) + ( temp % mod ) ) % mod ;
			pq.add( temp / 2 );
		}
		System.out.println( ans % mod );
	}
}
