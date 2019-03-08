package dpSet21;
import java.util.*;
public class BoxStacking {
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		BoxRectangle[] box = new BoxRectangle[n];
		for(int i = 0 ; i < n ; i++ )
		{
			int x = in.nextInt();
			int y = in.nextInt();
			int z = in.nextInt();
			box[i] = new BoxRectangle(x,y,z);
		}
		BoxStacking obj = new BoxStacking();
		System.out.println();
		
	}
	static class BoxRectangle
	{
		int width;
		int height;
		int depth;
		BoxRectangle(int w,int h,int d)
		{
			width = w;
			height = h;
			depth = d;
		}
	}
}
