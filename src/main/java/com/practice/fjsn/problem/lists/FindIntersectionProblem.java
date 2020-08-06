package com.practice.fjsn.problem.lists;

public class FindIntersectionProblem {

	private static class SimpleNode {
		Integer data;
		SimpleNode next;
		
		public SimpleNode(Integer data) {
			this.data = data;
		}
		
		@Override
		public String toString() {
			return data.toString();
		}
	}	
	
	public static void main(String[] args) {
		var l1 = new SimpleNode(1);
		var l2 = new SimpleNode(20);
		
		fillList(l1, 8, 2);
		fillList(l2, 6, 21);
		
		l2.next.next.next.next.next.next.next = l1.next.next.next;
		
		printList(l2);
		printIntersection(l1, l2);
	}
	
	private static void printIntersection(SimpleNode l1, SimpleNode l2) {
		var l1Length = 0;
		var l2Length = 0;
		var aux1 = l1;
		var aux2 = l2;
		var diff = 0;
		
		while (aux1 != null) {
			l1Length++;
			aux1 = aux1.next; 
		}
		while (aux2 != null) {
			l2Length++;
			aux2 = aux2.next; 
		}
		
		diff = Math.abs(l1Length - l2Length);
		
		if (l1Length > l2Length) {
			while (diff > 0) {
				l1 = l1.next;
				diff--;
			}
		} else {
			while (diff > 0) {
				l2 = l2.next;
				diff--;
			}
		}
		
		while (!l1.equals(l2)) {
			l1 = l1.next;
			l2 = l2.next;
		}
		
		printList(l1);
		printList(l2);
	}
	
	private static void fillList(SimpleNode n, int nodesToAdd, int initialValue) {
		if (nodesToAdd <= 0 || initialValue == Integer.MAX_VALUE) {
			return;
		}
		
		if (n == null) {
			n = new SimpleNode(initialValue);
			fillList(n.next, nodesToAdd - 1, initialValue + 1);
		} else {
			n.next = new SimpleNode(initialValue);
			fillList(n.next, nodesToAdd - 1, initialValue + 1);
		}		
	}
	
	private static void printList(SimpleNode n) {
		System.out.println();
		while (n != null) {
			System.out.print(n + "-> ");
			n = n.next;
		}
	}
}
