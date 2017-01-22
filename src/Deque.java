
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

    private int size;
    private Node<Item> first;
    private Node<Item> last;

    // construct an empty deque
    public Deque() {
        size = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> newNode = new Node<>(item);
        newNode.next = first;
        if (size == 0) {
            last = newNode;

        } else {
            first.previous = newNode;
        }
        first = newNode;
        size++;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        Node<Item> newNode = new Node<>(item);
        if (size == 0) {
            first = newNode;
        } else {
            last.next = newNode;
        }
        newNode.previous = last;
        last = newNode;
        size++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<Item> returnNode = first;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            first.next.previous = null;
            first = first.next;
        }
        size--;
        return returnNode.item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<Item> returnNode = last;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last.previous.next = null;
            last = last.previous;
        }
        size--;
        return returnNode.item;
    }

    // return an iterator over items in order from front to end
    @Override
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class Node<Item> {

        private Node<Item> next;
        private Node<Item> previous;
        private Item item;

        public Node(Item item) {
            this.item = item;
        }
    }

    private class DequeIterator implements Iterator<Item> {

        private Node<Item> next = first;

        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public Item next() {
            if (next == null) {
                throw new NoSuchElementException();
            }

            Item item = next.item;
            next = next.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    // unit testing (optional)
    public static void main(String[] args) {

    }

}
