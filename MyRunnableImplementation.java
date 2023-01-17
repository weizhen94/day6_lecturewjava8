package nus.iss;

public class MyRunnableImplementation implements Runnable {
    private String taskName; 

    public MyRunnableImplementation(){

    }

    public MyRunnableImplementation(String taskName){
        //this is to give the taskname
        this.taskName = taskName; 
    }

    @Override
            public void run(){
                for (int i = 0; i < 5; i++){
                    System.out.println(Thread.currentThread().getName() + "\t" + taskName +
                    "\tRunnable ..." + i);
                }
            }

}
