package Source;


class NewWork{
    synchronized public void prints() {
        //synchronized(this){
        for(int i=0;i<5;i++){
            System.out.printf(i+" ");
            try {
                Thread.sleep(300);
            }
            catch(Exception e){
                return;
            }
        }
    }

}

class Worker1 extends Thread {

    NewWork w;
    public Worker1(NewWork w){
        this.w=w;
    }
    @Override
    public void run(){
        w.prints();
    }
}



public class Question3 {
    public static void main(String[] args) throws InterruptedException {
        NewWork w=new NewWork();
        Worker1 w1=new Worker1(w);
        //System.out.println("Thread 1: "+w1.getName());
        Worker1 w2=new Worker1(w);
        Worker1 w3=new Worker1(w);
        w1.start();
        w2.start();
        w3.start();

    }
}