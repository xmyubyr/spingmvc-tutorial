package com.example.jindian.chapter2;
//返回倒数第k 个节点。实现一种算法，找出单向链表中倒数第k 个节点。
//经典思路，就是用两个指针，两个指针的位置差k,当一个慢的那个走到终点的时候，另一个自然是在倒数k的位置了。
public class NthToLast02 {
    LinkedListNode nthToLast(LinkedListNode head,int k){
        LinkedListNode p1 =head;
        LinkedListNode p2 =head;
        for(int i=0;i<k;i++){
            p1 = p1.next;
        }
        while(p1 != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
