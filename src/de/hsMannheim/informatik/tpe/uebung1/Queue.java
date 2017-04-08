package de.hsMannheim.informatik.tpe.uebung1;

import static gdi.MakeItSimple.*;

public class Queue<Element> {
	class Node {
		Element element;
		Node next;
		Node(Element element) {
			this.element = element;
		}
	}
	
	Node head;
	
	public boolean isEmpty() {
		return head == null;
	}
	public void enter(Element element) {
		Node node = new Node(element);
		if(head != null) {
			Node lastNode = head;
			while(lastNode.next != null) {
				lastNode = lastNode.next;
			}
			lastNode.next = node;
		} else {
			head = node;
		}
	}
	public Element leave() {
		if(head == null) {
			throw new GDIException("queue is empty");
		} else {
			Node node = head;
			head = node.next;
			return node.element;
		}
	}
}
public void printPostorder() {
	
	for(int i=0; i<ordnung*2 && this.kinder[i] != null; i++){
	
		if(null != this.kinder[i]) 
		this.kinder[i].printInorder();
	
	
		 println(keys[i].intValue());
		 i++;
	
		 if(null != this.kinder[i]) 
			this.kinder[i].printInorder();
		 
	}
	println("-|-");
}

public void printorder() {
	
	for(int i=0; i<ordnung*2 && this.kinder[i] != null; i++){
	
		if(null != this.kinder[i]) 
		this.kinder[i].printInorder();
	
	
		 println(keys[i].intValue());
		 i++;
	
		 if(null != this.kinder[i]) 
			this.kinder[i].printInorder();
		 
	}
	println("-|-");
}
