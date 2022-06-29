package com.example.jindian.chapter2;

import java.util.ArrayDeque;
import java.util.Deque;

//链表求和。给定两个用链表表示的整数，每个节点包含一个数位。这些数位是反向
//存放的，也就是个位排在链表首部。编写函数对这两个整数求和，并用链表形式返回结果。
//示例：
//输入：(7-> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
//输出：2 -> 1 -> 9，即912
//进阶：假设这些数位是正向存放的，请再做一遍。
//示例：
//输入：(6 -> 1 -> 7) + (2 -> 9 -> 5)，即617 + 295
//输出：9 -> 1 -> 2，即912
public class AddList05 {
    public static void main(String[] args) {
        LinkedListNode r1 =new LinkedListNode(7);
        LinkedListNode r2 =new LinkedListNode(1);
        LinkedListNode r3 =new LinkedListNode(6);
        LinkedListNode r4 =new LinkedListNode(5);
        LinkedListNode r5 =new LinkedListNode(9);
        LinkedListNode r6 =new LinkedListNode(2);
        r1.next = r2;
        r2.next =r3;
        r4.next =r5;
        r5.next = r6;
        LinkedListNode r7 = addList2(r1,r4);
        while(r7 != null){
            System.out.println(r7.data);
            r7 = r7.next;
        }
    }
    public static LinkedListNode addList(LinkedListNode p1,LinkedListNode p2){
        LinkedListNode r =new LinkedListNode(0);
        LinkedListNode res = r;
        int count = 0;
        while(true){
            if(p1 == null && p2 == null){
                if(count > 0){
                   r.next = new LinkedListNode(count);
                }
                return res.next;
            }
            int x=0,y=0;
            if(p1 != null){
               x =  p1 !=null ? p1.data : 0;
               p1 = p1.next;
            }
            if(p2!= null){
                y = p2 !=null ? p2.data : 0;
                p2 = p2.next;
            }
            int sum =(x + y +count)%10;
            count = (x+y)/10;
            r.next = new LinkedListNode(sum);
            r = r.next;
        }

    }
    public static LinkedListNode addList2(LinkedListNode p1,LinkedListNode p2){
        Deque<Integer> d1 = new ArrayDeque<>();
        Deque<Integer> d2 = new ArrayDeque<>();
        while(p1 != null){
            int v = p1.data;
            d1.addLast(v);
            p1 = p1.next;
        }
        while(p2 != null){
            int v = p2.data;
            d2.addLast(v);
            p2 = p2.next;
        }
        int carry =0;
        LinkedListNode res = new LinkedListNode(0),node =res;
        while(true){
            if(d1.isEmpty() && d2.isEmpty()){
                if(carry == 1){
                    res.next = new LinkedListNode(carry);
                }
                return node.next;
            }
            int x=0,y=0;
            if(!d1.isEmpty()){
                x = d1.pollFirst();
            }
            if(!d2.isEmpty()){
                y = d2.pollFirst();
            }
            int sum = x+y+carry;
            carry = (x+y)/10;
            LinkedListNode temp = new LinkedListNode(sum%10);
            temp.next = res.next;
            res.next = temp;
        }
    }
}
