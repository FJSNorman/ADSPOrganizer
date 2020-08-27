package com.practice.fjsn.problem.arrays;

/**
 * 
 * @author FranciscoJavier
 *
 * Given an array, perform a number of left/right rotations and print the value of the element at a given index.
 * For example, array a = [3, 4, 5, 2, 1, 7], number of rotations, k = 2 and indices to check, m = [1, 2].
 * 
 * First we perform the two rotations:
 * 	Left:
 * 	[3, 4, 5, 2, 1, 7] -> [4, 5, 2, 1, 7, 3] -> [5, 2, 1, 7, 3, 4]
 * 
 * 	Right:
 * 	[3, 4, 5, 2, 1, 7] -> [7, 3, 4, 5, 2, 1] -> [1, 7, 3, 4, 5, 2]
 * 
 * Now return the values from the zero-based indices 1 and 2 as indicated in the m array.
 * al[1] = 2
 * al[2] = 1
 * 
 * ar[1] = 7
 * ar[2] = 3
 * 
 * Output Format
 * For each query, print the value of the element at index m of the rotated array on a new line.
 */
public class Rotations {

	public static void main(String[] args) {
		var a = new int[] {3, 4, 5, 2, 1, 7};
		var k = 4;
		var q = new int[] {0, 1, 2};

		doLeftRotation(a, k, q);
		doRightRotation(a, k, q);
	}
	
	private static void doLeftRotation(int[] a, int k, int[] q) {
		System.out.println("Left rotation:");
		
		var n = a.length;
		k %= n;
		
		for (var i = 0; i < q.length; i++) {
			System.out.println(a[(n + q[i] + k) % n]);			
		}
	}
	
	private static void doRightRotation(int[] a, int k, int[] q) {
		System.out.println("\nRight rotation:");
		
		var n = a.length;
		k %= n;
		
		for (var i = 0; i < q.length; i++) {
			System.out.println(a[(n + q[i] - k) % n]);
		}
	}

}