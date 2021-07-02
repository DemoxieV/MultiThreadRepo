package com.Shildt_2;
//Использование синхронизированного блока кода для управление доступом к методу
public class MyThreadSync implements Runnable{
    Thread thrd; //Ссылка на поток (объект Thread) хранится в переменной thrd
    static SumArraySync sa=new SumArraySync(); //статический объект для получения суммы массива
    int a[];
    int answer;

    //Создание нового потока (объект Thread) на основе интерфейса и присваивание ему имени
    MyThreadSync(String name, int nums[]){
        thrd=new Thread(this,name);
        a=nums;
    }

    //Создание и запуск потока через фабричный метод
    public static MyThreadSync createAndStart(String name, int nums[]){
        //создаем экземпляр класса MyThreadUpdated
        MyThreadSync myThrd=new MyThreadSync(name, nums);
        //Начало выполнения потока:
        myThrd.thrd.start(); //метод start() вызовет run()
        return myThrd; //возврат переменной экземпляра, когда завершится метод run(), метод start()
    }

    //Точка входа в поток
    @Override
    public void run() { //Запуск потока на выполнение
        int sum;
        System.out.println(thrd.getName()+" - запуск");
       synchronized (sa) {
           answer = sa.sumArray(a);
       }
        System.out.println("Сумма для " + thrd.getName() + " равно " + answer);
        System.out.println(thrd.getName()+" - завершение");
    }
}
