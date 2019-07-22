/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayana;

import Adicional.ExportExc;
import Classes.Client;
import Classes.Sale;
import Classes.Save;
import Conexion.Conexion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author macbook
 */
public class VentasMostrador extends javax.swing.JDialog {

    /**
     * Creates new form VentasMostrador
     */
    public VentasMostrador() {
        initComponents();
         setIconImage (new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
  tableVentas.getTableHeader().setBackground(Color.white);
        tableVentas.getTableHeader().setForeground(Color.black);
        tableVentas.getTableHeader().setFont(new Font("InaiMathi", 0, 20));
        tableVentas.getColumnModel().getColumn(3).setCellRenderer(new CurrencyCellRenderer());
        tableVentas.getColumnModel().getColumn(1).setCellRenderer(new TimestampCellRenderer());
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tableVentas.getColumnModel().getColumn(0).setCellRenderer(tcr);
        tableVentas.getColumnModel().getColumn(2).setCellRenderer(tcr);

        ImageIcon imagen1 = new ImageIcon(getClass().getResource("Images/Eliminar.png"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEliminarVenta.setIcon(fondo1);
        ImageIcon imagen2 = new ImageIcon(getClass().getResource("Images/Info.png"));
        Icon fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnVerDetalle.setIcon(fondo2);
       
        ImageIcon imagen4 = new ImageIcon(getClass().getResource("Images/Buscar.png"));
        Icon fondo4 = new ImageIcon(imagen4.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        txtBuscar.setIcon(fondo4);
   con=new Conexion();
        con.Conectar();
        
        try {
            Sales=con.GetSalesByClient(Save.Client);
            client=con.GetClientById(Save.Client);
               DecimalFormat formatea = new DecimalFormat("$###,###.##");    
           txtSaldo.setText(formatea.format(client.Saldo()));

        } catch (SQLException ex) {}
    con.Desconectar();
this.setTitle("Ventas de "+Save.Clienttext);
jLabel5.setText("Ventas de "+Save.Clienttext);
    model=(DefaultTableModel)tableVentas.getModel(); 
    
        for(Sale obj: Sales)
        {
            model.addRow(new Object[]{obj.Id,obj.Date,obj.Comentario,obj.Monto});
        }
        trs=new TableRowSorter(model);
        tableVentas.setRowSorter(trs);   
    }
List<Sale> Sales;
 DecimalFormat formatea;
Conexion con;
Client client;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MenuVentas = new javax.swing.JPopupMenu();
        btnVerDetalle = new javax.swing.JMenuItem();
        btnEliminarVenta = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtBusqueda = new javax.swing.JTextPane();
        txtBuscar = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtSaldo = new javax.swing.JTextPane();
        lblSaldo = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVentas = new javax.swing.JTable();
        btnAgregarPago = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        btnVerDetalle.setText("Ver detalle");
        btnVerDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerDetalleActionPerformed(evt);
            }
        });
        MenuVentas.add(btnVerDetalle);

        btnEliminarVenta.setText("Eliminar");
        btnEliminarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarVentaActionPerformed(evt);
            }
        });
        MenuVentas.add(btnEliminarVenta);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ventas ");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbxFiltro.setBackground(new java.awt.Color(255, 248, 245));
        cbxFiltro.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        cbxFiltro.setForeground(new java.awt.Color(51, 51, 51));
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id venta", "Fecha", "Comentario", "Monto" }));

        jLabel3.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("En:");

        txtBusqueda.setBackground(new java.awt.Color(255, 248, 245));
        txtBusqueda.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(51, 51, 51));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });
        jScrollPane4.setViewportView(txtBusqueda);

        txtBuscar.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setText("Buscar:");

        txtSaldo.setEditable(false);
        txtSaldo.setBackground(new java.awt.Color(255, 255, 255));
        txtSaldo.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        txtSaldo.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        txtSaldo.setForeground(new java.awt.Color(51, 51, 51));
        txtSaldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSaldoKeyTyped(evt);
            }
        });
        jScrollPane7.setViewportView(txtSaldo);

        lblSaldo.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        lblSaldo.setForeground(new java.awt.Color(51, 51, 51));
        lblSaldo.setText("Saldo:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ventas");
        jLabel5.setToolTipText("");

        tableVentas.setBackground(new java.awt.Color(255, 248, 245));
        tableVentas.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        tableVentas.setForeground(new java.awt.Color(0, 0, 0));
        tableVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id venta", "Fecha", "Comentario", "Monto total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableVentas.setColumnSelectionAllowed(true);
        tableVentas.setRowHeight(22);
        tableVentas.setSelectionBackground(new java.awt.Color(204, 204, 204));
        tableVentas.setSelectionForeground(new java.awt.Color(0, 0, 0));
        tableVentas.getTableHeader().setReorderingAllowed(false);
        tableVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableVentasMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVentasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVentas);
        tableVentas.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnAgregarPago.setBackground(new java.awt.Color(217, 234, 220));
        btnAgregarPago.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        btnAgregarPago.setForeground(new java.awt.Color(51, 51, 51));
        btnAgregarPago.setText("Agregar nuevo pago");
        btnAgregarPago.setToolTipText("");
        btnAgregarPago.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(145, 146, 147)));
        btnAgregarPago.setFocusTraversalPolicyProvider(true);
        btnAgregarPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarPagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAgregarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarPago, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(429, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(81, 81, 81)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jMenuBar1.setBackground(new java.awt.Color(255, 248, 245));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jMenu2.setBackground(new java.awt.Color(255, 248, 245));
        jMenu2.setForeground(new java.awt.Color(51, 51, 51));
        jMenu2.setText("Exportar");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setBackground(new java.awt.Color(255, 248, 245));
        jMenuItem3.setForeground(new java.awt.Color(51, 51, 51));
        jMenuItem3.setText("Archivo de Excel");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 910, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 483, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasMouseClicked
      
    }//GEN-LAST:event_tableVentasMouseClicked
