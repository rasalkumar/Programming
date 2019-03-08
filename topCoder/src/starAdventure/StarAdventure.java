package starAdventure;

import java.util.*; 
public class StarAdventure { 
  public int mostStars(String[] level) { 
    int n = level.length; 
    int m = level[0].length(); 
    int[][][] v = new int[level.length][level.length][level.length]; 
    for(int i = 1; i<=m+n-2; i++) { 
      int[][][] x = new int[level.length][level.length][level.length]; 
      int min = Math.max(0, i-(m-1)); 
      int max = Math.min(n-1, i); 
      for(int a = min; a<=max; a++) { 
        int sa = level[a].charAt(i-a)-'0'; 
        for(int b = min; b<=max; b++) { 
          int sb = sa; 
          if(b!=a) { 
            sb+=level[b].charAt(i-b)-'0'; 
          } 
          for(int c = min; c<=max; c++) { 
            int sc = sb; 
            if(c!=a && c!=b) { 
              sc+=level[c].charAt(i-c)-'0'; 
            } 
            int best = -1;  
            if(a>0) { 
              if(b>0) { 
                if(c>0) { 
                  if(v[a-1][b-1][c-1]>best) { 
                    best = v[a-1][b-1][c-1]; 
                  } 
                } 
                if(v[a-1][b-1][c]>best) { 
                  best = v[a-1][b-1][c]; 
                } 
              } 
              if(c>0) { 
                if(v[a-1][b][c-1]>best) { 
                  best = v[a-1][b][c-1]; 
                } 
              } 
              if(v[a-1][b][c]>best) { 
                best = v[a-1][b][c]; 
              } 
            } 
            if(b>0) { 
              if(c>0) { 
                if(v[a][b-1][c-1]>best) { 
                  best = v[a][b-1][c-1]; 
                } 
              } 
              if(v[a][b-1][c]>best) { 
                best = v[a][b-1][c]; 
              } 
            } 
            if(c>0) { 
              if(v[a][b][c-1]>best) { 
                best = v[a][b][c-1]; 
              } 
            } 
            if(v[a][b][c]>best) { 
              best = v[a][b][c]; 
            } 
            x[a][b][c] = best+sc; 
          } 
        } 
      } 
      v = x; 
    } 
    return v[n-1][n-1][n-1]; 
  } 
  
} 
