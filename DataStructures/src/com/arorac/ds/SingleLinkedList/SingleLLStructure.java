package com.arorac.ds.SingleLinkedList;

public class SingleLLStructure <E>{
	
	private static class Node<E>{
		E item;
		Node<E> next;
		
		Node(E element , Node<E> next){
			this.item = element;
			this.next = next;
		}
	}
	
	Node<E> first;
	Node<E> last;
	
	public SingleLLStructure() {
		// TODO Auto-generated constructor stub
	}
	
	 public boolean add(){
		 return false;
	 }
}
