package com.jpldev.binarytree.tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class BinaryTreeTest {

	BinaryTree binaryTree = new BinaryTree();
	Node nodeA, nodeB, nodeC, nodeD, nodeE, nodeF, nodeG, nodeI;
	
	@Before
	public void setupBinaryTree(){
	
		nodeA = binaryTree.addValueToTree('a', null);
		nodeB = binaryTree.addValueToTree('b',nodeA);
		nodeC = binaryTree.addValueToTree('c', nodeA);
		nodeD = binaryTree.addValueToTree('d', nodeB);
		nodeE = binaryTree.addValueToTree('e', nodeB);
		nodeF = binaryTree.addValueToTree('f', nodeC);
		nodeG = binaryTree.addValueToTree('g', nodeC);
		nodeI = binaryTree.addValueToTree('i', nodeF);
	}
	
	
	@Test
	public void testAddValueToTree() {
		Node node = binaryTree.getNode();
		assertEquals(nodeA, node );
		assertEquals(nodeB, node.left );
		assertEquals(nodeC, node.right );
		assertEquals(nodeD, node.left.left );
		assertEquals(nodeE, node.left.right );
		assertEquals(nodeF, node.right.left );
		assertEquals(nodeG, node.right.right );
		assertEquals(nodeI, node.right.left.left );
	
		
	}

	@Test
	public void testFindCommonParrentBothInLeftFromRoot() {
		Node commonParrent = binaryTree.findCommonParrent('d', 'e');
		assertEquals('b', commonParrent.value);
	}
	
	@Test
	public void testFindCommonParrentBothInRightFromRoot() {
		Node commonParrent = binaryTree.findCommonParrent('f', 'g');
		assertEquals('c', commonParrent.value);
	}
	
	@Test
	public void testFindCommonParrentOneInLeftAndOneInRightFromRoot() {
		Node commonParrent = binaryTree.findCommonParrent('d', 'g');
		assertEquals('a', commonParrent.value);
	}
	
	@Test
	public void testFindCommonParrentWhenParentIsSearchedNode() {
		Node commonParrent = binaryTree.findCommonParrent('i', 'c');
		assertEquals('c', commonParrent.value);
	}

}
