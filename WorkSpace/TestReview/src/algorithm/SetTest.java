package algorithm;

import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest {

	public static void main(String[] args) {
		SortedSet<String> sorter = new TreeSet<String>();
		sorter.add("Dien");
		sorter.add("An");
		sorter.add("Do");
		System.out.println("Sort order: ");
		for (String s : sorter) {
			System.out.println(s);
		}
	}	

}
