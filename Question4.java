package Source;


import java.util.concurrent.Callable;

class NewWorker implements Callable{

    @Override
    public Integer call() throws Exception {
        System.out.println("Callable Implemented in Class");
        return 90;
    }
}

public class Question4 {
    public static void main(String[] args) {

        try {
            Callable c=()->{ System.out.println("Callable Lambda"); return 20; };
            System.out.println(c.call());

            NewWorker w=new NewWorker();
            System.out.println(w.call());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}