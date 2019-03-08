package circlecity;

//import java.util.*;
//import java.util.regex.*;
//import java.text.*;
//import java.math.*;
 
 
public class CircleCity
{
  public int findMin(int[] dist, int k)
  {
  //  int n = dist.length;
    long l = -1;
    long r = (long) 1e10;
    while (r > l + 1) {
      long m = (l + r) / 2;
      if (check(dist, m, k)) {
        r = m;
      } else {
        l = m;
      }
    }
    return (int) r;
  }
 
  private boolean check(int[] dist, long m, int k) {
    int n = dist.length;
    int[] nx = new int[n];
    int[] jp = new int[n];
    int j = 0;
    long s = 0;
    int ss = 0;
    for (int i = 0; i < n; i++) {
      while (s <= m && ss < n) {
        s += dist[j];
        j++;
        ss++;
        if (j == n) j = 0;
      }
      nx[i] = j;
      jp[i] = ss;
      s -= dist[i];
      ss--;
    }
//    System.out.println(m + " " + Arrays.toString(nx) + " " + Arrays.toString(jp));
    boolean[] z = new boolean[n];
    for (int l = 0; l < n; l++) {
      if (z[l]) continue;
      s = 0;
      int r = l;
      for (int i = 0; i < k; i++) {
        s += jp[r];
        r = nx[r];
      }
      if (s >= n) return true;
    }
    return false;
  }
 
 
}
