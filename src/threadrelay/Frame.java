package threadrelay;


public class Frame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame.class.getName());

    private int turno = 0; // 0..3
    private javax.swing.Timer timer; // timer Swing per animare le barre

    private Thread thread0, thread1, thread2, thread3;

    public Frame() {
        initComponents();

        pb0.setMinimum(0); pb0.setMaximum(90);
        pb1.setMinimum(0); pb1.setMaximum(90);
        pb2.setMinimum(0); pb2.setMaximum(90);
        pb3.setMinimum(0); pb3.setMaximum(90);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblRunner0 = new javax.swing.JLabel();
        lblRunner1 = new javax.swing.JLabel();
        lblRunner2 = new javax.swing.JLabel();
        lblRunner3 = new javax.swing.JLabel();
        pb1 = new javax.swing.JProgressBar();
        pb2 = new javax.swing.JProgressBar();
        pb3 = new javax.swing.JProgressBar();
        pb0 = new javax.swing.JProgressBar();
        btnAvvia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblRunner0.setText("Runner 0");

        lblRunner1.setText("Runner 1");

        lblRunner2.setText("Runner 2");

        lblRunner3.setText("Runner 3");

        btnAvvia.setText("Avvia");
        btnAvvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvviaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAvvia)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblRunner3)
                            .addComponent(lblRunner2)
                            .addComponent(lblRunner1)
                            .addComponent(lblRunner0))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pb1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pb2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pb3, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pb0, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb0, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRunner0))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRunner1)
                    .addComponent(pb1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRunner2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblRunner3)
                    .addComponent(pb3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnAvvia)
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvviaActionPerformed
   // reset barre
        pb0.setValue(0);
        pb1.setValue(0);
        pb2.setValue(0);
        pb3.setValue(0);

        btnAvvia.setEnabled(false);

        Runner.QuotaListener listener = new Runner.QuotaListener() {
            @Override
            public void onQuotaChanged(int runnerId, int quota) {
                javax.swing.SwingUtilities.invokeLater(() -> {
                    if (runnerId == 0) {
                        pb0.setValue(quota);
                    } else if (runnerId == 1) {
                        pb1.setValue(quota);
                    } else if (runnerId == 2) {
                        pb2.setValue(quota);
                    } else {
                        pb3.setValue(quota);
                    }
                });
            }

            @Override
            public void onFinished(int runnerId) {
                // opzionale: quando finisce l’ultimo riabilito il bottone
                if (runnerId == 3) {
                    javax.swing.SwingUtilities.invokeLater(() -> btnAvvia.setEnabled(true));
                }
            }
        };

        // IMPORTANTISSIMO: ricrea i Thread qui, perché un Thread non può ripartire 2 volte
        thread0 = new Thread(new Runner(0, listener), "runner0");
        thread1 = new Thread(new Runner(1, listener), "runner1");
        thread2 = new Thread(new Runner(2, listener), "runner2");
        thread3 = new Thread(new Runner(3, listener), "runner3");

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }//GEN-LAST:event_btnAvviaActionPerformed

    public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
        logger.log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(() -> new Frame().setVisible(true));
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAvvia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblRunner0;
    private javax.swing.JLabel lblRunner1;
    private javax.swing.JLabel lblRunner2;
    private javax.swing.JLabel lblRunner3;
    private javax.swing.JProgressBar pb0;
    private javax.swing.JProgressBar pb1;
    private javax.swing.JProgressBar pb2;
    private javax.swing.JProgressBar pb3;
    // End of variables declaration//GEN-END:variables
}
