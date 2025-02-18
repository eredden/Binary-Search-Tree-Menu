# main.py - Entry point for interfacing with a binary search tree.

import py.node as node

# Prompts the user with available options for interacting with the binary search tree.
def select_options() -> int:
    print("\nBINARY SEARCH TREE INTERFACE:")
    print("1. Create a binary search tree.")
    print("2. Add a node.")
    print("3. Delete a node.")
    print("4. Print nodes by in-order.")
    print("5. Print nodes by pre-order.")
    print("6. Print nodes by post-order.")
    print("7. Exit the program.\n")

    while True:
        try:
            selection = int(input("Select one of the options above (1-7): "))

            if selection > 0 and selection < 8: 
                return selection

        except ValueError:
           pass
            
        print("Invalid input. Please select an integer value between 1 and 7.\n")

# Prompts the user for a number.
def select_number() -> int:
    while True:
        try:
            return int(input("Select a search key: "))
        
        except ValueError:
           print("Invalid input. Please provide an integer value.\n")


if __name__ == "__main__":
    root = None

    while True:
        match select_options():
            case 1:
                root = node.Node(4)
                
                for iterator in range(1, 8):
                    node.insert(root, iterator)

            case 2:
                node.insert(root, select_number())

            case 3:
                root = node.delete(root, select_number())

            case 4:
                node.inorder(root)
                print("")

            case 5:
                node.preorder(root)
                print("")

            case 6:
                node.postorder(root)
                print("")
                
            case 7:
                break
