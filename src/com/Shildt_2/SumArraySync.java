package com.Shildt_2;
//Использование синхронизации для управление доступом
public class SumArraySync {
    private int sum;

    //Метод синхронизирован - может использоваться в каждый момент времени только одним потоком
    synchronized int sumArray(int nums[]){
        sum=0; //обнуление суммы

        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            System.out.println("Текущее значение суммы для "+Thread.currentThread().getName()+" равно "+sum);
            try{
                Thread.sleep(10); //разрешение переключения между задачами
            }
            catch (InterruptedException e){
                System.out.println("Поток прерван");
            }
        }
        return sum;
    }
}
