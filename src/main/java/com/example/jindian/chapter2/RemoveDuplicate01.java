package com.example.jindian.chapter2;

import java.util.HashSet;

//移除重复节点。编写代码，移除未排序链表中的重复节点。
//进阶：如果不得使用临时缓冲区，该怎么解决？
public class RemoveDuplicate01 {
    void deleteDupl(LinkedListNode n){
        HashSet<Integer> set = new HashSet<Integer>();
        LinkedListNode previous = null;
        while(n!=null){
            if(set.contains(n.data)){
                previous.next = n.next;
            }else{
                set.add(n.data);
                previous = n;
            }
            n=n.next;
        }
    }
    void deleteDuplication(LinkedListNode head){
        LinkedListNode current = head;
        while(current != null){
            LinkedListNode runner = current;
            while (runner.next != null){
                if(runner.next.data == current.data){
                    runner.next = runner.next.next;
                }else{
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
