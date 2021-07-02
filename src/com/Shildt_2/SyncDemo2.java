package com.Shildt_2;

public class SyncDemo2 {
    public static void main(String[] args) {
        int a[]={1,2,3,4,5};
        MyThreadSync mt1=MyThreadSync.createAndStart("Порожденный поток №1",a);
        MyThreadSync mt2=MyThreadSync.createAndStart("Порожденный поток №2",a);

        try{
            mt1.thrd.join();
            mt2.thrd.join();
        }
        catch (InterruptedException e){
            System.out.println("Прерывание основного потока");
        }
    }
}
