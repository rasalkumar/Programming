package amazon;
import java.util.*;
public class PointsInsidePolygon {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] x = new long[N+1];
        long[] y = new long[N+1];
        for (int i = 0; i <N ; i++) {
        	x[i]=sc.nextLong();
            y[i]=sc.nextLong();
        }
        x[N]=x[0];
        y[N]=y[0];
        long area =0;
        for(int i=0;i<N;i++){
            area+=x[i+1]*y[i]-x[i]*y[i+1];
        }
        long border =0;
        for(int i=0;i<N;i++){
            border+=gcd(Math.abs(x[i+1]-x[i]),Math.abs(y[i+1]-y[i]));
        }
        System.out.println((area+2-border)/2);
    }
    public static long gcd(long a, long b) {
        if(b==0)
        	return a;
        return gcd(b,a%b);
    }

}
