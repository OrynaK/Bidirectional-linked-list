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
        Fabric[] objects = new Fabric[size];
        int index = 0;
        Node curr = head;
        while (curr != null) {
            if (index != size) {
                objects[index] = curr.data;
            }
            curr = curr.next;
            index++;

        }
        return objects;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        int index = 1;
        Node curr = head;
        while (curr != null) {
            res.append("[the result of the invocation toString on the element ").append(index).append("]");
            curr = curr.next;
            index++;
            if (curr != null) {
                res.append(",");
            }
        }
        res.append("}");
        return res.toString();
    }

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
        if (head == null) throw new NoSuchElementException("There are no elements in the list");
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
        if (head == null) throw new NoSuchElementException("There are no elements in the list");
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
        if (head == null) throw new NoSuchElementException("There are no elements in the list");
        return head.data;
    }

    @Override
    public Fabric getLast() {
        if (head == null) throw new NoSuchElementException("There are no elements in the list");
        return tail.data;
    }

    @Override
    public Fabric get(Fabric element) {
        if (head == null) throw new NoSuchElementException("There are no elements in the list");
        Node curr = head;
        while (curr != tail.next) {
            if (curr.data != null) {
                if (curr.data.equals(element)) {
                    return curr.data;
                }
            }
            curr = curr.next;
        }
        return null;
    }

    @Override
    public boolean remove(Fabric element) {
        if (head == null) throw new NoSuchElementException("There are no elements in the list");
        Node curr = head;
        while (curr != null) {
            if (element != null) {
                if (curr.data != null && curr.data.equals(element)) {
                    break;
                }
            } else if (curr.data == null) {
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
            private boolean canRemove = false;

            @Override
            public boolean hasNext() {
                return curr != null;
            }

            @Override
            public Fabric next() {
                if (hasNext()) {
                    Fabric data = curr.data;
                    curr = curr.next;
                    canRemove = true;
                    return data;
                }
                throw new NoSuchElementException();
            }

            @Override
            public void remove() {
                if (canRemove) {
                    Node temp = curr == null ? null : curr.prev;

                    if (temp != null) {
                        if (temp.next != null)
                            temp.next.prev = temp.prev;
                        else
                            temp = temp.prev;


                        if (temp.prev != null)
                            temp.prev.next = temp.next;
                        else
                            head = temp.next;

                    }
                    size--;
                    canRemove = false;
                    return;
                }
                throw new IllegalStateException("Incorrect using method");
            }
        };
        return it;
    }


}
