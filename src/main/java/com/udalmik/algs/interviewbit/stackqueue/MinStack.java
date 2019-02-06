package com.udalmik.algs.interviewbit.stackqueue;

/*
 * Stack with constant time for "Get Min" operation
 */
public class MinStack {

    private Node head;

    public void push(int x) {
        if (isEmpty()) {
            head = new Node(x, null, x);
        } else {
            Node node = new Node(x, head, Math.min(head.minValue, x));
            head = node;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            head = head.next;
        }
    }

    public int top() {
        if (isEmpty()) {
            return -1;
        } else {
            return head.value;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int getMin() {
        if (isEmpty()) {
            return -1;
        } else {
            return head.minValue;
        }
    }
}

class Node {
    int value;
    Node next;
    int minValue;

    public Node(int value, Node next, int minValue) {
        this.value = value;
        this.next = next;
        this.minValue = minValue;
    }

}
