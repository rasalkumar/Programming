package nQueens;

import java.util.*;
public class Solution{
    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
        if(a < 1)
            return result;
        int[] queens = new int[a];
        enumerate(queens, 0, result);
        return result;
    }
    public void enumerate(int[] queens, int n, ArrayList<ArrayList<String>> result){
        int N = queens.length;
        
        if(n == N)
            addQueensToResult(queens, result);
        else{
            for(int i = 0; i < N; i++){
           //     System.out.println("****************For row = " + i + " place queens["+n+"] = " + i +"***********");
                queens[n] = i;
                if(isConsistent(queens, n))
                    enumerate(queens, n+1, result);
            }
        }
    }
    public  boolean isConsistent(int[] queens, int n){
        for(int i =0; i < n; i++){
           // System.out.printf("queens[%d] = %d and queens[%d] = %d \n", i, n, queens[i], queens[n]);
            if(queens[i] == queens[n]){ // same column
             //   System.out.println("\t Same Column");
                return false;
            }
            if((queens[i] - queens[n]) == (n - i)) {// same major diagonal
              //  System.out.println("\t Same major diagonal");
                return false;
            }
            if((queens[n] - queens[i]) == (n - i)) {//same minor diagonal
              //  System.out.println("\t Same minor diagonal");
                return false;
            }
        }
      //  System.out.println("\t Is consistent so enumerate " + (n+1));
        return true;
    }
    public void addQueensToResult(int[] queens, ArrayList<ArrayList<String>> result){
        int N = queens.length;
        ArrayList<String> temp = new ArrayList<String>();
        for(int i =0; i < N; i++){
            String row = "";
            for(int j = 0; j < N; j++){
                if(queens[i] == j)
                    row += "Q";
                else
                    row += ".";
            }
            temp.add(row);
        }
        result.add(temp);
    }
    public static void main(String[] args){
        int a = 4;
        Solution obj = new Solution(); 
        ArrayList<ArrayList<String>> result = obj.solveNQueens(a);
        for(ArrayList<String> list : result)
            System.out.println(list);
    }
}