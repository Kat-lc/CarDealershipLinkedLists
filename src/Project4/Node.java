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

public class Node implements Serializable {
    /**
     * Variable to contain vehicle information
     */
    private Auto data;

    /**
     * Node to contain the data of the next element in the list
     */
    private Node next;

    /*********************************************************************
     * Constructor initializes defines instance variables with given
     * parameters.
     *
     * @param data Information about vehicle.
     * @param next Node containing the next element in the list.
     * @return None.
     ********************************************************************/
    public Node(Auto data, Node next) {
        this.data = data;
        this.next = next;
    }

    /*********************************************************************
     * Retrieves the information about a vehicle.
     *
     * @return data Information about vehicle.
     ********************************************************************/
    public Auto getData() {
        return data;
    }

    /*********************************************************************
     * Sets the characteristics of a vehicle.
     *
     * @param data Information to modify vehicle.
     * @return None.
     ********************************************************************/
    public void setData(Auto data) {
        this.data = data;
    }

    /*********************************************************************
     * Sets pointer to next element in list.
     *
     * @return next The next element in the list.
     ********************************************************************/
    public Node getNext() {
        return next;
    }

    /*********************************************************************
     * Sets the data of the next element in the list.
     *
     * @return next Node to set the next element in list to.
     ********************************************************************/
    public void setNext(Node next) {
        this.next = next;
    }
}
