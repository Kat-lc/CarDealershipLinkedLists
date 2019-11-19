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
        int count = 0;
        Node temp = top;
        while(temp != null) {
            count++;
            temp = temp.getNext();
        }
        this.size = count;
        return count;
    }

    public void clear () {
        top = null;
        size = 0;
    }

    public void add(Auto s) {
        //  Order is: (First) List all Cars in bought by date order
        //  followed by (second) List all Trucks in bought by order.
        if(top == null)
            tail = top = new Node (s,null);
        else
            top = new Node(s, top);
    }


    public Auto remove(int index) {

        return null;
    }

    public Auto get(int index) {
        if(top == null)
            return null;
        else if(index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        else {
            Node temp = top;
            for(int i = 0; i < index; i++)
                temp = temp.getNext();
            return temp.getData();
        }
    }

    public String toString() {
        String list = "";

        return list;
    }


}
