/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import javazoom.jl.player.*;
/**
 *
 * @author JODA
 */
public class player extends Thread {  //avisamos que nuestra clase es un hilo
    private jlp reproductor= null;  //instanciamos nuestro recurso de librería
    String ruta=""; //una string que nos dice en dónde está el archivo a reproducír
    public player (){  //constructor (vacio xD)
       
    }
    public void rep(String ruta){ //método que hace sonar la canción
         try{
            String [] args= new String[1]; //creamos un argumento capaz de almacenar rutas relativas
            args[0]=ruta;  //lo asociamos a la ruta
            //reproductor= jlp.createInstance(args);  //instanciamos el archivo a la propiedad de reproducción
            
        }
        catch(Exception e){ 
            
        }
    }
    public void run(){  //la ejecución de hilo.
        try{
        
            reproductor.play(); //reproducimos la instancia.
            Thread.sleep(5000);  //que duerma 5 seg para hacer un loop.
        
        }
        catch(Exception e){
            
        }
            
            
    }
}
