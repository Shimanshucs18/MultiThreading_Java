package Source;


class Worker extends Thread  {

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
        w1.start();
        w2.start();
        System.out.println("Thread 1: "+w1.getId());
        System.out.println("Thread 2: "+w2.getId());
        w1.sleep(5000);
        w2.prints();
        w2.sleep(5000);
        w1.prints();

        new Thread(new RunWorker()).start();
        new Thread(()-> System.out.println("Runnable Lambda")).start();


    }
}