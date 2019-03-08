package student;

import java.util.*;

public class Driver2 {

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
		Arrays.sort(st);
		for(int i = 0 ;  i < n ; i++)
		{
			System.out.println(st[i].name + " " + st[i].marks);
		}

	}
	static class Student implements Comparable<Student>
	{
		int marks;
		String name,rollNo;
		Student(int marks, String name,String rollNo)
		{
			this.name = name;
			this.marks = marks;
			this.rollNo = rollNo;
		}
		@Override
		public int compareTo(Student other) {
			// TODO Auto-generated method stub
			return this.marks-other.marks;
		}
	}
	

}
