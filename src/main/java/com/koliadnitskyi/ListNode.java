package com.koliadnitskyi;

import java.util.Objects;

public class ListNode {
    private final int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void add(int newdata) {
        ListNode newNode = new ListNode(newdata);
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.add(newdata);
        }
    }

    @Override
    public String toString() {
        return "ListNode{" + "data=" + data + ", next=" + next + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return data == listNode.data && Objects.equals(next, listNode.next);
    }
}


