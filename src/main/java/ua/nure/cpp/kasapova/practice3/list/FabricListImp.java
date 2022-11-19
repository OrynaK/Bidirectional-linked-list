package ua.nure.cpp.kasapova.practice3.list;

import org.jetbrains.annotations.NotNull;
import ua.nure.cpp.kasapova.practice3.entity.Fabric;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class FabricListImp implements FabricList {
    static class Node {
        Node next;
        Node prev;
        Fabric data;

        public Node(Fabric element) {
            this.data = element;
            this.next = null;
            this.prev = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;


    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object toArray() {
        return new Fabric[0];
    }

//    @Override
//    public String toString() {
//        String result = "{";
//        int index = 1;
//        Node current = head;
//        while (current != null){
//            result += "[the result of the invocation toString on the element " + index + "]";
//
//            index++;
//            current = current.next;
//
//            if (current != null){
//                result += ",";
//            }
//        }
//        result += "}";
//        return result;
//    }

    @Override
    public void addFirst(Fabric element) {
        Node node = new Node(element);

        if (head == null) tail = node;
        else head.prev = node;

        node.next = head;
        head = node;
        size++;
    }

    @Override
    public void addLast(Fabric element) {
        Node node = new Node(element);
        if (head == null) head = node;
        else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    @Override
    public boolean removeFirst() {
        if (head == null) throw new NoSuchElementException();
        if (head != tail) {
            head = head.next;
            head.prev = null;
        } else {
            head = tail = null;
        }
        size--;
        return true;
    }

    @Override
    public boolean removeLast() {
        if (head == null) throw new NoSuchElementException();
        if (head != tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            tail = head = null;
        }
        size--;
        return true;
    }

    @Override
    public Fabric getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.data;
    }

    @Override
    public Fabric getLast() {
        if (head == null) throw new NoSuchElementException();
        return tail.data;
    }

    @Override
    public Fabric get(Fabric element) {
        if (head == null) throw new NoSuchElementException();
        Node curr = head;
        while (curr != null) {
            if (curr.data.equals(element)) {
                return curr.data;
            }
            curr = curr.next;
        }
        return null;
    }

    @Override
    public boolean remove(Fabric element) {
        if (head == null) throw new NoSuchElementException();
        Node curr = head;
        while (curr != null) {
            if (curr.data.equals(element)) {
                break;
            }
            curr = curr.next;
        }
        if (curr != null) {
            if (curr.next != null)
                curr.next.prev = curr.prev;
            else
                tail = curr.prev;


            if (curr.prev != null)
                curr.prev.next = curr.next;
            else
                head = curr.next;
            size--;
            return true;
        }
        return false;

    }

    @NotNull
    @Override
    public Iterator<Fabric> iterator() {
        Iterator<Fabric> it = new Iterator<Fabric>() {
            private Node curr = head;

            @Override
            public boolean hasNext() {
                return curr.next != null;
            }

            @Override
            public Fabric next() {
                if (hasNext()) {
                    Fabric data = curr.data;
                    curr = curr.next;
                    return data;
                }
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {

            }
        };
        return it;
    }


}
