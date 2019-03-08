package sherLockAndValidString;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for( int i = 0 ; i < s.length() ; i++ )
        {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i),1);
            else
                map.put(s.charAt(i) , map.get(s.charAt(i)) + 1 );    
        }
        //HashMap<Integer,Integer> map2 = new HashMap<>();
        //ArrayList<Integer> list = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            int x = entry.getValue();
            max = Math.max(max, x);
            min = Math.min(min, x);
            //list.add(x);
        }
        if(max == min)
        	return "YES";
        if(Math.abs(max-min) <= 1)
        	return "YES";
        return "NO";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	Scanner in = new Scanner(System.in); 

        String s = scanner.nextLine();

        String result = isValid(s);

        System.out.println(result);
        //scanner.close();
    }
}
