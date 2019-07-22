/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayana;

import Classes.Account;
import Classes.ComboListener;
import Classes.Expense;
import Classes.Provider;
import Classes.Save;
import Conexion.Conexion;
import java.awt.Image;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author macbook
 */
public class AuxPagos extends javax.swing.JDialog {

    /**
     * Creates new form AuxPagos
     */
    public AuxPagos() {
        initComponents();
         ImageIcon imagen = new ImageIcon(getClass().getResource("Images/Guardar.png"));
      Icon  fondo = new ImageIcon(imagen.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnCapturaEgresos.setIcon(fondo);
        txtProv.setText(Save.Providertext);
          con=new Conexion();
        con.Conectar();
          try {
        accounts=con.GetAccounts2();
      prov=con.GetProviderById(Save.Provider);
          } catch (SQLException ex) {}     
        con.Desconectar();
        for(Account obj : accounts){
        vectorCuentaEgr.add(obj.Description);
        }
        
                 cbxCuentaEgresos.setModel(new DefaultComboBoxModel(vectorCuentaEgr));		
        JTextField text4 = (JTextField)cbxCuentaEgresos.getEditor().getEditorComponent();
		text4.setFocusable(true);
		text4.setText("");
		text4.addKeyListener(new ComboListener(cbxCuentaEgresos,vectorCuentaEgr));
                 dtEgresos.getDateEditor().setEnabled(false);
                dtEgresos.setDate(Date.valueOf(LocalDate.now()));
                       DecimalFormat formatea = new DecimalFormat("$###,###.##");
                txtSaldo.setText(formatea.format(prov.Saldo()));
    }
Vector vectorCuentaEgr = new Vector();
List<Account> accounts;
Conexion con;
Provider prov;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtSaldo = new javax.swing.JTextField();
        txtDescripcionEgresos = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtProv = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtFacturaEgresos = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        tbFacturaEgresos = new javax.swing.JToggleButton();
        txtMontoEgresos = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbxCuentaEgresos = new javax.swing.JComboBox<>();
        dtEgresos = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        btnCapturaEgresos = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar pago a proveedor");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(55, 55, 55));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel11.setText("Saldo");

        txtSaldo.setEditable(false);
        txtSaldo.setBackground(new java.awt.Color(255, 255, 255));
        txtSaldo.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtSaldo.setForeground(new java.awt.Color(55, 55, 55));
        txtSaldo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtSaldo.setEnabled(false);

        txtDescripcionEgresos.setBackground(new java.awt.Color(255, 248, 245));
        txtDescripcionEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtDescripcionEgresos.setForeground(new java.awt.Color(55, 55, 55));
        txtDescripcionEgresos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(55, 55, 55));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel12.setText("Proveedor");

        txtProv.setEditable(false);
        txtProv.setBackground(new java.awt.Color(255, 255, 255));
        txtProv.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtProv.setForeground(new java.awt.Color(55, 55, 55));
        txtProv.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtProv.setEnabled(false);
        txtProv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProvActionPerformed(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(55, 55, 55));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel13.setText("Monto");

