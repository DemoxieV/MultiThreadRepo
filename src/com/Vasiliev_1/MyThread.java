package com.Vasiliev_1;
//Создание потока через интерфейс Runnable
public class MyThread implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <=5; i++) {
            System.out.println("Дочерний поток:\t"+i);
            try{
                Thread.sleep(1200);
            }
            catch (InterruptedException e){
                System.out.println("Прерывание дочернего потока");
            }
        }

    }
}
