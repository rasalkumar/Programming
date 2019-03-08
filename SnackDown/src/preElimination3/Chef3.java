package preElimination3;

//KEEP IT SIMPLE SILLY @Tm Protino
import java.util.*;
public class Chef3 {
	public static void main(String agrs[])
	{
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			int n = in.nextInt();
			int m = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			for(int i = 0 ; i < n; i++ )
			{
				for(int j = 0 ; j < m ; j++ )
				{
					
				}
			}
		}
	}
	public  boolean isConsistent(int[] queens, int n){
        for(int i =0; i < n; i++){
           // System.out.printf("queens[%d] = %d and queens[%d] = %d \n", i, n, queens[i], queens[n]);
            if(queens[i] == queens[n]){ // same column
             //   System.out.println("\t Same Column");
                return false;
            }
            if((queens[i] - queens[n]) == (n - i)) {// same major diagonal
              //  System.out.println("\t Same major diagonal");
                return false;
            }
            if((queens[n] - queens[i]) == (n - i)) {//same minor diagonal
              //  System.out.println("\t Same minor diagonal");
                return false;
            }
        }
      //  System.out.println("\t Is consistent so enumerate " + (n+1));
        return true;
    }

}