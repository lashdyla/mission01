package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;

public class SinglyLinkedList<E> implements List<E>
{
	//Nested node implementation.
	public static class Node<E>
	{
		private E element;
		private Node<E> next;

		// Constructors / methods
		public Node()
		{
			this (null, null);
		}
		public Node(E element, Node<E> next)
		{
			this.element = element;
			this.next = next;
		}

		// Get-Set method
		public E getElement()
		{
			return element;
		}
		public Node<E> getNext()
		{
			return next;
		}
		public void setElement(E element)
		{
			this.element = element;
		}
		public void setNext(Node<E> next)
		{
			this.next = next;
		}

	}

	// instance variables.  Add the tail reference.
	protected Node<E> head, tail;
	protected long size;

	// methods, empty list constructor first
	public SinglyLinkedList()
	{
		head = null;
		tail = null;
		size = 0;
	}

	//Return first element in list or null if empty.
	@Override
	public E first()
	{
		return (E) head;
	}

	@Override
	public E last()
	{
		return (E) tail;
	}

	@Override
	public void addLast(E element)
	{

	}

	//Add element to list front.
	@Override
	public void addFirst(E element)
	{

	}

	//Remove element at list front.
	@Override
	public E removeFirst()
	{
		//Check if empty list first.
		if (isEmpty())
		{
			System.err.println("Error: Cannot remove item from empty list.");
			return null; //return null here and be done with method.
		}

		//(1) Assign SLL's head as node to be removed.
		Node<E> removedNode = head;

		//(2) Set SLL's head ref to next (second) node in list.
		head = head.getNext();

		//(3) Set removed node's next ref to null (cut off).
		removedNode.setNext(null);

		//Adjust size
		size--;

		return (E) removedNode;

	}

	@Override
	public E removeLast()
	{
		return null;
	}

	@Override
	public void insert(E element, int index)
	{

	}

	@Override
	public E remove(int index)
	{
		return null;
	}

	@Override
	public E get(int index)
	{
		return null;
	}

	@Override
	public int size()
	{
		return 0;
	}

	//Check if list is empty.
	@Override
	public boolean isEmpty()
	{
		//If head == null, isEmpty is true.
		return head == null;
	}

	@Override
	public void printList()
	{

	}
}
