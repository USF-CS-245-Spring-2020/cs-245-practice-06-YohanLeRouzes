
import java.util.*;

public class LinkedList<T> implements List<T> {
    Node head; //Defining the head of the Node
    int size; //Defining the size of the list

    private class Node {
        T num; //Object T is num
        Node next; //next Node
        public Node(T item) {
            this.num = item; //num becomes the value of item
            this.next = null; //The next value is null
        }
    }

    public LinkedList() {
        this.head = new Node(null); //head is a new Node
        this.size = 0; //The size of the list is initially 0
    }

    public void add(T item) { //Add element to the list
        if(head.num == null) { //if the list is empty
            head = new Node(item);//head becomes a new Node with value item
            size++; //size increments
        }
        else { //else 
            Node node = new Node(item); //A new node is created with value item
            Node previous = head; //The previous element becomes the head
            for(int i=0; i<size-1; i++) { //The element takes the value of the next element
                previous = previous.next;
            }
            previous.next = node;
            size++; //size increments
        }
    }

    public void add(int pos, T item) { //Add element at position pos
        if(pos == 0) { //if the pos is 0
            Node node = new Node(item); //A new node with value item is added
            node.next = head; //The next node becomes the head
            head = node; //The head take the value of the new element
            size++; //The size increments
        }
        else { //else
            Node previous = head; //The previous Node takes the value of head
            for(int i = 0; i < pos ; i++) { //every element takes the value of the next element
                previous = previous.next;
            }
            Node node = new Node(item); //Creates a new Node with value item
            node.next = previous.next; //The current Node takes the value of the previous one
            previous.next = node;
            size++; //Size increments
        }
    }

    public T remove(int pos) { //Remove the element at position pos
        if(pos >= size || pos < 0) { //If the pos is out of bound, throw exception
            throw new IndexOutOfBoundsException();
        }
        if(pos == 0) { //If pos is the first element of the list
            Node node = head;//The node takes the value of head
            head = head.next;//The head becomes the next element of the list
            size--; //size decrements
            return node.num; //Return the value of the removed element
        }
        Node previous = head; //The previous element becomes the head
        for(int i = 0; i < pos; i++)//For every element, the previous Node takes the value of the next
            previous = previous.next;
        Node node = previous.next; //The current node takes value of the next node
        previous.next = node.next;
        size--;//size decrements
        return node.num;//Return the value of the removed node
    }

    public T get(int pos) { //Get the value of the element at position pos
        Node current = head; //Current node is defined as head
        int counts = 0;

        if(pos < 0 || pos > size-1) { //If pos is out of bound, throw exception
            throw new IndexOutOfBoundsException();
        }
        else { //else
            while(current!=null) { //While the current node is empty
                if(counts == pos) { //if count is equal to the position asked
                    return current.num; //return the value num of the node
                }
                counts++; //Increment counts
                current = current.next; //The current node is set to the next node
            }
        }
        return null; //return null if nothing is found
    }

    public int size() { //Returns the size of the list
        return size;
    }
}