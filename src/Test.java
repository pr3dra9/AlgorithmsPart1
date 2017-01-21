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
}
