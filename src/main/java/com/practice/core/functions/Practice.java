package com.practice.core.functions;

import java.util.ArrayList;
import java.util.List;

public class Practice {

	public static void main(String[] args) {
		Practice pc = new Practice();
//		pc.fibonacciSeries(10);
//		pc.isPalindrome("level");
//		pc.swapMethod();
//		pc.pyramidTriangle();
//		pc.invertedTriangle();
//		pc.printLargestOfAnArray();
//		pc.printMinOfMatrix();
//		pc.printMaxOfMatrix();
//		pc.printMaxValFromMinValCol();
//		pc.sortAnArray();
//		System.out.println(100 + 100);

//		List<String> commands = new ArrayList<String>();
//		commands.add("open firefox");
//		commands.add("open terminal");
//		commands.add("open curl");
//		commands.add("close 4");
//		commands.add("open ps");
//
//		pc.getOpenApplications(commands);

//		pc.oddNumbers(2, 5);
//		pc.printNumbers();
		pc.sortAnArray1();
	}

	public void fibonacciSeries(int length) {
		int a1 = 0;
		int a2 = 1;
		int a3;
		System.out.print(a1 + " " + a2);
		for (int i = 2; i < length; i++) {
			a3 = a1 + a2;
			a1 = a2;
			a2 = a3;
			System.out.print(" " + a3);
		}
	}

	public void isPalindrome(String text) {
		String temp = "";
		for (int i = text.length() - 1; i >= 0; i--) {
			temp = temp + text.charAt(i);
		}
		if (temp.equals(text)) {
			System.out.println("");
			System.out.println(true);
		}
	}

	public void swapMethod() {
		String a = "Mani";
		String b = "Sunil";
		String temp = "";

		temp = a;
		a = b;
		b = temp;

		System.out.println("a=" + a + " b=" + b);
	}

	public void pyramidTriangle() {
		int k = 1;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 4 - i; j++) {
				System.out.print(k + " ");
				k++;
			}
			System.out.println("");
		}
	}

	public void invertedTriangle() {
		int k = 1;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(k + " ");
				k++;
			}
			System.out.println("");
		}

	}

	public void printLargestOfAnArray() {
		int a[] = new int[10];
		int b[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int largest = b[0];
		for (int i = 0; i < b.length; i++) {
			if (b[i] > largest) {
				largest = b[i];
			}

		}
		System.out.println(largest);

	}

	public void printMinOfMatrix() {
		int a[][] = { { 1, 2, 3 }, { 3, 4, 5 }, { 5, 6, 7 } };
		int min = a[0][0];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] < min) {
					min = a[i][j];
				}
			}
		}
		System.out.println(min);
	}

	public void printMaxOfMatrix() {
		int a[][] = { { 1, 2, 3 }, { 3, 4, 5 }, { 5, 6, 7 } };
		int max = a[0][0];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] > max) {
					max = a[i][j];
				}
			}
		}
		System.out.println(max);
	}

	public void printMaxValFromMinValCol() {
		int a[][] = { { 1, 0, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
		int minValCol = 0;
		int maxVal = 0;
		int minVal = a[0][0];

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (a[i][j] < minVal) {
					minVal = a[i][j];
					minValCol = j;
				}
			}
		}
		for (int k = 0; k < 3; k++) {
			if (a[k][minValCol] > a[0][minValCol]) {
				maxVal = a[k][minValCol];
			}
		}
		System.out.println(maxVal);
	}

	public void sortAnArray() {
		int a[] = { 6, 2, 3, 5, 1, 0, 9 };
		int temp = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}

		}
		for (int k = 0; k < a.length; k++) {
			System.out.println(a[k]);
		}
	}

	public List<String> getOpenApplications(List<String> commands) {
		List<String> openApplications = new ArrayList<String>();
		for (int i = 0; i < commands.size(); i++) {
			if (commands.get(i).contains("open")) {
				String[] text = commands.get(i).split(" ");
				String textToAdd = text[1];
				openApplications.add(textToAdd);
			} else if (commands.get(i).contains("close")) {

				String[] count = commands.get(i).split(" ");
				int countToRemove = Integer.parseInt(count[1]);
				int countAfterRemove = openApplications.size() - countToRemove;
				if (countAfterRemove == 0 | countAfterRemove < 0) {
					openApplications.removeAll(openApplications);
				} else {
					for (int k = openApplications.size() - 1; k >= countAfterRemove; k--) {
						openApplications.remove(k);
					}
				}
			}
		}
		System.out.println(openApplications);
		return openApplications;

	}

	public List<Integer> oddNumbers(int l, int r) {
		List<Integer> oddNumbers = new ArrayList<Integer>();
		for (int i = l; i <= r; i++) {
			if (i % 2 != 0) {
				oddNumbers.add(i);
			}
		}
		return oddNumbers;

	}

	public void printNumbers() {
		int a = 0;
		int b = 2;
		int n = 10;
		for (int j = 0; j < n; j++) {
			int k = j;
			int result = 1;
			while (k != 0) {
				result = result *= 2;
				k--;
			}
			int output = Integer.sum(a, (result*b));
			a = output;
			System.out.print(output + " ");

		}

	}
	
	public void sortAnArray1() {
		int a[] = {5,4,3,2,1};
		int temp = 0;
		for(int i=0; i<a.length; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
					temp = a[j];
					a[j] = a[i];
					a[i] = temp;
				}
			}
		}
		for(int k=0; k<a.length; k++) {
			System.out.println(a[k]);
		}
		
	}
}
