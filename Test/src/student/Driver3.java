package student;
import java.util.*;
public class Driver3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Student[] st = new Student[n];
		for(int i = 0 ;  i < n ; i++)
		{
			int marks = in.nextInt();
			String name = in.next();
			String rollNo = in.next();
			st[i] = new Student(marks,name,rollNo);
		}
		Arrays.sort(st,new Comparator<Student>()
		{
			 public int compare(Student s1, Student s2) {
		            int cmp = Integer.compare(s1.marks, s2.marks);
		            if(cmp != 0)
		            	return cmp;
		            return s1.name.compareTo(s2.name);
		        }
		});
		for(int i = 0 ;  i < n ; i++)
		{
			System.out.println(st[i].name + " " + st[i].marks);
		}

	}
	static class Student
	{
		int marks;
		String name,rollNo;
		Student(int marks, String name,String rollNo)
		{
			this.name = name;
			this.marks = marks;
			this.rollNo = rollNo;
		}
	}

}
