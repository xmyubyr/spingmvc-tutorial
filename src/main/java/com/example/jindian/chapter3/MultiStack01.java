package com.example.jindian.chapter3;
//3.1 三合一。描述如何只用一个数组来实现三个栈。
public class MultiStack01{
    private int numberOfStacks = 3;
    private int stackCapacity;
    private int[] sizes;
    private int[] values;
    public MultiStack01(int stackSize){
        stackCapacity = stackSize;
        sizes = new int[numberOfStacks];
        values = new int[stackSize * numberOfStacks];
    }
    public void push(int stackNum, int value) throws Exception {
        if (isFull(stackNum)){
            throw new Exception();
        }
        sizes[stackNum] ++;
        values[indexOfTop(stackNum)] = value;
    }
    public int pop(int stackNum) throws Exception {
        if (isEmpty(stackNum)){
            throw new Exception();
        }
        int topindex = indexOfTop(stackNum);
        int value = values[topindex];
        values[topindex] = 0;
        sizes[stackNum] --;
        return value;
    }
    public int peek(int stackNum) throws Exception {
        if (isFull(stackNum)){
            throw new Exception();
        }
        return values[stackNum];
    }
    public  int indexOfTop(int stackNum){
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size -1;
    }
    public boolean isEmpty(int stackNum){
        return sizes[stackNum] == 0;
    }
    public boolean isFull(int stackNum){
        return sizes[stackNum] == stackCapacity;
    }
}
