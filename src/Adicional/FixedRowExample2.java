/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Adicional;

import Classes.*;
import Conexion.Conexion;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.text.DecimalFormat;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
 
/**
 * @version 1.0 03/05/99
 */
public class FixedRowExample2 extends JFrame {
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
  public FixedRowExample2(String st) {
    super( "Rentabilidad de " +st );
 
        
              con=new Conexion();
   //     model=(DefaultTableModel)tableEgresos.getModel();
       con.Conectar();  
         try{
     expensestype= con.GetExpensesTypesFlujo();
      incomestype= con.GetIncomesTypesFluj();
    expenses= con.GetExpenses(2019);
    incomes= con.GetIncomes(2019);
     cuentas=con.GetAccounts2();     
         }catch(SQLException e){
             
         } 
           double saldoinicial2019=0;
            con.Desconectar();

       
       /////////////////////////////////////////////
        

    roww = new Object[30+incomestype.size()+expensestype.size()];
    for(int m=0;m<30+incomestype.size()+expensestype.size();m++){
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
       double [][][] ingresos=new double[incomestype.size()][13][3];
       double [][][] egresos=new double[expensestype.size()][13][3];
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
  for(int i=0;i<expenses.size();i++){
       int mes=expenses.get(i).Date.getMonth();
        for(int j=0;j<expensestype.size();j++){
        if(expensestype.get(j).Id==expenses.get(i).Type_Id){
            egresos[j][mes][0]+=expenses.get(i).Amount;
               egresos[j][12][0]+=expenses.get(i).Amount;
        }
        }
       }
        DecimalFormat formatea = new DecimalFormat("###,###.##");
        for(int i=0;i<incomestype.size();i++){
            for(int j=0;j<12;j++){
                if(incomestype.get(i).Category_Id==1){
                    ingresostit[0][j][0]+=ingresos[i][j][0];
                  ingresostit[0][j][1]+=incomestype.get(i).Ppt;  
                      ingresostit[0][12][0]+=ingresos[i][j][0];
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
             data[rowtitulo][2+j*3]=formatea.format(ingresostit[0][j][2]*100);
                    }
                    pasada=true;
                }
                  roww[row]=incomestype.get(i).Description;
               for(int j=0;j<13;j++){
             data[row][j*3]=formatea.format(ingresos[i][j][0]);
             data[row][1+j*3]=formatea.format(ingresos[i][j][1]);
             data[row][2+j*3]=formatea.format(ingresos[i][j][2]*100);
                 }

             row++;
            }else{
                 if(pasada==true){
                      fakerow=rowtitulo+titulosingresos[0]+titulosegresos[7]+titulosegresos[0]+
                      titulosegresos[1]+titulosegresos[2]+titulosegresos[3]+titulosegresos[4]
                      +titulosegresos[5]+titulosegresos[6]+22;
                   roww[fakerow]="OTROS INGRESOS";
                    for(int j=0;j<13;j++){
             data[fakerow][j*3]=formatea.format(ingresostit[1][j][0]);
             data[fakerow][1+j*3]=formatea.format(ingresostit[1][j][1]);
             data[fakerow][2+j*3]=formatea.format(ingresostit[1][j][2]*100);
                    }
                    fakerow++;
                    pasada=false;
                }
             roww[fakerow]=incomestype.get(i).Description;
               for(int j=0;j<13;j++){
             data[fakerow][j*3]=formatea.format(ingresos[i][j][0]);
             data[fakerow][1+j*3]=formatea.format(ingresos[i][j][1]);
             data[fakerow][2+j*3]=formatea.format(ingresos[i][j][2]*100);
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
             data[row][2+j*3]=formatea.format(egresostit[0][j][2]*100);
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
             data[row][2+j*3]=formatea.format(varaux);
            
              }   
             row++;
              
             row++;
              roww[row]="GASTOS DE OPERACIÓN";
              for(int j=0;j<13;j++){
                  montoaux=egresostit[1][j][0]+egresostit[2][j][0];
         pptaux=egresostit[1][j][1]+egresostit[2][j][1];
         if(pptaux!=0){
         varaux=montoaux/pptaux;
         }else{
         varaux=0;}
             data[row][j*3]=formatea.format(montoaux);
             data[row][1+j*3]=formatea.format(pptaux);
             data[row][2+j*3]=formatea.format(varaux);
            
             }            
            row++;
               roww[row]="GASTOS DE ADMINISTRACIÓN";
               for(int j=0;j<13;j++){
             data[row][j*3]=formatea.format(egresostit[1][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[1][j][1]);
             data[row][2+j*3]=formatea.format(egresostit[1][j][2]*100);
  }
             row++; 
            
            }else if(i==titulosegresos[0]+titulosegresos[1]){
               roww[row]="GASTOS DE VENTA";
               for(int j=0;j<13;j++){
         
             data[row][j*3]=formatea.format(egresostit[2][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[2][j][1]);
             data[row][2+j*3]=formatea.format(egresostit[2][j][2]*100);   }
             row++; 
            
            }else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]){
             row++; 
             
                roww[row]="UTILIDAD DE LA OPERACIÓN";
         for(int j=0;j<13;j++){
         montoaux=ingresostit[0][j][0]-egresostit[0][j][0]-egresostit[1][j][0]-egresostit[2][j][0];
         pptaux=ingresostit[0][j][1]-egresostit[0][j][1]-egresostit[1][j][1]-egresostit[2][j][1];
         if(pptaux!=0){
         varaux=montoaux/pptaux;
         }else{
         varaux=0;}
                data[row][j*3]=formatea.format(montoaux);
             data[row][1+j*3]=formatea.format(pptaux);
             data[row][2+j*3]=formatea.format(varaux);
              }   
             row++;
            row++;
                 roww[row]="GASTOS FINANCIEROS";
             for(int j=0;j<13;j++){
 data[row][j*3]=formatea.format(egresostit[3][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[3][j][1]);
             data[row][2+j*3]=formatea.format(egresostit[3][j][2]*100); 
            }
            row++;
            }
            else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
                    +titulosegresos[3]){
               row++;
                   roww[row]="IMPUESTOS";
               for(int j=0;j<13;j++){
         
         data[row][j*3]=formatea.format(egresostit[4][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[4][j][1]);
             data[row][2+j*3]=formatea.format(egresostit[4][j][2]*100); 
            
            }
            row++;
            
            }  else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
                    +titulosegresos[3]+titulosegresos[4]){
               row++;
          roww[row]="INVERSIÓN";
               for(int j=0;j<13;j++){        
              data[row][j*3]=formatea.format(egresostit[5][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[5][j][1]);
             data[row][2+j*3]=formatea.format(egresostit[5][j][2]*100);            
            }
            row++;
            
            }
             else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
                    +titulosegresos[3]+titulosegresos[4]+titulosegresos[5]){
               row++;
             roww[row]="ANTICIPO DE UTILIDADES";
            for(int j=0;j<13;j++){
         
               data[row][j*3]=formatea.format(egresostit[6][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[6][j][1]);
             data[row][2+j*3]=formatea.format(egresostit[6][j][2]*100); 
        
            
            }
            row++;
            
            }
             else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
                    +titulosegresos[3]+titulosegresos[4]+titulosegresos[5]+titulosegresos[6]){
               row++;
             roww[row]="OTROS EGRESOS";
        
               for(int j=0;j<13;j++){
         
               data[row][j*3]=formatea.format(egresostit[7][j][0]);
             data[row][1+j*3]=formatea.format(egresostit[7][j][1]);
             data[row][2+j*3]=formatea.format(egresostit[7][j][2]*100); 
        
            }
            row++;
            
            } 
               roww[row]=expensestype.get(i).Description;
               for(int j=0;j<13;j++){
             data[row][j*3]=formatea.format(egresos[i][j][0]);
             data[row][1+j*3]=formatea.format(egresos[i][j][1]);
             data[row][2+j*3]=formatea.format(egresos[i][j][2]*100); 
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
             data[fakerow][2+j*3]=formatea.format(saldoinicialvar*100); 
         
             data[fakerow+1][j*3]=formatea.format(totalingresos);
             data[fakerow+1][1+j*3]=formatea.format(totalingresosppt);
             data[fakerow+1][2+j*3]=formatea.format(totalingresosvar*100); 
         
             data[fakerow+2][j*3]=formatea.format(totalegresos);
             data[fakerow+2][1+j*3]=formatea.format(totalegresosppt);
             data[fakerow+2][2+j*3]=formatea.format(totalegresosvar*100); 
         
             data[fakerow+3][j*3]=formatea.format(saldofinal);
             data[fakerow+3][1+j*3]=formatea.format(saldofinalppt);
             data[fakerow+3][2+j*3]=formatea.format(saldofinalvar*100); 
         
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
    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
     
    fixedTable = new JTable( fixedModel1 );
    fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
    fixedTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    
  
    JScrollPane fixedScroll = new JScrollPane( fixedTable );// {
   //   public void setColumnHeaderView(Component view) {} // work around
   // };                                                   //
      
      JScrollPane scroll      = new JScrollPane( table );
    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
 
     
     fixedScroll.setColumnHeader(null);
     final JScrollBar bar1 = scroll.getVerticalScrollBar();
    JScrollBar bar2 = fixedScroll.getVerticalScrollBar();
    bar2.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        bar1.setValue(e.getValue());
      }
    });
    fixedScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        JScrollBar bar = fixedScroll.getHorizontalScrollBar();
    JScrollBar dummyBar = new JScrollBar() {
      public void paint(Graphics g) {}
    };
    dummyBar.setPreferredSize(bar.getPreferredSize());
    fixedScroll.setVerticalScrollBar(bar2);
     
    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    //final JScrollBar bar1 = scroll.getVerticalScrollBar();
   // JScrollBar bar2 = fixedScroll.getVerticalScrollBar();
    bar2.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        bar1.setValue(e.getValue());
      }
    });
     scroll.setVerticalScrollBar(bar2);
    
     
    scroll.setPreferredSize(new Dimension(1000, 600));
    fixedScroll.setPreferredSize(new Dimension(200, 600));  // Hmm...
    getContentPane().add(     fixedScroll, BorderLayout.LINE_START);
    getContentPane().add(scroll, BorderLayout.CENTER);   
  }
 
