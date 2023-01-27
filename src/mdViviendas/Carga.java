package mdViviendas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author KEREN
 */
public class Carga {
    
    ArrayList<String> data;
    String[] dataVec;
    public String names;
  
   
    public Carga() {
        data= new ArrayList<>();
    }
    
    
   // CARGAMOS LOS DATOS 
    public void cargarDatos(){
        try {
            File names = new File("data.txt");
            FileReader frNames = new FileReader(names);
            BufferedReader bfNames = new BufferedReader(frNames);

            String name;

            try {
                while ((name = bfNames.readLine()) != null) {
                    data.add(name);
                }
            } catch (IOException ex) {
                Logger.getLogger(Carga.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("[-] No se encontro el diccionario en la ruta estipulada, porfavor cambien la ruta o coloque el archivo en la ruta estipulada.");
            System.exit(0);
        }
    }
    
    public String[] getData(){
        dataVec = new String[data.size()];
        for (int i = 0; i<data.size(); i++){
            dataVec[i] = data.get(i);
        }
        return dataVec;
    }
}
