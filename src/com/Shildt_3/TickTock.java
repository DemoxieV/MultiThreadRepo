package com.Shildt_3;
//Использование методов wait() и notify() для имитации часов
public class TickTock {
    String state; //сведения о состоянии часов

    synchronized void tick(boolean running) {
        if (!running) { //остановить часы
            state = "ticked";
            notify(); //уведомить ожидающие потоки
            return;
        }
        System.out.print("Tick ");

        state = "ticked"; //установить текущее состояние после такта "тик"
        notify(); //позволить выполниться методу tock() - метод tick() посылает уведомление методу tock()
        try{
            while(!state.equals("tocked"))
                wait(); //метод tick() ожидает завершения метода tock()
        }
        catch (InterruptedException e){
            System.out.println("Прерывание потока");
        }
    }

        synchronized void tock (boolean running){
            if (!running) { //остановить часы
                state = "tocked";
            notify(); //уведомить ожидающие потоки
                return;
            }
            System.out.println("Tock");

            state = "tocked"; //установить текущее состояние после такта "так"
        notify(); //позволить выполниться методу tick() - метод tock() посылает уведомление методу tick()
        try{
            while(!state.equals("ticked"))
                wait(); //метод tock() ожидает завершения метода tick()
        }
        catch (InterruptedException e){
            System.out.println("Прерывание потока");
        }
    }
}