package robotCarFueling;
import java.util.*;
public class RobotCarFuel {
	public static int GAS  = 1 ;
	public static int DIESEL = 2 ;
	public static int NOTHING  = 0 ;
	public static int LEFT = -1 ;
	public static int RIGHT = 1 ;
	public static int SPOT = 10 ;
	static int a[] = new int[SPOT];
	
	static int min;
	static class Cars
	{
		int visited[] = new int[SPOT];
		int nc;
		
	}
	static void fill(int step, int direction,int fuel,int quantity,int count,int cars_left,Cars station)
	{
		if(count == min)
	        return;
	    if(step == 0)
	    {//GASOLINE station
	    	//System.out.println("Case 1");
	        fill(1,RIGHT,GAS,2,count+1,cars_left,station);
	       return;
	    }if(step == SPOT-1)
	    {//DIESEL station
	    	//System.out.println("Case 2");
	        fill(SPOT-2,LEFT,DIESEL,2,count+1,cars_left,station);
	        return;
	    }if(a[step]==0)
	    {//spot not occupied by any car count does not increase
	    	//System.out.println("Case 3");
	        fill(step+direction,direction,fuel,quantity,count, cars_left,station);
	    }
	    if( a[step] == fuel && station.visited[step] == 0 && quantity > 0 )
	    {//fill
	        station.visited[step]=1;
	        if(cars_left == 1)
	        {    if(count < min)
	                min = count;
	        	//System.out.println(step+"**");	
	            return;
	        }//go forward
	        fill(step+direction,direction,fuel,quantity-1,count+1,cars_left-1,station);
	        //go back direction
	        fill(step-direction,-(direction),NOTHING,0,count+1,cars_left-1,station);
	        //don't fill and go forward
	        station.visited[step]=0;
	        fill(step+direction,direction,fuel,quantity,count+1,cars_left,station);
	    }
	    else
	    {//Already filled
	        fill(step+direction,direction,fuel,quantity,count+1,cars_left,station);
	    }
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while( t-- > 0 )
		{
			Cars station = new Cars();
			min = 65530;
			for(int i = 0 ; i < SPOT ; i++ )
			{
				a[i] = 0;
				station.visited[i] = 0 ;
			}
			station.nc = in.nextInt();  
			for(int i = 1 ; i <= station.nc ; i++)
			{
				a[i] = in.nextInt();
			}
			fill(0,RIGHT,GAS,2,0,station.nc,station);
			//System.out.println(min);//(int step, int direction,int fuel,int quantity,int count,int cars_left,Cars station)
	        fill(0,RIGHT,NOTHING,2,0,station.nc,station);
	        System.out.println(min);
		}

	}

}
