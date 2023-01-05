package collection;

import java.util.ArrayList;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Item> i = new ArrayList<>();
		i.add(new Item(1,"asd"));
		i.add(new Item(2,"asdf"));
		i.add(new Item(3,"asdfg"));
		
		for(Item it: i) {
			System.out.println(it);
		}
		
	}

}

class Item {
	String s;
	int n;
	
	public Item(int n, String s) {
		super();
		this.n = n;
		this.s = s;
	}
	@Override
	public String toString() {
		return "Item [n=" + n + ", s=" + s + "]";
	}

}
