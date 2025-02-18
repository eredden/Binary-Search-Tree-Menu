// BinarySearchTree.java - Defines a binary search tree and methods for interacting with it.
// Created on 02/18/2025 by Evan Redden for Computer Science 201: Data Structures and Algorithms.

public class BinarySearchTree {
    public Node root;

    // Empty constructor for the BinarySearchTree class.
    public BinarySearchTree() {
        this.root = null;
    }

    // Defines the Node class and a constructor for it.
    class Node {
        int searchKey;
        Node left;
        Node right;
  
        public Node(int searchKey) {
            this.searchKey = searchKey;
            this.left = null;
            this.right = null;
        }
    }
    
    // Inserts a node into a binary search tree given the root node and a search key.
    public Node insertNode(Node root, int searchKey) {
        // Insert the node into an empty branch.
        if (root == null) {
            return new Node(searchKey);
        } 

        // Recursively go down the branches until you reach the exit case above.
        else if (root.searchKey < searchKey) {
            root.right = insertNode(root.right, searchKey);
        }

        else if (root.searchKey > searchKey) {
            root.left = insertNode(root.left, searchKey);
        }

        // If the root search key is equivalent to the search key, return the root.
        return root;
    }

    // Gets the successor of a soon-to-be deleted node if it has children.
    private Node getSuccessorNode(Node root) {
        root = root.right;

        while (root != null && root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Deletes a node from a binary search tree given the root node.
    public Node deleteNode(Node root, int searchKey) {
        if (root != null) {
            if (root.searchKey > searchKey) {
                root.left = deleteNode(root.left, searchKey);
            }

            else if (root.searchKey > searchKey) {
                root.right = deleteNode(root.right, searchKey);
            }

            // This is when the desired search key is actually found.
            else {
                if (root.left == null) {
                    return root.right;
                }

                if (root.right == null) {
                    return root.left;
                }

                // If the node has two children, supplant it with the successor.
                Node successor = getSuccessorNode(root);
                root.searchKey = successor.searchKey;
                root.right = deleteNode(root.right, successor.searchKey);
            }
        }

        return root;
    }

    // Prints an in-order binary search tree.
    public void printTreeInOrder(Node root) {
        if (root != null) {
          printTreeInOrder(root.left);
          System.out.print(root.searchKey + " ");
          printTreeInOrder(root.right);
        }      
        
    }

    // Prints a pre-order binary search tree.
    public void printTreePreOrder(Node root) {
        if (root != null) {
            System.out.print(root.searchKey + " ");
            printTreePreOrder(root.left);
            printTreePreOrder(root.right);
        }
    }

    // Prints a post-order binary search tree.
    public void printTreePostOrder(Node root) {
        if (root != null) {
            printTreePostOrder(root.left);
            printTreePostOrder(root.right);
            System.out.print(root.searchKey + " ");
        }
    }
}