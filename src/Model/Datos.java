/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.aparcar;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author joda11
 */
public class Datos {
    JTextField Datos;
    int a;
    String letraCadena;
    String letranumber;
    public Datos(){
     this.letraCadena="";
     this.letranumber="";
    }
    public Datos(JTextField texto,int a){
        this.Datos = texto;
        this.a=a;
                                }
    
    public StringBuilder Placa(StringBuilder letrasPla,StringBuilder numberPla){
        StringBuilder capPlaca = new StringBuilder();
        if (letrasPla.length() > 2 && numberPla.length()> 2 && letrasPla.length()<4 && numberPla.length()<4) {
                if(isNumeric(numberPla.toString()) ){
                    letrasPla.setLength(3);
            numberPla.setLength(3);
            capPlaca=letrasPla.append(capPlaca).append(numberPla);
                    System.out.println("qui esta ");
                }else{
                     JOptionPane.showMessageDialog(null,"Problema con la placa1"+"  "+letrasPla+numberPla,"Verifique"+"  "+letrasPla+numberPla,1);
                }
            
                     }else{
                JOptionPane.showMessageDialog(null,"Problema con la placa2"+"  "+letrasPla+numberPla,"Verifique"+"  "+letrasPla+numberPla,1);
                        letrasPla.setLength(0);
                        numberPla.setLength(0);
            }
        
        return capPlaca;
    }
    
        public  boolean isNumeric(String cadena){
    	try {
    		Integer.parseInt(cadena);
    		return true;
    	} catch (NumberFormatException nfe){
    		return false;
    	}
    }
              public  void isCaden(final JTextField texto,final int a){
                            texto.addKeyListener(new KeyAdapter() {
                                public void keyTyped(KeyEvent e){
                                    char c= e.getKeyChar();
                                    int a1 = texto.getText().length();
                                    if(Character.isDigit(c) || a1>a){
                                        e.consume();
                                    }
                                }
                                                                  });
    }
public  void isProbar(final JTextField texto,final int a){
texto.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent e){
    
char c1= e.getKeyChar();
int a2 = texto.getText().length();
    if(!Character.isDigit(c1) || a2>a){
e.consume();}
}

});
}
}
