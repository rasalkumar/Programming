package test;
//import java.util.*;
import java.math.*;
public class Test {
	public static void main(String args[])
	{
		long a=12;
		long z=a;
        String s="";
        while(z!=0)
        {
            long d = z % 2;
            s = d + s;
            z =z/2;
        }
        System.out.println(s);
	}

}
