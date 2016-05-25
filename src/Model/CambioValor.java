package Model;
import static Model.Cajones.conexion;
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
public class CambioValor {
    DB base= new DB(); //instanciamos la clase de conexión
    public static Connection conexion;  //generamos conexión con ayuda de la clase
    int idUsuario;   //declaración de variables
    int Cajones;
    float Valorpar, Puesto;
    public CambioValor(){  //constructor por default
        this.idUsuario=0;
        this.Cajones=0;
        this.Valorpar=0;
        this.Puesto=0;
    }
    
      public CambioValor(int Cajones){  //método que retorna los atributos relacionados con un nombre
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from valores where Cajones= ?");
            select.setInt(1, Cajones);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    this.idUsuario= resultado.getInt(1);
                    this.Cajones= resultado.getInt(2);
                    this.Valorpar= resultado.getFloat(3);
                    this.Puesto= resultado.getFloat(4);
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
            select=conexion.prepareStatement("select max(Cajones) as 'Cajones' from valores");
            ResultSet rs= select.executeQuery();
         if(rs.next()){
            ultimo_id= rs.getInt("Cajones");
           //System.out.println("id aca: "+ultimo_id);
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
      public int ultimoValor_id(){      //método que nos entrega el último id creado.
            int ultimo_id=0;
          try {
            conexion = base.GetConnection();
            PreparedStatement select;
            select=conexion.prepareStatement("select max(Valorpar) as 'Valorpar' from valores");
            ResultSet rs= select.executeQuery();
         if(rs.next()){
            ultimo_id= rs.getInt("Valorpar");
           //System.out.println("id aca: "+ultimo_id);
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
      public int ultiValor_id(){      //método que nos entrega el último id creado.
            int ultimo_id=0;
          try {
            conexion = base.GetConnection();
            PreparedStatement select;
            select=conexion.prepareStatement("select max(id) as 'id' from valores;");
            ResultSet rs= select.executeQuery();
         if(rs.next()){
            ultimo_id= rs.getInt("id");
           System.out.println("id aca: "+ultimo_id);
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
      public CambioValor(int idUsuario, int Cajon, float ValorPa, float puesto){
          this.idUsuario=idUsuario;
          this.Cajones= Cajon;
          this.Valorpar= ValorPa;
          this.Puesto= puesto;
      }
            //Gets and sets
    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCajon() {
        return Cajones;
    }

    public void setCajon(int Cajon) {
        this.Cajones = Cajon;
    }

    public float getValorpa() {
        return Valorpar;
    }

    public void setValorpa(float Valorpa) {
        this.Valorpar = Valorpa;
    }

    public float getPuesto() {
        return Puesto;
    }

    public void setPuesto(float Puesto) {
        this.Puesto = Puesto;
    }
    
      
    public boolean Guardar(){  //guarda al usuario actual apuntado en el constructor
        
        try {
            conexion= base.GetConnection();
            PreparedStatement insertar= conexion.prepareStatement("insert into usuario (idUsuario,Nombre,Contraseña,Puesto) values(?,?,?,?) ");
            insertar.setInt(1, idUsuario);
            insertar.setInt(2,Cajones);
            insertar.setFloat(3, Valorpar);
            insertar.setFloat(4,Puesto);
            insertar.executeUpdate();
            conexion.close();
             JOptionPane.showMessageDialog(null,"Guardado!", "Éxito al Guardar",1);
            return true;
           
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema al insertar"+ex.getMessage(),"error",1);
            return false;
        }
        
    }
    
    public int Traervalor(int Valor,int campo){  //actualiza el usuario actualmente apuntado en el constructor.
                int Valor1=5;
                String campos="Cajones"; 
                String sqlf="";
                switch(campo){
                    case 1:
                        campos="Cajones";
                        sqlf="select "+campos+" from valores where "+campos+" = '"+Valor+"'";
                        break;
                          case 2:
                        campos="Valorpar";
                              System.out.println("select max("+campos+") as '"+campos+"' from valores");
                        sqlf="select max("+campos+") as '"+campos+"' from valores";
                                   break;
                          default :         
                          campos="Cajones";
                              break;
                }
        conexion=base.GetConnection();
        if(conexion!=null){
        conexion = base.GetConnection();
        PreparedStatement select;
        try{
            select = conexion.prepareStatement("select "+campos+" from valores where "+campos+" = '"+Valor+"'");
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    if(Valor==resultado.getInt(1)){
                                            Valor1 =resultado.getInt(1);
                    }
                resultado.close();
                }
            
            }
            conexion.close();
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Error al traer: "+ex.getMessage(),"error",1);
            return Valor=0;
        }}
        else{
            JOptionPane.showMessageDialog(null,"error al conectar","error",1);
            return Valor=0;
        }
               return Valor1;
    }
    
    public boolean actualizar(int idcam){  //actualiza el usuario actualmente apuntado en el constructor.
        conexion=base.GetConnection();
        if(conexion!=null){
        try{
            String peticion= "update valores set  Cajones=?, Valorpar=?  where id='";
            PreparedStatement actualizar= conexion.prepareStatement(peticion+idcam+"'");
            //actualizar.setInt(1,this.idUsuario);
            actualizar.setInt(1,this.Cajones);
            actualizar.setFloat(2,this.Valorpar);
            //actualizar.setFloat(4,this.Puesto);
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
            PreparedStatement borrar = conexion.prepareStatement("DELETE  from usuario where Nombre='"+this.Cajones+"'" );
         
            borrar.executeUpdate();
           JOptionPane.showMessageDialog(null,"borrado");
        }catch(SQLException ex){
            System.err.println("Ocurrió un error al borrar: "+ex.getMessage());
          
        }
    }
    
      
      public  List<CambioValor> getUsuarios(){ //devuelve una lista con todo los usuarios en la tabla.
        List<CambioValor> listaUsuarios = new ArrayList<CambioValor>();
        conexion = base.GetConnection();
        try{
            String consulta = "select idUsuario from usuario";
            PreparedStatement select = conexion.prepareStatement(consulta);
            boolean r = select.execute();
            if(r){
                ResultSet result = select.getResultSet();
                while(result.next()){
                    CambioValor user = new CambioValor(result.getInt(1));
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
    

