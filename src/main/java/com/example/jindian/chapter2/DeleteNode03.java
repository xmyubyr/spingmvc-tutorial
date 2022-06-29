package com.example.jindian.chapter2;
//删除中间节点。实现一种算法，删除单向链表中间的某个节点（除了第一个和最后
//一个节点，不一定是中间节点），假定你只能访问该节点。
public class DeleteNode03 {
    boolean deleteNode(LinkedListNode n){

      if(n == null || n.next == null){
          return false;
      }
      LinkedListNode next =n.next;
      n.data = next.data;
      n.next = next.next;
      return true;
    }
}
