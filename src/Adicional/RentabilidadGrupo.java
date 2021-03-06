/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicional;

import Classes.Account;
import Classes.Expense;
import Classes.Expense_Type;
import Classes.Flujo;
import Classes.Income;
import Classes.Income_Type;
import Conexion.Conexion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import jxl.write.Border;

/**
 *
 * @author macbook
 */
public class RentabilidadGrupo extends JFrame implements ActionListener {
    Object[][] data;
    Object[] roww;
    Conexion con;
    Object[] columnas;
    JTable fixedTable, table;
    private int FIXED_NUM = 2;
    java.util.List<Expense_Type> expensestype;
    java.util.List<Income_Type> incomestype;
    java.util.List<Account> cuentas;
    double saldoinicial2019;
       java.util.List<Expense> expenses;
       java.util.List<Income> incomes;
       java.util.List<Flujo> flujo;
         java.util.List<Flujo> products;
        java.util.List<Flujo> flujoegresos;
  public RentabilidadGrupo() {
    super( "Rentabilidad del grupo Ayana Spa" );
 
        
              con=new Conexion();
       con.Conectar();  
         try{
     expensestype= con.GetExpensesTypesFlujo();
      incomestype= con.GetIncomesTypesFluj();
    expenses= con.GetExpenses(2019);
    incomes= con.GetIncomes(2019);
    flujo=con.GetRentabilidad();
    flujoegresos=con.GetFlujoEgresosGiftCARD();
     cuentas=con.GetAccounts2();    
     products=con.GetProductsCost();
         }catch(SQLException e){
             
         } 
           double saldoinicial2019=0;
            con.Desconectar();       
       /////////////////////////////////////////////

    roww = new Object[35+incomestype.size()+expensestype.size()];
    for(int m=0;m<35+incomestype.size()+expensestype.size();m++){
    roww[m]="";
    }
    columnas= new Object[]{"        "," ENERO ","        ","        ","FEBRERO","        ","        ","MARZO","        ",
            "        ","ABRIL","        ","        ","MAYO","        ","        ","JUNIO","        ","        ","JULIO","        ",
            "        ","AGOSTO","        ","        ","SEPTIEMBRE","        ","        ","OCTUBRE","        ","        ","NOVIEMBRE","        ",
           "        ","DICIEMBRE","        ","        ","TOTAL","        "}    ;
    
     data =  new Object[roww.length][columnas.length];
     for(int m=0;m<roww.length;m++){
     for(int n=0;n<columnas.length;n++){
    data[m][n]="";
    } 
     }
      for(int j=0;j<13;j++){
             data[0][j*3]="Real";
             data[0][1+j*3]="PPT";
             data[0][2+j*3]="Var";
             }
       //////////////////////////////////////////////////
       double saldoinicial=0;
         
  saldoinicial=saldoinicial2019;
            
           double saldoinicial1=saldoinicial;
       int contingresos=0;
       int contegresos=0;
       int [] titulosingresos=new int [2];
         titulosingresos[0]=0;
           titulosingresos[1]=0;
       int [] titulosegresos=new int [8];
             for(int i=0;i<8;i++){
       titulosegresos[i]=0;
       }
       double [][][] ingresostit=new double[2][13][3];
       double [][][] egresostit=new double[8][13][3];
       double [][][] ingresos=new double[incomestype.size()+6][13][3];
       double [][][] egresos=new double[expensestype.size()+1][13][3];
       for(int j=0;j<13;j++){
       for(int k=0;k<3;k++){
            for(int i=0;i<incomestype.size();i++){
       ingresos[i][j][k]=0;
       }
            for(int i=0;i<expensestype.size();i++){
       egresos[i][j][k]=0;
       }
                for(int i=0;i<2 ;i++){
       ingresostit[i][j][k]=0;
       }
                    for(int i=0;i<8;i++){
       egresostit[i][j][k]=0;
       }
       }
       }
       for(int i=0;i<incomes.size();i++){
       int mes=incomes.get(i).Date.getMonth();
        for(int j=0;j<incomestype.size();j++){
        if(incomestype.get(j).Id==incomes.get(i).Type_Id){
            ingresos[j][mes][0]+=incomes.get(i).Amount;
                  ingresos[j][12][0]+=incomes.get(i).Amount;
        }
        }
       }
          for(int i=0;i<flujo.size();i++){
       int mes=flujo.get(i).Month-1;
           ingresostit[0][mes][0]+=flujo.get(i).Amount2();
           ingresostit[0][12][0]+=flujo.get(i).Amount2();               
            ingresos[incomestype.size()][mes][0]+=flujo.get(i).Product;
                  ingresos[incomestype.size()][12][0]+=flujo.get(i).Product;
                     ingresos[incomestype.size()+1][mes][0]+=flujo.get(i).Giftcard;
                  ingresos[incomestype.size()+1][12][0]+=flujo.get(i).Giftcard;
                     ingresos[incomestype.size()+2][mes][0]+=flujo.get(i).Facial;
                  ingresos[incomestype.size()+2][12][0]+=flujo.get(i).Facial;
                     ingresos[incomestype.size()+3][mes][0]+=flujo.get(i).BTL;
                  ingresos[incomestype.size()+3][12][0]+=flujo.get(i).BTL;
                     ingresos[incomestype.size()+4][mes][0]+=flujo.get(i).Masaje;
                  ingresos[incomestype.size()+4][12][0]+=flujo.get(i).Masaje;
         ingresos[incomestype.size()+5][mes][0]+=flujo.get(i).Medico;
                  ingresos[incomestype.size()+5][12][0]+=flujo.get(i).Medico;
       }
             for(int mes=0;mes<12;mes++){
                 ingresos[incomestype.size()][mes][1] = 25255.94;
                 
                 ingresos[incomestype.size()][12][1] += 25255.94;
                 ingresos[incomestype.size() + 1][mes][1] += 0;
                 ingresos[incomestype.size() + 1][12][1] += 0;
                 ingresos[incomestype.size() + 2][mes][1] = 50511.87;
                 ingresos[incomestype.size() + 2][12][1] += 50511.87;
                 ingresos[incomestype.size() + 3][mes][1] = 40409.5;
                 ingresos[incomestype.size() + 3][12][1] += 40409.5;
                 ingresos[incomestype.size() + 4][mes][1] = 10102.37;
                 ingresos[incomestype.size() + 4][12][1] += 10102.37;
                 ingresos[incomestype.size() + 5][mes][1] += 0;
                 ingresos[incomestype.size() + 5][12][1] += 0;
             }
             for(int mes=0;mes<13;mes++){

                 ingresos[incomestype.size()][mes][2] = (ingresos[incomestype.size()][mes][0]/ingresos[incomestype.size()][mes][1]);
                 ingresos[incomestype.size()+2][mes][2] = (ingresos[incomestype.size()+2][mes][0]/ingresos[incomestype.size()+2][mes][1]);
                  ingresos[incomestype.size()+3][mes][2] = (ingresos[incomestype.size()+3][mes][0]/ingresos[incomestype.size()+3][mes][1]);
                 ingresos[incomestype.size()+4][mes][2] =(ingresos[incomestype.size()+4][mes][0]/ingresos[incomestype.size()+4][mes][1]);

             }
  for(int i=0;i<expenses.size();i++){
       int mes=expenses.get(i).Date.getMonth();
        for(int j=0;j<expensestype.size();j++){
        if(expensestype.get(j).Id==expenses.get(i).Type_Id){
            if(expenses.get(i).Type_Id!=1){
            egresos[j][mes][0]+=expenses.get(i).Amount;
               egresos[j][12][0]+=expenses.get(i).Amount;
            }
        }
        }
       }
     for(int i=0;i<products.size();i++){
       int mes=products.get(i).Month-1;
           egresos[3][mes][0]+=products.get(i).Amount;
               egresos[3][12][0]+=products.get(i).Amount;
       }
   for(int i=0;i<flujoegresos.size();i++){
       int mes=flujoegresos.get(i).Month-1;
      
            egresos[expensestype.size()][mes][0]+=flujo.get(i).Amount;
                  egresos[expensestype.size()][12][0]+=flujo.get(i).Amount;
              egresostit[7][mes][0]+=flujo.get(i).Amount;
             egresostit[7][12][0]+=flujo.get(i).Amount;   
       }
        DecimalFormat formatea = new DecimalFormat("$###,###.##");
         DecimalFormat formatea2 = new DecimalFormat("###,###.##%");
        for(int i=0;i<incomestype.size();i++){
            for(int j=0;j<12;j++){
                if(incomestype.get(i).Category_Id==1){
                  ingresostit[0][j][1]+=incomestype.get(i).Ppt;  

                  ingresostit[0][12][1]+=incomestype.get(i).Ppt;  
                }else{
                           ingresostit[1][j][0]+=ingresos[i][j][0];
                  ingresostit[1][j][1]+=incomestype.get(i).Ppt; 
                  ingresostit[1][12][0]+=ingresos[i][j][0];
                  ingresostit[1][12][1]+=incomestype.get(i).Ppt; 
                }
            ingresos[i][j][1]=incomestype.get(i).Ppt;
            if(ingresos[i][j][1]!=0){
            ingresos[i][j][2]=ingresos[i][j][0]/ingresos[i][j][1];
            }
            ingresos[i][12][1]+=incomestype.get(i).Ppt;
            if(i==incomestype.size()-1){
             if(ingresostit[0][j][1]!=0){
            ingresostit[0][j][2]=ingresostit[0][j][0]/ingresostit[0][j][1];
            }
              if(ingresostit[1][j][1]!=0){
            ingresostit[1][j][2]=ingresostit[1][j][0]/ingresostit[1][j][1];
            }
            }
            }
             if(ingresos[i][12][1]!=0){
            ingresos[i][12][2]=ingresos[i][12][0]/ingresos[i][12][1];
            }
             if(incomestype.get(i).Category_Id==1){
            titulosingresos[0]+=1;
             }else{
                   titulosingresos[1]+=1;
             }
        }   
             if(ingresostit[0][12][1]!=0){
            ingresostit[0][12][2]=ingresostit[0][12][0]/ingresostit[0][12][1];
            }
              if(ingresostit[1][12][1]!=0){
            ingresostit[1][12][2]=ingresostit[1][12][0]/ingresostit[1][12][1];
            }
              
              
        for(int i=0;i<expensestype.size();i++){
            for(int j=0;j<12;j++){
            egresos[i][j][1]=expensestype.get(i).Ppt;
            
             if(expensestype.get(i).Category_Id==1){
             egresostit[0][j][1]+=expensestype.get(i).Ppt;
             egresostit[0][j][0]+=egresos[i][j][0];
             egresostit[0][12][1]+=expensestype.get(i).Ppt;
             egresostit[0][12][0]+=egresos[i][j][0];
             }else  if(expensestype.get(i).Category_Id==2){
             egresostit[1][j][1]+=expensestype.get(i).Ppt;
             egresostit[1][j][0]+=egresos[i][j][0];
             egresostit[1][12][1]+=expensestype.get(i).Ppt;
             egresostit[1][12][0]+=egresos[i][j][0];
             }else  if(expensestype.get(i).Category_Id==3){
              egresostit[2][j][1]+=expensestype.get(i).Ppt;
             egresostit[2][j][0]+=egresos[i][j][0];
             egresostit[2][12][1]+=expensestype.get(i).Ppt;
             egresostit[2][12][0]+=egresos[i][j][0];
             } else  if(expensestype.get(i).Category_Id==4){
              egresostit[3][j][1]+=expensestype.get(i).Ppt;
             egresostit[3][j][0]+=egresos[i][j][0];
             egresostit[3][12][1]+=expensestype.get(i).Ppt;
             egresostit[3][12][0]+=egresos[i][j][0];
             } else  if(expensestype.get(i).Category_Id==5){
              egresostit[4][j][1]+=expensestype.get(i).Ppt;
             egresostit[4][j][0]+=egresos[i][j][0];
             egresostit[4][12][1]+=expensestype.get(i).Ppt;
             egresostit[4][12][0]+=egresos[i][j][0];
             } else  if(expensestype.get(i).Category_Id==6){
             egresostit[5][j][1]+=expensestype.get(i).Ppt;
             egresostit[5][j][0]+=egresos[i][j][0];
             egresostit[5][12][1]+=expensestype.get(i).Ppt;
             egresostit[5][12][0]+=egresos[i][j][0];
             } else  if(expensestype.get(i).Category_Id==7){
             egresostit[6][j][1]+=expensestype.get(i).Ppt;
             egresostit[6][j][0]+=egresos[i][j][0];
             egresostit[6][12][1]+=expensestype.get(i).Ppt;
             egresostit[6][12][0]+=egresos[i][j][0];
             } else  if(expensestype.get(i).Category_Id==8){
             egresostit[7][j][1]+=expensestype.get(i).Ppt;
             egresostit[7][j][0]+=egresos[i][j][0];
             egresostit[7][12][1]+=expensestype.get(i).Ppt;
             egresostit[7][12][0]+=egresos[i][j][0];
             } 
            
             if(egresos[i][j][1]!=0){
            egresos[i][j][2]=egresos[i][j][0]/egresos[i][j][1];
            }
            egresos[i][12][1]+=expensestype.get(i).Ppt;
            if(i==expensestype.size()-1){
                 for(int k=0;k<8;k++){
                  if(egresostit[k][j][1]!=0){
            egresostit[k][j][2]=egresostit[k][j][0]/egresostit[k][j][1];
            }                
                 }       
            }
            }
             if(egresos[i][12][1]!=0){
            egresos[i][12][2]=egresos[i][12][0]/egresos[i][12][1];
            }
             if(expensestype.get(i).Category_Id==1){
            titulosegresos[0]+=1;
             }else  if(expensestype.get(i).Category_Id==2){
            titulosegresos[1]+=1;
             }else  if(expensestype.get(i).Category_Id==3){
            titulosegresos[2]+=1;
             } else  if(expensestype.get(i).Category_Id==4){
            titulosegresos[3]+=1;
             } else  if(expensestype.get(i).Category_Id==5){
            titulosegresos[4]+=1;
             } else  if(expensestype.get(i).Category_Id==6){
            titulosegresos[5]+=1;
             } else  if(expensestype.get(i).Category_Id==7){
            titulosegresos[6]+=1;
             } else  if(expensestype.get(i).Category_Id==8){
            titulosegresos[7]+=1;
             } 
        } 
        for(int k=0;k<8;k++){
                  if(egresostit[k][12][1]!=0){
            egresostit[k][12][2]=egresostit[k][12][0]/egresostit[k][12][1];
            }
        }     
  ///////////////
     int row=2;
              int rowtitulo=1;
                double montoaux=0;
                  double pptaux=0;
              double varaux=0;
int fakerow=0;
              boolean pasada=false;
    for(int i=0;i<incomestype.size();i++){
            if(i<titulosingresos[0]){
                if(pasada==false){
                     roww[rowtitulo]="INGRESOS";
                    for(int j=0;j<13;j++){
             data[rowtitulo][j*3]=formatea.format(ingresostit[0][j][0]);
             data[rowtitulo][1+j*3]=formatea.format(ingresostit[0][j][1]);
             data[rowtitulo][2+j*3]=formatea2.format(ingresostit[0][j][2]);
                    }
                    pasada=true;
                }
                  roww[row]="Producto";
                   roww[row+1]="Tarjeta de regalo";
                    roww[row+2]="Faciales";
                     roww[row+3]="BTL";
                      roww[row+4]="Masajes"; 
                      roww[row+5]="Médico";
                      
               for(int j=0;j<13;j++){
                   
             data[row][j*3]=formatea.format(ingresos[incomestype.size()][j][0]);
             data[row][1+j*3]=formatea.format(ingresos[incomestype.size()][j][1]);
                   data[row][2 + j * 3] = formatea2.format(ingresos[incomestype.size()][j][2] );
                   data[row + 1][j * 3] = formatea.format(ingresos[incomestype.size() + 1][j][0]);
                   data[row + 1][1 + j * 3] = formatea.format(ingresos[incomestype.size() + 1][j][1]);
                   data[row + 1][2 + j * 3] = formatea2.format(ingresos[incomestype.size() + 1][j][2] );
                   data[row + 2][j * 3] = formatea.format(ingresos[incomestype.size() + 2][j][0]);
                   data[row + 2][1 + j * 3] = formatea.format(ingresos[incomestype.size() + 2][j][1]);
                   data[row + 2][2 + j * 3] = formatea2.format(ingresos[incomestype.size() + 2][j][2] );
                   data[row + 3][j * 3] = formatea.format(ingresos[incomestype.size() + 3][j][0]);
                   data[row + 3][1 + j * 3] = formatea.format(ingresos[incomestype.size() + 3][j][1]);
                   data[row + 3][2 + j * 3] = formatea2.format(ingresos[incomestype.size() + 3][j][2] );
                   data[row + 4][j * 3] = formatea.format(ingresos[incomestype.size() + 4][j][0]);
                   data[row + 4][1 + j * 3] = formatea.format(ingresos[incomestype.size() + 4][j][1]);
                   data[row + 4][2 + j * 3] = formatea2.format(ingresos[incomestype.size() + 4][j][2] );
                   data[row + 5][j * 3] = formatea.format(ingresos[incomestype.size() + 5][j][0]);
                   data[row + 5][1 + j * 3] = formatea.format(ingresos[incomestype.size() + 5][j][1]);
                   data[row + 5][2 + j * 3] = formatea2.format(ingresos[incomestype.size() + 5][j][2] );
                 }
           
row+=6;
            }else{
                 if(pasada==true){
                      fakerow=rowtitulo+titulosingresos[0]+titulosegresos[7]+titulosegresos[0]+
                      titulosegresos[1]+titulosegresos[2]+titulosegresos[3]+titulosegresos[4]
                      +titulosegresos[5]+titulosegresos[6]+26;
                   roww[fakerow]="OTROS INGRESOS";
                    for(int j=0;j<13;j++){
             data[fakerow][j*3]=formatea.format(ingresostit[1][j][0]);
             data[fakerow][1+j*3]=formatea.format(ingresostit[1][j][1]);
             data[fakerow][2+j*3]=formatea2.format(ingresostit[1][j][2]);
                    }
                    fakerow++;
                    pasada=false;
                }
             roww[fakerow]=incomestype.get(i).Description;
               for(int j=0;j<13;j++){
             data[fakerow][j*3]=formatea.format(ingresos[i][j][0]);
             data[fakerow][1+j*3]=formatea.format(ingresos[i][j][1]);
             data[fakerow][2+j*3]=formatea2.format(ingresos[i][j][2]);
               }
              fakerow++;        
            }            
            
        } 
       row++;
         rowtitulo=row;
        for(int i=0;i<expensestype.size();i++){
            if(i==0){
             roww[row]="COSTOS DE VENTA";
             for(int j=0;j<13;j++){
             data[row][j*3]=formatea.format(egresostit[0][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[0][j][1]);
             data[row][2+j*3]=formatea2.format(egresostit[0][j][2]);
             }
            row++;      
            
            }else if(i==titulosegresos[0]){
            row++;
             roww[row]="UTILIDAD BRUTA";
              for(int j=0;j<13;j++){
         montoaux=ingresostit[0][j][0]-egresostit[0][j][0];
         pptaux=ingresostit[0][j][1]-egresostit[0][j][1];
         if(pptaux!=0){
         varaux=montoaux/pptaux;
         }else{
         varaux=0;}
           data[row][j*3]=formatea.format(montoaux);
             data[row][1+j*3]=formatea.format(pptaux);
             data[row][2+j*3]=formatea2.format(varaux);
            
              }   
             row++;
              
             row++;
              roww[row]="GASTOS DE OPERACIÓN";
              for(int j=0;j<13;j++){
                  montoaux=egresostit[1][j][0];
         pptaux=egresostit[1][j][1];
         if(pptaux!=0){
         varaux=montoaux/pptaux;
         }else{
         varaux=0;}
             data[row][j*3]=formatea.format(montoaux);
             data[row][1+j*3]=formatea.format(pptaux);
             data[row][2+j*3]=formatea2.format(varaux);
            
             }            
            row++;

            }
            else if(i==titulosegresos[0]+titulosegresos[1]){
             row++; 
             
                roww[row]="UTILIDAD DE LA OPERACIÓN";
         for(int j=0;j<13;j++){
         montoaux=ingresostit[0][j][0]-egresostit[0][j][0]-egresostit[1][j][0];
         pptaux=ingresostit[0][j][1]-egresostit[0][j][1]-egresostit[1][j][1];
         if(pptaux!=0){
         varaux=montoaux/pptaux;
         }else{
         varaux=0;}
                data[row][j*3]=formatea.format(montoaux);
             data[row][1+j*3]=formatea.format(pptaux);
             data[row][2+j*3]=formatea2.format(varaux);
              }   
             row++;
            row++;
                 roww[row]="GASTOS FINANCIEROS";
             for(int j=0;j<13;j++){
 data[row][j*3]=formatea.format(egresostit[2][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[2][j][1]);
             data[row][2+j*3]=formatea2.format(egresostit[2][j][2]); 
            }
            row++;
            }
            else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
                   ){
               row++;
                   roww[row]="IMPUESTOS";
               for(int j=0;j<13;j++){
         
         data[row][j*3]=formatea.format(egresostit[3][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[3][j][1]);
             data[row][2+j*3]=formatea2.format(egresostit[3][j][2]); 
            
            }
            row++;
            
            }  else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
                    +titulosegresos[3]){
               row++;
          roww[row]="INVERSIÓN";
               for(int j=0;j<13;j++){        
              data[row][j*3]=formatea.format(egresostit[4][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[4][j][1]);
             data[row][2+j*3]=formatea2.format(egresostit[4][j][2]);            
            }
            row++;
            
            }
             else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
                    +titulosegresos[3]+titulosegresos[4]){
               row++;
             roww[row]="ANTICIPO DE UTILIDADES";
            for(int j=0;j<13;j++){
         
               data[row][j*3]=formatea.format(egresostit[5][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[5][j][1]);
             data[row][2+j*3]=formatea2.format(egresostit[5][j][2]); 
        
            
            }
            row++;
            
            }
             else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
                    +titulosegresos[3]+titulosegresos[4]+titulosegresos[5]){
               row++;
             roww[row]="OTROS EGRESOS";
        
               for(int j=0;j<13;j++){
         
               data[row][j*3]=formatea.format(egresostit[6][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[6][j][1]);
             data[row][2+j*3]=formatea2.format(egresostit[6][j][2]); 
            
            }
            row++;
          roww[row]="Tarjetas de regalo";
                for(int j=0;j<13;j++){
             data[row][j*3]=formatea.format(egresos[expensestype.size()][j][0]);
             data[row][1+j*3]=formatea.format(egresos[expensestype.size()][j][1]);
             data[row][2+j*3]=formatea2.format(egresos[expensestype.size()][j][2]); 
              }
               
                 row++;
            
            } 
               roww[row]=expensestype.get(i).Description;
                for(int j=0;j<13;j++){
             data[row][j*3]=formatea.format(egresos[i][j][0]);
             data[row][1+j*3]=formatea.format(egresos[i][j][1]);
             data[row][2+j*3]=formatea2.format(egresos[i][j][2]); 
              }
               
                 row++;
                 
    }
        
        fakerow++;
          double totalingresos=0;
          double totalegresos=0;
          double saldofinal=0;
          double totalingresosppt=0;
          double totalegresosppt=0;
          double saldoinicialppt=saldoinicial;
          double saldofinalppt=0;
          double totalingresosvar=0;
          double totalegresosvar=0;
          double saldoinicialvar=0;
          double saldofinalvar=0;
            roww[fakerow]="CAJA INICIAL";
            roww[fakerow+1]="TOTAL DE INGRESOS";
            roww[fakerow+2]="TOTAL DE EGRESOS";
            roww[fakerow+3]="CAJA FINAL";
   
         for(int j=0;j<13;j++){
         totalingresos=0;
         totalegresos=0;
         totalingresosppt=0;
         totalegresosppt=0;
         for(int i=0;i<2;i++){
         totalingresos+=ingresostit[i][j][0];
          totalingresosppt+=ingresostit[i][j][1];
         }
         for(int i=0;i<8;i++){
         totalegresos+=egresostit[i][j][0];
          totalegresosppt+=egresostit[i][j][1];
         }
         
         if(j==12){
             saldoinicial=saldoinicial1;
             saldoinicialppt=saldoinicial1;
         saldofinal=saldoinicial+totalingresos-totalegresos;
         saldofinalppt=saldoinicialppt+totalingresosppt-totalegresosppt;
         if(totalingresosppt!=0){
         totalingresosvar=totalingresos/totalingresosppt;
         }else{
         totalingresosvar=0;}
         if(totalegresosppt!=0){
         totalegresosvar=totalegresos/totalegresosppt;
         }else{
         totalegresosvar=0;}
         if(saldoinicialppt!=0){
         saldoinicialvar=saldoinicial/saldoinicialppt;
         }else{
         saldoinicialvar=0;}
         if(saldofinalppt!=0){
         saldofinalvar=saldofinal/saldofinalppt;
         }else{
         saldofinalvar=0;}
         
         
         }else{            
                  saldofinal=saldoinicial+totalingresos-totalegresos;
         saldofinalppt=saldoinicialppt+totalingresosppt-totalegresosppt;
         if(totalingresosppt!=0){
         totalingresosvar=totalingresos/totalingresosppt;
         }else{
         totalingresosvar=0;}
         if(totalegresosppt!=0){
         totalegresosvar=totalegresos/totalegresosppt;
         }else{
         totalegresosvar=0;}
         if(saldoinicialppt!=0){
         saldoinicialvar=saldoinicial/saldoinicialppt;
         }else{
         saldoinicialvar=0;}
         if(saldofinalppt!=0){
         saldofinalvar=saldofinal/saldofinalppt;
         }else{
         saldofinalvar=0;}

         }
             data[fakerow][j*3]=formatea.format(saldoinicial);
             data[fakerow][1+j*3]=formatea.format(saldoinicialppt);
             data[fakerow][2+j*3]=formatea2.format(saldoinicialvar); 
         
             data[fakerow+1][j*3]=formatea.format(totalingresos);
             data[fakerow+1][1+j*3]=formatea.format(totalingresosppt);
             data[fakerow+1][2+j*3]=formatea2.format(totalingresosvar); 
         
             data[fakerow+2][j*3]=formatea.format(totalegresos);
             data[fakerow+2][1+j*3]=formatea.format(totalegresosppt);
             data[fakerow+2][2+j*3]=formatea2.format(totalegresosvar); 
         
             data[fakerow+3][j*3]=formatea.format(saldofinal);
             data[fakerow+3][1+j*3]=formatea.format(saldofinalppt);
             data[fakerow+3][2+j*3]=formatea2.format(saldofinalvar); 
         
             saldoinicial=saldofinal;
             saldoinicialppt=saldofinalppt;
            }
         
/////////////////////////////////////////////////////////////////////////////////////
 AbstractTableModel    model1 = new AbstractTableModel() {
      public int getColumnCount() { return columnas.length; }
      public int getRowCount() { return roww.length; }
      public String getRowName(int col) {
       return (String)columnas[col];
      }
       public String getColumnName(int col) {
       return (String)columnas[col];
      }
      public Object getValueAt(int row, int col) {
        return data[row][col];
      }
      public void setValueAt(Object obj, int row, int col) {
        data[row][col] = obj;
      }
      public boolean CellEditable(int row, int col) {
        return true;
      }
    };
     
    AbstractTableModel fixedModel1 = new AbstractTableModel() {     
      public int getColumnCount() { return 1; }
      public int getRowCount() { return roww.length; }
      public String getColumnName(int col) {
       return "    ";
      }
      public Object getValueAt(int rows, int col) {
        return roww[rows];
      }
    };    
    table = new JTable( model1 );
    table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground((column == 0)||(column == 3)||(column == 6) ||(column == 9) ||(column == 12) ||(column == 15) ||(column == 18) 
                ||(column == 21) ||(column == 24) ||(column == 27) ||(column == 30) ||(column == 33)||(column == 36)? new Color(217,234,220) : 
                (column == 1)||(column == 4)||(column == 7) ||(column == 10) ||(column == 13) ||(column == 16) ||(column == 19) 
                ||(column == 22) ||(column == 25) ||(column == 28) ||(column == 31) ||(column == 34)||(column == 37)  ? Color.LIGHT_GRAY: Color.WHITE);
        c.setFont((row == 1)||(row == 9)||(row == 16) ||(row == 18) ||(row == 43) ||(row == 45) ||(row == 48) 
                ||(row == 51) ||(row == 55) ||(row == 58) ||(row == 62) ||(row == 67) ||(row == 68) ||(row == 69) 
                ||(row == 70)  ? new Font("InaiMathi", Font.BOLD, 14):new Font("InaiMathi", Font.ITALIC, 14));
        return c;
    }

        @Override
        public void setBorder(javax.swing.border.Border border) {
            super.setBorder(javax.swing.border.LineBorder.createBlackLineBorder()); //To change body of generated methods, choose Tools | Templates.
        }

       
});
    table.setSelectionBackground(Color.GREEN);
    table.setSelectionForeground(Color.BLACK);
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
    fixedTable = new JTable( fixedModel1 );
    fixedTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer()
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        c.setBackground((row == 1)||(row == 9)||(row == 16) ||(row == 18) ||(row == 43) ||(row == 45) ||(row == 48) 
                ||(row == 51) ||(row == 55) ||(row == 58) ||(row == 62) ||(row == 67) ||(row == 68) ||(row == 69) 
                ||(row == 70)  ? Color.LIGHT_GRAY : Color.WHITE);
        c.setFont((row == 1)||(row == 9)||(row == 16) ||(row == 18) ||(row == 43) ||(row == 45) ||(row == 48) 
                ||(row == 51) ||(row == 55) ||(row == 58) ||(row == 62) ||(row == 67) ||(row == 68) ||(row == 69) 
                ||(row == 70)  ? new Font("InaiMathi", Font.BOLD, 14):new Font("InaiMathi", Font.ITALIC, 14));
  return c;
    }
      @Override
        public void setBorder(javax.swing.border.Border border) {
            super.setBorder(javax.swing.border.LineBorder.createBlackLineBorder()); //To change body of generated methods, choose Tools | Templates.
        }
    
});
    fixedTable.setSelectionBackground(Color.BLUE);
    fixedTable.setSelectionForeground(Color.BLACK);
    fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    fixedTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
  
    JScrollPane fixedScroll = new JScrollPane( fixedTable );// {
    JScrollPane scroll      = new JScrollPane( table );
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
     
    fixedScroll.setColumnHeader(null);
    final JScrollBar bar1 = scroll.getVerticalScrollBar();
    JScrollBar bar2 = fixedScroll.getVerticalScrollBar();
    bar2.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        bar1.setValue(e.getValue());
      }});
    fixedScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar bar = fixedScroll.getHorizontalScrollBar();
    JScrollBar dummyBar = new JScrollBar() {
      public void paint(Graphics g) {}
    };
    dummyBar.setPreferredSize(bar.getPreferredSize());
    fixedScroll.setVerticalScrollBar(bar2);
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    bar2.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        bar1.setValue(e.getValue());
      }
    });
     scroll.setVerticalScrollBar(bar2);  
    scroll.setPreferredSize(new Dimension(1000, 600));
    fixedScroll.setPreferredSize(new Dimension(200, 600));  // Hmm...
    
    JMenuBar barra=new JMenuBar();
    JMenuItem item=new JMenuItem();         
    item.addActionListener(this);
    item.setText("Exportar a excel");
    barra.add(item);
     getContentPane().add(barra,BorderLayout.PAGE_START);
    getContentPane().add(     fixedScroll, BorderLayout.LINE_START);
    getContentPane().add(scroll, BorderLayout.CENTER);   
  }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
     //To change body of generated methods, choose Tools | Templates.
      ExportExc j=new ExportExc();
        try{
j.exportarExcel(table,fixedTable);}
        catch(IOException er){}
    
    }

}
