package keyboardLayouts;
import java.io.*;
import java.util.*;
public class KeyBoardLayouts {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub

		InputStreamReader xyz=new InputStreamReader(System.in);
		BufferedReader in = new BufferedReader(xyz);
		String k1=in.readLine();
		String k2=in.readLine();
		String s=in.readLine();
		HashMap<Character,Character> map = new HashMap<>();
		for(int j=0;j<25;j++)
		{
			map.put(k1.charAt(j), k2.charAt(j));
		}
		int i=0;
		String t="";
		while(i<s.length())
		{
			if(!(s.charAt(i)>=65 && s.charAt(i)>90)||(s.charAt(i)>=97 && s.charAt(i)<=122))
			{
				t=t+s.charAt(i);
				i++;
			}
			else
			{
				t=t+map.get(s.charAt(i)).toString();
				i++;
			}
		}
		System.out.println(t);
	}

}
