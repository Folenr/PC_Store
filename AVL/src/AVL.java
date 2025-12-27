class Node {
    public int id, price, discount, shipping, quantity;
    public String name, img, category;
    int height;
    Node left, right;

    Node(int id, int price, int discount, int shipping,String name, String img, String category, int quantity) {
        this.id = id;
        this.price = price;
        this.discount = discount;
        this.shipping = shipping;
        this.name = name;
        this.img = img;
        this.category = category;
        this.quantity = quantity;
        this.height = 1;
    }
}

// Tree class
class AVL {
  Node root;

  int height(Node N) {
    if (N == null)
      return 0;
    return N.height;
  }

  int max(int a, int b) {
    return (a > b) ? a : b;
  }

  Node rightRotate(Node y) {
    Node x = y.left;
    Node T2 = x.right;
    x.right = y;
    y.left = T2;
    y.height = max(height(y.left), height(y.right)) + 1;
    x.height = max(height(x.left), height(x.right)) + 1;
    return x;
  }

  Node leftRotate(Node x) {
    Node y = x.right;
    Node T2 = y.left;
    y.left = x;
    x.right = T2;
    x.height = max(height(x.left), height(x.right)) + 1;
    y.height = max(height(y.left), height(y.right)) + 1;
    return y;
  }

  // Get balance factor of a node
  int getBalanceFactor(Node N) {
    if (N == null)
      return 0;
    return height(N.left) - height(N.right);
  }

  // Insert a node
  Node insertNode(Node node, int id, int price, int discount, int shipping,String name, String img, String category, int quantity) {

    // Find the position and insert the node
    if (node == null)
      return (new Node(id, price, discount, shipping, name, img, category, quantity));
    if (id < node.id)
      node.left = insertNode(node.left, id, price, discount, shipping, name, img, category, quantity);
    else if (id > node.id)
      node.right = insertNode(node.right, id, price, discount, shipping, name, img, category, quantity);
    else
      return node;

    // Update the balance factor of each node
    // And, balance the tree
    node.height = 1 + max(height(node.left), height(node.right));
    int balanceFactor = getBalanceFactor(node);
    if (balanceFactor > 1) {
      if (id < node.left.id) {
        return rightRotate(node);
      } else if (id > node.left.id) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
      }
    }
    if (balanceFactor < -1) {
      if (id > node.right.id) {
        return leftRotate(node);
      } else if (id < node.right.id) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
      }
    }
    return node;
  }

  Node nodeWithMinimumValue(Node node) {
    Node current = node;
    while (current.left != null)
      current = current.left;
    return current;
  }

  // Delete a node
  Node deleteNode(Node root, int id) {

    // Find the node to be deleted and remove it
    if (root == null)
      return root;
    if (id < root.id)
      root.left = deleteNode(root.left, id);
    else if (id > root.id)
      root.right = deleteNode(root.right, id);
    else {
      if ((root.left == null) || (root.right == null)) {
        Node temp = null;
        if (temp == root.left)
          temp = root.right;
        else
          temp = root.left;
        if (temp == null) {
          temp = root;
          root = null;
        } else
          root = temp;
      } else {
        Node temp = nodeWithMinimumValue(root.right);
        root.id = temp.id;
        root.right = deleteNode(root.right, temp.id);
      }
    }
    if (root == null)
      return root;

    // Update the balance factor of each node and balance the tree
    root.height = max(height(root.left), height(root.right)) + 1;
    int balanceFactor = getBalanceFactor(root);
    if (balanceFactor > 1) {
      if (getBalanceFactor(root.left) >= 0) {
        return rightRotate(root);
      } else {
        root.left = leftRotate(root.left);
        return rightRotate(root);
      }
    }
    if (balanceFactor < -1) {
      if (getBalanceFactor(root.right) <= 0) {
        return leftRotate(root);
      } else {
        root.right = rightRotate(root.right);
        return leftRotate(root);
      }
    }
    return root;
  }
  boolean search(Node root, int id) {
        if (root == null)
            return false;
        if (root.id == id)
            return true;
        if (root.id < id)
            return search(root.right, id);
        return search(root.left, id);
    }

  void inOrder(Node node) {
    if (node != null) {
        inOrder(node.left);
        System.out.print(node.id + " ");
      inOrder(node.right);
    }
  }

  // Driver code
  public static void main(String[] args) {
    AVL tree = new AVL();
    tree.root = tree.insertNode(tree.root, 10, 15, 0, 20, "Rubiks-Cube","Rubiks-Cube.jpg","others", 20);
    tree.root = tree.insertNode(tree.root, 20, 15, 0, 20, "Rubiks-Cube","Rubiks-Cube.jpg","others", 20);
    tree.root = tree.insertNode(tree.root, 30, 15, 0, 20, "Rubiks-Cube","Rubiks-Cube.jpg","others", 20);
    tree.root = tree.insertNode(tree.root, 40, 15, 0, 20, "Rubiks-Cube","Rubiks-Cube.jpg","others", 20);
    tree.root = tree.insertNode(tree.root, 50, 15, 0, 20, "Rubiks-Cube","Rubiks-Cube.jpg","others", 20);
    tree.root = tree.insertNode(tree.root, 25, 15, 0, 20, "Rubiks-Cube","Rubiks-Cube.jpg","others", 20);

    System.out.println("In order traversal of constructed AVL tree is : ");
    tree.inOrder(tree.root);
    System.out.println();
    System.out.println(tree.search(tree.root, 20));
    
    tree.root = tree.deleteNode(tree.root, 30);
    System.out.println("After Deletion: ");
    tree.inOrder(tree.root);
  }
}