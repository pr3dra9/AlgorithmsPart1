
import edu.princeton.cs.algs4.StdIn;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Predrag
 */
public class Permutation {

    public static void main(String[] args) {
        int i = Integer.parseInt(args[0]);
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        while (i > 0) {
            i--;
            System.out.println(queue.dequeue());
        }
    }
}
