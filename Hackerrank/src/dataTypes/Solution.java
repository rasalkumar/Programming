package dataTypes;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) {
        int i = 4;
        double d = 4.0;
        String s = "HackerRank ";
		
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        double b = scan.nextDouble();
        String c = scan.next();
        c += scan.nextLine();
        s = s + c ;
        
        System.out.println(a+i);
        System.out.println(String.format("%.1f",d+b));
        System.out.println(s);
        scan.close();
       }
   }