package flipkart;
import java.util.*;
public class SmallestRestrictedPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String s =in.next();
		System.out.println(smallestRestrictedPalindrome(s));
		
	}
	static String smallestRestrictedPalindrome(String s) {
		int c[] = new int[26];
		for (char ch : s.toCharArray()) 
			c[ch - 'a']++;
		String t = "";
		for (int i = 0; i < 26; i++) {
			for (int j = c[i] >> 1; j > 0; j-- ) {
				t += (char)('a' + i);
			}
		}
		int fl = 0;
		for (int i = 0;  fl == 0 && i < 26; i++) {
			if ((c[i]&1) != 0) {
				t += (char)('a' + i);
				fl = 1;
			}
		}
		int n = t.length() - fl ;
		for (int i = n ; i > 0; i-- ) {
			t += t.toCharArray()[i-1];
		}
		return t;
	}
	

}
