package ss11_dsa_stack_queue.practice.deploy_queue_using_linkedlist.controller;

import ss11_dsa_stack_queue.practice.deploy_queue_using_linkedlist.model.MyLinkedListQueue;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue = new MyLinkedListQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        System.out.println("Dequeued item is " + queue.dequeue().key);
    }
}
