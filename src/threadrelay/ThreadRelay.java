package threadrelay;

public class ThreadRelay {
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Frame().setVisible(true);
        });
    }
}
