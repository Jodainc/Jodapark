package Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author joda11
 */
public class Horas {
    static  long milisegundos_dia = 24 * 60 * 60 * 1000;

    String fechaInicial1;
    String fechaFinal1;
        public Horas(){
    this.fechaInicial1="";
     this.fechaFinal1 ="";
        
    }
    public Horas(String fechaInicial1,String fechaFinal1){
    this.fechaInicial1=fechaInicial1;
     this.fechaFinal1 =fechaFinal1;
        
    }
    
        public long retornaDiferencia(String fechaInicial1,String fechaFinal1){
 /**Creamos una instancia de la clase calendar*/
        Calendar calFechaInicial=Calendar.getInstance();
        Calendar calFechaFinal=Calendar.getInstance();
        Date fechaInicial= StringToDate(fechaInicial1, "/", 0);//yyyy-MM-dd
        Date fechaFinal= StringToDate(fechaFinal1, "/", 0);
 /**Le pasamos el objeto Date al metodo set time*/
        calFechaInicial.setTime(fechaInicial);
        calFechaFinal.setTime(fechaFinal);
        long horas=diferenciaHorasDias(calFechaInicial,
                calFechaFinal)+diferenciaHoras(calFechaInicial,calFechaFinal);
        long minutos=diferenciaMinutos(calFechaInicial,calFechaFinal);

        if(minutos<0){
           horas = horas-1;
           minutos = minutos+60;
        System.out.println("Horas: "+(horas)+" Minutos: " +(minutos));
        }else{
          System.out.println("Horas: "+(horas)+" Minutos : "+minutos);
        }
        long pasarTiempo  = horas*60;
        
        long totalDif=pasarTiempo+minutos;
        return totalDif;
    }
    public long retornaHoras(String fechaInicial1,String fechaFinal1){
 /**Creamos una instancia de la clase calendar*/
        Calendar calFechaInicial=Calendar.getInstance();
        Calendar calFechaFinal=Calendar.getInstance();
        Date fechaInicial= StringToDate(fechaInicial1, "/", 0);//yyyy-MM-dd
        Date fechaFinal= StringToDate(fechaFinal1, "/", 0);
 /**Le pasamos el objeto Date al metodo set time*/
        calFechaInicial.setTime(fechaInicial);
        calFechaFinal.setTime(fechaFinal);
 //Numero total de minutos que hay entre las dos Fechas
        long totalHoras = cantidadTotalHoras(calFechaInicial,calFechaFinal);
        System.out.println("Numero Total de Horas" +
        " Entre las dos Fechas: "+cantidadTotalHoras(calFechaInicial,calFechaFinal));
        return totalHoras;
    }
        public long retornaMinutos(String fechaInicial1,String fechaFinal1){
 /**Creamos una instancia de la clase calendar*/
        Calendar calFechaInicial=Calendar.getInstance();
        Calendar calFechaFinal=Calendar.getInstance();
        Date fechaInicial= StringToDate(fechaInicial1, "/", 0);//yyyy-MM-dd
        Date fechaFinal= StringToDate(fechaFinal1, "/", 0);
 /**Le pasamos el objeto Date al metodo set time*/
        calFechaInicial.setTime(fechaInicial);
        calFechaFinal.setTime(fechaFinal);
 //Numero total de minutos que hay entre las dos Fechas
        long totalminutos = cantidadTotalMinutos(calFechaInicial,calFechaFinal);
        System.out.println("Numero Total de Minutos" +
        " Entre las dos Fechas: "+cantidadTotalMinutos(calFechaInicial,calFechaFinal));
        return totalminutos;
    }
                public long retornaSegundos(String fechaInicial1,String fechaFinal1){
 /**Creamos una instancia de la clase calendar*/
        Calendar calFechaInicial=Calendar.getInstance();
        Calendar calFechaFinal=Calendar.getInstance();
        Date fechaInicial= StringToDate(fechaInicial1, "/", 0);//yyyy-MM-dd
        Date fechaFinal= StringToDate(fechaFinal1, "/", 0);
 /**Le pasamos el objeto Date al metodo set time*/
        calFechaInicial.setTime(fechaInicial);
        calFechaFinal.setTime(fechaFinal);
 //Numero total de minutos que hay entre las dos Fechas
        long totalsegundos = cantidadTotalSegundos(calFechaInicial,calFechaFinal);
        System.out.println("Numero Total de segundos" +
        " Entre las dos Fechas: "+cantidadTotalSegundos(calFechaInicial,calFechaFinal));
        return totalsegundos;
    }
    /*Metodo que calcula la diferencia de las horas que han pasado entre dos fechas en java
*/
    
