import java.lang.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;
	Node root;
	Node(int d)
	{
		data = d;
		left = null;
		right = null;
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
	Node root;
	void insertBegin(int data) {
		Node n = new Node(data);
		if(root == null) {
			root = n;
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