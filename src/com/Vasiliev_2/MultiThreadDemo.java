package com.Vasiliev_2;

public class MultiThreadDemo {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Начинает выполняться главный поток");

        MyThread A=new MyThread("Alpha",5);
        MyThread B=new MyThread("Bravo",3);
        MyThread C=new MyThread("Charlie",7);

        for (int k = 1; k <= 4; k++) {
            System.out.println("Сообщение от главного потока:\t"+k);
            Thread.sleep(2000);
        }
        if(A.isAlive()){
            A.join();
        }
        if(B.isAlive()){
            B.join();
        }
        if(C.isAlive()){
            C.join();
        }
        System.out.println("Главный поток завершен");
    }
}
