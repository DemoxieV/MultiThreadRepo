package com.Shildt_3;
//Приостановка, возобновление и остановка потока
public class MyThreadNew implements Runnable{
    Thread thrd;
    boolean suspended; //Флаг приостановки потока, если true
    boolean stopped; //Флаг остановки потока, если true

    //Конструктор потока
    MyThreadNew(String name){
        thrd=new Thread(this, name);
        suspended=false;
        stopped=false;
    }

    //Фабричный метод (создаем и запускаем поток)
    public static MyThreadNew createAndStart(String name){
        MyThreadNew myThrd=new MyThreadNew(name);
        myThrd.thrd.start();
        return myThrd;
    }

    //Точка входа для потока
    @Override
    public void run() {
        System.out.println(thrd.getName()+" - запуск");
        try {
            for (int i = 1; i < 1000; i++) {
                System.out.print(i+" ");
                if((i%10)==0){
                    System.out.println();
                    Thread.sleep(250);
                }
                //Использование синхронизированного блока кода для проверки значения переменных suspended и stopped
                synchronized (this){
                    while(suspended){
                        wait();
                    }
                    if(stopped) break;
                }
            }
        }
        catch (InterruptedException e){
            System.out.println(thrd.getName()+" - прерван");
        }
        System.out.println(thrd.getName()+" - выход");
    }

    //Остановить поток
    synchronized void mystop(){
        stopped=true;

        //следующие инструкции полностью останавливают приостановленный поток
        suspended=false;
//        System.out.println("Остановка потока");
        notify();
    }

    //Приостановить поток
    synchronized void mysuspend(){
        suspended=true;
//        System.out.println("Приостановка потока");
        notify();
    }

    //Возобновить поток
    synchronized void myresume(){
        suspended=false;
//        System.out.println("Возобновление потока");
        notify();
    }
}
