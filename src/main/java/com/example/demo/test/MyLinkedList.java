package com.example.demo.test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<AnyType> implements Iterable<AnyType> {
    private int theSize;
    private int modCount = 0;
    private Node<AnyType> beginMarker;
    private Node<AnyType> endMarker;

    public MyLinkedList(){
        doClear();
    }


    public void clear(){
        doClear();
    }
    public void doClear(){
        beginMarker = new Node<AnyType>(null, null, null);
        endMarker = new Node<AnyType>(null, beginMarker, null);
        beginMarker.next = endMarker;

        theSize = 0;
        modCount++;
    }




    public int size(){
        return theSize;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    //增
    public boolean add(AnyType x){
        add(size(), x);
        return true;
    }

    public void add(int idx, AnyType x){
        addBefore(getNode(idx, 0, size()), x);
    }
    //删
    public AnyType remove(int idx){
        return remove(getNode(idx));
    }

    //改
    public AnyType set(int idx, AnyType newVal){
        Node<AnyType> p = getNode(idx);
        AnyType oldVal = p.data;
        p.data = newVal;
        return oldVal;
    }


    //查
    public AnyType get(int idx){
        return getNode(idx).data;
    }


    //私有方法部分
    private void addBefore(Node<AnyType> p, AnyType x){
        Node<AnyType> newNode = new Node<>(x, p.prev, p);
        newNode.prev.next = newNode;
        p.prev = newNode;
        theSize++;
        modCount++;
    }
    private AnyType remove(Node<AnyType> p){
        p.next.prev = p.prev;
        p.prev.next = p.next;
        theSize--;
        modCount++;

        return p.data;
    }

    //获取Node
    private Node<AnyType> getNode(int idx){
        return getNode(idx, 0, size() - 1);
    }
    //lower,upper链表的范围
    private Node<AnyType> getNode(int idx, int lower, int upper){
        Node<AnyType> p;
        if(idx < lower || idx > upper)
            throw new IndexOutOfBoundsException();

        if(idx < size() / 2){
            p = beginMarker.next;
            for(int i = 0; i < idx; i++)
                p = p.next;
        }else {
            p = endMarker;
            for(int i = size(); i > idx; i--)
                p = p.prev;
        }
        return p;
    }



    //链表的结点Node
    private static class Node<AnyType>{
        public AnyType data;
        public Node<AnyType> prev;
        public Node<AnyType> next;

        public Node(AnyType d, Node<AnyType> p, Node<AnyType> n){
            data = d;
            prev = p;
            next = n;
        }
    }




    //迭代器
    public Iterator iterator(){
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator<AnyType>{
        private Node<AnyType> current = beginMarker.next;
        private int expectedModCount = modCount;
        private boolean okToRemove = false;

        @Override
        public boolean hasNext() {
            return current != endMarker;
        }

        @Override
        public AnyType next() {
           if(modCount != expectedModCount)
               throw new ConcurrentModificationException();
           if(!hasNext())
               throw new NoSuchElementException();

           AnyType nextItem = current.data;
           current = current.next;
           okToRemove = true;//能否删除的标志位，只有使用iterator调用next()之后才能删除
           return nextItem;

        }

        public void remove(){
            if(modCount != expectedModCount)
                throw new ConcurrentModificationException();
            if(!okToRemove)
                throw new IllegalStateException();

            MyLinkedList.this.remove(current.prev);
            expectedModCount++;
            okToRemove = false;
        }
    }





    
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
