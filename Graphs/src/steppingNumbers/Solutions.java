package steppingNumbers;
import java.util.*;
public class Solutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in  = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		Solutions obj = new Solutions();
		System.out.println(obj.stepnum(m, n));

	}
	 public  ArrayList<Integer> stepnum(int A, int B) {
		 ArrayList<Integer> result = new ArrayList<>();
		 for(int i  = A ; i < B ; i++ )
		 {
			 int flag = 0;
			 int  d = i % 10;  
			 for(int j = i/10 ; j > 0 ;j = j / 10 )
			 {
				 int  e = j%10;
				 int diff = Math.abs(d - e);
				 if(diff != 1)
				 {
					 flag = 1;
					 break;
				 }else
				 {
					 d = e;
				 }
			 }
			 if (flag==0)
			 {
				 result.add(i);
			 }
		 }
		 return result;
	    }

}
