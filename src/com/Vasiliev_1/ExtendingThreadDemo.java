package com.Vasiliev_1;

public class ExtendingThreadDemo {
    public static void main(String[] args) throws InterruptedException{
        System.out.println("Начинается выполнение программы");
        MyThread2 t=new MyThread2();
        System.out.println("Запускается дочерний поток");
        t.start();
        for (int k = 0; k <= 5; k++) {
            System.out.println("Главный поток:\t"+(char)('A'+k));
            Thread.sleep(2000);
        }
        if(t.isAlive()){
            //Ожидание завершения дочернего потока
            t.join();
        }
        System.out.println("Выполнение программы завершено");
    }
}
