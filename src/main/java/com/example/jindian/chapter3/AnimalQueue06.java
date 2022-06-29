package com.example.jindian.chapter3;

import java.util.LinkedList;

//3.6 动物收容所。有家动物收容所只收容狗与猫，且严格遵守“先进先出”的原则。在收
//养该收容所的动物时，收养人只能收养所有动物中“最老”（由其进入收容所的时间长短而定）
//的动物，或者可以挑选猫或狗（同时必须收养此类动物中“最老”的）。换言之，收养人不能自
//由挑选想收养的对象。请创建适用于这个系统的数据结构，实现各种操作方法，比如enqueue、
//dequeueAny、dequeoueDog 和dequeueCat。允许使用Java 内置的LinkedList 数据结构。
public class AnimalQueue06 {
    abstract class Animal{
        private int order;
        protected String name;
        public Animal(String name){
            this.name = name;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isOlderThan(Animal a){
            return this.order <a.order;
        }
    }
    class Cat extends Animal{
        public Cat(String n){
            super(n);
        }
    }
    class Dog extends Animal{
        public Dog(String n){
            super(n);
        }
    }
    LinkedList<Cat> cats = new LinkedList<>();
    LinkedList<Dog> dogs = new LinkedList<>();
    int order = 0;
    public void enqueue(Animal a) {
        a.setOrder(order);
        order++;
        if(a instanceof Cat){
            cats.add((Cat) a);
        }
        if(a instanceof Dog){
            dogs.add((Dog) a);
        }
    }
    public Animal dequeueAny() {
        if(dogs.size() == 0){
          return dequeueCats();
        }else if(cats.size() == 0){
            return dequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();
        if(dog.isOlderThan(cat)){
            return dequeueDogs();
        }else{
            return dequeueCats();
        }
    }
    public Dog dequeueDogs() {
        return dogs.poll();
    }
    public Cat dequeueCats() {
        return cats.poll();
    }
}
