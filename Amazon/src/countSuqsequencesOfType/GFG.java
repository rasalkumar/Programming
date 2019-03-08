package countSuqsequencesOfType;
import java.util.*;
public class GFG {
	public static void main(String args[])
	{
		
	    Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 ) {
		    String a = in.next();
		    int n = a.length();
		    int ac=0, bc=0, cc=0;
		    for (int i=0; i < n; i++) {
		        char ch = a.charAt(i);
		        if (ch == 'a') ac = 1 + 2*ac;
		        else if (ch == 'b') bc = ac + 2*bc;
		        else if (ch == 'c') cc = bc + 2*cc;
		    }
		    System.out.println(cc);
	}
	}
}
