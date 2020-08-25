package com.practice.fjsn.problem.common;

public class SimpleBinaryTreeNode<T> {
	private T value;
	private SimpleBinaryTreeNode<T> left;
	private SimpleBinaryTreeNode<T> right;
	
	public SimpleBinaryTreeNode(T value) {
		this.value = value;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public SimpleBinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(SimpleBinaryTreeNode<T> left) {
		this.left = left;
	}
	public SimpleBinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(SimpleBinaryTreeNode<T> right) {
		this.right = right;
	}	
}
