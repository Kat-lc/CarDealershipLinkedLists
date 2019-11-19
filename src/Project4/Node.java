package Project4;

import java.io.Serializable;

public class Node implements Serializable {
    private Auto data;
    private Node next;

    public Node(Auto data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Auto getData() {
        return data;
    }

    public void setData(Auto data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
