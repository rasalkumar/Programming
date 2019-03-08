package week3;

public class LineSegment {
	private final Point p;
	private final Point q;

	public LineSegment(Point p,Point q) {
		// TODO Auto-generated constructor stub
		this.p=p;
		this.q=q;
	}
	public void draw()
	{
		p.drawTo(q);
	}
	public String toString()
	{
		return p + "->" + q;
		
	}
	public int hashCode() {
        throw new UnsupportedOperationException();
    }

}
