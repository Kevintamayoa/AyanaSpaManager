/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayana;

import Classes.*;
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
import Adicional.ExportExc;
import java.awt.GraphicsEnvironment;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author macbook
 */
public class RegInventario extends javax.swing.JFrame {

    /**
     * Creates new form RegInventario
     */
    public RegInventario() {
        initComponents();
      setIconImage(new ImageIcon(getClass().getResource("Images/Screenshot_1.png")).getImage());
        table.getTableHeader().setBackground(Color.white);
        table.getTableHeader().setForeground(Color.black);
        table.getTableHeader().setFont(new Font("InaiMathi", 0, 20)); 
         DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        table.getColumnModel().getColumn(0).setCellRenderer(tcr);
         table.getColumnModel().getColumn(2).setCellRenderer(tcr);
             table.getColumnModel().getColumn(3).setCellRenderer(tcr);
        table.getColumnModel().getColumn(4).setCellRenderer(new CurrencyCellRenderer());
       
        table.getColumnModel().getColumn(1).setCellRenderer(new TimestampCellRenderer());
        ImageIcon imagen1 = new ImageIcon(getClass().getResource("Images/Eliminar.png"));
        Icon fondo1 = new ImageIcon(imagen1.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnEliminar.setIcon(fondo1);
           ImageIcon imagen2 = new ImageIcon(getClass().getResource("Images/Agregar.png"));
        Icon fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnPagar.setIcon(fondo2);
             ImageIcon imagen4 = new ImageIcon(getClass().getResource("Images/Buscar.png"));
        Icon fondo4 = new ImageIcon(imagen4.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        txtBuscar.setIcon(fondo4);
         imagen2 = new ImageIcon(getClass().getResource("Images/Info.png"));
       fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnDetalle.setIcon(fondo2);
          imagen2 = new ImageIcon(getClass().getResource("Images/Editar.png"));
       fondo2 = new ImageIcon(imagen2.getImage().getScaledInstance(25, 25, Image.SCALE_SMOOTH));
        btnDetalle1.setIcon(fondo2);
         model=(DefaultTableModel)table.getModel();
        con=new Conexion();
       
        con.Conectar();        
     try{
     if(Save.status2 ==1){
         request=con.GetRequestByProvider(Save.Provider);
     }else{
          request=con.GetRequest();
     }
      } catch (SQLException ex) {
                 }
     con.Desconectar();
        for(Request obj: request)
        {

            model.addRow(new Object[]{obj.Id,obj.Date,obj.Provider,obj.Comentario,obj.Monto,obj.Pagado(),obj.Recibido()});
        }
              trs=new TableRowSorter(model);
        table.setRowSorter(trs);
    }
    private DefaultTableModel model;
    Conexion con;
    List<Request> request;
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
        btnDetalle = new javax.swing.JMenuItem();
        btnDetalle1 = new javax.swing.JMenuItem();
        btnPagar = new javax.swing.JMenuItem();
        btnEliminar = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbxFiltro = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtBusqueda = new javax.swing.JTextPane();
        txtBuscar = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();

        btnDetalle.setText("Ver detalle");
        btnDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalleActionPerformed(evt);
            }
        });
        SubMenu.add(btnDetalle);

        btnDetalle1.setText("Editar comentario");
        btnDetalle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetalle1ActionPerformed(evt);
            }
        });
        SubMenu.add(btnDetalle1);

        btnPagar.setText("Pagar pedido");
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });
        SubMenu.add(btnPagar);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        SubMenu.add(btnEliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registro de pedidos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("InaiMathi", 0, 12)); // NOI18N

        cbxFiltro.setBackground(new java.awt.Color(255, 248, 245));
        cbxFiltro.setFont(new java.awt.Font("InaiMathi", 0, 14)); // NOI18N
        cbxFiltro.setForeground(new java.awt.Color(51, 51, 51));
        cbxFiltro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Id inventario", "Fecha", "Proveedor", "Comentario", "Monto", " " }));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(245, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("InaiMathi", 1, 20)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Registro de pedidos");
        jLabel5.setToolTipText("");

        table.setBackground(new java.awt.Color(255, 248, 245));
        table.setFont(new java.awt.Font("InaiMathi", 0, 18)); // NOI18N
        table.setForeground(new java.awt.Color(51, 51, 51));
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id inventario", "Fecha", "Proveedor", "Comentario", "Monto", "Pagado", "Recibido"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Double.class, java.lang.Boolean.class, java.lang.Boolean.class
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
        table.setGridColor(new java.awt.Color(153, 153, 153));
        table.setMinimumSize(new java.awt.Dimension(2147483647, 2147483647));
        table.setRowHeight(22);
        table.setSelectionBackground(new java.awt.Color(204, 204, 204));
        table.setSelectionForeground(new java.awt.Color(0, 0, 0));
        table.setShowGrid(true);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tableMouseReleased(evt);
            }
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
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
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 787, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(458, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(77, 77, 77)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
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
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked

    }//GEN-LAST:event_tableMouseClicked

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        try {
            Save.Request = Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
            Save.Providertext = table.getValueAt(table.getSelectedRow(), 2).toString();
            // Request req;

            con = new Conexion();
            con.Conectar();
            try {
                Save.Provider = con.GetProviderByRequestId(Save.Request).Id;
                //req=con.GetRequestById(Save.Request);

            } catch (SQLException ex) {

            }
            con.Desconectar();

            if (!Boolean.parseBoolean(table.getValueAt(table.getSelectedRow(), 5).toString())) {
                boolean simon = false;
                boolean simon2 = false;
                int m = JOptionPane.showConfirmDialog(this,
                        "¿Desea agregar pago a este proveedor? ", "",
                        JOptionPane.YES_NO_OPTION);
                if (m == JOptionPane.YES_OPTION) {
                    AuxPagos form = new AuxPagos();
                    form.setModal(true);
                    form.setVisible(true);
                    simon = true;
                }
                int n = JOptionPane.showConfirmDialog(this,
                        "¿Desea marcar este pedido cómo pagado? ", "",
                        JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    simon2 = true;
                    con = new Conexion();
                    con.Conectar();
                    try {
                        con.UpdateRequestPagado(Save.Request);
                    } catch (SQLException ex) {
                    }
                }

                if (simon ||simon2) {
                    if (!simon2) {
                        con = new Conexion();
                        con.Conectar();
                    }
                }
                try {
                    if (Save.status2 == 1) {
                        request = con.GetRequestByProvider(Save.Provider);
                    } else {
                        request = con.GetRequest();
                    }
                } catch (SQLException ex) {
                }
                con.Desconectar();
                int count = model.getRowCount();
                for (int i = 0; i < count; i++) {
                    model.removeRow(0);
                }

                for (Request obj : request) {
                    model.addRow(new Object[]{obj.Id, obj.Date, obj.Provider, obj.Comentario, obj.Monto, obj.Pagado(), obj.Recibido()});
                }
                JOptionPane.showMessageDialog(this, "Cambio realizado con éxito.");

            } else {
                boolean simon = false;
                boolean simon2 = false;
                int m = JOptionPane.showConfirmDialog(this,
                        "¿Desea agregar pago a este proveedor? ", "",
                        JOptionPane.YES_NO_OPTION);
                if (m == JOptionPane.YES_OPTION) {
                    AuxPagos form = new AuxPagos();
                    form.setModal(true);
                    form.setVisible(true);
                    simon = true;
                }
                if (!simon) {
                    int n = JOptionPane.showConfirmDialog(this,
                            "¿Desea remover la marca de este pedido cómo pagado? ", "",
                            JOptionPane.YES_NO_OPTION);
                    if (n == JOptionPane.YES_OPTION) {
                        simon2 = true;
                        con = new Conexion();
                        con.Conectar();
                        try {
                            con.DowndateRequestPagado(Save.Request);
                        } catch (SQLException ex) {}
                    }
                }
                if (simon || simon2) {
                    if(!simon2){
                        con = new Conexion();
                        con.Conectar();}
                        try {
                            if (Save.status2 == 1) {
                                request = con.GetRequestByProvider(Save.Provider);
                            } else {
                                request = con.GetRequest();
                            }
                        } catch (SQLException ex) {}
                        con.Desconectar();
                    int count = model.getRowCount();
                    for (int i = 0; i < count; i++) {
                        model.removeRow(0);
                    }

                    for (Request obj : request) {
                        model.addRow(new Object[]{obj.Id, obj.Date, obj.Provider, obj.Comentario, obj.Monto, obj.Pagado(), obj.Recibido()});
                    }
                      JOptionPane.showMessageDialog(this, "Cambio realizado con éxito.");
                  
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
  try{
        int n = JOptionPane.showConfirmDialog(this,
"¿Seguro que quiere eliminar este pedido?, se eliminará su contenido y se descontará del inventario.","Confirmación",
JOptionPane.YES_NO_OPTION);
   if(n==JOptionPane.YES_OPTION){
        con=new Conexion();
        con.Conectar();  
     try{
        con.DeleteRequest(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
     if(Save.status2 ==1){
         request=con.GetRequestByProvider(Save.Provider);
     }else{
          request=con.GetRequest();
     }
      } catch (SQLException ex) {}
          con.Desconectar();
        JOptionPane.showMessageDialog(this,"Pedido eliminado con éxito.");
                int count= model.getRowCount();
                for(int i=0;i<count;i++)
                {
                    model.removeRow(0);
                }
               
        for(Request obj: request)
        {
            model.addRow(new Object[]{obj.Id,obj.Date,obj.Provider,obj.Comentario,obj.Monto,obj.Pagado(),obj.Recibido()});
        }
   }}catch(Exception e){}
    }//GEN-LAST:event_btnEliminarActionPerformed

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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      Interfaz.RegInventarioBool=false;
    }//GEN-LAST:event_formWindowClosing

    private void btnDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalleActionPerformed

     try{
        Save.Request=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
         con=new Conexion();
        con.Conectar();  
     try{
           Save.Provider= con.GetProviderByRequestId(Save.Request).Id;
     
      } catch (SQLException ex) {}
          con.Desconectar();
         RegInventarioDet form=new RegInventarioDet();
         form.setBounds(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds());
      
        form.setModal(true);
        
     form.setVisible(true);
      con=new Conexion();
        con.Conectar();  
     try{
     if(Save.status2 ==1){
         request=con.GetRequestByProvider(Save.Provider);
     }else{
          request=con.GetRequest();
     }
       } catch (SQLException ex) {}
          con.Desconectar();
   
         
          int count= model.getRowCount();
                for(int i=0;i<count;i++)
                {
                    model.removeRow(0);
                }
       for(Request obj: request)
        {

            model.addRow(new Object[]{obj.Id,obj.Date,obj.Provider,obj.Comentario,obj.Monto,obj.Pagado(),obj.Recibido()});
        }
       }catch(Exception e){}    
    }//GEN-LAST:event_btnDetalleActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        ExportExc j=new ExportExc();
        try{
            j.exportarExcel(table);}
        catch(IOException e){}
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnDetalle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetalle1ActionPerformed
   try{
        int idd=Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString());
        String name = JOptionPane.showInputDialog(this, "Escriba el nuevo detalle de este pedido:");
if(name!=null){
     con=new Conexion();
        con.Conectar();  
     try{
         con.UpdateComentarioRequest( idd, name);
     if(Save.status2 ==1){
         request=con.GetRequestByProvider(Save.Provider);
     }else{
          request=con.GetRequest();
     }
       } catch (SQLException ex) {}
          con.Desconectar();
       JOptionPane.showMessageDialog(this,"Cambio realizado con éxito."); 
      
    table.setValueAt(name,table.getSelectedRow(), 3);
//         
//          int count= model.getRowCount();
//                for(int i=0;i<count;i++)
//                {
//                    model.removeRow(0);
//                }
//       for(Request obj: request)
//        {
//
//            model.addRow(new Object[]{obj.Id,obj.Date,obj.Provider,obj.Comentario,obj.Monto,obj.Pagado(),obj.Recibido()});
//        }
//    
}}catch(Exception e){}

    }//GEN-LAST:event_btnDetalle1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu SubMenu;
    private javax.swing.JMenuItem btnDetalle;
    private javax.swing.JMenuItem btnDetalle1;
    private javax.swing.JMenuItem btnEliminar;
    private javax.swing.JMenuItem btnPagar;
    private javax.swing.JComboBox<String> cbxFiltro;
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
