package nus.iss;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


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

        MyRunnableInterface<String> concatenateString = (a, b) -> {
            return a + b;
        };

        MyMessageInterface printString = (a) -> {
            System.out.println(a);
        };


        System.out.println("addOperation: " + addOperation.process(1, 1));
        System.out.println("multiplyOperation: " + addOperation.process(2,5));
        System.out.println("minusOperation: " + addOperation.process(10, 2));
        System.out.println("concatenateString: " + concatenateString.process("The quick brown fox ", "jumps over the wall."));
        printString.printMessage("Let's take a break at 12pm.");

        //list of employees
        List<Employee> employees = new ArrayList<Employee>(); 
        employees.add(new Employee(1, "Adam", "Cheng", 5000)); 
        employees.add(new Employee(2, "Bertram", "Chong", 5000)); 
        employees.add(new Employee(3, "Bernard", "Tan", 5000)); 
        employees.add(new Employee(4, "Kelvin", "Khoo", 5000)); 
        employees.add(new Employee(5, "Donnie", "Yen", 5000)); 
        employees.add(new Employee(6, "Chris", "Cheng", 5000)); 


        employees.forEach(emp -> {
            System.out.println(emp); 
        }); 

        List<Employee> filteredEmployees = employees.stream().filter(emp -> emp.getLastName().contains("Ch"))
        .collect(Collectors.toList()); 
        // filteredEmployees.forEach(emp -> System.out.println(emp));

        // employees.sort(Comparator.comparing(e -> e.getFirstName())); 
        // employees.sort(Comparator.comparing(Employee::getFirstName())); 

        Comparator<Employee> compare = Comparator.comparing(e -> e.getFirstName());
        employees.sort(compare.reversed()); 

        // employees.forEach(emp -> {
        //     System.out.println(emp); 
        // }); 

        //sorting by firstName
        Comparator<Employee> groupByComparator = Comparator.comparing(Employee::getFirstName).thenComparing(Employee::getLastName);
        employees.sort(groupByComparator); 
        employees.forEach(emp -> {
            System.out.println(emp);
        }); 
        




    }
}
