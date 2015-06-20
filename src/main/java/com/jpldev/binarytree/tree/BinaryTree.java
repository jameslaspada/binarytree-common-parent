package com.jpldev.binarytree.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BinaryTree {
	Node node;
	Node parent;
	Set<Node> visitedNodes = new HashSet<>();
	List<Node> foundValuePaths = new ArrayList<>();

	public BinaryTree() {

	}

	public Node addValueToTree(char value, Node parent) {
		Node newNode = new Node(value);
		newNode.parent = parent;
		if (this.node == null) {
			this.node = newNode;

		} else {
			insert(this.node, newNode, parent);
		}
		return newNode;
	}

	private void insert(Node lastNode, Node newNode, Node parrent) {

		if (parrent.left == null) {
			parrent.left = newNode;
		} else {
			parrent.right = newNode;
		}
	}

	public Node findCommonParrent(char a, char b) {
		List<Node> foundNodes = traverseTreeForCommonParent(node, a, b);
		Node returnCommonNode = null;
		if (foundNodes.size() < 2) {
			return null;
		}

		Node nodeA = foundNodes.get(0);
		Node nodeB = foundNodes.get(1);

		while (nodeA.parent != null) {
			while (nodeB.parent != null) {
				if (nodeA.equals(nodeB)) {
					returnCommonNode = nodeA;
				}
				nodeB = nodeB.parent;
			}
			nodeB = foundNodes.get(1);
			nodeA = nodeA.parent;
		}
		return returnCommonNode == null ? node : returnCommonNode;
	}

	private List<Node> traverseTreeForCommonParent(Node node, char a, char b) {
		visitedNodes.add(node);
		if (node.value == a && !foundValuePaths.contains(node)
				|| node.value == b && !foundValuePaths.contains(node)) {
			foundValuePaths.add(node);
		}

		if (foundValuePaths.size() < 2) {
			if (node.left != null && !visitedNodes.contains(node.left)) {

				traverseTreeForCommonParent(node.left, a, b);
			} else if (node.right != null && !visitedNodes.contains(node.right)) {

				traverseTreeForCommonParent(node.right, a, b);
			} else {
				if (node.parent != null) {
					traverseTreeForCommonParent(node.parent, a, b);
				}
			}
		} else {
			return foundValuePaths;
		}

		return foundValuePaths;
	}

	public Node getNode() {
		return node;
	}
}
