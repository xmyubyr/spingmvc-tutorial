package com.example.jindian.chapter2;
//链表相交。给定两个（单向）链表，判定它们是否相交并返回交点。请注意相交的
//定义基于节点的引用，而不是基于节点的值。换句话说，如果一个链表的第k 个节点与另一个
//链表的第j 个节点是同一节点（引用完全相同），则这两个链表相交。
public class InterSection07 {
    int getLength(LinkedListNode n){
        int len = 0;
        while(n != null){
           len++;
           n=n.next;
        }
        return len;
    }
    LinkedListNode findInterSection(LinkedListNode headA,LinkedListNode headB){
        LinkedListNode l =headA;
        LinkedListNode s =headB;
        int len1= getLength(l);
        int len2= getLength(s);
        int len =len1 - len2;
        if(len <0){
            l = headB;
            s = headA;
        }else{
            s = headB;
            l = headA;
        }
        while(len != 0){
            len--;
            l = l.next;
        }
        while(l != s){
           l= l.next;
           s= s.next;
        }
        return l;
    }
}
