package Source;

//Use a singleThreadExecutor, newCachedThreadPool() and  newFixedThreadPool()
// to submit a list of tasks and wait for completion of all tasks.

import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import java.util.concurrent.TimeUnit;

class Worker3 extends Thread{

    int id;
    public Worker3(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Starting Work: "+id);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Ending Work: "+id);
    }

}

public class Question2 {
    public static void main(String[] args) {
        //FixeDThreadPool
        ExecutorService e1= Executors.newFixedThreadPool(3);
        for(int i=0;i<9;i++){
            e1.submit(new Worker3(i));
        }
        e1.shutdown();
        System.out.println("Sumbitted");
        try {
            e1.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Executed");


        System.out.println("--------------------------------");
        //cached Thread pool
        ExecutorService e2= Executors.newCachedThreadPool();
        for(int i=0;i<9;i++){
            e2.submit(new Worker3(i));
        }
        e2.shutdown();
        System.out.println("Sumbitted");
        try {
            e2.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Executed");

        //single thread executor
        System.out.println("--------------------------------");
        ExecutorService e3= Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++){
            e3.submit(new Worker3(i));
        }
        e3.shutdown();
        System.out.println("Sumbitted");
        try {
            e3.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Executed");


    }
}