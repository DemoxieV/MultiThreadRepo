package com.Shildt_1;

public class UseThreads {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        //Сначала создаем объект типа MyThread
        MyThread mt=new MyThread("Порожденный поток №1");

        //Затем сформируем поток на основе этого объекта
        Thread newThrd=new Thread(mt);

        //Начинаем выполнение потока - запуск на выполнение:
        newThrd.start();

        //После вызова start() управление возвращается методу main(), где начинается выполнение for-цикла

        for (int i = 0; i < 50; i++) {
            System.out.print(".");
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){
                System.out.println("Прерывание основного потока");
            }
        }
        System.out.println("Завершение основного потока");
    }
}
