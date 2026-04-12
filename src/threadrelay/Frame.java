package threadrelay;

public class Frame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame.class.getName());
    
    private Thread thread0, thread1, thread2, thread3; //thread usati appena il programma si avvia
    private RunConfig config = new RunConfig(20, 20, 20); //default config

    public Frame() {
        initComponents();
        setLocationRelativeTo(null); //centra il form in mezzo allo schermo
        
        //definisco il massimo e il minimo delle progress bar (relativo alla quota)
        pb0.setMinimum(0); pb0.setMaximum(90);
        pb1.setMinimum(0); pb1.setMaximum(90);
        pb2.setMinimum(0); pb2.setMaximum(90);
        pb3.setMinimum(0); pb3.setMaximum(90);
        
        //progress bar da destra verso sinistra
        pb0.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        pb1.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        pb2.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        pb3.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
    }
    
    private void muoviCorridore(javax.swing.JProgressBar pb, javax.swing.JLabel corridore, int value) {
        int min = pb.getMinimum();
        int max = pb.getMaximum();
        float p = (value - min) / (float) (max - min); // 0..1

        //a value = 0 sta a destra, a value = max sta a sinistra
        float inv = 1.0f - p;

        int pbX = pb.getX();
        int pbW = pb.getWidth();

        int x = pbX + Math.round(inv * pbW) - (corridore.getWidth() / 2) - 5;
        int y = pb.getY() + 10;

        corridore.setLocation(x, y);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblCorridore2 = new javax.swing.JLabel();
        lblCorridore3 = new javax.swing.JLabel();
        lblCorridore0 = new javax.swing.JLabel();
        lblCorridore1 = new javax.swing.JLabel();
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
        jPanel1.setPreferredSize(new java.awt.Dimension(456, 316));
        jPanel1.setLayout(null);

        lblCorridore2.setText("🏃");
        jPanel1.add(lblCorridore2);
        lblCorridore2.setBounds(410, 160, 20, 16);

        lblCorridore3.setText("🏃");
        jPanel1.add(lblCorridore3);
        lblCorridore3.setBounds(410, 220, 20, 16);

        lblCorridore0.setText("🏃");
        jPanel1.add(lblCorridore0);
        lblCorridore0.setBounds(410, 40, 20, 16);

        lblCorridore1.setText("🏃");
        jPanel1.add(lblCorridore1);
        lblCorridore1.setBounds(410, 100, 20, 16);

        lblRunner0.setText("Runner 0");
        jPanel1.add(lblRunner0);
        lblRunner0.setBounds(30, 40, 60, 16);

        lblRunner1.setText("Runner 1");
        jPanel1.add(lblRunner1);
        lblRunner1.setBounds(30, 100, 60, 16);

        lblRunner2.setText("Runner 2");
        jPanel1.add(lblRunner2);
        lblRunner2.setBounds(30, 160, 60, 16);

        lblRunner3.setText("Runner 3");
        jPanel1.add(lblRunner3);
        lblRunner3.setBounds(30, 220, 60, 16);

        pb1.setBackground(new java.awt.Color(204, 204, 255));
        pb1.setForeground(new java.awt.Color(102, 102, 255));
        jPanel1.add(pb1);
        pb1.setBounds(110, 90, 320, 39);

        pb2.setBackground(new java.awt.Color(255, 204, 255));
        pb2.setForeground(new java.awt.Color(255, 51, 255));
        jPanel1.add(pb2);
        pb2.setBounds(110, 150, 320, 39);

        pb3.setBackground(new java.awt.Color(255, 204, 204));
        pb3.setForeground(new java.awt.Color(255, 102, 102));
        jPanel1.add(pb3);
        pb3.setBounds(110, 210, 320, 39);

        pb0.setBackground(new java.awt.Color(204, 255, 255));
        pb0.setForeground(new java.awt.Color(0, 204, 204));
        jPanel1.add(pb0);
        pb0.setBounds(110, 30, 320, 39);

        btnAvvia.setText("Avvia");
        btnAvvia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAvviaActionPerformed(evt);
            }
        });
        jPanel1.add(btnAvvia);
        btnAvvia.setBounds(350, 270, 76, 30);

        btnOpenSettings.setFont(new java.awt.Font("Segoe UI Emoji", 0, 14)); // NOI18N
        btnOpenSettings.setText("⚙");
        btnOpenSettings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenSettingsActionPerformed(evt);
            }
        });
        jPanel1.add(btnOpenSettings);
        btnOpenSettings.setBounds(280, 270, 57, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvviaActionPerformed
        //disabilita bottoni durante la gara
        btnOpenSettings.setEnabled(false);
        btnAvvia.setEnabled(false);
        
        //reset gara
        Runner.resetGara();
        
        //reset barre
        pb0.setValue(0); pb1.setValue(0);
        pb2.setValue(0); pb3.setValue(0);
        
        //creazione listener per quota
        Runner.QuotaListener listener = new Runner.QuotaListener() {
            @Override
            public void onQuotaChanged(int runnerId, int quota) {
                
                //Swing NON è thread-safe, non si può chiamare pb0.setValue(...) da essi,
                //SwingUtilies.invokeLater(...) permette di eseguire la determinata
                //modifica della GUI sul thread di Swing (EDT) appena è possibile
                
                javax.swing.SwingUtilities.invokeLater(() -> {
                    if (runnerId == 0) {
                        pb0.setValue(quota);
                        muoviCorridore(pb0, lblCorridore0, quota);
                    } else if (runnerId == 1) {
                        pb1.setValue(quota);
                        muoviCorridore(pb1, lblCorridore1, quota);
                    } else if (runnerId == 2) {
                        pb2.setValue(quota);
                        muoviCorridore(pb2, lblCorridore2, quota);
                    } else {
                        pb3.setValue(quota);
                        muoviCorridore(pb3, lblCorridore3, quota);
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
    private javax.swing.JLabel lblCorridore0;
    private javax.swing.JLabel lblCorridore1;
    private javax.swing.JLabel lblCorridore2;
    private javax.swing.JLabel lblCorridore3;
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
