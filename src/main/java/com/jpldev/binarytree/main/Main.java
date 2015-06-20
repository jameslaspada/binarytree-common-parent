package com.jpldev.binarytree.main;

import com.jpldev.binarytree.tree.BinaryTree;
import com.jpldev.binarytree.tree.Node;

public class Main {

	public Main() {

	}

	public static void main(String[] args) {
		BinaryTree binaryTree = new BinaryTree();
		Node a = binaryTree.addValueToTree('a', null);
		Node b = binaryTree.addValueToTree('b',a);
		Node c = binaryTree.addValueToTree('c', a);
		binaryTree.addValueToTree('d', b);
		binaryTree.addValueToTree('e', b);
		Node f = binaryTree.addValueToTree('f', c);
		binaryTree.addValueToTree('g', c);
		binaryTree.addValueToTree('i', f);
		Node commonParrent = binaryTree.findCommonParrent('d', 'e');
		
		System.out.print(commonParrent.value);
	}

}
