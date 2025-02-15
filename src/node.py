# node.py - Definition for the Node class and auxillary functions for BSTs.

class Node: 
    def __init__(self, search_key: int):
        if not type(search_key) is int:
            raise ValueError("The search key must be an integer.")

        self.search_key = search_key
        self.left = None
        self.right = None

# Inserts a search key into the binary tree.
def insert(root: Node, search_key: int) -> Node:
    if root is None:
        return Node(search_key)
    
    elif root.search_key == search_key:
        return root
    
    elif root.search_key < search_key:
        root.right = insert(root.right, search_key)

    elif root.search_key > search_key:
        root.left = insert(root.left, search_key)
    
    return root

# Gets the successor of a deleted node.
def get_successor(root: Node) -> Node:
    root = root.right

    while root is not None and root.left is not None:
        root = root.left

    return root

# Deletes a search key from the binary tree.
# TODO: Revise this so that it actually deletes stuff.
def delete(root: Node, search_key: int) -> Node | None:
    if root:
        if root.search_key < search_key:
            delete(root.right, search_key)

        elif root.search_key > search_key:
            delete(root.left, search_key)

        elif root.search_key == search_key:
            if not root.left:
                return root.right

            if not root.right:
                return root.left

            successor = get_successor(root)
            root.search_key = successor.search_key
            root.right = delete(root.right, successor.search_key)

    return root

# Traverses through a binary tree in-order.
def inorder(root: Node) -> None:
    if root:
        inorder(root.left)
        print(root.search_key, end=" ")
        inorder(root.right)

# Traverses through a binary tree pre-order.
def preorder(root: Node) -> None:
    if root:
        print(root.search_key, end=" ")
        preorder(root.left)
        preorder(root.right)

# Traverses through a binary tree post-order.
def postorder(root: Node) -> None:
    if root:
        postorder(root.left)
        postorder(root.right)
        print(root.search_key, end=" ")