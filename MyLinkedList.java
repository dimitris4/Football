import java.lang.reflect.Array;
import java.util.*;

public class MyLinkedList {
    private MyListNode front;

    //empty constructor
    public MyLinkedList(){
        front = null;
    }

    //returns the size of the linked list
    public int size() {
        int count = 0;
        MyListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }


    // post: appends the given value to the end of the list
    public void add(Player player) {
        if (front == null) {
            front = new MyListNode(player);
        } else {
            MyListNode current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new MyListNode(player);
        }
    }

    //returns the player at the given index in the list
    public Player get(int index) {
        return nodeAt(index).data;
    }

    //post: returns comma-separated, bracketed version of list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            MyListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    //returns the index of the first occurrence of the given value
    public int indexOf(Player element) {
        int index = 0;
        MyListNode current = front;
        while (current != null) {
            if (current.data == element) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    //pre: 0 < = index < size()
    //post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            MyListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    //pre: 0 <= i < size()
    // post: returns a reference to the node at the given index
    private MyListNode nodeAt(int index) {
        MyListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    //returns a linked list of Player objects who have the same given name
    public  MyLinkedList search(String name) {
        MyLinkedList results = new MyLinkedList();
        int count = 0;
        if (front == null) {
            return null;
        }
        MyListNode current = front;
        while (current != null) {
            if (current.data.getFirstName().equalsIgnoreCase(name) || current.data.getLastName().equalsIgnoreCase(name)) {
                results.add(current.data);
            }
            current = current.next;
            count++;
        }
        return results;
    }

    //return a linked list of Player objects who have the same given age
    public MyLinkedList search(int age) {
        MyLinkedList results = new MyLinkedList();
        int count = 0;
        if (front == null) {
            return null;
        }
        boolean found = false;
        MyListNode current = front;
        while (current != null) {
            if (current.data.getAge() == age) {
                results.add(current.data);
            }
            current = current.next;
            count++;
        }
        if (results == null) {
            System.out.println("No results found.");
        }
        return results;
    }

    //returns a linked list of Player objects whose ages fall within a given range
    public MyLinkedList search(int age1, int age2) {
        MyLinkedList results = new MyLinkedList();
        int count = 0;
        if (front == null) {
            return null;
        }
        boolean found = false;
        MyListNode current = front;
        while (current != null) {
            if (current.data.getAge() >= age1 && current.data.getAge() <= age2) {
                results.add(current.data);
            }
            current = current.next;
            count++;
        }
        if (results == null) {
            System.out.println("No results found.");
        }
        return results;
    }

    public Player searchId(int id) {
        MyListNode current = front;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public void sort() {
        //Node current will point to head
        MyListNode current = front;
        MyListNode index;
        Player temp;
        if (front == null) {
            return;
        } else {
            while(current != null) {
                //Node index will point to node next to current
                index = current.next;

                while(index != null) {
                    //If current node's data is greater than index's node data, swap the data between them
                    if(current.data.compareTo(index.data) > 0) {
                        temp = current.data;
                        current.data = index.data;
                        index.data = temp;
                    }
                    index = index.next;
                }
                current = current.next;
            }
        }
    }
}