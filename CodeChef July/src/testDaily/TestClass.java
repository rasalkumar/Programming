package testDaily;
import java.util.*;
class TestClass {
    public static void main(String args[] ){
    
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while( t-- > 0 )
        {
            int n = in.nextInt();
            int a[] = new int[n];
            for(int i = 0 ; i < n ; i++ )
            {
                a[i] = in.nextInt();
            }
            
            ArrayList<Integer> res = new ArrayList<>();
            res.add(a[0]);
            
            res.add(a[2]);
            int index2 = 2 ;
            while((2 * index2) + 2 < n)
            {
                res.add(a[(2 * index2) + 2]);
                index2 = (2 * index2) + 2;
            }
            
            
            res.add(a[1]);
            int index1 = 1;
            while((2 * index1 +1) < n)
            {
                res.add(a[2 * index1 +1]);
                index1 = (2 * index1) + 1;
            }
            
            
            
            for(int i = 0 ;i < res.size();i++)
            {
                System.out.print(res.get(i) + " ");
            }
            System.out.println();
            
        }

    }
    
}
