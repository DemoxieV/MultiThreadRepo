package com.Shildt_1;

public class ThreadVariations {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        //Создание и запуск потока
        MyThreadUpdated mt = MyThreadUpdated.createAndStart("Порожденный поток №1");


        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Прерывание основного потока");
            }
        }
        System.out.println("Завершение основного потока");
    }
}
