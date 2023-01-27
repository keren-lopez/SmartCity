package mnViviendas;

/**  
 *
 * @author KEREN
 */
public class Vivienda {

    public Ciudadano ciudadano;
    public int cisterna;
    public int canecas;
   public int iluminacionInteligente;
    public int lucesAhorro;
    public int material;


    public Vivienda(Ciudadano ciudadano, int cisterna, int canecas, int iluminacionInteligente, int lucesAhorro, int material) {
        this.ciudadano = ciudadano;
        this.cisterna = cisterna;
        this.canecas = canecas;
        this.iluminacionInteligente = iluminacionInteligente;
        this.lucesAhorro = lucesAhorro;
        this.material= material; 
    }

    /**
     * @return the ciudadano
     */
    public Ciudadano getCiudadano() {
        return ciudadano;
    }

    /**
     * @return the cisterna
     */
    public int getCisterna() {
        return cisterna;
    }

    /**
     * @return the canecas
     */
    public int getCanecas() {
        return canecas;
    }

    /**
     * @return the iluminacion_inteligente
     */
    public int getIluminacionInteligente() {
        return iluminacionInteligente;
    }

    /**
     * @return the luces_ahorro
     */
    public int getLucesAhorro() {
        return lucesAhorro;
    }


    /**
     * @return the material
     */
    public int getMaterial() {
        return material;
    }
    
    
    
    
}
