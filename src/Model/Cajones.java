package Model;
import static Model.Clientes.conexion;
import static Model.usuarios.conexion;
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
public class Cajones {
   DB base= new DB(); //instanciamos a la clade de conexión de nuestra base de datos
    public static Connection conexion;  //hacemos la conexión a la base de datos con ayuda de nuestra clase
    int Numero,Estado,TipoVe;  //declaramos unas cuantas variables que ocupamos
    
    public Cajones(){
        this.Numero=0;
        this.Estado=0;
        this.TipoVe=0;
    }
    
    public Cajones(int Numero){   //este método recibe como parametro el número de cajón y te retorna todos los datos asociados
        int cont=0;
                int cont1=0;
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from cajon where Numero= ?");
            select.setInt(1, Numero);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    this.Numero= resultado.getInt(1);
                    this.Estado=resultado.getInt(2);
                    this.TipoVe= resultado.getInt(3);
                  
                }
                resultado.close();
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: "+ex.getMessage().toString());
        }
    }
        public int TipoVehic(int Numero){   //este método recibe como parametro el número de cajón y te retorna todos los datos asociados
        
                int cont=0;
                int cont1=0;
                int tipoVehi=0;
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from cajon where Numero= ?");
            select.setInt(1, Numero);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    this.Numero= resultado.getInt(1);
                    this.Estado=resultado.getInt(2);
                    this.TipoVe= resultado.getInt(3);
                  
                }
                resultado.close();
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: "+ex.getMessage().toString());
        }
        return tipoVehi;
        }
    public String TipoImagen(int tipoCajon){
        String tipoImagen="";
        switch(this.TipoVe){
            case 1 :
                if(tipoCajon==1){
                       tipoImagen="/backgrounds/image3007.png";
                }else if(tipoCajon==2){
                     tipoImagen="/backgrounds/moto3_1.png";
                }else{
                    tipoImagen="/backgrounds/moto2_1.png";
                }
             
                break;
                case 2 :
                            if(tipoCajon==1){
                       tipoImagen= "/backgrounds/image3004.png";
                }else if(tipoCajon==2){
                     tipoImagen= "/backgrounds/carro3_1.png";
                }else{
                    tipoImagen="/backgrounds/carro2_1.png";
                }
             
                break;
                default:
                  if(tipoCajon==1){
                       tipoImagen= "/backgrounds/image3004.png";
                }else if(tipoCajon==2){
                     tipoImagen= "/backgrounds/carro3_1.png";
                }else{
                    tipoImagen="/backgrounds/carro2_1.png";
                }
                break;
                
        } 
        
        return tipoImagen;
    }
    public int ConsultaCajon(int numero){
         int numero2=5;
        conexion = base.GetConnection();
        PreparedStatement select;
        try{
            select = conexion.prepareStatement("select Numero from cajon where Numero= '"+numero+"' ");
             boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    if(numero==resultado.getInt(1)){
                                            numero2 =resultado.getInt(1);
                    }
                resultado.close();
                }else{
                    numero2=0;
                }
            
            }
            conexion.close();
             
        }catch (SQLException ex){
            System.out.println("ocurrio un error Consulta Cajon()"+ ex.getMessage().toString());
        }
        
        
    return numero2;}
    
    public Cajones(int Numero, int Estado,int TipoVe){  //el constructor
        this.Numero=Numero;
        this.Estado=Estado;
        this.TipoVe = TipoVe;
    }

    public int getNumero() {   //los get and set
        return Numero;
    }

    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    public int getEstado() {
        return Estado;
    }

    public void setEstado(int Estado) {
        this.Estado = Estado;
    }
        public int getTipove() {
        return Estado;
    }

    public void setTipove(int Tipove) {
        this.TipoVe = TipoVe;
    }
    
        public boolean Guardar(){  //guarda el cajon   actual apuntado en el constructor
        
        try {
            conexion= base.GetConnection();
            PreparedStatement insertar= conexion.prepareStatement("insert into cajon (Numero,Estado,TipoVehiculo) values(?,?,?) ");
            insertar.setInt(1, this.Numero);
            insertar.setInt(2,1);
            insertar.setInt(3,this.TipoVe);
            insertar.executeUpdate();
            conexion.close();
             JOptionPane.showMessageDialog(null,"Guardado!", "Éxito al Guardar",1);
            return true;
           
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Problema al insertar in Cajones"+ex.getMessage(),"error",1);
            return false;
        }
        
    }
        public boolean actualizar(){  //aqui actualizamos los datos para el cajón actual, osea el enviado en constructor
        conexion=base.GetConnection();
        if(conexion!=null){
        try{
            String peticion= "update cajon set Numero=?,Estado=?  where Numero='";
            PreparedStatement actualizar= conexion.prepareStatement(peticion+this.Numero+"'");
            actualizar.setInt(1,this.Numero);
            actualizar.setInt(2,0);
            actualizar.executeUpdate();
            conexion.close();
           // JOptionPane.showMessageDialog(null,"Registro Actualizado","Éxito al actualizar",1);
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
         public  void eliminar(){  //elimina el cliente actual en constructor
        conexion = base.GetConnection();
        try{
            PreparedStatement borrar = conexion.prepareStatement("DELETE  from cajon where Numero='"+this.Numero+"'" );
         
            borrar.executeUpdate();
         //  JOptionPane.showMessageDialog(null,"borrado");
        }catch(SQLException ex){
            System.err.println("Ocurrió un error al borrar: "+ex.getMessage());
          
        }
     }
         public boolean actualizar2(){
        conexion=base.GetConnection();
        if(conexion!=null){
        try{
            String peticion= "update cajon set Numero=?,Estado=?,TipoVehiculo=?  where Numero='";
            PreparedStatement actualizar= conexion.prepareStatement(peticion+this.Numero+"'");
            actualizar.setInt(1,this.Numero);
            actualizar.setInt(2,0);
            actualizar.setInt(3, this.TipoVe);
            actualizar.executeUpdate();
            conexion.close();
           // JOptionPane.showMessageDialog(null,"Registro Actualizado","Éxito al actualizar",1);
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
    
    public  List<Cajones> getCajones(){   //obtenemos todos los registros de nuestra tabla en forma de lista.
        List<Cajones> listaCajones = new ArrayList<Cajones>();
        conexion = base.GetConnection();
        try{
            String consulta = "select Numero from cajon";
            PreparedStatement select = conexion.prepareStatement(consulta);
            boolean r = select.execute();
            if(r){
                ResultSet result = select.getResultSet();
                while(result.next()){
                    Cajones caj = new Cajones(result.getInt(1));
                    System.out.println(caj);
                    listaCajones.add(caj);
                }
                result.close();
            }
            conexion.close();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return listaCajones;
    }
    
    
}
