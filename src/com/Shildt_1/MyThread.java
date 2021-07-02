package com.Shildt_1;
//Создание потока путем реализации интерфейса Runnable
public class MyThread implements Runnable{
    String thrdName;

    MyThread(String name){
        thrdName=name;
    }

    //Точка входа в поток
    @Override
    public void run() { //Запуск потока на выполнение
        System.out.println(thrdName+" - запуск");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("В "+thrdName+ ", счетчик:"+count);
            }
        }
        catch (InterruptedException e){
            System.out.println(thrdName+" - прерван");
        }
        System.out.println(thrdName+" - завершение");
    }
}
