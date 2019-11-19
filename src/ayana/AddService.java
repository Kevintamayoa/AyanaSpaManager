/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayana;

import Classes.ComboListener;
import Classes.Inventory_Category;
import Classes.Inventory_Type;
import Classes.Provider;
import Classes.Save;
import Classes.Service_Type;
import Conexion.Conexion;
import java.awt.Image;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author macbook
 */
public class AddService extends javax.swing.JDialog {

    /**
     * Creates new form AddService
     */
    public AddService() {
        initComponents();
        PrecioInd=0;
        PrecioPaq=0;
        cbxCategory.addItem("Facial");
         cbxCategory.addItem("BTL");
         cbxCategory.addItem("Masajes");
         cbxCategory.addItem("Médico");
         setIconImage (new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
           ImageIcon imagen1 = new ImageIcon(getClass().getResource("Images/Guardar.png"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnAddInsumos.setIcon(fondo1);

   if(Save.status2==1){
            this.setTitle("Editar producto");
             jLabel17.setText("Editar producto");
               int aa=0;
                  try{
                    con=new Conexion();
                    con.Conectar();
                 servicio=con.GetServiceTypeById(Save.Service);
                 aa=servicio.Category_Id-1;
                    con.Desconectar();
                }catch (SQLException ex) {}
             
            txtNombre.setText(servicio.Description);
            cbxCategory.setSelectedIndex(aa);
            txtPrecioproducto.setText(servicio.Price+"");  
            PrecioInd=servicio.Price;
             txtPrecioproducto1.setText(servicio.Cost1+"");  
            PrecioPaq=servicio.Cost1;
   }
    }
    Service_Type servicio;
double PrecioInd;
double PrecioPaq;
List<Service_Type> servicios;
     Conexion con;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        btnAddInsumos = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtPrecioproducto = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbxCategory = new javax.swing.JComboBox<>();
        txtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtPrecioproducto1 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo servicio");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setBackground(new java.awt.Color(217, 234, 220));
        jLabel17.setFont(new java.awt.Font("InaiMathi", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Nuevo servicio");

        btnAddInsumos.setBackground(new java.awt.Color(255, 255, 255));
        btnAddInsumos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnAddInsumos.setForeground(new java.awt.Color(55, 55, 55));
        btnAddInsumos.setText("Agregar");
        btnAddInsumos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddInsumosActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(55, 55, 55));
        jLabel11.setText("Precio de venta individual");

        txtPrecioproducto.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioproducto.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtPrecioproducto.setForeground(new java.awt.Color(55, 55, 55));
        txtPrecioproducto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioproductoKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioproductoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioproductoKeyReleased(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(55, 55, 55));
        jLabel7.setText("Categoría");

        cbxCategory.setBackground(new java.awt.Color(255, 255, 255));
        cbxCategory.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        cbxCategory.setForeground(new java.awt.Color(55, 55, 55));
        cbxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoryActionPerformed(evt);
            }
        });

        txtNombre.setBackground(new java.awt.Color(255, 255, 255));
        txtNombre.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(55, 55, 55));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(55, 55, 55));
        jLabel10.setText("Servicio");

        txtPrecioproducto1.setBackground(new java.awt.Color(255, 255, 255));
        txtPrecioproducto1.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtPrecioproducto1.setForeground(new java.awt.Color(55, 55, 55));
        txtPrecioproducto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioproducto1KeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPrecioproducto1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioproducto1KeyReleased(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(55, 55, 55));
        jLabel12.setText("Precio de venta paquete");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel12))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPrecioproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(btnAddInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPrecioproducto1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(btnAddInsumos, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
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

    private void btnAddInsumosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddInsumosActionPerformed
        try{
            if(txtNombre.getText().length()<2||cbxCategory.getSelectedItem().toString()==""){
                return;
            }
            if(Save.status2==1){
            try{
                    con=new Conexion();
                    con.Conectar();
                    int aa=cbxCategory.getSelectedIndex()+1;
                    con.UpdateServiceType(new Service_Type(txtNombre.getText(),PrecioPaq,PrecioInd,aa),Save.Service);
                    con.Desconectar();
                }catch (SQLException ex) {}
                JOptionPane.showMessageDialog(null,"Servicio modificado con éxito.");
            
            }else{
                try{
                    con=new Conexion();
                    con.Conectar();
                    int aa=cbxCategory.getSelectedIndex()+1;
                    con.AddServiceType(new Service_Type(txtNombre.getText(),PrecioPaq,PrecioInd,aa));
                    con.Desconectar();
                }catch (SQLException ex) {}
                JOptionPane.showMessageDialog(null,"Servicio agregado a la lista con éxito.");
            }
                this.dispose();

        }catch(Exception e){
            return;}finally{}
    }//GEN-LAST:event_btnAddInsumosActionPerformed

    private void txtPrecioproductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioproductoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioproductoKeyTyped

    private void txtPrecioproductoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioproductoKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioproductoKeyPressed

    private void txtPrecioproductoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioproductoKeyReleased
             try {
                PrecioInd = Double.parseDouble(txtPrecioproducto.getText());
            } catch (Exception e) {
                PrecioInd = 0;
                txtPrecioproducto.setText(null);
            }finally{}
    }//GEN-LAST:event_txtPrecioproductoKeyReleased

    private void cbxCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoryActionPerformed

    }//GEN-LAST:event_cbxCategoryActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtPrecioproducto1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioproducto1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioproducto1KeyTyped

    private void txtPrecioproducto1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioproducto1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioproducto1KeyPressed

    private void txtPrecioproducto1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioproducto1KeyReleased
            try {
                PrecioPaq = Double.parseDouble(txtPrecioproducto1.getText());
            } catch (Exception e) {
                PrecioPaq = 0;
                txtPrecioproducto1.setText(null);
            }finally{}
    }//GEN-LAST:event_txtPrecioproducto1KeyReleased

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
            java.util.logging.Logger.getLogger(AddService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddService.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddService().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddInsumos;
    private javax.swing.JComboBox<String> cbxCategory;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioproducto;
    private javax.swing.JTextField txtPrecioproducto1;
    // End of variables declaration//GEN-END:variables
}
