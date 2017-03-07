class MainClass {

   public static void main(String args[]) {

      Node head = new Node("Sameer");

      Node temp = addNode("Monica", head);

      temp = addNode("Doug", temp);
      temp = addNode("Eric", temp);
      temp = addNode("Charlie", temp);
      temp = addNode("Dan", temp);
      temp = addNode("Enrique", temp);
      temp = addNode("Ankitha", temp);

      addNode("Chad", temp);

      SolveMidLinkedList(head);
   }

   static Node addNode(String str, Node node) {
      Node newNode = new Node(str);
      node.link = newNode;
      return newNode;
   }

   static void SolveMidLinkedList(Node head) {
      int LinkedListSize = 0;
      Node temp = head;
      Node LastEle = null, MiddleEle = null, temp1 = null, temp2 = null;
      while(temp != null) {
          LastEle = temp;
          temp = temp.link;
          LinkedListSize++;
      }

      temp = head;
      System.out.println("Before rearranging the linked list");
      while(temp != null) {
          System.out.println(temp.name);
          temp = temp.link;
      }

      temp = head;
      int iCount = 1;
      while(temp != null) {
          if(iCount <= (LinkedListSize/2)) {
              MiddleEle = temp;
              temp = temp.link;
          } else {
              temp2 = temp.link;
              temp.link = temp1;
              temp1 = temp;
              temp = temp2;
          }
          iCount++;
      }
      MiddleEle.link = LastEle;

      temp = head;
      System.out.println("After rearranging the linked list");
      while(temp != null) {
          System.out.println(temp.name);
          temp = temp.link;
      }

   }
}

class Node {
    Node link = null;
    String name;
    Node(String str) {
        this.name = str;
    }
}
