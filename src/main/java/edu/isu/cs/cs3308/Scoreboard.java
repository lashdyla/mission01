package edu.isu.cs.cs3308;

import edu.isu.cs.cs3308.structures.List;
import edu.isu.cs.cs3308.structures.impl.SinglyLinkedList;

/**
 * A class used to represent a scoreboard for a game which is constrained to
 * only contain a specific maximum number of entries.
 *
 * @author Isaac Griffith
 */
public class Scoreboard {

    private int capacity;
    private List<GameEntry> board;

    /**
     * Constructs a new scoreboard with the provided maximum capacity.
     *
     * @param capacity Maximum number of entries supported by this scoreboard.
     */
    public Scoreboard(int capacity) {
        board = new SinglyLinkedList<>();
        this.capacity = capacity;
    }

    /**
     * Adds the specified GameEntry to the top of the List. If the entry is null
     * we should expect nothing to happen.
     *
     * @param entry Entry to be added.
     */
    public void add(GameEntry entry)
    {
        // Implement add process
        // @author Dylan Lasher
        if (capacity != size())
        {
            if (entry != null)
            {
                board.addFirst(entry);
            }
        }
    }

    /**
     * Removes the element at the provided index from the scoreboard.
     *
     * @param i the index of the element to be removed.
     * @return GameEntry at the specified index
     * @throws IndexOutOfBoundsException If the index is greater than or equal
     * to the list size or less than zero.
     */
    public GameEntry remove(int i) throws IndexOutOfBoundsException
    {
        // Implement remove process
        // @author Dylan Lasher
        if (i >= size())
        {
            throw new IndexOutOfBoundsException("Index is greater than List bounds");
        }
        else if (i < 0)
        {
            throw new IndexOutOfBoundsException("Index is less than List bounds");
        }
        return board.remove(i);
    }

    /**
     * Prints the contents of the scoreboard to the console.
     */
    public void printScores() {
        board.printList();
    }

    /**
     * @return current number of entries held by the scoreboard.
     */
    public int size() {
        return board.size();
    }
}
