package com.Vasiliev_2;
//Работа с демон-потоком. Задача на вычисление суммы натуральных чисел

import static javax.swing.JOptionPane.*;
public class DaemonThreadDemo {
    public static void main(String[] args) throws InterruptedException{
        //Создание объекта для дочернего потока.
        // Первый аргумент контструктора - лямбда-выражение, второй - название потока
        Thread t=new Thread(()->{
            int k=1,s=0; //Индексная переменная для записи суммы чисел
            while (true){ //Бесконечный цикл для вычисления суммы
                System.out.println(Thread.currentThread().getName()+": "+s);
                try{
                    Thread.sleep(1000);
                }
                catch (InterruptedException e){}
                s+=k;
                k++;
            }
        },"Вычисление суммы");
        t.setDaemon(true); //статус демон-потока
        int res;
        t.start();
        do{
            Thread.sleep(3000);
            res=showConfirmDialog(null, "Закончить вычисление суммы?", "Сумма чисел", YES_NO_OPTION);
        }while(res!=YES_OPTION);
    }
}
