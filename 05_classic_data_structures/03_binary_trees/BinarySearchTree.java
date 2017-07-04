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
}
