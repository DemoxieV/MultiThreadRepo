package com.Shildt_3;
//переделанный пример - синхронизация основного и дочернего потоков
public class Suspend2 {
    public static void main(String[] args) {
        MyThreadNew mt1=MyThreadNew.createAndStart("Мой поток");
        Thread mainThrd=Thread.currentThread();

        try{
            mainThrd.sleep(1000);
            mt1.mysuspend();
            mainThrd.setName("Главный поток. Приостановка Моего потока");
            synchronized (System.out) {
                System.out.println(mainThrd.getName());
            }
            mainThrd.sleep(1000);

            mt1.myresume();
            mainThrd.setName("Главный поток. Возобновление Моего потока");
            synchronized (System.out) {
                System.out.println(mainThrd.getName());
            }
            mainThrd.sleep(1000);

            mt1.mysuspend();
            mainThrd.setName("Главный поток. Приостановка Моего потока");
            synchronized (System.out) {
                System.out.println(mainThrd.getName());
            }
//            mainThrd.sleep(1000);

            mt1.myresume();
            mainThrd.setName("Главный поток. Возобновление Моего потока");
            synchronized (System.out) {
                System.out.println(mainThrd.getName());
            }
            mainThrd.sleep(1000);


            mt1.mysuspend();
            mt1.mystop();
            mainThrd.setName("Главный поток. Остановка Моего потока");
            synchronized (mainThrd) {
                System.out.println(mainThrd.getName());
            }
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