TableRowSorter trs;
 private DefaultTableModel model;
    private void tableVentasMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVentasMouseReleased
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
MenuVentas.show(tableVentas, evt.getX(), evt.getY());
        }
    }//GEN-LAST:event_tableVentasMouseReleased

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        txtBusqueda.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusqueda.getText(),cbxFiltro.getSelectedIndex()));
            }

        });
        trs=new TableRowSorter(model);
        tableVentas.setRowSorter(trs);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnVerDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerDetalleActionPerformed
        try{
            Save.Sale2=Sales.stream()
            .    filter(obj -> Integer.parseInt(tableVentas.getValueAt(tableVentas.getSelectedRow(), 0).toString())==obj.Id)
            .    findAny()
            .    orElse(null);
            VerContenidoVenta form= new VerContenidoVenta();
             form.setModal(true);
            form.setVisible(true);
        }catch(Exception e){}
    }//GEN-LAST:event_btnVerDetalleActionPerformed

    private void btnEliminarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarVentaActionPerformed
        try{
            int n = JOptionPane.showConfirmDialog(this,
                "¿Desea eliminar el pedido número "+tableVentas.getValueAt(tableVentas.getSelectedRow(), 0).toString()+
                " ?, se eliminará todo su contenido a excepción de los pagos. ","",
                JOptionPane.YES_NO_OPTION);
            if(n==JOptionPane.YES_OPTION){

                con=new Conexion();
                con.Conectar();
                try{
                    con.DeleteSale(Integer.parseInt(tableVentas.getValueAt(tableVentas.getSelectedRow(), 0).toString()));
               Sales=con.GetSalesByClient(Save.Client);
               client=con.GetClientById(Save.Client);
               DecimalFormat formatea = new DecimalFormat("$###,###.##");    
           txtSaldo.setText(formatea.format(client.Saldo()));
                } catch (SQLException ex) {}
                con.Desconectar();
                JOptionPane.showMessageDialog(this,"Eliminado realizado con éxito.");

                model=(DefaultTableModel)tableVentas.getModel();
                int count= model.getRowCount();
                for(int i=0;i<count;i++)
                {
                    model.removeRow(0);
                }

                for(Sale obj: Sales)
                {
                    model.addRow(new Object[]{obj.Id,obj.Date,obj.Comentario,obj.Monto});
                }
            }
        }catch(Exception e){}

    }//GEN-LAST:event_btnEliminarVentaActionPerformed

    private void btnAgregarPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarPagoActionPerformed
        Save.ingreso=1;
        try{
            Save.Providertext=client.Description;

            Save.Client=client.Id;
            AddPagoCliente form=new AddPagoCliente();
            form.setModal(true);
            form.setVisible(true);
        }catch(Exception e){}
        int j=model.getRowCount();
        for(int i=0;i<j;i++){
            model.removeRow(j-i-1);
        }
        con=new Conexion();
        con.Conectar();
        try{
                    Sales=con.GetSalesByClient(Save.Client);
               client=con.GetClientById(Save.Client);
               DecimalFormat formatea = new DecimalFormat("$###,###.##");    
           txtSaldo.setText(formatea.format(client.Saldo()));

        } catch (SQLException ex) {
        }
        con.Desconectar();
      for(Sale obj: Sales)
                {
                    model.addRow(new Object[]{obj.Id,obj.Date,obj.Comentario,obj.Monto});
                }

    }//GEN-LAST:event_btnAgregarPagoActionPerformed

    private void txtSaldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSaldoKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSaldoKeyTyped

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ExportExc j=new ExportExc();
        try{
            j.exportarExcel(tableVentas);}
        catch(IOException e){}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

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
            java.util.logging.Logger.getLogger(VentasMostrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentasMostrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentasMostrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentasMostrador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentasMostrador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu MenuVentas;
    private javax.swing.JButton btnAgregarPago;
    private javax.swing.JMenuItem btnEliminarVenta;
    private javax.swing.JMenuItem btnVerDetalle;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JTable tableVentas;
    private javax.swing.JLabel txtBuscar;
    private javax.swing.JTextPane txtBusqueda;
    private javax.swing.JTextPane txtSaldo;
    // End of variables declaration//GEN-END:variables
}
