package threadrelay;

public class Runner implements Runnable {

    public interface QuotaListener {
        void onQuotaChanged(int runnerId, int quota);
        void onFinished(int runnerId);
    }

    private static int turno = 0;
    private static final Object staffetta = new Object();
    private static final int QUOTA_PASSAGGIO = 90;

    private static final Object lockPausa = new Object();
    private static boolean inPausa = false;
    private static boolean fermato = false;

    private final int id;
    private final QuotaListener listener;
    private final int msVelocita;

    private boolean staffettaPassata = false;

    public Runner(int id, QuotaListener listener, int msVelocita) {
        this.id = id;
        this.listener = listener;
        this.msVelocita = msVelocita;
    }

    @Override
    public void run() {
        try {
            synchronized (staffetta) {
                while (turno != id && !fermato) {
                    staffetta.wait();
                }
            }

            for (int quota = 0; quota <= 99; quota++) {

                synchronized (lockPausa) {
                    while (inPausa && !fermato) {
                        lockPausa.wait();
                    }
                    if (fermato) return;
                }

                if (listener != null) listener.onQuotaChanged(id, quota);

                if (!staffettaPassata && quota >= QUOTA_PASSAGGIO) {
                    staffettaPassata = true;
                    synchronized (staffetta) {
                        turno++;
                        staffetta.notifyAll();
                    }
                }

                if (quota < 99) Thread.sleep(msVelocita);
            }

            if (listener != null) listener.onFinished(id);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void resetGara() {
        synchronized (staffetta) {
            turno = 0;
            staffetta.notifyAll();
        }
        synchronized (lockPausa) {
            inPausa = false;
            fermato = false;
            lockPausa.notifyAll();
        }
    }

    public static void pausa() {
        synchronized (lockPausa) {
            inPausa = true;
        }
    }

    public static void riprendi() {
        synchronized (lockPausa) {
            inPausa = false;
            lockPausa.notifyAll();
        }
    }

    public static void ferma() {
        synchronized (lockPausa) {
            fermato = true;
            inPausa = false;
            lockPausa.notifyAll();
        }
        synchronized (staffetta) {
            staffetta.notifyAll();
        }
    }
}