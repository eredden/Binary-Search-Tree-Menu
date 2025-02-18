// Main.java - Entry-point for the program. Used as a menu for interacting with a binary search tree.
// Created on 02/18/2025 by Evan Redden for Computer Science 201: Data Structures and Algorithms.

import java.util.Scanner; // Required for taking in user input.

public class Main {
    // Continously prompt the user to select an option until the user provides a valid integer.
    public static int promptForOptionSelection(Scanner listener) {
        System.out.println("\nBINARY SEARCH TREE INTERFACE:");
        System.out.println("1. Create a binary search tree.");
        System.out.println("2. Add a node.");
        System.out.println("3. Delete a node.");
        System.out.println("4. Print nodes in-order.");
        System.out.println("5. Print nodes pre-order.");
        System.out.println("6. Print nodes post-order.");
        System.out.println("7. Exit the program.\n");

        while (true) {
            try {
                System.out.print("Select an option (1-7): ");

                int selection = Integer.parseInt(
                  listener.nextLine()
                );

                if (selection > 0 && selection < 8) {
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
    public static int promptForSearchKey(Scanner listener) {
        while (true) {
            try {
                System.out.print("Select a search key: ");

                int selection = Integer.parseInt(
                    listener.nextLine()
                );

                return selection;
            }

            catch (NumberFormatException err) {
                System.out.println("Invalid input. Please provide an integer value.\n");
            }
        }
    }

    // Create a balanced binary search tree.
    public static Node createBalancedTree(int[] values, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node node = new Node(values[mid]);

        node.left = createBalancedTree(values, start, mid - 1);
        node.right = createBalancedTree(values, mid + 1, end);

        return node;
    }

    public static void main(String[] args) {
        Scanner listener = new Scanner(System.in);
        BinarySearchTree tree = new BinarySearchTree();

        while (true) {
            switch (promptForOptionSelection(listener)) {
                // Create a binary search tree with a root search key of 4.
                case 1:
                    int[] values = {1, 2, 3, 4, 5, 6, 7};

                    tree.root = createBalancedTree(values, 0, values.length - 1);

                    break;

                // Insert a node into the tree.
                case 2:
                    tree.insertNode(
                        tree.root,
                        promptForSearchKey(listener)
                    );

                    break;

                // Delete a node from the tree.
                case 3:
                    tree.root = tree.deleteNode(
                        tree.root,
                        promptForSearchKey(listener)
                    );

                    break;

                // Print the tree in-order.
                case 4:
                    tree.printTreeInOrder(tree.root);

                    System.out.println();
                    break;

                // Print the tree pre-order.
                case 5:
                    tree.printTreePreOrder(tree.root);

                    System.out.println();
                    break;

                // Print the tree post-order.
                case 6:
                    tree.printTreePostOrder(tree.root);

                    System.out.println();
                    break;

                // Exit the program.
                case 7:
                    System.out.println("Have a great day!\n");

                    listener.close();
                    return;
            }
        }
    }
}