//  public FixedRowExample2(int year) {
//    super( "Rentabilidad " +year );
//
//              con=new Conexion();
//   //     model=(DefaultTableModel)tableEgresos.getModel();
//       con.Conectar();  
//       java.util.List<Projects> ven = con.GetProjectsVentasRentabilidad(year);
//       java.util. List<Contenedor_Inventario> inv=con.GetCostoInventarioRentabilidad(year);
//       java.util. List<Contenedor_Inventario2> inv2=con.GetCostoInventario2Rentabilidad(year);
//       java.util.List<ExpensesType> expensestype= con.GetExpensesTypesFlujo();
//       java.util.List<IncomesType> incomestype= con.GetIncomesTypesFluj();
//       java.util.List<Expenses> expenses= con.GetExpenses(year);
//       java.util.List<Incomes> incomes= con.GetIncomes(year);
//       java.util.List<Accounts> cuentas=con.GetCuentas();     
//
//
//         
//           double saldoinicial2019=con.GetSaldoInicial2019();
//            con.Desconectar();
//
//       
//       /////////////////////////////////////////////
//        
//
//    roww = new Object[30+incomestype.size()+expensestype.size()];
//    for(int m=0;m<30+incomestype.size()+expensestype.size();m++){
//    roww[m]="";
//    }
//    columnas= new Object[]{"        "," ENERO ","        ","        ","FEBRERO","        ","        ","MARZO","        ",
//            "        ","ABRIL","        ","        ","MAYO","        ","        ","JUNIO","        ","        ","JULIO","        ",
//            "        ","AGOSTO","        ","        ","SEPTIEMBRE","        ","        ","OCTUBRE","        ","        ","NOVIEMBRE","        ",
//           "        ","DICIEMBRE","        ","        ","TOTAL","        "}    ;
//    
//     data =  new Object[roww.length][columnas.length];
//     for(int m=0;m<roww.length;m++){
//     for(int n=0;n<columnas.length;n++){
//    data[m][n]="";
//    } 
//     }
//      for(int j=0;j<13;j++){
//             data[0][j*3]="Real";
//             data[0][1+j*3]="PPT";
//             data[0][2+j*3]="Var";
//             }
//       //////////////////////////////////////////////////
//       double saldoinicial=0;
//            if(year==2018){
//           for(int i=0;i<cuentas.size();i++){
//       saldoinicial+=cuentas.get(i).Ppt;
//       }}else{
//  saldoinicial=saldoinicial2019;
//            }
//           double saldoinicial1=saldoinicial;
//       int contingresos=0;
//       int contegresos=0;
//       int [] titulosingresos=new int [2];
//         titulosingresos[0]=0;
//           titulosingresos[1]=0;
//       int [] titulosegresos=new int [8];
//             for(int i=0;i<8;i++){
//       titulosegresos[i]=0;
//       }
//       double [][][] ingresostit=new double[2][13][3];
//       double [][][] egresostit=new double[8][13][3];
//       double [][][] ingresos=new double[incomestype.size()][13][3];
//       double [][][] egresos=new double[expensestype.size()][13][3];
//       for(int j=0;j<13;j++){
//       for(int k=0;k<3;k++){
//            for(int i=0;i<incomestype.size();i++){
//       ingresos[i][j][k]=0;
//       }
//            for(int i=0;i<expensestype.size();i++){
//       egresos[i][j][k]=0;
//       }
//                for(int i=0;i<2 ;i++){
//       ingresostit[i][j][k]=0;
//       }
//                    for(int i=0;i<8;i++){
//       egresostit[i][j][k]=0;
//       }
//       }
//       }
//       for(int i=0;i<incomes.size();i++){
//       int mes=incomes.get(i).Date.getMonth();
//        for(int j=0;j<incomestype.size();j++){
//        if(incomestype.get(j).Id==incomes.get(i).IncomesCategory_Id &&incomestype.get(j).Id!=1){
//            ingresos[j][mes][0]+=incomes.get(i).Amount;
//                  ingresos[j][12][0]+=incomes.get(i).Amount;
//        }
//        }
//       }
//         for(int i=0;i<ven.size();i++){
//       int mes=ven.get(i).Date_Venta.getMonth();
//           ingresos[0][mes][0]+=ven.get(i).Monto;
//                  ingresos[0][12][0]+=ven.get(i).Monto;
//         egresos[0][mes][0]+=(ven.get(i).Monto*ven.get(i).Comision_Vendedor+ven.get(i).Monto*ven.get(i).Comision_Hint+
//                 ven.get(i).Monto*ven.get(i).Comision_Jenaro+ven.get(i).Monto*ven.get(i).Comision_Gerente+ven.get(i).Monto*ven.get(i).Comision_JuanPablo)/100;
//                  egresos[0][12][0]+=(ven.get(i).Monto*ven.get(i).Comision_Vendedor+ven.get(i).Monto*ven.get(i).Comision_Hint+
//                 ven.get(i).Monto*ven.get(i).Comision_Jenaro+ven.get(i).Monto*ven.get(i).Comision_Gerente+ven.get(i).Monto*ven.get(i).Comision_JuanPablo)/100;
//       }
//       
//  for(int i=0;i<expenses.size();i++){
//       int mes=expenses.get(i).Date.getMonth();
//        for(int j=0;j<expensestype.size();j++){
//        if(expensestype.get(j).Id==expenses.get(i).ExpensesCategory_Id &&expensestype.get(j).Id!=1&&expensestype.get(j).Id!=6&&expensestype.get(j).Id!=7
//                &&expensestype.get(j).Id!=8&&expensestype.get(j).Id!=9){
//            egresos[j][mes][0]+=expenses.get(i).Amount;
//               egresos[j][12][0]+=expenses.get(i).Amount;
//        }
//        }
//       }
//    for(int i=0;i<inv.size();i++){
//       int mes=inv.get(i).Date_Venta.getMonth();
//       if(inv.get(i).CatInventario_Id==1){
//         egresos[2][mes][0]+=inv.get(i).Monto;
//               egresos[2][12][0]+=inv.get(i).Monto;
//       }else{
//            egresos[1][mes][0]+=inv.get(i).Monto;
//               egresos[1][12][0]+=inv.get(i).Monto; 
//           
//       }
//        
//       }
//       for(int i=0;i<inv2.size();i++){
//       int mes=inv2.get(i).Date_Venta.getMonth();
//       if(inv2.get(i).CatInventario_Id==3){
//         egresos[2][mes][0]+=inv2.get(i).Monto;
//               egresos[2][12][0]+=inv2.get(i).Monto;
//       }else{
//            egresos[6][mes][0]+=inv2.get(i).Monto;
//               egresos[6][12][0]+=inv2.get(i).Monto; 
//           
//       }
//        
//       }
//        DecimalFormat formatea = new DecimalFormat("###,###.##");
//        for(int i=0;i<incomestype.size();i++){
//            for(int j=0;j<12;j++){
//                if(incomestype.get(i).IncomesCategory_Id==1){
//                    ingresostit[0][j][0]+=ingresos[i][j][0];
//                  ingresostit[0][j][1]+=incomestype.get(i).Ppt;  
//                      ingresostit[0][12][0]+=ingresos[i][j][0];
//                  ingresostit[0][12][1]+=incomestype.get(i).Ppt;  
//                }else{
//                           ingresostit[1][j][0]+=ingresos[i][j][0];
//                  ingresostit[1][j][1]+=incomestype.get(i).Ppt; 
//                  ingresostit[1][12][0]+=ingresos[i][j][0];
//                  ingresostit[1][12][1]+=incomestype.get(i).Ppt; 
//                }
//            ingresos[i][j][1]=incomestype.get(i).Ppt;
//            if(ingresos[i][j][1]!=0){
//            ingresos[i][j][2]=ingresos[i][j][0]/ingresos[i][j][1];
//            }
//            ingresos[i][12][1]+=incomestype.get(i).Ppt;
//            if(i==incomestype.size()-1){
//             if(ingresostit[0][j][1]!=0){
//            ingresostit[0][j][2]=ingresostit[0][j][0]/ingresostit[0][j][1];
//            }
//              if(ingresostit[1][j][1]!=0){
//            ingresostit[1][j][2]=ingresostit[1][j][0]/ingresostit[1][j][1];
//            }
//            }
//            }
//             if(ingresos[i][12][1]!=0){
//            ingresos[i][12][2]=ingresos[i][12][0]/ingresos[i][12][1];
//            }
//             if(incomestype.get(i).IncomesCategory_Id==1){
//            titulosingresos[0]+=1;
//             }else{
//                   titulosingresos[1]+=1;
//             }
//        }   
//             if(ingresostit[0][12][1]!=0){
//            ingresostit[0][12][2]=ingresostit[0][12][0]/ingresostit[0][12][1];
//            }
//              if(ingresostit[1][12][1]!=0){
//            ingresostit[1][12][2]=ingresostit[1][12][0]/ingresostit[1][12][1];
//            }
//              
//              
//        for(int i=0;i<expensestype.size();i++){
//            for(int j=0;j<12;j++){
//            egresos[i][j][1]=expensestype.get(i).Ppt;
//            
//             if(expensestype.get(i).ExpensesCategory_Id==1){
//             egresostit[0][j][1]+=expensestype.get(i).Ppt;
//             egresostit[0][j][0]+=egresos[i][j][0];
//             egresostit[0][12][1]+=expensestype.get(i).Ppt;
//             egresostit[0][12][0]+=egresos[i][j][0];
//             }else  if(expensestype.get(i).ExpensesCategory_Id==2){
//             egresostit[1][j][1]+=expensestype.get(i).Ppt;
//             egresostit[1][j][0]+=egresos[i][j][0];
//             egresostit[1][12][1]+=expensestype.get(i).Ppt;
//             egresostit[1][12][0]+=egresos[i][j][0];
//             }else  if(expensestype.get(i).ExpensesCategory_Id==3){
//              egresostit[2][j][1]+=expensestype.get(i).Ppt;
//             egresostit[2][j][0]+=egresos[i][j][0];
//             egresostit[2][12][1]+=expensestype.get(i).Ppt;
//             egresostit[2][12][0]+=egresos[i][j][0];
//             } else  if(expensestype.get(i).ExpensesCategory_Id==4){
//              egresostit[3][j][1]+=expensestype.get(i).Ppt;
//             egresostit[3][j][0]+=egresos[i][j][0];
//             egresostit[3][12][1]+=expensestype.get(i).Ppt;
//             egresostit[3][12][0]+=egresos[i][j][0];
//             } else  if(expensestype.get(i).ExpensesCategory_Id==5){
//              egresostit[4][j][1]+=expensestype.get(i).Ppt;
//             egresostit[4][j][0]+=egresos[i][j][0];
//             egresostit[4][12][1]+=expensestype.get(i).Ppt;
//             egresostit[4][12][0]+=egresos[i][j][0];
//             } else  if(expensestype.get(i).ExpensesCategory_Id==6){
//             egresostit[5][j][1]+=expensestype.get(i).Ppt;
//             egresostit[5][j][0]+=egresos[i][j][0];
//             egresostit[5][12][1]+=expensestype.get(i).Ppt;
//             egresostit[5][12][0]+=egresos[i][j][0];
//             } else  if(expensestype.get(i).ExpensesCategory_Id==7){
//             egresostit[6][j][1]+=expensestype.get(i).Ppt;
//             egresostit[6][j][0]+=egresos[i][j][0];
//             egresostit[6][12][1]+=expensestype.get(i).Ppt;
//             egresostit[6][12][0]+=egresos[i][j][0];
//             } else  if(expensestype.get(i).ExpensesCategory_Id==8){
//             egresostit[7][j][1]+=expensestype.get(i).Ppt;
//             egresostit[7][j][0]+=egresos[i][j][0];
//             egresostit[7][12][1]+=expensestype.get(i).Ppt;
//             egresostit[7][12][0]+=egresos[i][j][0];
//             } 
//            
//             if(egresos[i][j][1]!=0){
//            egresos[i][j][2]=egresos[i][j][0]/egresos[i][j][1];
//            }
//            egresos[i][12][1]+=expensestype.get(i).Ppt;
//            if(i==expensestype.size()-1){
//                 for(int k=0;k<8;k++){
//                  if(egresostit[k][j][1]!=0){
//            egresostit[k][j][2]=egresostit[k][j][0]/egresostit[k][j][1];
//            }                
//                 }       
//            }
//            }
//             if(egresos[i][12][1]!=0){
//            egresos[i][12][2]=egresos[i][12][0]/egresos[i][12][1];
//            }
//             if(expensestype.get(i).ExpensesCategory_Id==1){
//            titulosegresos[0]+=1;
//             }else  if(expensestype.get(i).ExpensesCategory_Id==2){
//            titulosegresos[1]+=1;
//             }else  if(expensestype.get(i).ExpensesCategory_Id==3){
//            titulosegresos[2]+=1;
//             } else  if(expensestype.get(i).ExpensesCategory_Id==4){
//            titulosegresos[3]+=1;
//             } else  if(expensestype.get(i).ExpensesCategory_Id==5){
//            titulosegresos[4]+=1;
//             } else  if(expensestype.get(i).ExpensesCategory_Id==6){
//            titulosegresos[5]+=1;
//             } else  if(expensestype.get(i).ExpensesCategory_Id==7){
//            titulosegresos[6]+=1;
//             } else  if(expensestype.get(i).ExpensesCategory_Id==8){
//            titulosegresos[7]+=1;
//             } 
//        } 
//        for(int k=0;k<8;k++){
//                  if(egresostit[k][12][1]!=0){
//            egresostit[k][12][2]=egresostit[k][12][0]/egresostit[k][12][1];
//            }
//        }     
//  ///////////////
//     int row=2;
//              int rowtitulo=1;
//                double montoaux=0;
//                  double pptaux=0;
//              double varaux=0;
//int fakerow=0;
//              boolean pasada=false;
//    for(int i=0;i<incomestype.size();i++){
//            if(i<titulosingresos[0]){
//                if(pasada==false){
//                     roww[rowtitulo]="INGRESOS";
//                    for(int j=0;j<13;j++){
//             data[rowtitulo][j*3]=formatea.format(ingresostit[0][j][0]);
//             data[rowtitulo][1+j*3]=formatea.format(ingresostit[0][j][1]);
//             data[rowtitulo][2+j*3]=formatea.format(ingresostit[0][j][2]*100);
//                    }
//                    pasada=true;
//                }
//                  roww[row]=incomestype.get(i).Description;
//               for(int j=0;j<13;j++){
//             data[row][j*3]=formatea.format(ingresos[i][j][0]);
//             data[row][1+j*3]=formatea.format(ingresos[i][j][1]);
//             data[row][2+j*3]=formatea.format(ingresos[i][j][2]*100);
//                 }
//
//             row++;
//            }else{
//                 if(pasada==true){
//                      fakerow=rowtitulo+titulosingresos[0]+titulosegresos[7]+titulosegresos[0]+
//                      titulosegresos[1]+titulosegresos[2]+titulosegresos[3]+titulosegresos[4]
//                      +titulosegresos[5]+titulosegresos[6]+22;
//                   roww[fakerow]="OTROS INGRESOS";
//                    for(int j=0;j<13;j++){
//             data[fakerow][j*3]=formatea.format(ingresostit[1][j][0]);
//             data[fakerow][1+j*3]=formatea.format(ingresostit[1][j][1]);
//             data[fakerow][2+j*3]=formatea.format(ingresostit[1][j][2]*100);
//                    }
//                    fakerow++;
//                    pasada=false;
//                }
//             roww[fakerow]=incomestype.get(i).Description;
//               for(int j=0;j<13;j++){
//             data[fakerow][j*3]=formatea.format(ingresos[i][j][0]);
//             data[fakerow][1+j*3]=formatea.format(ingresos[i][j][1]);
//             data[fakerow][2+j*3]=formatea.format(ingresos[i][j][2]*100);
//               }
//              fakerow++;        
//            }            
//            
//        } 
//       row++;
//         rowtitulo=row;
//        for(int i=0;i<expensestype.size();i++){
//            if(i==0){
//             roww[row]="COSTOS DE VENTA";
//             for(int j=0;j<13;j++){
//             data[row][j*3]=formatea.format(egresostit[0][j][0]);
//             data[row][1+j*3]=formatea.format(egresostit[0][j][1]);
//             data[row][2+j*3]=formatea.format(egresostit[0][j][2]*100);
//             }
//            row++;      
//            
//            }else if(i==titulosegresos[0]){
//            row++;
//             roww[row]="UTILIDAD BRUTA";
//              for(int j=0;j<13;j++){
//         montoaux=ingresostit[0][j][0]-egresostit[0][j][0];
//         pptaux=ingresostit[0][j][1]-egresostit[0][j][1];
//         if(pptaux!=0){
//         varaux=montoaux/pptaux;
//         }else{
//         varaux=0;}
//           data[row][j*3]=formatea.format(montoaux);
//             data[row][1+j*3]=formatea.format(pptaux);
//             data[row][2+j*3]=formatea.format(varaux);
//            
//              }   
//             row++;
//              
//             row++;
//              roww[row]="GASTOS DE OPERACIÓN";
//              for(int j=0;j<13;j++){
//                  montoaux=egresostit[1][j][0]+egresostit[2][j][0];
//         pptaux=egresostit[1][j][1]+egresostit[2][j][1];
//         if(pptaux!=0){
//         varaux=montoaux/pptaux;
//         }else{
//         varaux=0;}
//             data[row][j*3]=formatea.format(montoaux);
//             data[row][1+j*3]=formatea.format(pptaux);
//             data[row][2+j*3]=formatea.format(varaux);
//            
//             }            
//            row++;
//               roww[row]="GASTOS DE ADMINISTRACIÓN";
//               for(int j=0;j<13;j++){
//             data[row][j*3]=formatea.format(egresostit[1][j][0]);
//             data[row][1+j*3]=formatea.format(egresostit[1][j][1]);
//             data[row][2+j*3]=formatea.format(egresostit[1][j][2]*100);
//  }
//             row++; 
//            
//            }else if(i==titulosegresos[0]+titulosegresos[1]){
//               roww[row]="GASTOS DE VENTA";
//               for(int j=0;j<13;j++){
//         
//             data[row][j*3]=formatea.format(egresostit[2][j][0]);
//             data[row][1+j*3]=formatea.format(egresostit[2][j][1]);
//             data[row][2+j*3]=formatea.format(egresostit[2][j][2]*100);   }
//             row++; 
//            
//            }else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]){
//             row++; 
//             
//                roww[row]="UTILIDAD DE LA OPERACIÓN";
//         for(int j=0;j<13;j++){
//         montoaux=ingresostit[0][j][0]-egresostit[0][j][0]-egresostit[1][j][0]-egresostit[2][j][0];
//         pptaux=ingresostit[0][j][1]-egresostit[0][j][1]-egresostit[1][j][1]-egresostit[2][j][1];
//         if(pptaux!=0){
//         varaux=montoaux/pptaux;
//         }else{
//         varaux=0;}
//                data[row][j*3]=formatea.format(montoaux);
//             data[row][1+j*3]=formatea.format(pptaux);
//             data[row][2+j*3]=formatea.format(varaux);
//              }   
//             row++;
//            row++;
//                 roww[row]="GASTOS FINANCIEROS";
//             for(int j=0;j<13;j++){
// data[row][j*3]=formatea.format(egresostit[3][j][0]);
//             data[row][1+j*3]=formatea.format(egresostit[3][j][1]);
//             data[row][2+j*3]=formatea.format(egresostit[3][j][2]*100); 
//            }
//            row++;
//            }
//            else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
//                    +titulosegresos[3]){
//               row++;
//                   roww[row]="IMPUESTOS";
//               for(int j=0;j<13;j++){
//         
//         data[row][j*3]=formatea.format(egresostit[4][j][0]);
//             data[row][1+j*3]=formatea.format(egresostit[4][j][1]);
//             data[row][2+j*3]=formatea.format(egresostit[4][j][2]*100); 
//            
//            }
//            row++;
//            
//            }  else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
//                    +titulosegresos[3]+titulosegresos[4]){
//               row++;
//          roww[row]="INVERSIÓN";
//               for(int j=0;j<13;j++){        
//              data[row][j*3]=formatea.format(egresostit[5][j][0]);
//             data[row][1+j*3]=formatea.format(egresostit[5][j][1]);
//             data[row][2+j*3]=formatea.format(egresostit[5][j][2]*100);            
//            }
//            row++;
//            
//            }
//             else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
//                    +titulosegresos[3]+titulosegresos[4]+titulosegresos[5]){
//               row++;
//             roww[row]="ANTICIPO DE UTILIDADES";
//            for(int j=0;j<13;j++){
//         
//               data[row][j*3]=formatea.format(egresostit[6][j][0]);
//             data[row][1+j*3]=formatea.format(egresostit[6][j][1]);
//             data[row][2+j*3]=formatea.format(egresostit[6][j][2]*100); 
//        
//            
//            }
//            row++;
//            
//            }
//             else if(i==titulosegresos[0]+titulosegresos[1]+titulosegresos[2]
//                    +titulosegresos[3]+titulosegresos[4]+titulosegresos[5]+titulosegresos[6]){
//               row++;
//             roww[row]="OTROS EGRESOS";
//        
//               for(int j=0;j<13;j++){
//         
//               data[row][j*3]=formatea.format(egresostit[7][j][0]);
//             data[row][1+j*3]=formatea.format(egresostit[7][j][1]);
//             data[row][2+j*3]=formatea.format(egresostit[7][j][2]*100); 
//        
//            }
//            row++;
//            
//            } 
//               roww[row]=expensestype.get(i).Description;
//               for(int j=0;j<13;j++){
//             data[row][j*3]=formatea.format(egresos[i][j][0]);
//             data[row][1+j*3]=formatea.format(egresos[i][j][1]);
//             data[row][2+j*3]=formatea.format(egresos[i][j][2]*100); 
//              }
//             row++; 
//    }
//        fakerow++;
//          double totalingresos=0;
//          double totalegresos=0;
//          double saldofinal=0;
//          double totalingresosppt=0;
//          double totalegresosppt=0;
//          double saldoinicialppt=saldoinicial;
//          double saldofinalppt=0;
//          double totalingresosvar=0;
//          double totalegresosvar=0;
//          double saldoinicialvar=0;
//          double saldofinalvar=0;
//            roww[fakerow]="CAJA INICIAL";
//            roww[fakerow+1]="TOTAL DE INGRESOS";
//            roww[fakerow+2]="TOTAL DE EGRESOS";
//            roww[fakerow+3]="CAJA FINAL";
//   
//         for(int j=0;j<13;j++){
//         totalingresos=0;
//         totalegresos=0;
//         totalingresosppt=0;
//         totalegresosppt=0;
//         for(int i=0;i<2;i++){
//         totalingresos+=ingresostit[i][j][0];
//          totalingresosppt+=ingresostit[i][j][1];
//         }
//         for(int i=0;i<8;i++){
//         totalegresos+=egresostit[i][j][0];
//          totalegresosppt+=egresostit[i][j][1];
//         }
//         
//         if(j==12){
//             saldoinicial=saldoinicial1;
//             saldoinicialppt=saldoinicial1;
//         saldofinal=saldoinicial+totalingresos-totalegresos;
//         saldofinalppt=saldoinicialppt+totalingresosppt-totalegresosppt;
//         if(totalingresosppt!=0){
//         totalingresosvar=totalingresos/totalingresosppt;
//         }else{
//         totalingresosvar=0;}
//         if(totalegresosppt!=0){
//         totalegresosvar=totalegresos/totalegresosppt;
//         }else{
//         totalegresosvar=0;}
//         if(saldoinicialppt!=0){
//         saldoinicialvar=saldoinicial/saldoinicialppt;
//         }else{
//         saldoinicialvar=0;}
//         if(saldofinalppt!=0){
//         saldofinalvar=saldofinal/saldofinalppt;
//         }else{
//         saldofinalvar=0;}
//         
//         
//         }else{            
//                  saldofinal=saldoinicial+totalingresos-totalegresos;
//         saldofinalppt=saldoinicialppt+totalingresosppt-totalegresosppt;
//         if(totalingresosppt!=0){
//         totalingresosvar=totalingresos/totalingresosppt;
//         }else{
//         totalingresosvar=0;}
//         if(totalegresosppt!=0){
//         totalegresosvar=totalegresos/totalegresosppt;
//         }else{
//         totalegresosvar=0;}
//         if(saldoinicialppt!=0){
//         saldoinicialvar=saldoinicial/saldoinicialppt;
//         }else{
//         saldoinicialvar=0;}
//         if(saldofinalppt!=0){
//         saldofinalvar=saldofinal/saldofinalppt;
//         }else{
//         saldofinalvar=0;}
//
//         }
//             data[fakerow][j*3]=formatea.format(saldoinicial);
//             data[fakerow][1+j*3]=formatea.format(saldoinicialppt);
//             data[fakerow][2+j*3]=formatea.format(saldoinicialvar*100); 
//         
//             data[fakerow+1][j*3]=formatea.format(totalingresos);
//             data[fakerow+1][1+j*3]=formatea.format(totalingresosppt);
//             data[fakerow+1][2+j*3]=formatea.format(totalingresosvar*100); 
//         
//             data[fakerow+2][j*3]=formatea.format(totalegresos);
//             data[fakerow+2][1+j*3]=formatea.format(totalegresosppt);
//             data[fakerow+2][2+j*3]=formatea.format(totalegresosvar*100); 
//         
//             data[fakerow+3][j*3]=formatea.format(saldofinal);
//             data[fakerow+3][1+j*3]=formatea.format(saldofinalppt);
//             data[fakerow+3][2+j*3]=formatea.format(saldofinalvar*100); 
//         
//             saldoinicial=saldofinal;
//             saldoinicialppt=saldofinalppt;
//            }
//         
///////////////////////////////////////////////////////////////////////////////////////
// AbstractTableModel    model1 = new AbstractTableModel() {
//      public int getColumnCount() { return columnas.length; }
//      public int getRowCount() { return roww.length; }
//      public String getRowName(int col) {
//       return (String)columnas[col];
//      }
//       public String getColumnName(int col) {
//       return (String)columnas[col];
//      }
//      public Object getValueAt(int row, int col) {
//        return data[row][col];
//      }
//      public void setValueAt(Object obj, int row, int col) {
//        data[row][col] = obj;
//      }
//      public boolean CellEditable(int row, int col) {
//        return true;
//      }
//    };
//     
//    AbstractTableModel fixedModel1 = new AbstractTableModel() {     
//      public int getColumnCount() { return 1; }
//      public int getRowCount() { return roww.length; }
//      public String getColumnName(int col) {
//       return "    ";
//      }
//      public Object getValueAt(int rows, int col) {
//        return roww[rows];
//      }
//    };
//      
//     
//    table = new JTable( model1 );
//    table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//    table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//     
//    fixedTable = new JTable( fixedModel1 );
//    fixedTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//    fixedTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
//    
//  
//    JScrollPane fixedScroll = new JScrollPane( fixedTable );// {
//   //   public void setColumnHeaderView(Component view) {} // work around
//   // };                                                   //
//      
//      JScrollPane scroll      = new JScrollPane( table );
//    scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
// 
//     
//     fixedScroll.setColumnHeader(null);
//     final JScrollBar bar1 = scroll.getVerticalScrollBar();
//    JScrollBar bar2 = fixedScroll.getVerticalScrollBar();
//    bar2.addAdjustmentListener(new AdjustmentListener() {
//      public void adjustmentValueChanged(AdjustmentEvent e) {
//        bar1.setValue(e.getValue());
//      }
//    });
//    fixedScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        JScrollBar bar = fixedScroll.getHorizontalScrollBar();
//    JScrollBar dummyBar = new JScrollBar() {
//      public void paint(Graphics g) {}
//    };
//    dummyBar.setPreferredSize(bar.getPreferredSize());
//    fixedScroll.setVerticalScrollBar(bar2);
//     
//    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//    //final JScrollBar bar1 = scroll.getVerticalScrollBar();
//   // JScrollBar bar2 = fixedScroll.getVerticalScrollBar();
//    bar2.addAdjustmentListener(new AdjustmentListener() {
//      public void adjustmentValueChanged(AdjustmentEvent e) {
//        bar1.setValue(e.getValue());
//      }
//    });
//     scroll.setVerticalScrollBar(bar2);
//    
//     
//    scroll.setPreferredSize(new Dimension(1000, 600));
//    fixedScroll.setPreferredSize(new Dimension(200, 600));  // Hmm...
//    getContentPane().add(     fixedScroll, BorderLayout.LINE_START);
//    getContentPane().add(scroll, BorderLayout.CENTER);   
//  }

}
