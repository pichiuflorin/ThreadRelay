package threadrelay;

public class Frame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame.class.getName());
    
    private Thread thread0, thread1, thread2, thread3; //thread usati appena il programma si avvia
    private RunConfig config = new RunConfig(20, 20, 20); //default config

    public Frame() {
        initComponents();
        setLocationRelativeTo(null); //centra il form in mezzo allo schermo
        
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
        btnOpenSettings = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblRunner0.setText("Runner 0");

        lblRunner1.setText("Runner 1");

        lblRunner2.setText("Runner 2");

        lblRunner3.setText("Runner 3");

        pb1.setBackground(new java.awt.Color(204, 204, 255));
        pb1.setForeground(new java.awt.Color(102, 102, 255));

        pb2.setBackground(new java.awt.Color(255, 204, 255));
        pb2.setForeground(new java.awt.Color(255, 51, 255));

        pb3.setBackground(new java.awt.Color(255, 204, 204));
        pb3.setForeground(new java.awt.Color(255, 102, 102));

        pb0.setBackground(new java.awt.Color(204, 255, 255));
        pb0.setForeground(new java.awt.Color(0, 204, 204));

        btnAvvia.setText("Avvia");
        btnAvvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvviaActionPerformed(evt);
            }
        });

        btnOpenSettings.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        btnOpenSettings.setText("⚙");
        btnOpenSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenSettingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnOpenSettings, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAvvia))
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
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb0, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblRunner0)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblRunner1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lblRunner2)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pb3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lblRunner3)))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAvvia)
                    .addComponent(btnOpenSettings))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvviaActionPerformed
        btnOpenSettings.setEnabled(false);
        Runner.resetGara();
        
        //reset barre
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
                if (runnerId == 3) {
                    javax.swing.SwingUtilities.invokeLater(() -> {
                        btnAvvia.setEnabled(true);
                        btnOpenSettings.setEnabled(true);
                    });
                }
            }
        };

        //thread ricreati, perché un thread non può ripartire due volte
        thread0 = new Thread(new Runner(0, listener, config.msAcc, config.msCost, config.msDec), "runner0");
        thread1 = new Thread(new Runner(1, listener, config.msAcc, config.msCost, config.msDec), "runner1");
        thread2 = new Thread(new Runner(2, listener, config.msAcc, config.msCost, config.msDec), "runner2");
        thread3 = new Thread(new Runner(3, listener, config.msAcc, config.msCost, config.msDec), "runner3");

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }//GEN-LAST:event_btnAvviaActionPerformed
    
    private void btnOpenSettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenSettingsActionPerformed
        btnAvvia.setEnabled(false);

        Settings s = new Settings(config, new Settings.SettingsListener() {
            @Override
            public void onSettingsSaved(RunConfig newConfig) {
                config = newConfig;
            }
        });

        //se l'utente chiude il form settings senza premere "Salva"
        s.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent e) {
                btnAvvia.setEnabled(true);
            }
        });

        s.setLocationRelativeTo(this);
        s.setVisible(true);
    }//GEN-LAST:event_btnOpenSettingsActionPerformed

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
    private javax.swing.JButton btnOpenSettings;
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
