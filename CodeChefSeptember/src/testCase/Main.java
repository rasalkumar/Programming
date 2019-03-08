package testCase;
import java.util.*;
public class Main {

public static void main(String a[]){
		
		HashMap<Price, String> hm = new HashMap<Price, String>();
		hm.put(new Price("Banana", 20), "Banana");
		hm.put(new Price("Apple", 40), "Apple");
		hm.put(new Price("Orange", 30), "Orange");
		printMap(hm);
		Price key = new Price("Banana", 20);
		System.out.println("------Does key available? "+hm.get(key));
	}
	
	public static void printMap(HashMap<Price, String> map){
		
		Set<Price> keys = map.keySet();
		for(Price p:keys){
			System.out.println(p+"==>"+map.get(p));
		}
	}
}

class Price{
	
	private String item;
	private int price;
	
	public Price(String itm, int pr){
		this.item = itm;
		this.price = pr;
	}
	
	public int hashCode(){
		System.out.println("In hashcode");
		int hashcode = 0;
		hashcode = price*20;
		hashcode += item.hashCode();
		return hashcode;
	}
	
	public boolean equals(Object obj){
		System.out.println("In equals");
		if (obj instanceof Price) {
			Price pp = (Price) obj;
			return (pp.item.equals(this.item) && pp.price == this.price);
		} else {
			return false;
		}
	}
	
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String toString(){
		return "item: "+item+"  price: "+price;
	}
}