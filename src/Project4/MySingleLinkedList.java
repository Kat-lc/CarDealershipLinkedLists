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
        //  followed by (second) List all Trucks in bought by order.'
        // Case 0: List doesn't exist, tail and top point to new node containing 's'
        if (top == null)
            tail = top = new Node(s, null);
            //Case 1: If 's' is a car
        else if (s instanceof Car) {
            Node temp = top;
            while (temp.getNext() != null && temp.getNext().getData() instanceof Car)
                if (temp.getNext().getData().getBoughtOn().compareTo(s.getBoughtOn()) < 0)
                    temp = temp.getNext();
                else
                    break;
            if (temp == top &&  temp.getData() instanceof Truck)
                top = new Node(s, top);
            else if(temp == top && temp.getData().getBoughtOn().compareTo(s.getBoughtOn()) > 0)
                top = new Node(s, top);
            else
                temp.setNext(new Node(s, temp.getNext()));
            // Case 2: If 's' is a Truck
        } else {
            Node temp = top;
            while(temp.getNext() != null) {
                if(temp.getNext().getData() instanceof Truck && temp.getNext().getData().getBoughtOn().compareTo(s.getBoughtOn()) > 0)
                    break;
                else
                    temp = temp.getNext();
            }
            if(temp == top && temp.getData() instanceof Truck)
                top = new Node(s, top);
            else
                temp.setNext(new Node(s, temp.getNext()));
        }
    }



    public Auto remove(int index) {
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
        Node temp = top;
        for (int i = 0; i < index - 1; i++)
            temp = temp.getNext();

        temp.setNext(temp.getNext().getNext());
        return get(index-1);
    }

    public Auto get(int index) {
        if(top == null)
            return null;
        else if(index < 0 || index >= size())
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

    public void display(){
        Node temp = top;
        System.out.println("------------------------");
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }


}
