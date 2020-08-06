package com.practice.fjsn.problem.arrays;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class AddElementsOfTwoArraysProblem {

	public static void main(String[] args) {
		var a1 = new int[] {1, 2, 3, 4, 5, 6};
		var a2 = new int[] {9, 8, 7, 6, 5, 4, 3, 21};
		
		addArrays(a1, a2);
		printArray(addArrays(a1, a2));
	}
	
	private static Object[] addArrays(int[] a1, int[] a2) {
		var q = new LinkedList<Integer>();
		var max = Math.max(a1.length, a2.length);
		
		for (int i = 0; i < max; i++) {
			var sum = 0;
			if (a1.length > i) {
				if (a2.length > i) {
					sum = a1[i] + a2[i];
				} else {
					sum = a1[i];
				}
			} else {
				sum = a2[i];
			}
			
			addNumberToQueue(sum, q);
		}
		
		return q.toArray();
	}	
	
	private static void addNumberToQueue(int n, Queue<Integer> q) {		
		var s = new LinkedList<Integer>();
		while (n != 0) {
			s.push(n % 10);
			n /= 10;
		}
		
		while (!s.isEmpty()) {
			q.offer(s.pop());
		}
	}
	
	private static void printArray(Object[] a) {
		System.out.println(Arrays.toString(a));
	}
}
