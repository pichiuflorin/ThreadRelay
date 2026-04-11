package threadrelay;

import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;

public class Runner implements Runnable{
    
    //listener per le progressbar
    public interface QuotaListener {
        void onQuotaChanged(int runnerId, int quota);
        void onFinished(int runnerId);
    }
    
    private int quota;
    private int id; //quale runner è? runner0, runner1 ecc.
    
    private QuotaListener listener;
    
    public Runner(int id, QuotaListener listener) {
        this.id = id;
        this.listener = listener;
        this.quota = 0;
    }
    
    private static int turno = 0; // 0 per runner0, 1 per runner1 ecc.
    private static final Object staffetta = new Object(); //risorsa condivisa
    
    synchronized public void run(){
        synchronized (staffetta) {
            //non è il mio turno, aspetto
            while (turno != id) {
                try { staffetta.wait(); }
                catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    return; //esco dal thread
                }
            }
            
            //è il mio turno --> corro fino a 90
            System.out.println("[Runner " + id + "] in esecuzione.");
            
            //quota accelerazione (fino a 20)
            quotaScalare(0, 20, 20, true);
            
            //quota costante (fino a 70)
            quotaLineare(20, 70, 20);
            
            //quota decelerazione (fino a 90)
            quotaScalare(70, 90, 20, false);
            
            System.out.println(""); //spazio dopo la filata di numeri
            turno++; //passo il turno
            staffetta.notifyAll(); //sveglio gli altri thread
        }
        
        if (listener != null) listener.onFinished(id);
    }
    
    /**
     * Quota che aumenta con velocità costante
     * @param minQuota quota da cui parte la conta
     * @param maxQuota quota che deve essere raggiunta
     * @param msVelocita velocità costante
     */
    private void quotaLineare(int minQuota, int maxQuota, int msVelocita){
        for (quota = minQuota; quota < (maxQuota + 1); quota++) {
                System.out.print(quota + " ");
                
                if (listener != null) listener.onQuotaChanged(id, quota);
                
                try {
                    Thread.sleep(msVelocita);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                    return; //esco dal thread
                }
            }
    }
    
    /**
     * Quota che aumenta in maniera scalare
     * @param minQuota quota da cui parte la conta
     * @param maxQuota quota che deve essere raggiunta
     * @param msVelocitaMassima velocità che deve essere raggiunta
     * @param accelerazione booleano per accelerare o decelerare
     */
    private void quotaScalare(int minQuota, int maxQuota, int msVelocitaMassima, boolean accelerazione){
        for (quota = minQuota; quota <= maxQuota; quota++){
            System.out.print(quota + " ");
            
            if (listener != null) listener.onQuotaChanged(id, quota);
            
            //range di ms (più ms --> più lento)
            int msMin = msVelocitaMassima;
            int msMax = msVelocitaMassima + 30;
            
            int v; //ms di sleep per questa quota
            
            if (accelerazione){ //true per default
                //ACCELERAZIONE (msMax --> msMin)
                v = msMax - (quota - minQuota);
                //non deve scendere sotto msMin
                if (v < msMin) v = msMin;
            } else {
                //DECELERAZIONE (msMin --> msMax)
                v = msMin + (quota - minQuota);
                
                //non deve salire sopra msMax
                if (v > msMax) v = msMax;
            }
            
            try {
                Thread.sleep(v);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
                return; //esco dal thread
            }
        }
    }
}