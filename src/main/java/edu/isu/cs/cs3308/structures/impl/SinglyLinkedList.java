package edu.isu.cs.cs3308.structures.impl;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.Node;

/**
 * Class in which SLL is implemented
 *
 * @author Dylan Lasher
 * @param <E> any list type
 */
public class SinglyLinkedList<E> implements List<E>
{

	// List head ref
	protected Node<E> head = null;

	// List tail ref
	protected Node<E> tail = null;

	// Node counter
	protected int size = 0;

	/**
	 * Check if null element
	 * @param element to check
	 * @return true if not null, false if null
	 */
	private boolean checkElement(E element)
	{
		return (element != null) ? true : false;
	}

	/**
	 * Checks if index is within 0/size
	 * @param index to check
	 * @return true if valid index, false if invalid
	 */
	private boolean checkIndex(int index) {
		return (index < size && index >= 0) ? true : false;
	}

	/**
	 * Used to fix the head and tail of list
	 * If a node remains in the list, then head and tail are set to it
	 * If size of list is 0, then set head and tail to null
	 * @param theNode Node to set if it's alone in list
	 */
	private void singleHeadTail(Node<E> theNode)
	{
		// if theNode is the only one in the list
		if (size == 1) {
			head = theNode;
			tail = theNode;
		}
		// else there are no nodes in the list
		else if (size == 0)
		{
			head = null;
			tail = null;
		}
	}

	/**
	 * Get node from list at specific index.
	 * @param index within the list
	 * @return node retrieved from list
	 */
	private Node<E> getNode(int index)
	{
		// get current head node to start from
		Node<E> seekNode = head;

		// seek through the list starting from the head
		for (int i = 0; i < index; i++)
		{
			seekNode = seekNode.getNext();
		}

		// return the desired Node from the list index
		return seekNode;
	}

	/**
	 * Adds 1 to size counter.
	 */
	private void addSize() {
		size++;
	}

	/**
	 * Subtracts 1 from size counter
	 */
	private void subSize()
	{
		size--;

		if (size < 0) //can't go below 0
		{
			size = 0;
		}
	}

	/**
	 * Get data from first node in list
	 * @return data within the head node, null if empty list
	 */
	@Override
	public E first() {
		return (head != null) ? head.getData() : null;
	}

	/**
	 * Get data from last node the list
	 * @return data in tail node, null if empty list
	 */
	@Override
	public E last() {
		return (tail != null) ? tail.getData() : null;
	}

	/**
	 * Creates a node with given element data to list head
	 * @param element data stored in last node
	 */
	@Override
	public void addLast(E element)
	{
		// check if the element is null
		if (checkElement(element))
		{
			// check if the size at least 1
			if (!isEmpty())
			{
				// (1) create new node
				Node<E> lastNode = new Node<>(element);

				// (2) set its next ref to null
				lastNode.setNext(null);

				// (3) make the original tail next to the future tail
				tail.setNext(lastNode);

				// (4) change the tail ref to new node
				tail = lastNode;

				// (5) increment size
				addSize();
			}
			// if size is 0 add to first ref
			else {
				addFirst(element);
			}
		}
	}

	/**
	 * Creates node with given element data to the beginning of list
	 * @param element data to store in first node
	 */
	@Override
	public void addFirst(E element)
	{
		// (1) check if element is null
		if (checkElement(element))
		{
			// (2) create new node
			Node<E> firstNode = new Node<>(element);

			// (3) check if there is more than one node in list
			if (size > 0)
			{
				firstNode.setNext(head);
			}
			// (4) else this is the only node in list
			else {
				// set as null
				firstNode.setNext(null);
			}

			// (5) change head ref to the new node
			head = firstNode;

			// (6) increment size
			addSize();

			// (7) fix head and tail if single node in list
			singleHeadTail(firstNode);
		}
	}

