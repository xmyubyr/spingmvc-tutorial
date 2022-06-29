package com.example.jindian.chapter2;
//2.8 环路检测。给定一个有环链表，实现一个算法返回环路的开头节点。
//有环链表的定义：在链表中某个节点的next 元素指向在它前面出现过的节点，则表明该
//链表存在环路。
public class Circle08 {
    public static void main(String[] args) {
        LinkedListNode r1 =new LinkedListNode(1);
        LinkedListNode r2 =new LinkedListNode(2);
        LinkedListNode r3 =new LinkedListNode(3);
        LinkedListNode r4 =new LinkedListNode(4);
        LinkedListNode r5 =new LinkedListNode(5);
        LinkedListNode r6 =new LinkedListNode(6);
        r1.next = r2;
        r2.next =r3;
        r3.next = r4;
        r4.next =r5;
        r5.next = r6;
        r6.next = r2;
        LinkedListNode n = checkCircle(r1);
        System.out.println(checkCircle(r1).data);
    }
    static LinkedListNode checkCircle(LinkedListNode head){
        LinkedListNode slow = head;
        LinkedListNode fast = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow ==fast){
                break;

            }
        }
        slow = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
