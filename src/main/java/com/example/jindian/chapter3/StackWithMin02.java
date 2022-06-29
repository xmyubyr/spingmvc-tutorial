package com.example.jindian.chapter3;

import java.util.Stack;

//3.2 栈的最小值。请设计一个栈，除了pop 与push 函数，还支持min 函数，其可返回栈
//元素中的最小值。执行push、pop 和min 操作的时间复杂度必须为O (1)。
public class StackWithMin02 extends Stack<Integer> {
    Stack<Integer> s;
    StackWithMin02(){
        s = new Stack();
    }
    public void push(int value){
        if(value <= min()){
            s.push(value);
        }
        super.push(value);
    }
    public Integer pop(){
        int value = super.pop();
        if(value == min()){
            s.pop();
        }
        return value;
    }
    public int min(){
        if(s.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return s.peek();
        }
    }
}
