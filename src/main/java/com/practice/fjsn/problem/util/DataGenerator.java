package com.practice.fjsn.problem.util;

import java.util.LinkedList;

import com.practice.fjsn.problem.common.SimpleBinaryTreeNode;

public class DataGenerator {
	
	public static void main(String[] args) {
		Integer[] values = new Integer[] {12, 6, 67, 3, 9, 21, 89};
		SimpleBinaryTreeNode<Integer> root = generateBinaryTree(values);
		printBinaryTreeInPreOrder(root);
	}

	public static <T> SimpleBinaryTreeNode<T> generateBinaryTree(T[] values) {
		SimpleBinaryTreeNode<T> root = null;
		
		for (int i = 0; i < values.length; i++) {
			root = addToBinaryTree(root, values[i]);
		}
		
		return root;
	}
	
	public static <T> void printBinaryTreeInPreOrder(SimpleBinaryTreeNode<T> root) {
		if (root == null) {
			return;
		}
		
		System.out.print(root.getValue() + " -> ");
		printBinaryTreeInPreOrder(root.getLeft());
		printBinaryTreeInPreOrder(root.getRight());
	}
	
	private static <T> SimpleBinaryTreeNode<T> addToBinaryTree(SimpleBinaryTreeNode<T> root, T value) {
		var node = new SimpleBinaryTreeNode<>(value);
		if (root == null) {
			return node;
		}
		
		SimpleBinaryTreeNode<T> aux = null;
		var queue = new LinkedList<SimpleBinaryTreeNode<T>>();
		queue.offer(root);
		
		while (queue.peek() != null) {
			aux = queue.poll();
			
			if (aux.getLeft() == null) {
				aux.setLeft(node);
				break;
			} else if (aux.getRight() == null) {
				aux.setRight(node);
				break;
			} else {
				queue.offer(aux.getLeft());
				queue.offer(aux.getRight());
			}
		}
		
		return root;
	}
}