	/**
	 * Removes first node in list
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E removeFirst()
	{
		// (1) check if the head Node is not null
		if (head != null)
		{
			// check if there are more than 1 nodes in list
			if (size > 1)
			{

				// (1) track of the original head
				Node<E> removeNode = head;

				// (2) set new head ref to next of original
				head = removeNode.getNext();

				// (3) remove next of original head ref
				removeNode.setNext(null);

				// (4) decrement size
				subSize();

				// (5) fix the head and tail ref if single node in list
				singleHeadTail(head);

				// (6) return original head data
				return removeNode.getData();
			}
			// (7) else there is only one node in the list to remove
			else {
				// make a temp of current head node
				Node<E> removeNode = head;

				// set the list head and tail ref to null
				head.setNext(null);
				head = null;
				tail.setNext(null);
				tail = null;

				// return data
				return removeNode.getData();
			}
		}

		// else,  no head Node
		else {
			return null;
		}
	}

	/**
	 * Remove last node in list
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E removeLast()
	{
		// check if there are at least 2 nodes
		if (size > 1)
		{
			return remove(size - 1);
		}

		// else just remove first node
		else {
			return removeFirst();
		}
	}

	/**
	 * Create node with given element data, and insert that node
	 * into list at given index
	 * @param element data to store in node
	 * @param index where in list node will be inserted
	 */
	@Override
	public void insert(E element, int index)
	{
		// if element not null
		if (checkElement(element))
		{
			// if index is the head
			if (index == 0)
			{
				addFirst(element);
			}

			// if index is the tail
			else if (index >= size)
			{
				addLast(element);
			}

			// else index is other node
			else {
				// check if index is acceptable value
				if (checkIndex(index))
				{
					// get node before one to be added
					Node<E> prevNode = getNode(index-1);

					// create node to be inserted
					Node<E> insertNode = new Node<>(element);

					// set next for new node
					insertNode.setNext(prevNode.getNext());

					// set correct next for previous node
					prevNode.setNext(insertNode);

					// increment size
					addSize();
				}
			}
		}
	}

	/**
	 * Removes given node from list based on a given index
	 * @param index of node in list to remove
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E remove(int index)
	{
		// check if index is a acceptable value
		if (checkIndex(index))
		{
			// if index is head
			if (index == 0)
			{
				return removeFirst();
			}

			// check if index is other node
			else {
				// get node before to-be-removed node
				Node<E> prevNode = getNode(index-1);

				// get to-be-removed
				Node<E> removeNode = prevNode.getNext();

				// set new connection with TBR node
				prevNode.setNext(removeNode.getNext());

				// null next of removeNode
				removeNode.setNext(null);

				// decrement size
				subSize();

				// fix the head and tail ref if single node in list
				singleHeadTail(prevNode);

				// return removed Node data
				return removeNode.getData();
			}
		}

		// if index is invalid
		else {
			return null;
		}
	}

	/**
	 * Get data in node from list at given index
	 * @param index of node in list to retrieve
	 * @return data stored in to-be-removed node
	 */
	@Override
	public E get(int index)
	{
		// check if index is acceptable value
		if (checkIndex(index))
		{
			// if index is head ref
			if (index == 0)
			{
				return head.getData();
			}

			// check if index is tail ref
			else if (index == size-1)
			{
				return tail.getData();
			}

			// else index is other node
			else {
				return getNode(index).getData();
			}
		}

		// if index is invalid
		else {
			return null;
		}
	}

	/**
	 * Stored value which contains the number of nodes in list
	 * @return count of nodes in list
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Determine if list is empty
	 * @return True if empty list, false if size != 0
	 */
	@Override
	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	/**
	 * For each list node, print index on new line
	 */
	@Override
	public void printList()
	{
		// if there are nodes in list
		if (!isEmpty()) {
			// get head as starting point
			Node<E> printNode = head;

			// iterate though list until end
			for (int i = 0; i < size; i++) {
				// print current node data on new line
				System.out.println(printNode.getData());

				// get next node for data
				printNode = printNode.getNext();
			}
		}
		// else there are no nodes in list
		else {
			System.out.println("There is nothing in this list.");
		}
	}
}
