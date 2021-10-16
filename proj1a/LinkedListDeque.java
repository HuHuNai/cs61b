public class LinkedListDeque<T> {
    private class Node {
        public T value;
        public Node next = null;
        public Node previous = null;

        public Node(T value) {
            this.value = value;
        }
    }

    private Node head;
    private int size;

    public LinkedListDeque() {
        head = new Node(null);
        head.next = head;
        head.previous = head;
        size = 0;
    }

    public void addFirst(T value) {
        Node c = new Node(value);
        Node n = head.next;
        head.next = c;
        c.previous = head;
        head.next = n;
        n.previous = c;
        size += 1;
    }

    public void addLast(T value) {
        Node c = new Node(value);
        Node p = head.previous;
        c.next = head;
        head.previous = c;
        c.previous = p;
        p.next = c;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node c = head.next;
        while (c.next != head) {
            System.out.print(c.value + " ");
        }
    }

    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        Node c = head.next;
        Node n = c.next;
        head.next = n;
        n.previous = head;
        size-=1;
        return c.value;
    }

    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        Node c = head.previous;
        Node p = c.previous;
        head.previous = p;
        p.next = head;
        size-=1;
        return c.value;
    }

    public T get(int index) {
        T out = null;
        if (index < size / 2 && index >= 0) {
            Node c = head;
            for (int count = -1; count < index; count++) {
                c = c.next;
            }
            out = c.value;
        }
        if (index >= size / 2 && index >= 0&&index<size) {
            Node c = head;
            index = size - 1 - index;
            for (int count = -1; count < index; count++) {
                c = c.next;
            }
        }
        return out;
    }
    private T helper(Node c,int index){
        T out=null;
        if (index<size&&index>=0){
            int count=-1;
            if (count==index){
                out=c.value;
            }
            else{
                c=c.next;
                count++;

            }
        }
        return out;
    }
    public T getRecursive(int index){
        return helper(head,index);
    }
}
