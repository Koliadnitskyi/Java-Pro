package com.koliadnitskyi;

import lombok.Data;

@Data
public class ListNode {
    private final int data;
    private ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public void add(int newdata) {
        ListNode newNode = new ListNode(newdata);
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.add(newdata);
        }
    }
}


