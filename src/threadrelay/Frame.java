package threadrelay;

public class Frame extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Frame.class.getName());
    
    private Thread thread0, thread1, thread2, thread3;

    public Frame() {
        initComponents();
        setLocationRelativeTo(null);
        
        //definisco il massimo e il minimo delle progress bar
        pb0.setMinimum(0); pb0.setMaximum(99);
        pb1.setMinimum(0); pb1.setMaximum(99);
        pb2.setMinimum(0); pb2.setMaximum(99);
        pb3.setMinimum(0); pb3.setMaximum(99);
        
        //progress bar da destra verso sinistra
        pb0.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        pb1.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        pb2.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        pb3.setComponentOrientation(java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        
        lblCorridore0.setSize(lblCorridore0.getPreferredSize());
        lblCorridore1.setSize(lblCorridore1.getPreferredSize());
        lblCorridore2.setSize(lblCorridore2.getPreferredSize());
        lblCorridore3.setSize(lblCorridore3.getPreferredSize());
    }

    private int getMsFromCombo() {
        String v = (String) cmbVelocita.getSelectedItem();
        if ("Slow".equals(v)) return 40;
        if ("Fast".equals(v)) return 10;
        return 20;
    }
    
    private void muoviCorridore(javax.swing.JProgressBar pb, javax.swing.JLabel corridore, int value) {
        int min = pb.getMinimum();
        int max = pb.getMaximum();
        float p = (value - min) / (float) (max - min);
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
        btnRiprendi = new javax.swing.JButton();
        btnPausa = new javax.swing.JButton();
        btnFerma = new javax.swing.JButton();
        cmbVelocita = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(456, 316));
        jPanel1.setLayout(null);

        lblCorridore2.setText("🏃");
        jPanel1.add(lblCorridore2);
        lblCorridore2.setBounds(420, 160, 20, 16);

        lblCorridore3.setText("🏃");
        jPanel1.add(lblCorridore3);
        lblCorridore3.setBounds(420, 220, 20, 16);

        lblCorridore0.setText("🏃");
        jPanel1.add(lblCorridore0);
        lblCorridore0.setBounds(420, 40, 20, 16);

        lblCorridore1.setText("🏃");
        jPanel1.add(lblCorridore1);
        lblCorridore1.setBounds(420, 100, 20, 16);

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

        btnRiprendi.setText("Riprendi");
        btnRiprendi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRiprendiActionPerformed(evt);
            }
        });
        jPanel1.add(btnRiprendi);
        btnRiprendi.setBounds(260, 270, 90, 30);

        btnPausa.setText("Pausa");
        btnPausa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPausaActionPerformed(evt);
            }
        });
        jPanel1.add(btnPausa);
        btnPausa.setBounds(190, 270, 70, 30);

        btnFerma.setText("Ferma");
        btnFerma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFermaActionPerformed(evt);
            }
        });
        jPanel1.add(btnFerma);
        btnFerma.setBounds(119, 270, 70, 30);

        cmbVelocita.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Slow", "Regular", "Fast" }));
        jPanel1.add(cmbVelocita);
        cmbVelocita.setBounds(20, 270, 90, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 456, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAvviaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAvviaActionPerformed
        btnPausa.setEnabled(true);
        btnFerma.setEnabled(true);
        btnRiprendi.setEnabled(false);
        cmbVelocita.setEnabled(false);
        btnAvvia.setEnabled(false);

        Runner.resetGara();

        pb0.setValue(0); pb1.setValue(0);
        pb2.setValue(0); pb3.setValue(0);

        muoviCorridore(pb0, lblCorridore0, 0);
        muoviCorridore(pb1, lblCorridore1, 0);
        muoviCorridore(pb2, lblCorridore2, 0);
        muoviCorridore(pb3, lblCorridore3, 0);

        int msVelocita = getMsFromCombo();

        Runner.QuotaListener listener = new Runner.QuotaListener() {
            @Override
            public void onQuotaChanged(int runnerId, int quota) {
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
                        cmbVelocita.setEnabled(true);
                    });
                }
            }
        };

        thread0 = new Thread(new Runner(0, listener, msVelocita), "runner0");
        thread1 = new Thread(new Runner(1, listener, msVelocita), "runner1");
        thread2 = new Thread(new Runner(2, listener, msVelocita), "runner2");
        thread3 = new Thread(new Runner(3, listener, msVelocita), "runner3");

        thread0.start();
        thread1.start();
        thread2.start();
        thread3.start();
    }//GEN-LAST:event_btnAvviaActionPerformed
    
    private void btnPausaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPausaActionPerformed
        Runner.pausa();

        btnRiprendi.setEnabled(true);

        btnPausa.setEnabled(false);
        btnFerma.setEnabled(false);
        btnAvvia.setEnabled(false);
        cmbVelocita.setEnabled(false);
    }//GEN-LAST:event_btnPausaActionPerformed

    private void btnFermaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFermaActionPerformed
        Runner.ferma();

        if (thread0 != null) thread0.interrupt();
        if (thread1 != null) thread1.interrupt();
        if (thread2 != null) thread2.interrupt();
        if (thread3 != null) thread3.interrupt();

        Runner.resetGara();

        pb0.setValue(0); pb1.setValue(0);
        pb2.setValue(0); pb3.setValue(0);

        muoviCorridore(pb0, lblCorridore0, 0);
        muoviCorridore(pb1, lblCorridore1, 0);
        muoviCorridore(pb2, lblCorridore2, 0);
        muoviCorridore(pb3, lblCorridore3, 0);

        btnAvvia.setEnabled(true);
        cmbVelocita.setEnabled(true);

        btnPausa.setEnabled(true);
        btnFerma.setEnabled(true);
        btnRiprendi.setEnabled(false);
    }//GEN-LAST:event_btnFermaActionPerformed

    private void btnRiprendiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRiprendiActionPerformed
        Runner.riprendi();

        btnRiprendi.setEnabled(false);

        btnPausa.setEnabled(true);
        btnFerma.setEnabled(true);
        btnAvvia.setEnabled(false);
        cmbVelocita.setEnabled(false);
    }//GEN-LAST:event_btnRiprendiActionPerformed

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
    private javax.swing.JButton btnFerma;
    private javax.swing.JButton btnPausa;
    private javax.swing.JButton btnRiprendi;
    private javax.swing.JComboBox<String> cmbVelocita;
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
