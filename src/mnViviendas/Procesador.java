package mnViviendas;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import mdViviendas.Carga;
import mdViviendas.Salida;

/**
 *
 * @author KEREN
 */

public class Procesador {

    ArrayList<Vivienda> viviendas;
    String[] data;
   

    public Procesador() {
        viviendas = new ArrayList<>();
    }

    public void separarData() {
        Carga c = new Carga();
        c.cargarDatos();
        data = c.getData();

        for (int i = 0; i < data.length; i++) {
            String var = data[i];

            String nombre = var.split(",")[0];
            int cedula = parseInt(var.split(",")[1]);
            int cisterna = parseInt(var.split(",")[2]);
            int canecas = parseInt(var.split(",")[3]);
            int iluminacionInteligente = parseInt(var.split(",")[4]);
            int lucesAhorro = parseInt(var.split(",")[5]);
            int material = parseInt(var.split(",")[6]);
            Vivienda v = new Vivienda(new Ciudadano(nombre, cedula), cisterna, canecas, iluminacionInteligente, lucesAhorro, material);
            viviendas.add(v);
        }
    }

    public String puntajeGeneral(int cedula) {

        for (Vivienda v : viviendas) {
            if (v.getCiudadano().getCedula() == cedula) {
                float puntajeCisterna, puntajeCanecas, puntajeluz, puntajeLuzAhorro, puntajeMaterial, suma, promediocis;

                //cisterna
                if (v.getCisterna() == 1) {
                   
                    puntajeCisterna = 0.5f;
                } else {
                    puntajeCisterna = 0;
                }

                //canecas
                if (v.getCanecas() == 1) {
               
                    puntajeCanecas = 0.5f;
                } else {
                    puntajeCanecas = 0;
                }

                //iluminacion inteligente   
                if (v.getIluminacionInteligente() == 1) {
                    puntajeluz = 1.0f;
                } else {
                    puntajeluz = 0;
                }

                if (v.getLucesAhorro() == 1) {

                    puntajeLuzAhorro = 1.0f;
                } else {
                    puntajeLuzAhorro = 0;
                }

                if (v.getMaterial() == 9) {
                    puntajeMaterial = 2.0f;
                }

                if (v.getMaterial() <= 8) {
                    puntajeMaterial = 1.7f;
                }
                if (v.getMaterial() == 10) {
                    puntajeMaterial = 0;
                }

                //puntaje general
                suma = v.getCisterna() + v.getCanecas() + v.getIluminacionInteligente() + v.getLucesAhorro() + v.getMaterial();
                return "Su puntaje general es de" +" "+ suma;
            }
        }
        return null;
    }

    public void guardarDatos() {
        Salida s = new Salida();
        s.abrirArchivo("data.txt");
        for (int i = 0; i < viviendas.size(); i++) {
            Vivienda v = viviendas.get(i);
            s.escribirArchivo(v.getCiudadano().getNombre() + "," + v.getCiudadano().getCedula() + "," + v.getCisterna() + "," + v.getCanecas() + "," + v.getIluminacionInteligente() + ","+v.getLucesAhorro()+","+ v.getMaterial());
        }
        s.cerrarArchivo();

    }

    public void adicionarVivienda(Vivienda v) {
        viviendas.add(v);
    }

    public boolean buscarCiudadano(int cedula) {
        for (Vivienda var : viviendas) {
            if (var.getCiudadano().getCedula() == cedula) {
                return true;
            }
        }
        return false;
    }

    public String promedioCisterna() {
        int contcis = 0;
        for (Vivienda v : viviendas) {
            if (v.getCisterna() == 1) {
                contcis++;
            }
        }
        float promcis = (contcis * 100 ) / viviendas.size();
        return "Porcentaje de casa que contienen cisterna " +" "+ promcis + "%";

    }
    
    public String promedioCaneca() {
        int contcaneca = 0;
        for (Vivienda v : viviendas) {
                if (v.getCanecas() == 1) {
                    contcaneca++;
                }
        }
        float promcaneca = (contcaneca * 100 ) / viviendas.size();
        return "Porcentaje de las viviendas que contienen canecas " +" "+ promcaneca + "%";

    }
    
    public String promedioIlumintel() {
        int contilumintel = 0;
        for (Vivienda v : viviendas) {
                if (v.getIluminacionInteligente()== 1) {
                    contilumintel++;
                }
        }
        float promilumintel = (contilumintel * 100 ) / viviendas.size();
        return "Porcentaje de las viviendas que contienen iluminacion inteleginte " +" "+ promilumintel + "%";
    }
    
    public String promedioLuzahorro() {
        int conluzahorr = 0;
        for (Vivienda v : viviendas) {
                if (v.getLucesAhorro() == 1) {
                    conluzahorr++;
                }
        }
        float promluzahorr = (conluzahorr * 100 ) / viviendas.size();
        return "Porcentaje de viviendas que contienen luces de ahorro " +" "+ promluzahorr + "%";

    }
    
    
}

