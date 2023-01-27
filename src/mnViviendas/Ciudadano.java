package mnViviendas;

/**
 *
 * @author KEREN
 */
public class Ciudadano {
    private String nombre;
    private int cedula;

    public Ciudadano(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the cedula
     */
    public int getCedula() {
        return cedula;
    }
    
    
}
