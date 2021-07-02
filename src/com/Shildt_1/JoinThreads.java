package com.Shildt_1;

public class JoinThreads {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        MyThreadUpdated mt1=MyThreadUpdated.createAndStart("Порожденный поток №1");
        MyThreadUpdated mt2=MyThreadUpdated.createAndStart("Порожденный поток №2");
        MyThreadUpdated mt3=MyThreadUpdated.createAndStart("Порожденный поток №3");

        try{
            mt1.thrd.join();
            System.out.println("Порожденный поток №1 - присоединен");
            mt2.thrd.join();
            System.out.println("Порожденный поток №2 - присоединен");
            mt3.thrd.join();
            System.out.println("Порожденный поток №3 - присоединен");
        }
        catch (InterruptedException e){
            System.out.println("Прерывание основого потока");
        }
        System.out.println("Завершение основного потока");
    }
}
