
package mdViviendas;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KEREN
 */
public class Salida {
    File archivo; 
    FileWriter escribir;
    PrintWriter line;
    
    public void abrirArchivo(String ruta){
        archivo = new File(ruta);

        if (archivo.exists()) {
            archivo.delete();
        }

        try {
            archivo.createNewFile();
            escribir = new FileWriter(archivo);
            line = new PrintWriter(escribir);
        } catch (IOException ex) {
            Logger.getLogger(Salida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void escribirArchivo(String info){
        line.println(info);
    }

    public void cerrarArchivo() {
        try {
            line.close();
            escribir.close();
        } catch (IOException ex) {
            Logger.getLogger(Salida.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    
