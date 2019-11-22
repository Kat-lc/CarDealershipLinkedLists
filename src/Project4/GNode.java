package Project4;

import java.io.Serializable;

/*********************************************************************
 * A car dealership program that allows you to purchase vehicles for
 * your inventory and sell to customers. This program utilizes Linked
 * Lists for storing of inventory.
 * This class is a generic version of the Node class. Instead of
 * using type Auto, it uses generic 'E' as a type placeholder.
 *
 * @author Katie Cussans, Jason Kaip
 * @version Fall 2019
 ********************************************************************/

public class GNode<E> implements Serializable {
    /**
     * Variable to contain object  information
     */
    private E data;

    /**
     * Node to contain the data of the next element in the list
     */
    private GNode<E> next;

    /*********************************************************************
     * Constructor initializes defines instance variables with given
     * parameters.
     *
     * @param data Information about object .
     * @param next Node containing the next element in the list.
     * @return None.
     ********************************************************************/
    public GNode(E data, GNode<E> next) {
        this.data = data;
        this.next = next;
    }

    /*********************************************************************
     * Retrieves the information about an object .
     *
     * @return data Information about object .
     ********************************************************************/
    public E getData() {
        return data;
    }

    /*********************************************************************
     * Sets the characteristics of an object .
     *
     * @param data Information to modify object .
     * @return None.
     ********************************************************************/
    public void setData(E data) {
        this.data = data;
    }

    /*********************************************************************
     * Sets pointer to next element in list.
     *
     * @return next The next element in the list.
     ********************************************************************/
    public GNode<E> getNext() {
        return next;
    }

    /*********************************************************************
     * Sets the data of the next element in the list.
     *
     * @return next Node to set the next element in list to.
     ********************************************************************/
    public void setNext(GNode<E> next) {
        this.next = next;
    }
}
