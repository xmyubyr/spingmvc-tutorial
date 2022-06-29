package com.example.jindian.chapter2;

public class LinkedListNode {
    LinkedListNode next = null;
    int data;
    public LinkedListNode(int d){
        data =d;
    }
    void appendTotail(int d){
        LinkedListNode node = new LinkedListNode(d);
        LinkedListNode n = this;
        while(n.next != null){
            n = n.next;
        }
        n.next= node;
    }
}
