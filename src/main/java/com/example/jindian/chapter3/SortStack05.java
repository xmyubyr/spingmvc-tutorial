package com.example.jindian.chapter3;

import java.util.Stack;

//3.5 栈排序。编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临
//时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：push、
//pop、peek 和isEmpty。
public class SortStack05 {
    void sort(Stack<Integer> stack){
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()){
            int t = stack.pop();
            while(!temp.isEmpty() && temp.peek()>t){
                stack.push(temp.pop());
            }
            temp.push(t);
        }
        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
    }
}
