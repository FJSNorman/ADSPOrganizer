package com.practice.fjsn.problem.trees;

import com.practice.fjsn.problem.common.SimpleBinaryTreeNode;
import com.practice.fjsn.problem.util.DataGenerator;

/**
 * 
 * @author FranciscoJavier
 *
 * Given a binary tree, write a function that returns true if the tree satisfies below property.
 * 
 * For every node, data value must be equal to sum of data values in left and right children. 
 * Consider data value as 0 for NULL children. Below tree is an example
 * 
 *                        10
 *                      /    \
 *                     8      2
 *                    / \    /
 *                   3   5  2
 *            
 *  Root = left + right                 
 *  10 = 8 + 2
 *  8 = 3 + 5
 *  2 = 2 + 0                 
 */
public class ChildrenSum {

	public static void main(String[] args) {
		var values = new Integer[] {10, 6, 4, 4, 2, 3, 1, 4, 0, 1, 1, 3, 0, 1};
		var root = DataGenerator.generateBinaryTree(values);
		DataGenerator.printBinaryTreeInPreOrder(root);
		
		System.out.println(isCorrect(root));
	}
	
	private static boolean isCorrect(SimpleBinaryTreeNode<Integer> root) {
		if (root.getLeft() == null && root.getRight() == null) {
			return true;
		}
		
		var left = root.getLeft();
		var right = root.getRight();
		var sum = (left == null ? 0 : left.getValue()) + (right == null ? 0 : right.getValue());
		
		if (sum == root.getValue()) {
			if (left == null) {
				return isCorrect(right);
			} else if (right == null) {
				return isCorrect(left);
			} else {
				return isCorrect(left) && isCorrect(right);
			}			
		}
		
		return false;
	}

}
