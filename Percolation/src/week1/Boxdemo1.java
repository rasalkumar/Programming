package week1;
class Box{
	double width;
	double height;
	double depth;
	double volume(){
		return width*height*depth;
	}
	
}
public class Boxdemo1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Box Mybox1= new Box();
		Box Mybox2= new Box();
		Mybox1.width=10;
		Mybox1.height=20;
		Mybox1.depth=15;
		Mybox2.width=3;
		Mybox2.height=6;
		Mybox2.depth=9;
		
		double vol1,vol2;
		vol1=Mybox1.volume();
		vol2=Mybox2.volume();
		System.out.println("Volume 1 = "+vol1);
		System.out.println("Volume 2 = "+vol2);
	}
}