    public static long diferenciaHorasDias(Calendar fechaInicial ,Calendar fechaFinal){
    //Milisegundos al día
    long diferenciaHoras=0;
    //Restamos a la fecha final la fecha inicial y lo dividimos entre el numero de milisegundos al dia
    diferenciaHoras=(fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/milisegundos_dia;
   if(diferenciaHoras>0){
  // Lo Multiplicaos por 24 por que estamos utilizando el formato militar
    diferenciaHoras*=24;
   }
    return diferenciaHoras;
}
 /*Metodo que calcula la diferencia de los minutos entre dos fechas
*/
public static long diferenciaMinutos(Calendar fechaInicial ,Calendar fechaFinal){

    long diferenciaHoras=0;
    diferenciaHoras=(fechaFinal.get(Calendar.MINUTE)-fechaInicial.get(Calendar.MINUTE));
    return diferenciaHoras;
}
/*Metodo que devuelve el Numero total de minutos que hay entre las dos Fechas */
public static long cantidadTotalMinutos(Calendar fechaInicial ,Calendar fechaFinal){

    long totalMinutos=0;
    totalMinutos=((fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/1000/60);
    return totalMinutos;
}
/*Metodo que devuelve el Numero total de horas que hay entre las dos Fechas */
public static long cantidadTotalHoras(Calendar fechaInicial ,Calendar fechaFinal){

    long totalMinutos=0;
    totalMinutos=((fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/1000/60/60);
    return totalMinutos;
}
/*Metodo que devuelve el Numero total de Segundos que hay entre las dos Fechas */
public static long cantidadTotalSegundos(Calendar fechaInicial ,Calendar fechaFinal){

    long totalMinutos=0;
    totalMinutos=((fechaFinal.getTimeInMillis()-fechaInicial.getTimeInMillis())/1000);
    return totalMinutos;
}
 /*Metodo que calcula la diferencia de las horas entre dos fechas*/
public static long diferenciaHoras(Calendar fechaInicial ,Calendar fechaFinal){
    long diferenciaHoras=0;
    diferenciaHoras=(fechaFinal.get(Calendar.HOUR_OF_DAY)-fechaInicial.get(Calendar.HOUR_OF_DAY));

    return diferenciaHoras;
}
/* Convierte una fecha en date a string*/
public static String DateToString(Date fecha,String caracter,int op){
    String formatoHora=" HH:mm:ss";//Formato de hora
    //caracter hace referencia al separador / -
   String formato="yyyy"+caracter+"MM"+caracter+"dd"+formatoHora;
    if(op==1)
        //
        formato="yyyy"+caracter+"dd"+caracter+"MM"+formatoHora;
    else if(op==2)
        formato="MM"+caracter+"yyyy"+caracter+"dd"+formatoHora;
     else if(op==3)
        formato="MM"+caracter+"dd"+caracter+"yyyy"+formatoHora;
     else if(op==4)
        formato="dd"+caracter+"yyyy"+caracter+"MM"+formatoHora;
      else if(op==5)
        formato="dd"+caracter+"MM"+caracter+"yyyy"+formatoHora;

  SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
 String fechaFormato=null;
            sdf.setLenient(false);
            fechaFormato=sdf.format(fecha);

return fechaFormato;
}
/*Convertir fecha date en string*/
public static Date StringToDate(String fecha,String caracter,int op){
    String formatoHora=" HH:mm:ss";
     String formato="yyyy"+caracter+"MM"+caracter+"dd"+formatoHora;
    if(op==1)
        //
        formato="yyyy"+caracter+"dd"+caracter+"MM"+formatoHora;
    else if(op==2)
        formato="MM"+caracter+"yyyy"+caracter+"dd"+formatoHora;
     else if(op==3)
        formato="MM"+caracter+"dd"+caracter+"yyyy"+formatoHora;
     else if(op==4)
        formato="dd"+caracter+"yyyy"+caracter+"MM"+formatoHora;
      else if(op==5)
        formato="dd"+caracter+"MM"+caracter+"yyyy"+formatoHora;
 SimpleDateFormat sdf = new SimpleDateFormat(formato, Locale.getDefault());
 Date fechaFormato=null;
        try {

            sdf.setLenient(false);
            fechaFormato=sdf.parse(fecha);
        } catch (ParseException ex) {

        }
return fechaFormato;
}
}