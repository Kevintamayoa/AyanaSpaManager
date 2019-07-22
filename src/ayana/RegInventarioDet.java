/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayana;

import Adicional.ExportExc;
import Classes.Inventory;
import Classes.Request;
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
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author macbook
 */
public class RegInventarioDet extends javax.swing.JDialog {

    /**
     * Creates new form RegInventarioDet
     */
    public RegInventarioDet() {
        initComponents();
    setIconImage(new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
        table.getTableHeader().setBackground(Color.white);
        table.getTableHeader().setForeground(Color.black);
        table.getTableHeader().setFont(new Font("InaiMathi", 0,20)); 
        table.getColumnModel().getColumn(5).setCellRenderer(new CurrencyCellRenderer());
        table.getColumnModel().getColumn(4).setCellRenderer(new CurrencyCellRenderer());
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        table.getColumnModel().getColumn(0).setCellRenderer(tcr);
          table.getColumnModel().getColumn(3).setCellRenderer(tcr);
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("Images/Eliminar.png"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEliminar.setIcon(fondo1);
           ImageIcon imagen2 = new ImageIcon(getClass().getResource("Images/Agregar.png"));
        Icon fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnRecibir.setIcon(fondo2);
             ImageIcon imagen4 = new ImageIcon(getClass().getResource("Images/Buscar.png"));
        Icon fondo4 = new ImageIcon(imagen4.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        txtBuscar.setIcon(fondo4);
        con=new Conexion();
        model=(DefaultTableModel)table.getModel();
        con.Conectar();        
     try{
         inventory=con.GetInventoryByRequest(Save.Request);
    
      } catch (SQLException ex) {
                 }
     con.Desconectar();
        for(Inventory obj: inventory)
        {
            model.addRow(new Object[]{obj.Id,obj.Cat,obj.Type,obj.Qty,obj.Cost,obj.CostUnit(),obj.Sta()});
        }
              trs=new TableRowSorter(model);
        table.setRowSorter(trs);
    }
  private DefaultTableModel model;
Conexion con;
List<Inventory> inventory;
 TableRowSorter trs;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        SubMenu = new javax.swing.JPopupMenu();
        btnRecibir = new javax.swing.JMenuItem();
        btnEliminar = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBusqueda = new javax.swing.JTextPane();
        txtBuscar = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        btnRecibir.setText("Recibir producto");
        btnRecibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecibirActionPerformed(evt);
            }
        });
        SubMenu.add(btnRecibir);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        SubMenu.add(btnEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        cbxFiltro.setBackground(new java.awt.Color(255, 248, 245));
        cbxFiltro.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        cbxFiltro.setForeground(new java.awt.Color(51, 51, 51));
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id", "Categoría", "Producto", "Cantidad", "Costo total", "Costo unitario" }));

        jLabel3.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 51, 51));
        jLabel3.setText("En:");

        txtBusqueda.setBackground(new java.awt.Color(255, 248, 245));
        txtBusqueda.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        txtBusqueda.setForeground(new java.awt.Color(51, 51, 51));
        txtBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaKeyTyped(evt);
            }
        });
        jScrollPane3.setViewportView(txtBusqueda);

        txtBuscar.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        txtBuscar.setForeground(new java.awt.Color(51, 51, 51));
        txtBuscar.setText("Buscar:");

        jCheckBox1.setBackground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(55, 55, 55));
        jCheckBox1.setText("Recibir todo");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.CENTER, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addGap(12, 12, 12))))
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registro de pedidos detallado");
        jLabel5.setToolTipText("");

        table.setBackground(new java.awt.Color(255, 248, 245));
        table.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        table.setForeground(new java.awt.Color(0, 0, 0));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Categoría", "Producto", "Cantidad", "Costo total", "Costo unitario", "Recibido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        table.setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        table.setRowHeight(22);
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table.setShowGrid(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(423, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(82, 82, 82)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                    .addGap(12, 12, 12)))
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseReleased
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
        evt.consume();
        SubMenu.show(table, evt.getX(), evt.getY());
        }    
    }//GEN-LAST:event_tableMouseReleased

    private void txtBusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaKeyTyped
        txtBusqueda.addKeyListener(new KeyAdapter(){
            @Override
            public void keyReleased(KeyEvent ke){
                trs.setRowFilter(RowFilter.regexFilter("(?i)"+txtBusqueda.getText(),cbxFiltro.getSelectedIndex()));
            }

        });
        trs=new TableRowSorter(model);
        table.setRowSorter(trs);
    }//GEN-LAST:event_txtBusquedaKeyTyped

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
  try{
        int n = JOptionPane.showConfirmDialog(this,
"¿Seguro que quiere eliminar este producto del pedido?,  se descontará del inventario si ya ha sido confirmado.","Confirmación",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
        con=new Conexion();
        con.Conectar();  
     try{
        con.DeleteRegRequest(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
     inventory=con.GetInventoryByRequest(Save.Request);
      } catch (SQLException ex) {}
          con.Desconectar();
        JOptionPane.showMessageDialog(this,"Producto del pedido eliminado con éxito.");
                int count= model.getRowCount();
                for(int i=0;i<count;i++)
                {
                    model.removeRow(0);
                }
      for(Inventory obj: inventory)
        {
            model.addRow(new Object[]{obj.Id,obj.Cat,obj.Type,obj.Qty,obj.Cost,obj.CostUnit(),obj.Sta()});
        }
   }}catch(Exception e){}
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnRecibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecibirActionPerformed
      try{
          if(Boolean.parseBoolean(table.getValueAt(table.getSelectedRow(), 6).toString())==false){
              con=new Conexion();
        con.Conectar();  
     try{
        con.RecibirRegRequest(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
         inventory=con.GetInventoryByRequest(Save.Request);
    
      } catch (SQLException ex) {}
          con.Desconectar();
        JOptionPane.showMessageDialog(this,"Producto del pedido recibido y agregado al inventario con éxito.");
          }else{
               int n = JOptionPane.showConfirmDialog(this,
"¿Seguro que quiere cancelar el recibo de este producto?,  se descontará del inventario.","Confirmación",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
        con=new Conexion();
        con.Conectar();  
     try{
     con.DesrecibirRegRequest(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
      inventory=con.GetInventoryByRequest(Save.Request);
    
       } catch (SQLException ex) {}
          con.Desconectar();
        JOptionPane.showMessageDialog(this,"Producto del pedido descontado con éxito.");
   }
          }
          int count= model.getRowCount();
                for(int i=0;i<count;i++)
                {
                    model.removeRow(0);
                }
      for(Inventory obj: inventory)
        {
            model.addRow(new Object[]{obj.Id,obj.Cat,obj.Type,obj.Qty,obj.Cost,obj.CostUnit(),obj.Sta()});
        }
          
          
       }catch(Exception e){}
    }//GEN-LAST:event_btnRecibirActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (jCheckBox1.isSelected()) {
             int n = JOptionPane.showConfirmDialog(this,
"¿Seguro que quiere recibir todos los productos?","Confirmación",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
            con = new Conexion();
            con.Conectar();
            try {
                for (Inventory obj : inventory) {
                    if (obj.Status == 0) {
                        con.RecibirRegRequest(obj.Id);
                     }
                }
                      inventory = con.GetInventoryByRequest(Save.Request);                     
            } catch (SQLException ex) {
            }
            con.Desconectar();
        }
             JOptionPane.showMessageDialog(this,"Los productos del pedido han sido recibidos y agregados al inventario con éxito.");
      int count= model.getRowCount();
                for(int i=0;i<count;i++)
                {
                    model.removeRow(0);
                }
      for(Inventory obj: inventory)
        {
            model.addRow(new Object[]{obj.Id,obj.Cat,obj.Type,obj.Qty,obj.Cost,obj.CostUnit(),obj.Sta()});
        }
        } else {
             int n = JOptionPane.showConfirmDialog(this,
"¿Seguro que quiere cancelar el recibo de todos los productos?, se descontaran del inventario.","Confirmación",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
            con = new Conexion();
            con.Conectar();
            try {
                for (Inventory obj : inventory) {
                    if (obj.Status == 1) {
                        con.DesrecibirRegRequest(obj.Id);
                     }
                }
                      inventory = con.GetInventoryByRequest(Save.Request);                     
            } catch (SQLException ex) {
            }
            con.Desconectar();
        }
             JOptionPane.showMessageDialog(this,"Los productos del pedido han sido descontados del inventario con éxito.");
      int count= model.getRowCount();
                for(int i=0;i<count;i++)
                {
                    model.removeRow(0);
                }
      for(Inventory obj: inventory)
        {
            model.addRow(new Object[]{obj.Id,obj.Cat,obj.Type,obj.Qty,obj.Cost,obj.CostUnit(),obj.Sta()});
        }
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ExportExc j=new ExportExc();
        try{
            j.exportarExcel(table);}
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
            java.util.logging.Logger.getLogger(RegInventarioDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegInventarioDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegInventarioDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegInventarioDet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegInventarioDet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu SubMenu;
    private javax.swing.JMenuItem btnEliminar;
    private javax.swing.JMenuItem btnRecibir;
    private javax.swing.JComboBox<String> cbxFiltro;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable table;
    private javax.swing.JLabel txtBuscar;
    private javax.swing.JTextPane txtBusqueda;
    // End of variables declaration//GEN-END:variables
}
