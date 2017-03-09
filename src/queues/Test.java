package queues;


import queues.Deque;
import queues.RandomizedQueue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Predrag
 */
public class Test {
    public static void main(String[] args) {
        //testAddRemove();
        //testIterator();
        //testAddRemoveRQ();
        //testAddRemoveRQ2();
        //testIteratorRQ();
        test();
    }
    
    static void testAddRemove() {
        Deque<String> d = new Deque<>();
        d.addLast("4");
        d.addLast("5");
        d.addLast("6");
        d.addFirst("1");
        d.addFirst("1.2");
        d.addFirst("1.3");
        while (!d.isEmpty()) {
            System.out.println(d.removeLast());
        }
        System.out.println("");
    }

    static void testAddRemoveRQ() {
        RandomizedQueue<String> d = new RandomizedQueue<>();
        d.enqueue("1");
        d.enqueue("2");
        d.enqueue("3");
        d.enqueue("4");
        d.enqueue("5");
        d.enqueue("6");
        while (!d.isEmpty()) {
            System.out.println(d.dequeue());
        }
        System.out.println("");
    }

    static void testAddRemoveRQ2() {
        RandomizedQueue<String> d = new RandomizedQueue<>();
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.enqueue("1");
        d.dequeue();
        
        while (!d.isEmpty()) {
            System.out.println(d.dequeue());
        }
        System.out.println("");
    }
    
    static void testIterator() {
        Deque<String> d = new Deque<>();
        d.addLast("4");
        d.addLast("5");
        d.addLast("6");
        d.addFirst("1");
        d.addFirst("1.2");
        d.addFirst("1.3");
        for (String d1 : d) {
            System.out.println(d1);
        }
        System.out.println("-------------");
        for (String d1 : d) {
            System.out.println(d1);
        }
        System.out.println("-------------");
        for (String d1 : d) {
            System.out.println(d1);
        }
        
    }

    static void testIteratorRQ() {
        RandomizedQueue<String> d = new RandomizedQueue<>();
        d.enqueue("1");
        d.enqueue("2");
        d.enqueue("3");
        d.enqueue("4");
        d.enqueue("5");
        d.enqueue("6");
        for (String d1 : d) {
            System.out.println(d1);
        }
        System.out.println("-------------");
        for (String d1 : d) {
            System.out.println(d1);
        }
        System.out.println("-------------");
        for (String d1 : d) {
            System.out.println(d1);
        }
        
    }

    
    static void test() {
        RandomizedQueue<String> rq = new RandomizedQueue<>();
         rq.enqueue("OERRFSXAMI");
         rq.dequeue();//     ==> "OERRFSXAMI"
         rq.enqueue("GFSUQHRTIR");
         rq.enqueue("RGKEBJSXTD");
         rq.sample();//      ==> "RGKEBJSXTD"
         rq.enqueue("GHHRDARSSX");
         rq.dequeue();//     ==> "RGKEBJSXTD"
         rq.sample();//      ==> "GFSUQHRTIR"
         rq.dequeue();//     ==> "GFSUQHRTIR"
         rq.dequeue();//     ==> "GHHRDARSSX"
         rq.enqueue("HNNATOJIDK");
    }
}
