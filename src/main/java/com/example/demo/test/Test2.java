package com.example.demo.test;

import java.util.Iterator;
public class Test2 extends Test{
    public static void main(String[] args) {
        int i = 0;
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        linkedList.add("a1");
        linkedList.add("a2");
        linkedList.add("a3");
        linkedList.add("a4");
        linkedList.add("a5");
        linkedList.add("a6");
        linkedList.add("a7");
        for (String a :
                linkedList) {
            System.out.println(a);
        }
        System.out.println("----------------------------");
        linkedList.remove(1);

        for (String a :
                linkedList) {
            System.out.println(a);
        }
        System.out.println("----------------------------");
        linkedList.add(3, "a3-add");
        for (String a :
                linkedList) {
            System.out.println(a);
        }
        System.out.println("----------------------------");
        Iterator iterator = linkedList.iterator();
        while(iterator.hasNext()){
            iterator.next();
            if(i % 2 == 0)
            iterator.remove();
            i++;
        }
        for (String a :
                linkedList) {
            System.out.println(a);
        }
        System.out.println("----------------------------");
        System.out.println("----------------------------");

    }
}
