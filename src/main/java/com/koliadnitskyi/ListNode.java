package com.koliadnitskyi;

import lombok.Data;

@Data
public class ListNode {
    private final int data;
    private ListNode next;

    public void add(int newData) {
        ListNode newNode = new ListNode(newData);
        if (this.next == null) {
            this.next = newNode;
        } else {
            this.next.add(newData);
        }
    }
}


