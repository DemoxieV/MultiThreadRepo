package com.Shildt_3;
//!Важно: перенесла инструкции вывода в консоль непосредственно в методы дочернего потока, иначе
// инструкции println() выполняются основным потоком, который не синхронизирован с дочерним "Мой поток".
// Это приводит к состоянию гонки основного и дочернего потоков за ресурс - использование консоли
// Также в методе run каждый цикл счетчик проходит не десятки, а единицы, после любой единицы может вывалиться в wait()
public class Suspend {
    public static void main(String[] args) {
        MyThreadNew mt1=MyThreadNew.createAndStart("Мой поток");

        try{
            Thread.sleep(1000);
            mt1.mysuspend();
            System.out.println("Приостановка потока"); //Было в учебнике, перенесла в методы "Моего потока"
//            Thread.sleep(500);

            mt1.myresume();
            System.out.println("Возобновление потока");
            Thread.sleep(1000);

            mt1.mysuspend();
            System.out.println("Приостановка потока");
//            Thread.sleep(500);

            mt1.myresume();
            System.out.println("Возобновление потока");
            Thread.sleep(1000);

            mt1.mysuspend();
            mt1.mystop();
            System.out.println("Остановка потока");
        }
        catch (InterruptedException e){
            System.out.println("Прерывание основного потока.");
        }

        //Ожидание завершение потока
        try{
            mt1.thrd.join();
        }
        catch (InterruptedException e){
            System.out.println("Прерывание основного потока.");
        }
        System.out.println("Выход из основного потока.");
    }
}
