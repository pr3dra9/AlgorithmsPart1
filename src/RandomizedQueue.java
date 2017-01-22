
import edu.princeton.cs.algs4.StdRandom;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {

    private int n = 0;
    private Item[] queue;

    // construct an empty randomized queue
    public RandomizedQueue() {
        queue = (Item[]) new Object[1];
    }

    // is the queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the queue
    public int size() {
        return n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (n == queue.length) {
            resize();
        }
        queue[n++] = item;
    }

    // remove and return a random item
    public Item dequeue() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        int i = StdRandom.uniform(n);

        Item returnItem = queue[i];
        queue[i] = queue[n - 1];
        queue[n - 1] = null;
        n--;
        if (n < queue.length / 4) {
            resize();
        }        
        return returnItem;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (n == 0) {
            throw new NoSuchElementException();
        }
        int i = StdRandom.uniform(n);
        return queue[i];
    }

    // return an independent iterator over items in random order
    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int tail = n;
        private Item[] aux;

        public RandomizedQueueIterator() {
            aux = (Item[]) new Object[n];
            for (int i = 0; i < n; i++) {
                aux[i] = queue[i];
            }
        }

        @Override
        public boolean hasNext() {
            return tail > 0;
        }

        @Override
        public Item next() {
            if (tail == 0) {
                throw new NoSuchElementException();
            }
            int i = StdRandom.uniform(tail);
            Item returnItem = aux[i];
            aux[i] = aux[tail - 1];
            aux[tail - 1] = null;
            tail--;
            return returnItem;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    // unit testing (optional)
    public static void main(String[] args) {
    }

    private void resize() {
        int size = 1;
        if (n > 0) {
            size = n * 2;
        }
        Item[] newArray = (Item[]) new Object[size];
        for (int i = 0; i < n; i++) {
            newArray[i] = queue[i];
        }
        queue = newArray;
    }

}
