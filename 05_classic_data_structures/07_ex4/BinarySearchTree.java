public class BinarySearchTree {

   public Node root;

   public BinarySearchTree() {
      root = null;
   }

   public void insert(int data) {
      Node newNode = new Node();
      newNode.data = data;

      if (root == null) {
         root = newNode;
      }
      else {
         Node current = root;
         Node parent;

         // For binary tree, the left node is smaller
         // than parent node, and the right node is greater
         // than the parent node.

         while (true) {

            // Initialize parent node.
            parent = current;
            if (data < current.data) {
               // Go deeper into the tree. Move to the left.
               current = current.left;
               if (current == null) {
                  parent.left = newNode;
                  break;
               }
            }
            else {
               current = current.right;
               if (current == null) {
                  parent.right = newNode;
                  break;
               }
            }
         }

      }
   }
   public void inOrder () {
       inOrder(root);
   }
   private void inOrder (Node n) {
       if (n != null) {
           inOrder(n.left);
           System.out.println(n.getData());
           inOrder(n.right);
       }
   }
   public void preOrder () {
       preOrder(root);
   }
   private void preOrder (Node n) {
       if (n != null) {
           // Print data first before moving to the left and right.
           System.out.println(n.getData());
           preOrder(n.left);
           preOrder(n.right);
       }
   }
   public void postOrder () {
       postOrder(root);
   }
   private void postOrder (Node n) {
       if (n != null) {
           postOrder(n.left);
           postOrder(n.right);
           System.out.println(n.getData());
       }
   }
   public int min () {
       Node current = root;
       while (current.left != null) {
           current = current.left;
       }
       return current.getData();
   }
   public int max () {
       Node current = root;
       while (current.right != null) {
           current = current.right;
       }
       return current.getData();
   }
}
