class Node {
    int value;
    String NodeName;
    Node left;
    Node right;

    Node(int value, String NodeName) {
        this.value = value;
        this.NodeName = NodeName;
        this.left = null;
        this.right = null;
    }
}

class FindPath {
    int minValue = 0;
    Node SmallPathNode;

    void FindtheMinValue(int min, Node SmallPathNode) {
        min += SmallPathNode.value;
        if(SmallPathNode.left == null && SmallPathNode.right == null) {
            if(this.minValue == 0) {
                this.minValue = min;
            }
            if(this.minValue > min) {
                this.minValue = min;
                this.SmallPathNode = SmallPathNode;
            }
            min = 0;
        } else {
          FindtheMinValue(min, SmallPathNode.left);
          FindtheMinValue(min, SmallPathNode.right);
        }
    }

    boolean FindMinPath(Node nodePath) {
        if(nodePath == null) {
            return false;
        }
        if((nodePath == this.SmallPathNode) || FindMinPath(nodePath.left) || FindMinPath(nodePath.right)) {
            System.out.print(nodePath.NodeName + " <<---- ");
            return true;
        }
        return false;
    }
}

class MainClass {
   public static void main(String args[]) {
      Node n1 = new Node(13, "Apple");
      Node n2 = new Node(15, "Banana");
      Node n3 = new Node(23, "Cat");
      Node n4 = new Node(22, "Dog");
      Node n5 = new Node(18, "Elephant");
      Node n6 = new Node(10, "Fridge");
      Node n7 = new Node(12, "Guava");
      Node n8 = new Node(19, "Happy");
      Node n9 = new Node(16, "Indigo");

      n1.left = n2;
      n1.right = n3;
      n2.left = n4;
      n2.right = n5;
      n3.left = n6;
      n3.right = n7;
      n4.left = n8;
      n4.right = n9;

      Node root = n1;

      FindPath fp = new FindPath();
      fp.FindtheMinValue(0, root);

      System.out.println("The smallest sum value in the binary tree is " + fp.minValue);
      System.out.println("The node name for which the the value is the smallest sum in the binary tree is " + fp.SmallPathNode.NodeName + " node.");

      System.out.println("The path for the smallest sum in the binary tree is ");
      fp.FindMinPath(root);
   }
}
