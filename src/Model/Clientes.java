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
public class Clientes {
    DB base= new DB();  //instanciamos nuestra clase de base de datos
    public static Connection conexion;   //hacemos la conexión con ayuda de la clase DB
    int Cajon_Numero,Tipove;
    String Placa, Nombre, Correo, Marca_modelo,Obser, Llegada;
    
    public Clientes(){  //constructor default
        this.Cajon_Numero=0;
        this.Placa="";
        this.Nombre="";
        this.Correo="";
        this.Marca_modelo="";
        this.Llegada="";
        this.Obser="";
        this.Tipove=0;
    }
    
    public Clientes(String Nombre){  //método que retorna atributos asociados con el nombre que recibamos
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from cliente where Nombre= ?");
            select.setString(1, Nombre);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    this.Placa= resultado.getString(1);
                    this.Nombre= resultado.getString(2);
                    this.Correo= resultado.getString(3);
                    this.Marca_modelo= resultado.getString(4);
                     this.Cajon_Numero= resultado.getInt(5);
                     this.Llegada=resultado.getString(6);
                }
                resultado.close();
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: "+ex.getMessage().toString());
        }
    }
    
    public Clientes(int Cajon_Numero){  //método que retorna los atributos relacionados con el número de cajón recibido
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from cliente where Cajon_Numero= '"+Cajon_Numero+"'");
            //select.setInt(5,Cajon_Numero);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.executeQuery();
                if(resultado.next()){
                    this.Placa= resultado.getString(1);
                    this.Nombre= resultado.getString(2);
                    this.Correo= resultado.getString(3);
                    this.Marca_modelo= resultado.getString(4);
                     this.Cajon_Numero= resultado.getInt(5);
                     this.Llegada=resultado.getString(6);
                }
                resultado.close();
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: "+ex.getMessage().toString());
        }
    }
    
      //constructor
    public Clientes (String Placa, String Nombre, String Correo, String Marca_modelo, int Cajon_Numero, String Llegada,String Obser,int Tipove){
        this.Placa=Placa;
        this.Nombre=Nombre;
        this.Correo=Correo;
        this.Marca_modelo=Marca_modelo;
        this.Cajon_Numero=Cajon_Numero;
        this.Llegada=Llegada;
        this.Obser=Obser;
        this.Tipove=Tipove;
        
    }
// gets and sets
    public int getCajon_Numero() {
        return Cajon_Numero;
    }

    public void setCajon_Numero(int Cajon_Numero) {
        this.Cajon_Numero = Cajon_Numero;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getMarca_modelo() {
        return Marca_modelo;
    }

    public void setMarca_modelo(String Marca_modelo) {
        this.Marca_modelo = Marca_modelo;
    }

    public String getLlegada() {
        return Llegada;
    }

    public void setLlegada(String Llegada) {
        this.Llegada = Llegada;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
    public String getObser() {
        return Nombre;
    }

    public void setObser(String Obser) {
        this.Nombre = Obser;
    }
     public int getTipove() {
        return Tipove;
    }

    public void setTipove(int Tipove) {
        this.Tipove = Tipove;
    }
    
    
    
    
    public boolean Guardar(){  //método para guardar el cliente actual en el constructor.
        
        try {
            conexion= base.GetConnection();
            PreparedStatement insertar= conexion.prepareStatement("insert into cliente (Placa,Nombre,Correo,Marca_modelo,Cajon_Numero,Llegada,Observacion,TipoVehi) values(?,?,?,?,?,?,?,?) ");
            insertar.setString(1, Placa);
            insertar.setString(2,Nombre);
            insertar.setString(3, Correo);
            insertar.setString(4,Marca_modelo);
            insertar.setInt(5,Cajon_Numero);
            insertar.setString(6, Llegada);
            insertar.setString(7,Obser);
              insertar.setInt(8,Tipove);
            insertar.executeUpdate();
            conexion.close();
             JOptionPane.showMessageDialog(null,"Guardado!", "Éxito al Guardar",1);
            return true;
           
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema al insertar"+ex.getMessage(),"error",1);
            return false;
        }
        
    }
    
     public  void eliminar(){  //elimina el cliente actual en constructor
        conexion = base.GetConnection();
        try{
            PreparedStatement borrar = conexion.prepareStatement("DELETE  from cliente where Placa='"+this.Placa+"'" );
         
            borrar.executeUpdate();
         //  JOptionPane.showMessageDialog(null,"borrado");
        }catch(SQLException ex){
            System.err.println("Ocurrió un error al borrar: "+ex.getMessage());
          
        }
     }
     
     public  List<Clientes> getClientes(){  //retorna una  lista con todos los clientes en la database
        List<Clientes> listaClientes = new ArrayList<Clientes>();
        conexion = base.GetConnection();
        try{
            String consulta = "select Nombre from cliente";
            PreparedStatement select = conexion.prepareStatement(consulta);
            boolean r = select.execute();
            if(r){
                ResultSet result = select.getResultSet();
                while(result.next()){
                    Clientes client = new Clientes(result.getString(2));
                    System.out.println(client);
                    listaClientes.add(client);
                }
                result.close();
            }
            conexion.close();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return listaClientes;
    }

}
