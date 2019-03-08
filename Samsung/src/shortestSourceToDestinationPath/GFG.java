package shortestSourceToDestinationPath;


import java.util.*;

class GFG
{
	public static void main(String[] args) {
		Scanner s  = new Scanner(System.in);
		int numOfTest = s.nextInt();
		int[][] matrix = null;

		for(int i=0; i<numOfTest; i++) {

			int row = s.nextInt();
			int col = s.nextInt();

			matrix = new int[row][col];
			for(int x = 0; x< row; x++) {
				for(int y = 0; y< col; y++) {
					matrix[x][y] = s.nextInt();
				}
			}
			Pos src = new Pos(0,0);
			Pos dest = new Pos(s.nextInt(),s.nextInt());
			System.out.println(shortestPathLength(matrix, row, col, src, dest));
		}
		s.close();
	}

	private static int shortestPathLength(int[][] matrix, int rowN, int colN, Pos src, Pos dest) {
		
		if(matrix[0][0]==0) {
			return -1;
		}
		
		if(dest.x==0 && dest.y==0 && matrix[0][0]==1) {
			return 0;
		}
		
		int count = 0;
		boolean found = false;
		int[] xArr = {0,-1,1,0};
		int[] yArr = {-1,0,0,1};
		boolean[][] visited = new boolean[rowN][colN];

		Queue<Pos> q = new LinkedList<>();
		q.add(src);
		Pos dummyPos = new Pos(-1,-1);
		q.add(dummyPos);

		while(q.size() != 1){

			Pos pCurr = q.poll();
			if(pCurr.x>=0 && pCurr.y>=0 && pCurr.x<rowN && pCurr.y<colN){
				visited[pCurr.x][pCurr.y]=true;	
			}

			if(pCurr.x==dest.x && pCurr.y==dest.y){
				found =true;
				return count;
			}

			if(pCurr.x==-1 && pCurr.y==-1){
				count++;
				q.add(dummyPos);
			}
			else{
				for(int j=0; j<xArr.length; j++){
					if(pCurr.x+xArr[j]>=0 && pCurr.y+yArr[j]>=0 && 
							pCurr.x+xArr[j]<rowN && pCurr.y+yArr[j]<colN &&
							matrix[pCurr.x+xArr[j]][pCurr.y+yArr[j]] != 0 &&
							!visited[pCurr.x+xArr[j]][pCurr.y+yArr[j]]){
						q.add(new Pos(pCurr.x+xArr[j],pCurr.y+yArr[j]));
					}
				}
			}
		}
		if(found)
			return count;
		else
			return -1;
	}
}

 class Pos {
	int x,y;

	public Pos(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

}
 
  class DistanceInfo {
		
		int distance = -1;
		int lastVertex = -1;
		
		public DistanceInfo() {
			super();
		}
		
		public DistanceInfo(int distance, int lastVertex) {
			super();
			this.distance = distance;
			this.lastVertex = lastVertex;
		}
		
		public int getDistance() {
			return distance;
		}
		public void setDistance(int distance) {
			this.distance = distance;
		}
		public int getLastVertex() {
			return lastVertex;
		}
		public void setLastVertex(int lastVertex) {
			this.lastVertex = lastVertex;
		}

		@Override
		public String toString() {
			return "DistanceInfo [distance=" + distance + ", lastVertex=" + lastVertex + "]";
		}
		
		

	}
