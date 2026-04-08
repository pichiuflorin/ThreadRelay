package threadrelay;

public class Runner implements Runnable{
    private int quota;
    private static boolean hasTestimone;
    
    public Runner() {
        //risorsa condivisa
        hasTestimone = true;
        //quota che deve raggiungere 90
        quota = 0;
    }
    
    synchronized public void run(){
        if (hasTestimone == true) {
            while (quota < 90) {
                quota += 1;
                System.out.println(quota);
            }
            notify();
        }
    }
}