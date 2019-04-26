package edu.isu.cs.cs3308.structures;

/**
 * Node logistics for later use
 *
 * @author Dylan Lasher
 * @param <E> any node type
 */
public class Node<E>
{

	private E data;
	private Node<E> next;

	/**
	 * Constructor with data parameter
	 * @param data Whatever node data should be stored
	 */
	public Node(E data) {
		this.data = data;
	}

	/**
	 * Get node data
	 * @return node data
	 */
	public E getData() {
		return data;
	}

	/**
	 * Set node data
	 * @param data node stores
	 */
	public void setData(E data) {
		this.data = data;
	}

	/**
	 * Get next node data
	 * @return next node data
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * Set next node data
	 * @param next node data
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
}