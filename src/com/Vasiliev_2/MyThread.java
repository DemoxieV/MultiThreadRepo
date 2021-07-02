package com.Vasiliev_2;
import java.util.Random;
public class MyThread extends Thread{
    private int count; //кол-во сообщений

    MyThread(String name, int count){
        super(name);
        this.count=count;
        start();
    }

    @Override
    public void run() {
        System.out.println("Выполняется поток "+getName());
        //Создание объекта класса для генерирования случайных чисел
        Random rnd=new Random();
        for (int k = 1; k <= count; k++) {
            System.out.println("Сообщение от потока "+getName()+":\t"+getName().charAt(0)+k);
            try {
                Thread.sleep(1000+rnd.nextInt(2001));
            }catch (InterruptedException e){
                System.out.println("Прерывание потока "+getName());
            }
        }
        System.out.println("Поток "+getName()+" завершен");
    }
}
