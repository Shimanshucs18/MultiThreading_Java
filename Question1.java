package Source;


class Worker extends Thread  {

    public Object sleep;

    public void prints() {
        System.out.println("Prints Method for "+this.getId());
    }
    public void run(){
        System.out.println("This is Thread: "+this.getId());
    }
}

class RunWorker implements Runnable  {
    @Override
    public void run(){
        System.out.println("Runnable Thread Running");
    }
}

public class Question1 {
    public static void main(String[] args) throws InterruptedException {
        Worker w1=new Worker();
        Worker w2=new Worker();
        Worker w3=new Worker();
        w1.start();
        w2.start();
        w3.start();
        System.out.println("Thread 1: "+w1.getId());
        System.out.println("Thread 2: "+w2.getId());
        System.out.println("Thread 3: "+w3.getId());
        w1.sleep(5000);
        w2.prints();
        w2.sleep(5000);
        w1.prints();
        w3.sleep(5000);


        new Thread(new RunWorker()).start();
        new Thread(()-> System.out.println("Runnable Lambda")).start();

        try {
            System.out.println("Waiting for the threads to finish.");
            w1.join();
            w2.join();
            w3.join();
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted.");
        }

        System.out.println("Main thread exiting.");


    }
}