package week3;

import java.util.Comparator;

import edu.princeton.cs.algs4.StdDraw;

public class Point implements Comparable<Point> {
	
	private final int x;
	private final int y;

	public Point(int x, int y) // constructs the point (x, y)
	{
		this.x = x;
		this.y = y;
	}

	public void draw() // draws this point
	{
		StdDraw.point(x, y);
	}

	public void drawTo(Point that) // draws the line segment from this point to
									// that point
	{
		StdDraw.line(this.x, this.y, that.x, that.y);
	}

	public String toString() // string representation
	{
		return "(" + x + "," + y + ")";
	}

	public int compareTo(Point that) // compare two points by y-coordinates,
										// breaking ties by x-coordinates
	{
		if (y == that.y && x == that.x) {
			return 0;
		}
		if ((y < that.y) || (y == that.y) && (x < that.x)) {
			return -1;
		}
		return 1;

	}

	public double slopeTo(Point that) // the slope between this point and that
										// point
	{
		if (that == null) {
			throw new NullPointerException();
		}
		if (x == that.x) {
			if (y == that.y) {
				return Double.NEGATIVE_INFINITY;
			}
			return Double.POSITIVE_INFINITY;
		}
		if (y == that.y) {
			return 0.0;
		}
		return (double) (this.y - that.y) / (this.x - that.x);

	}

	public Comparator<Point> slopeOrder() {
        return new jComparator();
    }

    private class jComparator implements Comparator<Point> {

        @Override
        public int compare(Point arg0, Point arg1) {
            double jSlope0 = slopeTo(arg0);
            double jSlope1 = slopeTo(arg1);

            return Double.compare(jSlope0, jSlope1);
        }
    }

}
