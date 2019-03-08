package flipkart;
/*
 * 2. Time conversion - eg :
31st Jul 2017 ---> 2017-07-31
1st Jul 2017 ---> 2017-07-01
2nd Jul 2017 ---> 2017-07-02
 */
import java.util.*;

public class TimeConversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			in.nextLine();
			String s = in.nextLine();
			StringTokenizer str = new StringTokenizer(s, " ");
			HashMap<String, String> map = new HashMap<>();
			map.put("Jan", "01");
			map.put("Feb", "02");
			map.put("Mar", "03");
			map.put("Apr", "04");
			map.put("May", "05");
			map.put("Jun", "06");
			map.put("Jul", "07");
			map.put("Aug", "08");
			map.put("Sep", "09");
			map.put("Oct", "10");
			map.put("Nov", "11");
			map.put("Dec", "01");

			HashMap<String, String> map2 = new HashMap<>();
			map2.put("1st", "01");
			map2.put("17th", "17");
			map2.put("2nd", "02");
			map2.put("18th", "18");
			map2.put("3rd", "03");
			map2.put("19th", "19");
			map2.put("4th", "04");
			map2.put("20th", "20");
			map2.put("5th", "05");
			map2.put("21st", "21");
			map2.put("6th", "06");
			map2.put("22nd", "22");
			map2.put("7th", "07");
			map2.put("23rd", "23");
			map2.put("8th", "08");
			map2.put("24th", "24");
			map2.put("9th", "09");
			map2.put("25th", "25");
			map2.put("10th", "10");
			map2.put("26th", "26");
			map2.put("11th", "11");
			map2.put("27th", "27");
			map2.put("12th", "12");
			map2.put("28th", "28");
			map2.put("13th", "13");
			map2.put("29th", "29");
			map2.put("14th", "14");
			map2.put("30th", "30");
			map2.put("15th", "15");
			map2.put("31st", "31");
			map2.put("16th", "16");

			String p = str.nextToken();
			String q = str.nextToken();
			String r = str.nextToken();
			
			//System.out.println(p + " " + q + " " + r + " " );

			String ans = "";
			ans += r + "-" + map.get(q) + "-" + map2.get(p);
			
			System.out.println(ans);
		}

	}
}
