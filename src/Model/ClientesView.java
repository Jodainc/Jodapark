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
public class ClientesView {
    DB base= new DB();  //instanciamos nuestra clase de base de datos
    public static Connection conexion;   //hacemos la conexión con ayuda de la clase DB
    String Placa, Nombre, Correo, Marca_modelo,Obser, Llegada;
    
    public ClientesView(){  //constructor default
        this.Placa="";
        this.Nombre="";
        this.Correo="";
        this.Marca_modelo="";
        this.Llegada="";
        this.Obser="";
    }
    public boolean insertarTabla(String Placa){
        boolean valido=false;
        conexion = base.GetConnection();
        PreparedStatement select;
        try{
             select = conexion.prepareStatement("select * from cliview where Placa= '"+Placa+"'");
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    if(Placa.equals(resultado.getString(2))){
                        valido=true;
                    }
                }
                resultado.close();
            }
            }catch(SQLException ex){
            
        }
        return valido;
    }
    public ClientesView(String Nombre){  //método que retorna atributos asociados con el nombre que recibamos
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from cliview where Nombre= ?");
            select.setString(1, Nombre);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    this.Placa= resultado.getString(1);
                    this.Nombre= resultado.getString(2);
                    this.Correo= resultado.getString(3);
                    this.Marca_modelo= resultado.getString(4);
                     this.Llegada=resultado.getString(6);
                }
                resultado.close();
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: "+ex.getMessage().toString());
        }
    }
    
    public ClientesView(int Cajon_Numero){  //método que retorna los atributos relacionados con el número de cajón recibido
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from cliview where Cajon_Numero= '"+Cajon_Numero+"'");
            //select.setInt(5,Cajon_Numero);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.executeQuery();
                if(resultado.next()){
                    this.Placa= resultado.getString(1);
                    this.Nombre= resultado.getString(2);
                    this.Correo= resultado.getString(3);
                    this.Marca_modelo= resultado.getString(4);
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
    public ClientesView (String Placa, String Nombre, String Correo, String Marca_modelo, String Llegada,String Obser){
        this.Placa=Placa;
        this.Nombre=Nombre;
        this.Correo=Correo;
        this.Marca_modelo=Marca_modelo;
        this.Llegada=Llegada;
        this.Obser=Obser;
        
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
    public boolean Guardar(){  //método para guardar el cliente actual en el constructor.
        
        try {
            conexion= base.GetConnection();
            PreparedStatement insertar= conexion.prepareStatement("insert into cliview (Placa,Nombre,Celular,Marca_modelo,Llegada,Observacion) values(?,?,?,?,?,?) ");
            insertar.setString(1, Placa);
            insertar.setString(2,Nombre);
            insertar.setString(3, Correo);
            insertar.setString(4,Marca_modelo);
            insertar.setString(5, Llegada);
            insertar.setString(6,Obser);
            insertar.executeUpdate();
            conexion.close();
             JOptionPane.showMessageDialog(null,"Guardado Cliente nuevo!", "Éxito al Guardar",1);
            return true;
           
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema al insertar"+ex.getMessage(),"error",1);
            return false;
        }
        
    }
     public  List<ClientesView> getClientes(){  //retorna una  lista con todos los clientes en la database
        List<ClientesView> listaClientes = new ArrayList<ClientesView>();
        conexion = base.GetConnection();
        try{
            String consulta = "select Nombre from cliview";
            PreparedStatement select = conexion.prepareStatement(consulta);
            boolean r = select.execute();
            if(r){
                ResultSet result = select.getResultSet();
                while(result.next()){
                    ClientesView client = new ClientesView(result.getString(3));
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
