/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayana;

import Classes.Account;
import Classes.Client;
import Classes.Save;
import Conexion.Conexion;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author macbook
 */
public class AddClient extends javax.swing.JDialog {

    /**
     * Creates new form AddClient
     */
    public AddClient() {
        initComponents();
      setIconImage (new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
     ImageIcon imagen = new ImageIcon(getClass().getResource("Images/Guardar.png"));
      Icon  fondo = new ImageIcon(imagen.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnCapturaEgresos.setIcon(fondo);
        if(Save.status2==1){
            this.setTitle("Editar cliente");
            jLabel8.setText("Editar cliente");
            try{
            con=new Conexion();
            con.Conectar();
            clientes=con.GetClients();
            con.Desconectar();
                
            cliente= clientes.stream()
            .filter(obj -> Save.Client==obj.Id)
            .findAny()
            .orElse(null);
              }catch(Exception e){
              JOptionPane.showMessageDialog(this,"Error de conexión.");
        }finally{}
            txtName.setText(cliente.Description);
            txtAdress.setText(cliente.Direccion);
            txtEmail.setText(cliente.Email);
            txtPhone.setText(cliente.Telefono);
        }
    }
Conexion con;
List<Client> clientes;
Client cliente;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtName = new javax.swing.JTextField();
        txtAdress = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPhone = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnCapturaEgresos = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nuevo cliente");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtName.setBackground(new java.awt.Color(255, 248, 245));
        txtName.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(102, 102, 102));
        txtName.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtName.setFocusTraversalPolicyProvider(true);

        txtAdress.setBackground(new java.awt.Color(255, 248, 245));
        txtAdress.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtAdress.setForeground(new java.awt.Color(102, 102, 102));
        txtAdress.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtAdress.setFocusTraversalPolicyProvider(true);

        txtEmail.setBackground(new java.awt.Color(255, 248, 245));
        txtEmail.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtEmail.setForeground(new java.awt.Color(102, 102, 102));
        txtEmail.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtEmail.setFocusTraversalPolicyProvider(true);
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtPhone.setBackground(new java.awt.Color(255, 248, 245));
        txtPhone.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        txtPhone.setForeground(new java.awt.Color(102, 102, 102));
        txtPhone.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 51, 51), 1, true));
        txtPhone.setFocusTraversalPolicyProvider(true);

        jLabel4.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel4.setText("Nombre");

        jLabel7.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel7.setText("Teléfono");

        btnCapturaEgresos.setBackground(new java.awt.Color(255, 255, 255));
        btnCapturaEgresos.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        btnCapturaEgresos.setForeground(new java.awt.Color(102, 102, 102));
        btnCapturaEgresos.setText("Guardar");
        btnCapturaEgresos.setToolTipText("");
        btnCapturaEgresos.setBorder(null);
        btnCapturaEgresos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturaEgresosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel5.setText("Dirección");

        jLabel6.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel6.setText("Email");

        jLabel8.setBackground(new java.awt.Color(217, 234, 220));
        jLabel8.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nuevo cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(174, 174, 174)
                .addComponent(btnCapturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAdress, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnCapturaEgresos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCapturaEgresosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturaEgresosActionPerformed
       
            if(txtName.getText().length()<2){
               JOptionPane.showMessageDialog(this,"El nombre del cliente debe tener almenos dos carácteres.","Datos incompletos",JOptionPane.ERROR_MESSAGE);
           return;
            }
                if(Save.status2==0){
                    try{
             Client client= clientes.stream()
            .filter(obj -> txtName.getText().toString().toLowerCase().equals(obj.Description.toLowerCase()))
            .findAny()
            .orElse(null);
             if(client!=null){
                     JOptionPane.showMessageDialog(this,"Cliente ya existente","Datos incompletos",JOptionPane.ERROR_MESSAGE);
          
              return;}
                    }catch(Exception e){
              }
                    try{
                    con=new Conexion();
                    con.Conectar();
                    con.AddClient(new Client(txtName.getText(),txtAdress.getText(),txtEmail.getText(),txtPhone.getText()));
                    con.Desconectar();
                      JOptionPane.showMessageDialog(this,"Éxito en el guardado");
                     
                      this.dispose();
                       }catch(Exception e){
                   }
                    
                }else{
                     try{
             Client client= clientes.stream()
            .filter(obj -> txtName.getText().toString().toLowerCase().equals(obj.Description.toLowerCase()))
            .findAny()
            .orElse(null);
             if(client.Id!=cliente.Id){
                   JOptionPane.showMessageDialog(this,"Cliente ya existente","Datos incompletos",JOptionPane.ERROR_MESSAGE);
              return;
             }
                                }catch(Exception e){
                   }finally{}
 try{
                    con=new Conexion();
                    con.Conectar();
                    con.UpdateClient(new Client(cliente.Id,txtName.getText(),txtAdress.getText(),txtEmail.getText(),txtPhone.getText()));
                    con.Desconectar();
                      JOptionPane.showMessageDialog(this,"Éxito en el guardado");
                        this.dispose();
                       }catch(Exception e){
                   }finally{}

                }
                
    }//GEN-LAST:event_btnCapturaEgresosActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

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
            java.util.logging.Logger.getLogger(AddClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapturaEgresos;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtAdress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}