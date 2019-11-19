package Project4;

import java.io.Serializable;

public class MySingleLinkedList implements Serializable
{
    private Node top;
    private Node tail;
    public int size;

    public MySingleLinkedList() {
        top = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public void clear () {
        top = null;
        size = 0;
    }

    public void add(Auto s) {
        //  Order is: (First) List all Cars in bought by date order
        //  followed by (second) List all Trucks in bought by order.
        

    }


    public Auto remove(int index) {

        return null;
    }

    public Auto get(int index) {

        return null;
    }

    public String toString() {
        return null;
    }


}
