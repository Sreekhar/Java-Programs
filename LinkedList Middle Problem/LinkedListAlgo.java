class MainClass {

   public static void main(String args[]) {

      Node head = new Node("Sameer");

      //Adding data to my linked list
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

   //method to add a node to the linked list
   static Node addNode(String str, Node node) {
      Node newNode = new Node(str);
      node.link = newNode;
      return newNode;
   }

   //method to reverse the right hald of the linkedlist
   static void SolveMidLinkedList(Node head) {
      int LinkedListSize = 0;
      Node temp = head;
      Node LastEle = null, MiddleEle = null, temp1 = null, temp2 = null;

      //While loop to find the size of the linkedlist and also to find the last element in the linkedlist
      while(temp != null) {
          LastEle = temp;
          temp = temp.link;
          LinkedListSize++;
      }

      //Printing the names
      temp = head;
      System.out.println("Before rearranging the linked list");
      while(temp != null) {
          System.out.println(temp.name);
          temp = temp.link;
      }

      //The main procedure
      temp = head;
      int iCount = 1;
      while(temp != null) {
          //Not changing the order of first half of the linked list
          if(iCount <= (LinkedListSize/2)) {
              MiddleEle = temp;
          } else {
              //Reversing the order of second half(right side half) of the linked list.
              temp2 = temp.link;
              temp.link = temp1;
              temp1 = temp;
          }
          temp = temp.link;
          iCount++;
      }
      //At the end asssigning the middle element to the last element of the linked list.
      MiddleEle.link = LastEle;

      //Printing the names
      temp = head;
      System.out.println("After rearranging the linked list");
      while(temp != null) {
          System.out.println(temp.name);
          temp = temp.link;
      }

   }
}

//General definition of Node in a linked list.
class Node {
    Node link = null;
    String name;
    Node(String str) {
        this.name = str;
    }
}
