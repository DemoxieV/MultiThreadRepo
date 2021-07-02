package com.Vasiliev_Labs;
//Класс для создания потоков
public class MyThread extends Thread{
    //Ссылка на объект с целочисленным полем
    private MyNumber obj;
    //Интервал приостановки в выполнении потока
    private int time;
    //Кол-во циклов
    private int count;
    private boolean state;

    //Конструктор
    MyThread(String name, MyNumber obj, int time, int count, boolean state){
        super(name);
        this.obj=obj;
        this.time=time;
        this.count=count;
        this.state=state;
        start();
    }

    //Метод для отображения линии из символов
    private void line(){
        char s;
        if(state) s='-';
        else s='*';
        for (int k = 1; k <=35 ; k++) {
            System.out.print(s);
        }
        System.out.println("");
    }

    @Override
    public void run() {
        for (int k = 1; k <=count; k++) {
            synchronized (obj){
                line();
                System.out.println("Поток "+getName()+": исходное значение "+obj.number);
                try{
                    Thread.sleep(time);
                } catch (InterruptedException e){
                    System.out.println(e);
                }
                //Изменение значения поля объекта
                if(state) obj.number++;
                else obj.number--;
                System.out.println("Поток "+getName()+": новое значение "+obj.number);
                line();
            }
        }
    }
}
