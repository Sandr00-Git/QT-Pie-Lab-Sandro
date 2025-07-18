package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QueueTeesTest {

    static class TestCutie implements Cutie {
        private final String desc;
        private final int rating;

        TestCutie(String desc, int rating) {
            this.desc = desc;
            this.rating = rating;
        }

        public String description() {
            return desc;
        }

        public Integer cutenessRating() {
            return rating;
        }
    }

    @Test
    void testBasicEnqueueDequeue() {
        QueueTees queue = new QueueTees();
        Cutie c1 = new TestCutie("Test A", 8);
        Cutie c2 = new TestCutie("Test B", 9);

        queue.enqueue(c1);
        queue.enqueue(c2);

        assertEquals(2, queue.size());
        assertEquals("Test A", queue.dequeue().description());
        assertEquals("Test B", queue.dequeue().description());
        assertEquals(0, queue.size());
    }

    @Test
    void testQueueFull() {
        QueueTees queue = new QueueTees();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new TestCutie("Cutie #" + i, i));
        }
        assertEquals(10, queue.size());

        queue.enqueue(new TestCutie("Overflow", 11)); // Should not be added
        assertEquals(10, queue.size());
    }

    @Test
    void testDequeueEmpty() {
        QueueTees queue = new QueueTees();
        assertNull(queue.dequeue());
    }

    @Test
    void testCircularQueueWrapAround() {
        QueueTees queue = new QueueTees();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(new TestCutie("C" + i, i));
        }
        for (int i = 0; i < 5; i++) {
            queue.dequeue();
        }
        for (int i = 0; i < 5; i++) {
            queue.enqueue(new TestCutie("NewC" + i, i));
        }
        assertEquals(10, queue.size());
    }

    @Test
    void testSizeConsistency() {
        QueueTees queue = new QueueTees();
        assertEquals(0, queue.size());
        queue.enqueue(new TestCutie("One", 1));
        assertEquals(1, queue.size());
        queue.dequeue();
        assertEquals(0, queue.size());
    }
}
