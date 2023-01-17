package nus.iss;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App 
{
    public static void main( String[] args )
    {
        // Thread thread1 = new Thread(new Runnable() {
        //     @Override 
        //     public void run(){
        //         for (int i = 0; i < 5; i++){
        //             System.out.println(Thread.currentThread().getName() + "\tRunnable ..." + i);
        //         }
        //     }

        // }); 
        // thread1.start(); 

        MyRunnableImplementation mRI = new MyRunnableImplementation("task1"); 
        MyRunnableImplementation mRI2 = new MyRunnableImplementation("task2"); 
        MyRunnableImplementation mRI3 = new MyRunnableImplementation("task3"); 
        MyRunnableImplementation mRI4 = new MyRunnableImplementation("task4"); 
        MyRunnableImplementation mRI5 = new MyRunnableImplementation("task5"); 

        ////running using the thread
        // Thread thread2 = new Thread(mRI); 
        // thread2.start(); 

        // Thread thread3 = new Thread(mRI); 
        // thread3.start(); 

        // //using the executor service to run the thread, running with an executor service allows you to use the thread pool, this is a single Thread executor means 1 counter
        // ExecutorService executorService = Executors.newSingleThreadExecutor(); 
        // executorService.execute(mRI); 
        // executorService.execute(mRI2);
        // executorService.shutdown(); 

        // //new fixed thread pool means you have 3 counters
        // ExecutorService executorService = Executors.newFixedThreadPool(3); 
        // executorService.execute(mRI); 
        // executorService.execute(mRI2);
        // executorService.execute(mRI3);
        // executorService.execute(mRI4);
        // executorService.execute(mRI5);
        // executorService.shutdown(); 

        ExecutorService executorService = Executors.newCachedThreadPool(); 
        executorService.execute(mRI); 
        executorService.execute(mRI2);
        executorService.execute(mRI3);
        executorService.execute(mRI4);
        executorService.execute(mRI5);
        executorService.shutdown(); 

        MyRunnableInterface<Integer> addOperation = (a, b) -> {
            return a + b; 
        }; 

        MyRunnableInterface<Integer> multiplyOperation = (a, b) -> {
            return a * b; 
        }; 

        MyRunnableInterface<Integer> minusOperation = (a, b) -> {
            return a - b; 
        }; 

        System.out.println("addOperation: " + addOperation.process(1, 1));
        System.out.println("multiplyOperation: " + addOperation.process(1,1));
        System.out.println("minusOperation: " + addOperation.process(1, 1));


    }
}
