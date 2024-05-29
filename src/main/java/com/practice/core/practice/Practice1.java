package com.practice.core.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Practice1 {

	public static void main(String[] args) {
		Practice1 fn = new Practice1();
		fn.printCountOfTheNumbers();
	}

	// Hashmap is non Synchronized and Not Thread Safe
	// Hashmap Stores the data by Key Value Pair
	// Hashmap accepts null Keys and Null values
	// Hashmap object values can be iterated with iterator
	public void hashMapExample() {
		HashMap<String, String> a = new HashMap<String, String>();
		a.put("Dad", "Sunil");
		a.put("Mom", "Mani");
		a.put("Daughter", "Vinni");

		Set b = a.entrySet();
		Iterator it = b.iterator();

		while (it.hasNext()) {

			Map.Entry c = (Map.Entry) it.next();
			System.out.println(c.getKey());
			System.out.println(c.getValue());
		}

	}

	public void arrayListExample() {
		ArrayList<String> a = new ArrayList<String>();
		a.add("Sunil");
		a.add("Mani");
		a.add("Vinni");
		a.add("vinni");

		a.remove("vinni");
		a.removeAll(a);
		System.out.println(a);
	}

	public void hashSetExample() {
		HashSet<String> b = new HashSet<String>();

		b.add("Sunil");
		b.add("Mani");
		b.add("Vinni");

		Iterator<String> it = b.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}

	}

	public void printCountOfTheNumbers() {
		int a[] = { 4, 5, 3, 4, 7, 3, 9, 2, 2};
		int k = 0;
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			if (!al.contains(a[i])) {
				al.add(a[i]);
				k = 1;

				for (int j = i + 1; j < a.length; j++) {
					if (a[i] == a[j]) {
						k++;
					}
				}
				
				System.out.println(a[i] + " count is " + k);
				
//				if (k == 1) {
//					System.out.println(a[i]);
//				}
			}
		}
	}
	
	
	public int printLargestOccurrence() {
		int a[] = {1,1,6,6,1,1,6,6};
		int length = a.length;
		int nX =0;
		int nY =0;
		int result =-1;
		for(int i=0; i<length; i++) {
			if(a[i]==1) {
				nX++;
			}
			else if(a[i] ==6) {
				nY++;
			}
			if(nX==nY) {
				result =i;
			}
		}
		System.out.println(result);
		return result;
		
	}
	
	public Map<Character, Integer> countOfOccurrences(String s){
		Map<Character, Integer> listOfOccurrences = new HashMap<Character, Integer>();
		for(Character c: s.toCharArray()) {
			listOfOccurrences.put(c, listOfOccurrences.getOrDefault(c, 0)+1);
		}
		
		return listOfOccurrences;	
	}
	
	public void countOfOcc() {
		Practice1 fn = new Practice1();
		Map<Character, Integer> count = fn.countOfOccurrences("mani");
		for(Map.Entry<Character, Integer> entry:count.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
	}
	


}
