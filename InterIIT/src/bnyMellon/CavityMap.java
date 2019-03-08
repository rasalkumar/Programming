package bnyMellon;
import java.util.*;
import java.io.*;
public class CavityMap 
{


	    // Complete the cavityMap function below.
	    static String[] cavityMap(String[] grid) {
	        char[][] a = new char[grid.length][grid[0].length()];
	        for( int i = 0 ; i < grid.length ;i++ )
	        {
	            for( int j = 0 ; j < grid[i].length() ; j++ )
	            {
	                if( i == 0 || j == 0 || i == grid.length -1 || j == grid[i].length() -1 )
	                {
	                    a[i][j] = grid[i].charAt(j);
	                } 
	                else if(grid[i].charAt(j) > grid[i-1].charAt(j) &&
	                        grid[i].charAt(j) > grid[i].charAt(j-1) &&
	                        grid[i].charAt(j) > grid[i].charAt(j+1) &&
	                        grid[i].charAt(j) > grid[i+1].charAt(j))
	                {
	                    a[i][j] = 'X';
	                }
	                else
	                {
	                    a[i][j] = grid[i].charAt(j);
	                }        
	            }
	        }
	        String result[] = new String[grid.length];
	        for(int i = 0 ; i < a.length ;i++)
	        {
	            result[i] = convert(a[i]);
	        }
	        return result;
	   }
	    public static String convert(char[] c)
	    {
	        String t= "";
	        for( int i = 0 ; i < c.length ; i++ )
	            t = t + c[i];
	        return t;
	    }

	    private static final Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) throws IOException {
	        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

	        int n = scanner.nextInt();
	        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

	        String[] grid = new String[n];

	        for (int i = 0; i < n; i++) {
	            String gridItem = scanner.nextLine();
	            grid[i] = gridItem;
	        }

	        String[] result = cavityMap(grid);

	        for (int i = 0; i < result.length; i++) {
	            bufferedWriter.write(result[i]);

	            if (i != result.length - 1) {
	                bufferedWriter.write("\n");
	            }
	        }

	        bufferedWriter.newLine();

	        bufferedWriter.close();

	        scanner.close();
	    }
	

}
