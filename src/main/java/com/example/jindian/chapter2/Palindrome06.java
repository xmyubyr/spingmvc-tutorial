package com.example.jindian.chapter2;
//2.6 回文链表。编写一个函数，检查链表是否为回文。
public class Palindrome06 {
    boolean isPalindrome(LinkedListNode n){
        LinkedListNode nv =reverse(n);
        return isEqual(n,nv);

    }
    LinkedListNode reverse(LinkedListNode node){
        LinkedListNode head = null;
        while(node != null){
            LinkedListNode last = new LinkedListNode(node.data);
            last.next = head;
            head = last;
            node = node.next;
        }
        return head;
    }
    boolean isEqual(LinkedListNode n1,LinkedListNode n2){
        while(n1!= null && n2 !=null){
            if(n1.data != n2.data){
               return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}
