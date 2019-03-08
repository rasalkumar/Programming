package lab5;
import java.util.*;
public class App {

	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		

	}
	public static String[] Split(String s)
	{
		StringTokenizer str = new StringTokenizer(s, "#");
		ArrayList<String> a= new ArrayList<>();
		while(str.hasMoreTokens())
		{
			String p = str.nextToken();
			String[] k = p.split(" ");
			for(int i = 0 ; i < k.length ; i++)
			{
				a.add(k[i]);
			}
			
		}
		String[] b = new String[a.size()];
		for(int i  = 0 ; i < a.size() ;i++)
		{
			b[i] = a.get(i);
		}
			
		return b;
	}
	public static String[] UniqueLabels(String words[])
	{
		return null;
	}
	public static int[] Count(String words[], String labels[])
	{
		return null;
	}
	public static void display(int n)
	{
		
	}

}
