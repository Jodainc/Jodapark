/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author JODA
 */
public class Recibos {
     DB base= new DB();   //instanciamos nuestra clase de conexión .
    public static Connection conexion;  //hacemos conexión con ayuda de nuestra clase
    int Folio;
    double Tiempo,Importe;   //declaración de variables
    String Cliente, Tipo_pago,Fecha;
    
    public Recibos(){  //constructor default
        this.Folio=0;
        this.Tiempo=0;
        this.Importe=0;
        this.Cliente="";
        this.Tipo_pago=""; 
        this.Fecha="";
    }
    
     public Recibos(String nombre){  //método que retorna los atributos asociados al nombre del cliente
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from recibo where Cliente= '"+nombre+"'");
          // select.setString(2, nombre);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    this.Folio= resultado.getInt(1);
                    this.Tiempo= resultado.getInt(3);
                    this.Importe= resultado.getInt(4);
                    this.Cliente= resultado.getString(2);
                    this.Tipo_pago= resultado.getString(5);
                    this.Fecha= resultado.getString(6);
                    
                }
                resultado.close();
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: "+ex.getMessage().toString());
        }
    }
         //constructor
     public Recibos (String Cliente, double Tiempo,double Importe, String Tipo_pago,String Fecha){
       
         this.Tiempo= Tiempo;
         this.Importe= Importe;
         this.Cliente= Cliente;
         this.Tipo_pago= Tipo_pago;
         this.Fecha= Fecha;
     }
    //gets and sets
    public int getFolio() {
        return Folio;
    }

    public void setFolio(int Folio) {
        this.Folio = Folio;
    }

    public double getTiempo() {
        return Tiempo;
    }

    public void setTiempo(int Tiempo) {
        this.Tiempo = Tiempo;
    }

    public double getImporte() {
        return Importe;
    }

    public void setImporte(int Importe) {
        this.Importe = Importe;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getTipo_pago() {
        return Tipo_pago;
    }

    public void setTipo_pago(String Tipo_pago) {
        this.Tipo_pago = Tipo_pago;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }
     
    
     
     public boolean Guardar(){  //método que guarda el reibo actual.
        
        try {
            conexion= base.GetConnection();
            PreparedStatement insertar= conexion.prepareStatement("insert into recibo (Cliente, Tiempo, Importe, Tipo_pago,Fecha) values(?,?,?,?,?) ");
           // insertar.setInt(1, Folio);
            insertar.setString(1,Cliente);
            insertar.setDouble(2, Tiempo);
            insertar.setDouble(3, Importe);
            insertar.setString(4,Tipo_pago);
            insertar.setString(5, Fecha);
            insertar.executeUpdate();
            conexion.close();
             JOptionPane.showMessageDialog(null,"Recibo creado!", "Éxito al Guardar",1);
            return true;
           
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema al insertar"+ex.getMessage(),"error",1);
            return false;
        }
        
    }
     
      public  List<Recibos> getClientes(){  //método que regresa en forma de lista los registros de la tabla recibos
        List<Recibos> listaRecibos = new ArrayList<Recibos>();
        conexion = base.GetConnection();
        try{
            String consulta = "select * from recibo";
            PreparedStatement select = conexion.prepareStatement(consulta);
            boolean r = select.execute();
            if(r){
                ResultSet result = select.getResultSet();
                while(result.next()){
                    Recibos recib = new Recibos(result.getString(2));
               //     System.out.println(recib.getCliente());
                    listaRecibos.add(recib);
                }
                result.close();
            }
            conexion.close();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return listaRecibos;
    }
     
}
