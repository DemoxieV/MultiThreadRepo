package com.Vasiliev_1;

public class CreatingThreadDemo {
    //Главный поток
    public static void main(String[] args) {
        System.out.println("Начинается выполнение программы");

        //Создание объекта класса Thread для запуска дочернего потока на выполнение
        Thread t=new Thread(new MyThread());
        System.out.println("Запускается дочерний поток");

        t.start();
        for (int k = 0; k <=5; k++) {
            System.out.println("Главный поток:\t"+(char)('A'+k));
            try{
                Thread.sleep(2000);
            }
            catch (InterruptedException e){
                System.out.println("Прерывание главного потока");
            }
        }
        System.out.println("Выполнение программы завершено");
    }
}
