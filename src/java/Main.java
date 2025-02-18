// Main.java - Entry-point for the program. Used as a menu for interacting with a binary search tree.
// Created on 02/18/2025 by Evan Redden for Computer Science 201: Data Structures and Algorithms.

import java.util.Scanner; // Required for taking in user input.

public class Main {
    // Continously prompt the user to select an option until the user provides a valid integer.
    public static int promptForOptionSelection() {
        System.out.println("\nBINARY SEARCH TREE INTERFACE:");
        System.out.println("1. Create a binary search tree.");
        System.out.println("2. Add a node.");
        System.out.println("3. Delete a node.");
        System.out.println("4. Print nodes in-order.");
        System.out.println("5. Print nodes pre-order.");
        System.out.println("6. Print nodes post-order.");
        System.out.println("7. Exit the program.\n");

        Scanner listener = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Select a search key: ");

                int selection = Integer.parseInt(
                  listener.nextLine()
                );

                if (selection > 0 && selection < 8) {
                  listener.close();
                  return selection;
                }
            }

            catch (NumberFormatException err) {
                // Do nothing if a int cast error is encountered.
                // This is done so that the user does not see the error.
                ;
            }

            System.out.println("Invalid input. Select an integer value between 1 and 7.\n");
        }
    }

    // Continously prompt for a search key (integer) until the user provides a valid integer.
    public static int promptForSearchKey() {
        Scanner listener = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Select a search key: ");

                int selection = Integer.parseInt(
                    listener.nextLine()
                );

                listener.close();
                return selection;
            }

            catch (NumberFormatException err) {
                System.out.println("Invalid input. Please provide an integer value.\n");
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        while (true) {
            switch (promptForOptionSelection()) {
                // Create a tree with a root node that has a search key of 4.
                case 1:
                    tree.insertNode(tree.root, 4);

                    for (int i = 1; i < 8; i++) {
                        tree.insertNode(tree.root, i);
                    }

                    break;

                // Insert a node into the tree.
                case 2:
                    tree.insertNode(
                        tree.root,
                        promptForSearchKey()
                    );
                    break;

                // Delete a node from the tree.
                case 3:
                    tree.root = tree.deleteNode(
                        tree.root,
                        promptForSearchKey()
                    );
                    break;

                // Print the tree in-order.
                case 4:
                    tree.printTreeInOrder(tree.root);
                    break;

                // Print the tree pre-order.
                case 5:
                    tree.printTreePreOrder(tree.root);
                    break;

                // Print the tree post-order.
                case 6:
                    tree.printTreePostOrder(tree.root);
                    break;

                // Exit the program.
                case 7:
                    System.out.println("Have a great day!");
                    return;
            }
        }
    }
}