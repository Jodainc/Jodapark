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
    DB base= new DB();
    public static Connection conexion;
    int idUsuario;
    int Cajones;
    int Valorpar, TipoVehi;
    String Fecha;
    public CambioValor(){  //constructor por default
        this.idUsuario=0;
        this.Cajones=0;
        this.Valorpar=0;
        this.TipoVehi=0;
        this.Fecha="";
    }
    
      public CambioValor(int Cajones){
        conexion = base.GetConnection();
        PreparedStatement select;
        try {
            select = conexion.prepareStatement("select * from Valores where Tipo_vehi= ?");
            select.setInt(1, Cajones);
            boolean consulta = select.execute();
            if(consulta){
                ResultSet resultado =  select.getResultSet();
                if(resultado.next()){
                    this.idUsuario= resultado.getInt(1);
                    this.Cajones= resultado.getInt(2);
                    this.Valorpar= resultado.getInt(3);
                    this.TipoVehi= resultado.getInt(4);
                    this.Fecha=resultado.getString(5);
                }
                resultado.close();
            }
            conexion.close();
        } catch (SQLException ex) {
            System.err.println("Ocurrió un error: "+ex.getMessage().toString());
        }
    }
      public int ultimo_id(int Valori){
            int ultimo_id=0;
          try {
            conexion = base.GetConnection();
            PreparedStatement select;
            select=conexion.prepareStatement("select max(Cambio_Valor) as 'Cambio_Valor' from Valores WHERE Tipo_vehi = '"+Valori+"'");
            ResultSet rs= select.executeQuery();
         if(rs.next()){
            ultimo_id= rs.getInt("Cambio_Valor");
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
      public int ultimoValor_id(int ValorA){
            int ultimo_id=0;
          try {
            conexion = base.GetConnection();
            PreparedStatement select;
            select=conexion.prepareStatement("select max(Valorpar) as 'Valorpar' from Valores WHERE Tipo_vehi = '"+ValorA+"'");
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
            public int ultimoCajon(int ValorA){
            int ultimo_id=0;
          try {
            conexion = base.GetConnection();
            PreparedStatement select;
            select=conexion.prepareStatement("select max(Cajones) as 'Cajones' from Valores WHERE Tipo_vehi = '"+ValorA+"'");
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
      public int ultiValor_id(int ValorA){
            int ultimo_id=0;
          try {
            conexion = base.GetConnection();
            PreparedStatement select;
            select=conexion.prepareStatement("select max(Cambio_Valor) as 'Cambio_Valor' from Valores WHERE Tipo_vehi = '"+ValorA+"'");
            ResultSet rs= select.executeQuery();
         if(rs.next()){
            ultimo_id= rs.getInt("Cambio_Valor");
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
      public CambioValor(int idUsuario, int Cajon, int ValorPa, int tipoVehi,String fecha){
          this.idUsuario=idUsuario;
          this.Cajones= Cajon;
          this.Valorpar= ValorPa;
          this.TipoVehi= tipoVehi;
          this.Fecha = fecha;
      }
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
    public int getValorpa() {
        return Valorpar;
    }
    public void setValorpa(int Valorpa) {
        this.Valorpar = Valorpa;
    }
    public int getTipovehi() {
        return TipoVehi;
    }
    public void setPuesto(int tipoVehi) {
        this.TipoVehi = tipoVehi;
    }
        public String getFecha() {
        return Fecha;
    }
    public void setFecha(String fecha) {
        this.Fecha = fecha;
    }
    public int Traervalor(int Valor,int campo){
                int Valor1=0;
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
            select = conexion.prepareStatement("select "+campos+" from Valores where "+campos+" = '"+Valor+"'");
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
            String peticion= "update Valores set  Cajones=?, Valorpar=?,Tipo_vehi=?,Fecha_Cambio=?  where Cambio_Valor='";
            PreparedStatement actualizar= conexion.prepareStatement(peticion+idcam+"'");
            //actualizar.setInt(1,this.idUsuario);
            actualizar.setInt(1,this.Cajones);
            actualizar.setInt(2,this.Valorpar);
            actualizar.setInt(3, this.TipoVehi);
            actualizar.setString(4,this.Fecha);
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
      public  List<CambioValor> getUsuarios(){ //devuelve una lista con todo los usuarios en la tabla.
        List<CambioValor> listaUsuarios = new ArrayList<CambioValor>();
        conexion = base.GetConnection();
        try{
            String consulta = "select Cambio_Valor from Valores";
            PreparedStatement select = conexion.prepareStatement(consulta);
            boolean r = select.execute();
            if(r){
                ResultSet result = select.getResultSet();
                while(result.next()){
                    CambioValor user = new CambioValor(result.getInt(4));
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
    

