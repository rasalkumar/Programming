package hotelReviews;
import java.util.*;
public class Solution {
	
	    
	    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
	    	 class Pair{
	    		    private int goodness;
	    		    private int index;
	    		    public Pair(int goodness, int index){
	    		        this.goodness = goodness;
	    		        this.index = index;
	    		    }
	    		    public Pair(){}
	    		    public int getGoodness(){ return goodness; }
	    		    public int getIndex(){ return index; }
	    		    public void setGoodness(int goodness){ this.goodness = goodness; }
	    		    public void setIndex(int index){ this.index = index; }
	    		}

	    	Set<String> set = new HashSet<String>();
	        
	        for(String good: A.split("_")) set.add(good);
	        
	        int n = B.size();
	        List<Pair> rank = new ArrayList<Pair>();
	        
	        for(int i=0; i<n; i++){
	            String review = B.get(i);
	            int cnt = 0;
	            for(String word: review.split("_")){
	                if(set.contains(word)) cnt += 1;
	            }
	            Pair pair = new Pair();
	            // set pair values:
	            pair.setGoodness(cnt);
	            pair.setIndex(i);
	            rank.add(pair);
	        }
	        
	        Collections.sort(rank,new Comparator<Pair>(){
	          @Override
	          public int compare(Pair lhs, Pair rhs) {
	              if(rhs.getGoodness() > lhs.getGoodness()) return 1;
	              else if(rhs.getGoodness() < lhs.getGoodness()) return -1;
	              else{
	                  if(rhs.getIndex() > lhs.getIndex()) return -1;
	                  else return 1;
	              }
	             }
	         });

	        ArrayList<Integer> ans = new ArrayList<Integer>();
	         for(Pair p: rank){
	             ans.add(p.getIndex());
	         }
	         
	         return ans;
	        
	    }
	}


