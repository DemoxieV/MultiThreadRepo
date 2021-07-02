package com.Shildt_1;

public class MyThreadUpdated implements Runnable{
    Thread thrd; //Ссылка на поток (объект Thread) хранится в переменной thrd

    //Создание нового потока (объект Thread) на основе интерфейса и присваивание ему имени
    MyThreadUpdated(String name){
        thrd=new Thread(this,name); //Имя потока присваивается при его создании
    }

    //Создание и запуск потока через фабричный метод
    public static MyThreadUpdated createAndStart(String name){
        //создаем экземпляр класса MyThreadUpdated, куда передаем имя потока
        MyThreadUpdated myThrd=new MyThreadUpdated(name);
        //Начало выполнения потока:
        myThrd.thrd.start(); //метод start() вызовет run()
        return myThrd; //возврат переменной экземпляра, когда завершится метод run(), метод start()
    }

    //Точка входа в поток
    @Override
    public void run() { //Запуск потока на выполнение
        System.out.println(thrd.getName()+" - запуск");
        try {
            for (int count = 0; count < 10; count++) {
                Thread.sleep(400);
                System.out.println("В "+thrd.getName()+ ", счетчик:"+count);
            }
        }
        catch (InterruptedException e){
            System.out.println(thrd.getName()+" - прерван");
        }
        System.out.println(thrd.getName()+" - завершение");
    }
}
