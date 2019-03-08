package checkMirrorInNArray;
import java.util.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int t = scan.nextInt();
		
		AB:
		while(t > 0) {
		    int n = scan.nextInt();
		    int e = scan.nextInt();
		    
		    int[] pat = new int[2*e];
		    int[] mat = new int[2*e];
		    
		    for (int i=0; i<2*e; i++) pat[i] = scan.nextInt();
		    for (int i=0; i<2*e; i++) mat[i] = scan.nextInt();
		    
		    HashMap<Integer, Deque<Integer>> stackHash = new HashMap<>();
		    HashMap<Integer, Deque<Integer>> queueHash = new HashMap<>();
		    
		    for (int i=0; i<e; i++) {
		        if (!stackHash.containsKey(pat[2*i])) {
		            stackHash.put(pat[2*i], new LinkedList<>());
		        }
		        stackHash.get(pat[2*i]).push(pat[2*i + 1]);
		        
		        if (!queueHash.containsKey(mat[2*i])) {
		            queueHash.put(mat[2*i], new LinkedList<>());
		        }
		        queueHash.get(mat[2*i]).add(mat[2*i +1]);
		    }
		    int lastNode = Integer.MIN_VALUE;
		    for (int i=0; i<e; i++) {
		        int node = pat[2*i];
		        
	            lastNode = node;
	            while(!stackHash.get(node).isEmpty()) {
	                if (stackHash.get(node).pop() != queueHash.get(node).poll()) {
	                    System.out.println("0");
    	                t--;
    	                continue AB;
	                }
	            }
	            if (!queueHash.get(node).isEmpty()) {
	                System.out.println("0");
	                t--;
	                continue AB;
	            }
		    }
		    System.out.println("1");
		    t--;
		}
	}
}