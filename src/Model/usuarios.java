
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
public class usuarios {
    DB base= new DB(); //instanciamos la clase de conexión
    public static Connection conexion;  //generamos conexión con ayuda de la clase
    int idUsuario;   //declaración de variables
    String Nombre, Contraseña, Puesto;
    public usuarios(){  //constructor por default
        this.idUsuario=0;
        this.Nombre="";
        this.Contraseña="";
        this.Puesto="";
    }
    
      public usuarios(String Nombre){  //método que retorna los atributos relacionados con un nombre
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from usuario where Nombre= ?");
            select.setString(1, Nombre);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    this.idUsuario= resultado.getInt(1);
                    this.Nombre= resultado.getString(2);
                    this.Contraseña= resultado.getString(3);
                    this.Puesto= resultado.getString(4);
                }
                resultado.close();
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: "+ex.getMessage().toString());
        }
    }
   
      public int ultimo_id(){      //método que nos entrega el último id creado.
            int ultimo_id=0;
          try {
            conexion = base.GetConnection();
            PreparedStatement select;
            select=conexion.prepareStatement("select max(idUsuario) as 'idUsuario' from usuario");
            ResultSet rs= select.executeQuery();
         if(rs.next()){
            ultimo_id= rs.getInt("idUsuario");
          //  System.out.println("id aca: "+ultimo_id);
         } 
            select.close();
            rs.close();
            conexion.close();
        } catch (SQLException ex) {
          System.out.println("error: "+ex.getMessage());
            ultimo_id=1;
        }
          return ultimo_id;
      }
                        //Constructor
      public usuarios(int idUsuario, String Nombre, String Contraseña, String puesto){
          this.idUsuario=idUsuario;
          this.Nombre= Nombre;
          this.Contraseña= Contraseña;
          this.Puesto= Puesto;
      }
            //Gets and sets
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getCostraseña() {
        return Contraseña;
    }

    public void setConstraseña(String Constraseña) {
        this.Contraseña = Constraseña;
    }

    public String getPuesto() {
        return Puesto;
    }

    public void setPuesto(String Puesto) {
        this.Puesto = Puesto;
    }
    
      
    public boolean Guardar(){  //guarda al usuario actual apuntado en el constructor
        
        try {
            conexion= base.GetConnection();
            PreparedStatement insertar= conexion.prepareStatement("insert into usuario (idUsuario,Nombre,Contraseña,Puesto) values(?,?,?,?) ");
            insertar.setInt(1, idUsuario);
            insertar.setString(2,Nombre);
            insertar.setString(3, Contraseña);
            insertar.setString(4,Puesto);
            insertar.executeUpdate();
            conexion.close();
             JOptionPane.showMessageDialog(null,"Guardado!", "Éxito al Guardar",1);
            return true;
           
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema al insertar"+ex.getMessage(),"error",1);
            return false;
        }
        
    }
    
    public boolean actualizar(){  //actualiza el usuario actualmente apuntado en el constructor.
        conexion=base.GetConnection();
        if(conexion!=null){
        try{
            String peticion= "update usuario set idUsuario=?, Nombre=?, Contraseña=?, Puesto=?  where Nombre='";
            PreparedStatement actualizar= conexion.prepareStatement(peticion+this.Nombre+"'");
            actualizar.setInt(1,this.idUsuario);
            actualizar.setString(2,this.Nombre);
            actualizar.setString(3,this.Contraseña);
            actualizar.setString(4,this.Puesto);
            actualizar.executeUpdate();
            conexion.close();
            JOptionPane.showMessageDialog(null,"Registro Actualizado","Éxito al actualizar",1);
            return true;
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al actualizar: "+ex.getMessage(),"error",1);
            return false;
        }}
        else{
            JOptionPane.showMessageDialog(null,"error al conectar","error",1);
            return false;
        }
    }
    
      public  void eliminar(String noControl){  //elimina al usuario actualmente apuntado en el  constructor
        conexion = base.GetConnection();
        try{
            PreparedStatement borrar = conexion.prepareStatement("DELETE  from usuario where Nombre='"+this.Nombre+"'" );
         
            borrar.executeUpdate();
           JOptionPane.showMessageDialog(null,"borrado");
        }catch(SQLException ex){
            System.err.println("Ocurrió un error al borrar: "+ex.getMessage());
          
        }
    }
    
      
      public  List<usuarios> getUsuarios(){ //devuelve una lista con todo los usuarios en la tabla.
        List<usuarios> listaUsuarios = new ArrayList<usuarios>();
        conexion = base.GetConnection();
        try{
            String consulta = "select idUsuario from usuario";
            PreparedStatement select = conexion.prepareStatement(consulta);
            boolean r = select.execute();
            if(r){
                ResultSet result = select.getResultSet();
                while(result.next()){
                    usuarios user = new usuarios(result.getString(1));
                    System.out.println(user);
                    listaUsuarios.add(user);
                }
                result.close();
            }
            conexion.close();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return listaUsuarios;
    }


}
    

