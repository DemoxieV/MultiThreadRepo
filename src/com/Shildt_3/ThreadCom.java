package com.Shildt_3;

public class ThreadCom {
    public static void main(String[] args) {
        TickTock tt=new TickTock();
        //Ошибка в учебнике - стр. 462, не были запущены потоки
        MyThread mt1=MyThread.createAndStart("Tick", tt);
        MyThread mt2=MyThread.createAndStart("Tock", tt);

//        MyThread mt1=new MyThread("Tick", tt);
//        MyThread mt2=new MyThread("Tock", tt);
//
//        mt1.thrd.start();
//        mt2.thrd.start();

        try {
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch(InterruptedException e){
            System.out.println("Прерывание основного потока");
        }

    }
}
