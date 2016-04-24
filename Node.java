import java.lang.*;
import java.util.*;

class Node {
	int data;
	Node next;
	Node(int d)
	{
		data = d;
		next = null;
	}
}

class practice {

public static void main(String[] args){
	Operations o = new Operations();
	o.insertBegin(4);
	o.insertBegin(3);
	o.insertBegin(5);
	o.insertBegin(5);
	o.insertBegin(3);
	o.PrintData();

	}
}

class Operations {
	Node head;
	void insertBegin(int data) {
		Node n = new Node(data);
		if(head == null) {
			head = n;
		} else {
			n.next = head;
			head = n;
		}
	}
	
	void PrintData() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
}