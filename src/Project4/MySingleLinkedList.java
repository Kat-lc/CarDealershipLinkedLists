package Project4;

import java.io.Serializable;

/*********************************************************************
 * A car dealership program that allows you to purchase vehicles for
 * your inventory and sell to customers. This program utilizes Linked
 * Lists for storing of inventory.
 *
 * @author Katie Cussans, Jason Kaip
 * @version Fall 2019
 ********************************************************************/

public class MySingleLinkedList<E extends Auto> implements Serializable
{
    /**
     * Node that always points to top of the list.
     */
    private GNode<E> top;

    /**
     * Node that always points to bottom of list.
     */
    private GNode<E> tail;

    /**
     * Size of Linked List
     */
    public int size;

    /*********************************************************************
     * Constructor creates linked list by setting top pointer to null and
     * size of list to zero.
     *
     * @return None.
     ********************************************************************/
    public MySingleLinkedList() {
        top = null;
        size = 0;
    }

    /*********************************************************************
     * Retrieves the size of the linked list.
     *
     * @return count Number of elements in list.
     ********************************************************************/
    public int size() {
        int count = 0;
        GNode<E> temp = top;
        while(temp != null) {
            count++;
            temp = temp.getNext();
        }
        this.size = count;
        return count;
    }

    /*********************************************************************
     * Clears linked list by resetting top pointer to null and size to 0.
     *
     * @return None.
     ********************************************************************/
    public void clear () {
        top = null;
        this.size = 0;
    }

    /*********************************************************************
     * Adds a vehicle to the list in the appropriate sorted position.
     *
     * @param s The vehicle to add to the list.
     * @return None.
     ********************************************************************/
    public <s extends Auto> void add(E s) {
        //  Order is: (First) List all Cars in bought by date order
        //  followed by (second) List all Trucks in bought by order.'
        // Case 0: List doesn't exist, tail and top point to new node containing 's'
        if (top == null)
            tail = top = new GNode<E>(s, null);
            //Case 1: If 's' is a car
        else if (s instanceof Car) {
            GNode<E> temp = top;
            while (temp.getNext() != null && temp.getNext().getData() instanceof Car)
                if (temp.getNext().getData().getBoughtOn().compareTo(s.getBoughtOn()) < 0)
                    temp = temp.getNext();
                else
                    break;
            if (temp == top &&  temp.getData() instanceof Truck)
                top = new GNode<E>(s, top);
            else if(temp == top && temp.getData().getBoughtOn().compareTo(s.getBoughtOn()) > 0)
                top = new GNode<E>(s, top);
            else
                temp.setNext(new GNode<E>(s, temp.getNext()));
            // C+.ase 2: If 's' is a Truck
        } else {
            GNode<E> temp = top;
            while(temp.getNext() != null) {
                if(temp.getNext().getData() instanceof Truck && temp.getNext().getData().getBoughtOn().compareTo(s.getBoughtOn()) > 0)
                    break;
                else
                    temp = temp.getNext();
            }
            if(temp == top && temp.getData() instanceof Truck && temp.getData().getBoughtOn().compareTo(s.getBoughtOn()) > 0)
                top = new GNode<E>(s, top);
            else
                temp.setNext(new GNode<E>(s, temp.getNext()));
        }
    }

    /*********************************************************************
     * Removes a vehicle from the list based on index chosen.
     *
     * @param index Specifies which vehicle to remove.
     * @return Null Top is either null or index is out of range.
     * @return get() Returns the vehicle that was removed from the list.
     ********************************************************************/
    public E remove(int index) {
        //Case 0: No list
        if (top == null)
            return null;

        //Case 1: Out of range
        if (index < 0 || index >= size())
            return null;

        //Case 2: Removes top element
        if (index == 0) {
            top = top.getNext();
            return get(0);
        }

        //Case 3: Removes at index
        GNode<E> temp = top;
        for (int i = 0; i < index - 1; i++)
            temp = temp.getNext();

        temp.setNext(temp.getNext().getNext());
        return get(index-1);
    }

    /*********************************************************************
     * Retrieves the information of a vehicle from the list based on
     * index specified.
     *
     * @param index Vehicle to retrieve information for.
     * @throws IndexOutOfBoundsException if index is invalid.
     * @return null Returns null if there is no list.
     * @return temp.getData() Returns information about specified vehicle
     ********************************************************************/
    public E get(int index) {
        if(top == null)
            return null;
        else if(index < 0 || index >= size())
            throw new IndexOutOfBoundsException();
        else {
            GNode<E> temp = top;
            for(int i = 0; i < index; i++)
                temp = temp.getNext();
            return temp.getData();
        }
    }

    /*********************************************************************
     * Inserts the data from the list into a string.
     *
     * @return list String containing contents of list.
     ********************************************************************/
    public String toString() {
        String list = "";
        GNode<E> temp = top;
        while (temp != null) {
            list = list + "\n" + temp.getData();
            temp = temp.getNext();
        }

        return list;
    }
}