        txtFacturaEgresos.setBackground(new java.awt.Color(255, 248, 245));
        txtFacturaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtFacturaEgresos.setForeground(new java.awt.Color(55, 55, 55));
        txtFacturaEgresos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtFacturaEgresos.setEnabled(false);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(55, 55, 55));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel14.setText("Factura");

        tbFacturaEgresos.setBackground(new java.awt.Color(255, 255, 255));
        tbFacturaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        tbFacturaEgresos.setForeground(new java.awt.Color(55, 55, 55));
        tbFacturaEgresos.setSelected(true);
        tbFacturaEgresos.setText("Si");
        tbFacturaEgresos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        tbFacturaEgresos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tbFacturaEgresosStateChanged(evt);
            }
        });
        tbFacturaEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbFacturaEgresosActionPerformed(evt);
            }
        });

        txtMontoEgresos.setBackground(new java.awt.Color(255, 248, 245));
        txtMontoEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtMontoEgresos.setForeground(new java.awt.Color(55, 55, 55));
        txtMontoEgresos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtMontoEgresos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMontoEgresosKeyReleased(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(55, 55, 55));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel15.setText("Cuenta");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(55, 55, 55));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setText("Fecha");

        cbxCuentaEgresos.setBackground(new java.awt.Color(255, 248, 245));
        cbxCuentaEgresos.setEditable(true);
        cbxCuentaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCuentaEgresos.setForeground(new java.awt.Color(55, 55, 55));
        cbxCuentaEgresos.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        cbxCuentaEgresos.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbxCuentaEgresosItemStateChanged(evt);
            }
        });
        cbxCuentaEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCuentaEgresosActionPerformed(evt);
            }
        });

        dtEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(55, 55, 55));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Detalle");

        btnCapturaEgresos.setBackground(new java.awt.Color(255, 255, 255));
        btnCapturaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnCapturaEgresos.setForeground(new java.awt.Color(55, 55, 55));
        btnCapturaEgresos.setText("Guardar");
        btnCapturaEgresos.setToolTipText("");
        btnCapturaEgresos.setBorder(null);
        btnCapturaEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaEgresosActionPerformed(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(217, 234, 220));
        jLabel16.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Agregar pago a proveedor");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMontoEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCuentaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProv, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tbFacturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFacturaEgresos)))
                .addGap(40, 40, 40))
            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(173, 173, 173)
                .addComponent(btnCapturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtProv, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDescripcionEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCuentaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tbFacturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFacturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMontoEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btnCapturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
double MontoEgr;
    private void tbFacturaEgresosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_tbFacturaEgresosStateChanged

    }//GEN-LAST:event_tbFacturaEgresosStateChanged

    private void tbFacturaEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbFacturaEgresosActionPerformed
        if(tbFacturaEgresos.isSelected()){
            tbFacturaEgresos.setText("Si");
            txtFacturaEgresos.setEditable(true);
        }else{
            tbFacturaEgresos.setText("No");
            txtFacturaEgresos.setText(null);
            txtFacturaEgresos.setEditable(false);
        }
    }//GEN-LAST:event_tbFacturaEgresosActionPerformed

    private void txtMontoEgresosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoEgresosKeyReleased
        try {
            MontoEgr = Double.parseDouble(txtMontoEgresos.getText());
        } catch (NumberFormatException e) {
            MontoEgr = 0;
            txtMontoEgresos.setText(null);
        }
    }//GEN-LAST:event_txtMontoEgresosKeyReleased

    private void cbxCuentaEgresosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbxCuentaEgresosItemStateChanged

    }//GEN-LAST:event_cbxCuentaEgresosItemStateChanged

    private void cbxCuentaEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCuentaEgresosActionPerformed

    }//GEN-LAST:event_cbxCuentaEgresosActionPerformed

    private void btnCapturaEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaEgresosActionPerformed
              try{
            Account cuenta= accounts.stream()
            .filter(obj -> cbxCuentaEgresos.getSelectedItem().toString().equals(obj.Description))
            .findAny()
            .orElse(null);

            if(MontoEgr==0){
                JOptionPane.showMessageDialog(this,"Falta ingresar monto.");
                return;
            }
            int fac=0;
            if(tbFacturaEgresos.isSelected()){
                fac=1;
            }
            con=new Conexion();
            con.Conectar();
            con.AddPagoRequest(Save.Provider,new Expense(dtEgresos.getDate(),1,txtDescripcionEgresos.getText(),cuenta.Id,fac,txtFacturaEgresos.getText(),MontoEgr,Save.TemporalUser.Id));
            con.Desconectar();
            JOptionPane.showMessageDialog(this,"Egreso capturado con éxito.");
            this.dispose();
            MontoEgr=0;
            txtDescripcionEgresos.setText(null);
            txtMontoEgresos.setText(null);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this,"Información faltante.");
        }
    }//GEN-LAST:event_btnCapturaEgresosActionPerformed

    private void txtProvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProvActionPerformed

    /**
     * @param args the command line arguments
     */
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AuxPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AuxPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AuxPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AuxPagos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AuxPagos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapturaEgresos;
    private javax.swing.JComboBox<String> cbxCuentaEgresos;
    private com.toedter.calendar.JDateChooser dtEgresos;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton tbFacturaEgresos;
    private javax.swing.JTextField txtDescripcionEgresos;
    private javax.swing.JTextField txtFacturaEgresos;
    private javax.swing.JTextField txtMontoEgresos;
    private javax.swing.JTextField txtProv;
    private javax.swing.JTextField txtSaldo;
    // End of variables declaration//GEN-END:variables
}