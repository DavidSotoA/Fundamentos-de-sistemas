
import java.util.List;
import java.util.Map;


public class Elemento {
    private String nombre;
    Map<String, String> atributo;
    private String texto;
    private List<Elemento> hijos;

    public Elemento(String nombre, Map<String, String> atributo, String texto, List<Elemento> hijos) {
        this.nombre = nombre;
        this.atributo = atributo;
        this.texto = texto;
        this.hijos = hijos;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Map<String, String> getAtributo() {
        return atributo;
    }

    public void setAtributo(Map<String, String> atributo) {
        this.atributo = atributo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Elemento> getHijos() {
        return hijos;
    }

    public void setHijos(List<Elemento> hijos) {
        this.hijos = hijos;
    }
    
    
}
