package Source;


class Number{
    int number;
    Object lock;
    public Number(){
        this.number=0;
        this.lock=new Object();
    }
    public Number(int number){
        this.number=number;
        this.lock=new Object();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Object getLock() {
        return lock;
    }

    public void setLock(Object lock) {
        this.lock = lock;
    }
}
class Calculate{
    public int addTwo(Number n1, Number n2){
        synchronized(n1.getLock()){
            synchronized (n2.getLock()){
                int n=n1.getNumber();
                n1.setNumber(n2.getNumber());
                n2.setNumber(n);
                return n1.getNumber()+n;
            }
        }

    }
}
public class Question5 {
    public static void main(String[] args) {
        Number n1=new Number(25);
        Number n2=new Number(45);
        Calculate c=new Calculate();
        Thread t1=new Thread(()->{
            for(int i=0;i<100;i++){

                c.addTwo(n1,n2);
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0;i<100;i++){

                c.addTwo(n1,n2);
            }
        });
        System.out.println("done");
        t1.start();
        t2.start();
    }
}