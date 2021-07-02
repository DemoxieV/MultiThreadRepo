package com.Shildt_1;
//запускаем несколько потоков и проверяем момент завершения потока
public class MoreThreads {
    public static void main(String[] args) {
        System.out.println("Запуск основного потока");

        MyThreadUpdated mt1=MyThreadUpdated.createAndStart("Порожденный поток №1");
        MyThreadUpdated mt2=MyThreadUpdated.createAndStart("Порожденный поток №2");
        MyThreadUpdated mt3=MyThreadUpdated.createAndStart("Порожденный поток №3");

       do {
            System.out.print(".");
            try{
               Thread.sleep(100);
            }
            catch (InterruptedException e){
                System.out.println("Прерывание основого потока");
            }
            //Ожидание завершения всех потоков
        } while (mt1.thrd.isAlive() || mt2.thrd.isAlive() || mt3.thrd.isAlive());
        System.out.println("Завершение основного потока");
    }
}
