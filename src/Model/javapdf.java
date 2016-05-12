package Model;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element; 
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
/**
 *
 * @author JODA
 */
public class javapdf {
    File ruta= new File("");
String rutarel= ruta.getAbsolutePath();
    //Crea un documento con encabezado y varias páginas.
    public void createPdf(String folio,String cliente, String tiempo, String metodo,String pago,String fecha) throws IOException, DocumentException
    {   
        //Se crea el nuevo documento y se determina de que tamaño serán la hoja.
        Document document = new Document(PageSize.LETTER , 36, 36, 54, 36); 
        //Se declaran los parrafos que se usaran.
        Paragraph parrafo, parrafo2, parrafo3, encabezado, info;  
        //Mandamos llamar la(s) imágen(es) que queremos usar.
        Image imagen = Image.getInstance("logo_chico.png"); 
        Image firma= Image.getInstance("firma.png");
       
        
        //Para poder añadir al documento los elementos que requieras. 
        PdfWriter.getInstance(document, new FileOutputStream(rutarel+"\\Recibo"+folio+".pdf"));
        
        //Se "abre" el documento y puedes escribir en el. 
        document.open();
        //Crear un encabezado. 
        encabezado = new Paragraph("Recibo Tech Estacionamiento.\n\n");
        encabezado.setAlignment(Element.ALIGN_CENTER); //Centrar "encabezado". 
        document.add(encabezado); //Agregar al documento el encabezado.
        imagen.setAlignment(Element.ALIGN_LEFT); //Centrar imagen. 
        firma.setAlignment(Element.ALIGN_CENTER);
        document.add(imagen); //Agregar al documento la imagen. 
        document.add(new Paragraph("\t\tServicio de estacionamiento y seguridad vehicular.\n RFC: EST235613 Rep. Legal Jorge Alberto Márquez\n"
                + "Colima Col.             Tel: 312 23423534"));
       
       
        PdfPTable tabla = new PdfPTable(2);
        //addCell() Agrega una celda a la tabla, el cambio de fila ocurre automaticamente al llenar la fila.
        tabla.addCell("Fecha");
        tabla.addCell("Folio");
        tabla.addCell(fecha);
        tabla.addCell(folio);
        tabla.setWidthPercentage(20);
        tabla.setHorizontalAlignment(Element.ALIGN_RIGHT);
        document.add(tabla); //Agregar la tabla al documento.
        
         PdfPTable tabla2 = new PdfPTable(4);
         tabla2.addCell("Cliente: ");
         tabla2.addCell("Tiempo");
         tabla2.addCell("Vehiculo");
         tabla2.addCell("Método de pago");
         tabla2.addCell(cliente);
         tabla2.addCell(tiempo);
         tabla2.addCell("Protegido");
         tabla2.addCell(metodo);
         tabla2.setHorizontalAlignment(Element.ALIGN_CENTER);
         document.add(tabla2);
         
         PdfPTable tabla3 = new PdfPTable(1);
         tabla3.addCell("Total a pagar");
         tabla3.addCell(pago);
         tabla3.setHorizontalAlignment(Element.ALIGN_RIGHT);
         tabla3.setWidthPercentage(14);
         document.add(tabla3);
         
         document.add(new Paragraph("\n"));
         document.add(new Paragraph("\n"));
         document.add(new Paragraph("\n"));
         document.add(firma);
         
        document.close(); 
     }
    
        
}