package chefAndTyping;
import java.util.*;
public class Typing {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t;
		t = in.nextInt();
	    while (t-->0){
	        int n,ans=0;
	        n = in.nextInt();
	        String str;
	        HashMap<String,Integer> ss = new HashMap<>();
	        for(int i=0;i<n;i++){
	            str = in.next();
	            if(ss.containsKey(str)  ){
	                ans += ss.get(str)/2;
	                continue;
	            }
	            int count =2;
	            for(int j=1;j<str.length();j++){
	                if( ( (str.charAt(j) == 'd' || str.charAt(j)=='f') && (str.charAt(j-1) == 'd' || str.charAt(j-1)== 'f' ) ) 
	                || ( (str.charAt(j-1) == 'j' || str.charAt(j-1)=='k') && (str.charAt(j-1) == 'j' || str.charAt(j-1)== 'k' ) ) )
	                    count += 4;
	                else
	                count += 2;
	            }
	            ss.put(str, count); 
	            ans += count;
	        }
	        System.out.println(ans);
	    }

	}

}
