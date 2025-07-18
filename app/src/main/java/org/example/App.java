/*
 * This source file was generated by the Gradle 'init' task
 */
package org.example;

class Puppy implements Cutie {
    public String description() {
        return "A little puppy with big, sad eyes";
    }

    public Integer cutenessRating() {
        return 11;
    }
}

class Kitty implements Cutie {
    public String description() {
        return "A fluffy kitty that purrs all day";
    }

    public Integer cutenessRating() {
        return 9;
    }
}

class PygmyMarmoset implements Cutie {
    public String description() {
        return "A tiny monkey with a funny face";
    }

    public Integer cutenessRating() {
        return 10;
    }
}

public class App {
    public static void main(String[] args) {
        // Create Cutie objects
        Puppy puppy = new Puppy();
        Kitty kitty = new Kitty();
        PygmyMarmoset marmoset = new PygmyMarmoset();

        // Create QueueTees queue
        QueueTees queue = new QueueTees();

        // Check initial size
        System.out.println("Initial queue size: " + queue.size());

        // Enqueue cuties
        queue.enqueue(puppy);
        queue.enqueue(kitty);
        queue.enqueue(marmoset);

        // Check size after enqueue
        System.out.println("Queue size after adding cuties: " + queue.size());

        // Dequeue and print descriptions
        System.out.println("Dequeued: " + queue.dequeue().description());
        System.out.println("Dequeued: " + queue.dequeue().description());
        System.out.println("Dequeued: " + queue.dequeue().description());
    }
}
