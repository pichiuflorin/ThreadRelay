package threadrelay;

public class Settings extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(Settings.class.getName());
    
    private final SettingsListener listener;
    
    public Settings(RunConfig initialConfig, SettingsListener listener) {
        initComponents();
        
        this.listener = listener;
        
        //definisco un range per gli slider
        sliderAcc.setMinimum(5);  sliderAcc.setMaximum(100);
        sliderCost.setMinimum(5); sliderCost.setMaximum(100);
        sliderDec.setMinimum(5);  sliderDec.setMaximum(100);
        
        //inizializzazione degli slider con i valori attuali
        sliderAcc.setValue(initialConfig.msAcc);
        sliderCost.setValue(initialConfig.msCost);
        sliderDec.setValue(initialConfig.msDec);
    }
    
    public interface SettingsListener {
        void onSettingsSaved(RunConfig newConfig);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        sliderAcc = new javax.swing.JSlider();
        sliderCost = new javax.swing.JSlider();
        sliderDec = new javax.swing.JSlider();
        lblImpostazioni = new javax.swing.JLabel();
        lblAccelerazione = new javax.swing.JLabel();
        lblVelocitaCostante = new javax.swing.JLabel();
        lblDecelerazione = new javax.swing.JLabel();
        btnSalva = new javax.swing.JButton();
        btnResetToDefault = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lblImpostazioni.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblImpostazioni.setText("IMPOSTAZIONI");

        lblAccelerazione.setText("Accelerazione");

        lblVelocitaCostante.setText("Velocità costante");

        lblDecelerazione.setText("Decelerazione");

        btnSalva.setText("Salva");
        btnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaActionPerformed(evt);
            }
        });

        btnResetToDefault.setText("Reset to default");
        btnResetToDefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetToDefaultActionPerformed(evt);
            }
        });

        lblInfo.setText("(maggiore --> più lento)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnResetToDefault)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalva)
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblImpostazioni)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblInfo))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblVelocitaCostante)
                                    .addComponent(lblDecelerazione)
                                    .addComponent(lblAccelerazione))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(sliderAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sliderDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sliderCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblImpostazioni)
                    .addComponent(lblInfo))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sliderAcc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAccelerazione))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sliderCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblVelocitaCostante))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sliderDec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDecelerazione))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSalva)
                    .addComponent(btnResetToDefault))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
        RunConfig cfg = new RunConfig(
            sliderAcc.getValue(),
            sliderCost.getValue(),
            sliderDec.getValue()
        );
        
        if (listener != null) listener.onSettingsSaved(cfg);
        dispose();
    }//GEN-LAST:event_btnSalvaActionPerformed

    private void btnResetToDefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetToDefaultActionPerformed
        sliderAcc.setValue(20);
        sliderCost.setValue(20);
        sliderDec.setValue(20);

        RunConfig cfg = new RunConfig(20, 20, 20);
        if (listener != null) listener.onSettingsSaved(cfg);
        dispose();
    }//GEN-LAST:event_btnResetToDefaultActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnResetToDefault;
    private javax.swing.JButton btnSalva;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAccelerazione;
    private javax.swing.JLabel lblDecelerazione;
    private javax.swing.JLabel lblImpostazioni;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JLabel lblVelocitaCostante;
    private javax.swing.JSlider sliderAcc;
    private javax.swing.JSlider sliderCost;
    private javax.swing.JSlider sliderDec;
    // End of variables declaration//GEN-END:variables
}
