// BinarySearchTree.java - Defines the Node class and a constructor for it.
// Created on 02/18/2025 by Evan Redden for Computer Science 201: Data Structures and Algorithms.

public class Node {
    public int searchKey;
    public Node left;
    public Node right;

    public Node(int searchKey) {
        this.searchKey = searchKey;
        this.left = null;
        this.right = null;
    }
}