package nikita;

//import java.util.*;
//import java.lang.*;
import java.io.*;
//import java.math.*;
 
class Satyam
{
	public static void main (String[] args)throws Exception
                  {
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		int tc=Integer.parseInt(in.readLine());
		while(tc--!=0)
		{
			String s=in.readLine();
			s=s.toLowerCase();
			String []str=s.split(" ");
			int l=str.length;
			if(l==1)
			{
			String ch=s.charAt(0)+"";
			System.out.println(ch.toUpperCase()+""+s.substring(1));
			}
			else
			{
				for(int i=0;i<l-1;i++)
				{
					String ch=str[i].charAt(0)+"";
					System.out.print(ch.toUpperCase()+". ");
				}
				String ch=str[l-1].charAt(0)+"";
				System.out.println(ch.toUpperCase()+""+str[l-1].substring(1));
			}
		}
	}
}  