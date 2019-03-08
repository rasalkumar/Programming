package bnyMellon;

import java.io.*;
import java.util.*;

public class FriendCircle {
    static int parent[];
    static int size[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] s = new String[n];
        for(int i = 0 ; i < n ; i++ )
        {
            s[i] = in.next();
        }
        parent = new int[1000000];
        size = new int[1000000];
        for(int i = 1 ; i <= n ; i++ )
        {
            parent[i] = i;
            size[i] = 1;
        }
        for(int i = 0 ; i < n ;i++)
        {
            for(int j = 0 ; j < n ; j++ )
            {
                if(i == j)
                    continue;
                if( s[i].charAt(j) == 'Y' )
                {
                    union(i + 1,j + 1);
                }
            }
        }
        int count = 0;
        for(int i= 0 ; i < 1000000 ;i++)
        {
            if(size[i] != 0)
            {
                count++;
            }
        }
        System.out.println(count);
    }
    public static int find(int v)
    {
        while(v != parent[v])
        {
            v = parent[parent[v]];
        }
        return v;
    }
    public static void union(int a,int b)
    {
        int root_a = find(a);
        int root_b = find(b);
        
        if(root_a == root_b)
            return;
        
        if(size[root_a] > size[root_b])
        {
            parent[root_b] = root_a ;
            size[root_a] += size[root_b];
            size[root_b] = 0;
        }
        else
        {
            parent[root_a] = root_b ;
            size[root_b] += size[root_a];
            size[root_a] = 0 ;
        }
    }
}