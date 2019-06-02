package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		ArrayList<String> strings = new ArrayList<String>();
		//   Don't forget to import the ArrayList class

		//2. Add five Strings to your list
		strings.add("The First");
		strings.add("Farmer Fred");
		strings.add("Super Slug");
		strings.add("Business Bee");
		strings.add("Political Panda");
		//3. Print all the Strings using a standard for-loop
		for(int j = 0; j < strings.size(); j++) {
			System.out.println(strings.get(j));
		}
		
		//4. Print all the Strings using a for-each loop
		for(String s : strings) {
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		for(int j = 0; j < strings.size(); j = j+2) {
			System.out.println(strings.get(j));
		}
		//6. Print all the Strings in reverse order.
		for(int j = strings.size()-1; j >= 0; j--) {
			System.out.println(strings.get(j));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for(int j = 0; j < strings.size(); j++) {
			if(strings.get(j).contains("e")) {
				System.out.println(strings.get(j));
			}
		}
	}
}
