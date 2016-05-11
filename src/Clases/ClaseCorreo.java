package Clases;

/**
 *
 * @author JODA
 */
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;


public class ClaseCorreo {
    
    String usuarioCorreo;  //declaración de variables
    String password;
    
    String ruta_recibo;
    String archivorecibo;
  
   // String reporte;
    
    String destinatario;
    String asunto;
    String mensaje;
    
    //constructor
    public ClaseCorreo(String usuarioCorreo, String password, String ruta_recibo, String archivorecibo, String destinatario, String asunto,String mensaje) {
        this.usuarioCorreo = usuarioCorreo;
        this.password = password;
        this.ruta_recibo= ruta_recibo;
        this.archivorecibo= archivorecibo;
        this.destinatario = destinatario;
        this.asunto = asunto;
        this.mensaje = mensaje;
    }
//los gets and sets
    public void setUsuarioCorreo(String usuarioCorreo) {
        this.usuarioCorreo = usuarioCorreo;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRuta_recibo(String ruta_factura) {
        this.ruta_recibo = ruta_factura;
    }

    public void setArchivorecibo(String archivofactura) {
        this.archivorecibo = archivofactura;
    }

    

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    
    
    
   // public ClaseCorreo(String usuarioCorre,String password,String destinatario,String mensaje){
       // this(usuarioCorre,password,"","",destinatario,"",mensaje);
    //}
    
    //public ClaseCorreo(String usuarioCorre,String password,String destinatario,String asunto,String mensaje){
        //this(usuarioCorre,password,"","",destinatario,asunto,mensaje);
    //}    

    public boolean sendMail(){
        try
        {
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", usuarioCorreo);
            props.setProperty("mail.smtp.auth", "true");

            Session session = Session.getDefaultInstance(props, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText(mensaje);

            BodyPart adjunto = new MimeBodyPart();
            if (!ruta_recibo.equals("")){
                 adjunto.setDataHandler(
                    new DataHandler(new FileDataSource(ruta_recibo)));
                adjunto.setFileName(archivorecibo);                
            }
             
            
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            if (!ruta_recibo.equals("")){
                multiParte.addBodyPart(adjunto);
            }
            
            


            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(usuarioCorreo));
            message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(destinatario));
                message.setSubject(asunto);
            message.setContent(multiParte);
           

            Transport t = session.getTransport("smtp");
            t.connect(usuarioCorreo, password);
            t.sendMessage(message, message.getAllRecipients());
            t.close();
            return true;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }   
        
    }
    
    public void enviar(){
        String clave = "vmvspveiyorhqnuz"; 
        ClaseCorreo e = new ClaseCorreo( usuarioCorreo, password, ruta_recibo, archivorecibo, destinatario, asunto, mensaje);
        if (e.sendMail()){
            JOptionPane.showMessageDialog(null,"El email se mandó correctamente");
            
        }else{
            JOptionPane.showMessageDialog(null,"El email no se mandó correctamente");
        }
    }
    
    public  void main(String[] args){
        
    }

}
