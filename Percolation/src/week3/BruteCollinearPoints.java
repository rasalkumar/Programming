package week3;

import java.util.ArrayList;
import java.util.Arrays;
public class BruteCollinearPoints {
	
    private LineSegment[] segments;
    
	public BruteCollinearPoints(Point[] points) {
		if(points==null)
		{
			throw new NullPointerException();
		}
		checkDuplicatedEntried(points);
		ArrayList<LineSegment> foundSegments=new ArrayList<>();
		
		Point[] pointsCopy = Arrays.copyOf(points, points.length);
		Arrays.sort(pointsCopy);
		
		for (int p = 0; p < pointsCopy.length - 3; p++) {
            for (int q = p + 1; q < pointsCopy.length - 2; q++) {
                for (int r = q + 1; r < pointsCopy.length - 1; r++) {
                    for (int s = r + 1; s < pointsCopy.length; s++) {
                        if (pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[r]) &&
                                pointsCopy[p].slopeTo(pointsCopy[q]) == pointsCopy[p].slopeTo(pointsCopy[s])) {
                            foundSegments.add(new LineSegment(pointsCopy[p], pointsCopy[s]));
                        }
                    }
                }
            }
        }

        segments = foundSegments.toArray(new LineSegment[foundSegments.size()]);
	}
	private void checkDuplicatedEntried(Point[] points) {
		for(int i=0;i<=points.length;i++)
		{
			for(int j=i+1;j<points.length;j++)
			{
				if(points[i].compareTo(points[j])==0)
				{
					throw new IllegalArgumentException("Duplicate Points are given");
				}
			}
		}
		
	}
	public int numberOfSegments()        // the number of line segments
	{
		return segments.length;
	}
	public LineSegment[] segments()                // the line segments
	{
	   return Arrays.copyOf(segments, numberOfSegments());
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
