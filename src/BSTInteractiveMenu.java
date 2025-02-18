// BSTInteractiveMenu.java - Created 02/18/2025 by Evan Redden for Computer Science 201: Data Structures and Algorithms.

// Defines a Node class and constructor.
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

// Defines a Binary Search Tree class and methods for interacting with it.
public class BinarySearchTree {
    public Node root;

    // Inserts a node into a binary search tree given the root node and a search key.
    public Node insertNode(Node root, int searchKey) {
        // Insert the node into an empty branch.
        if (root == null) {
            return Node(searchKey);
        } 

        // Recursively go down the branches until you reach the exit case above.
        else if (root.searchKey < searchKey) {
            root.right = insertNode(root.right, searchKey);
        }

        else if (root.searchKey > searchKey) {
            root.left = insertNode(root.left, searchKey);
        }

        // If the root search key is equivalent to the search key, return the root.
        return root
    }

    // Gets the successor of a soon-to-be deleted node if it has children.
    private Node getSuccessorNode(Node root) {
        root = root.right;

        while (root && root.left) {
            root = root.left;
        }

        return root;
    }

    // Deletes a node from a binary search tree given the root node.
    public Node deleteNode(Node root, int searchKey) {
        if (root) {
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
                successor = getSuccessorNode(root);
                root.searchKey = successor.searchKey;
                root.right = deleteNode(root.right, successor.searchKey);
            }
        }

        return root;
    }

    // Prints an in-order binary search tree.
    public void printTreeInOrder(Node root) {
        printTreeInOrder(root.left);
        System.out.print(root.searchKey + " ");
        printTreeInOrder(root.right);
    }

    // Prints a pre-order binary search tree.
    public void printTreePreOrder(Node root) {
        System.out.print(root.searchKey + " ");
        printTreePreOrder(root.left);
        printTreePreOrder(root.right);
    }

    // Prints a post-order binary search tree.
    public void printTreePostOrder(Node root) {
        printTreePostOrder(root.left);
        printTreePostOrder(root.right);
        System.out.print(root.searchKey + " ");
    }
}

// The entry-point for the program.
public class Main {
    // Continously prompt the user to select an option until the user provides a valid integer.
    public int promptForOptionSelection() {
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
                System.out.print("Select a search key: ")
                
                int selection = listener.nextLine();

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
    public int promptForSearchKey() {
        Scanner listener = new Scanner(System.in);

        while (true) {
            try {
                System.out.print("Select a search key: ")
                return (int) listener.nextLine();
            }
            
            catch (NumberFormatException err) {
                System.out.println("Invalid input. Please provide an integer value.\n");
            }
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        while (true) {
            switch (select_options()) {
                // Create the tree.
                case 1:
                    tree.insertNode(4);

                    for (int i = 1; i < 8; i++) {
                        tree.insertNode(i);
                    }

                    break;

                // Insert a node into the tree.
                case 2:
                    int searchKey = promptForSearchKey();

                    tree.insertNode(searchKey);
                    break;

                // Delete a node from the tree.
                case 3:
                    int searchKey = promptForSearchKey();

                    tree = tree.deleteNode(searchKey);
                    break;

                // Print the tree in-order.
                case 4:
                    tree.printTreeInOrder();
                    break;

                // Print the tree pre-order.
                case 5:
                    tree.printTreePreOrder();
                    break;

                // Print the tree post-order.
                case 6:
                    tree.printTreePostOrder();
                    break;

                // Exit the program.
                case 7:
                    System.out.println("Have a great day!");
                    return;
            }
        }
    }
}