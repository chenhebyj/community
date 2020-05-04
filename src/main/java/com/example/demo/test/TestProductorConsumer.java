package com.example.demo.test;


class Clerk{
    public int count;
    public synchronized void product(){
        if(count >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else{
            count++;
            System.out.println(Thread.currentThread().getName()+"生产第"+count+"个商品");
            notifyAll();
        }
    }

    public synchronized void consume(){
        if(count <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }else{

            System.out.println(Thread.currentThread().getName()+"消费第"+count+"个商品");
            count--;
            notifyAll();

        }
    }

}

class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始生产");
        while(true){
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.product();
        }
    }
}
class Consumer implements Runnable{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("开始消费");
        while(true){
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.consume();
        }

    }
}

public class TestProductorConsumer {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        new Thread(new Productor(clerk),"生产1").start();
        new Thread(new Consumer(clerk),"消费1").start();
        new Thread(new Consumer(clerk),"消费2").start();
        new Thread(new Consumer(clerk),"消费3").start();
        new Thread(new Consumer(clerk),"消费4").start();
        new Thread(new Consumer(clerk),"消费5").start();
    }
}
