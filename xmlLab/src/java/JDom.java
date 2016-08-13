import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

public class JDom{
    
    public static Elemento obtenerDatos(){
        Scanner in = new Scanner(System.in);
        Elemento elemento,hijo;
        List<Elemento> hijos= new ArrayList<>();
        String nombre_raiz, nombre_hijo, contenido, clave, valor;
        Map<String, String> atributos;
        int elementos, numero_atributos;
        System.out.print("Ingrese el nombre del elemento raiz: ");
        nombre_raiz=in.nextLine();
        System.out.print("Ingrese el numero de elementos: ");
        elementos=in.nextInt();
        in.nextLine();
        for(int i=0;i<elementos;i++){
            System.out.print("Ingrese el nombre del elemento "+(i+1)+": ");
            nombre_hijo=in.nextLine();
            System.out.print("Ingrese el numero de atributos de elemento "+(i+1)+": ");
            numero_atributos=in.nextInt();
            in.nextLine();
            atributos= new HashMap<>();
            for(int j=0;j<numero_atributos;j++){
                System.out.print("Ingrese la clave del atributo "+(j+1)+" del elemento "+(i+1)+": ");
                clave=in.nextLine();
                System.out.print("Ingrese el valor del atributo "+(j+1)+" del elemento "+(i+1)+": ");
                valor=in.nextLine();
                atributos.put(clave, valor);
            }
            System.out.print("Ingrese el contenido del elemento "+(i+1)+": ");
            contenido=in.nextLine();
            hijo= new Elemento(nombre_hijo, atributos, contenido, null);
            hijos.add(hijo);
        }
        elemento= new Elemento(nombre_raiz, null, null, hijos);
        return elemento;
    }
    
    public static Document crearXML(Elemento documento){
        Element nuevo_elemento;
        String key;
        Map<String, String> atributos;
        Element raiz = new Element(documento.getNombre());
        Document doc= new Document(raiz);
        //doc.setRootElement(raiz);
        for(Elemento elemento: documento.getHijos()){
            nuevo_elemento= new Element(elemento.getNombre());
            nuevo_elemento.setText(elemento.getTexto());
            atributos=elemento.getAtributo();
            Iterator it=atributos.keySet().iterator();
            while(it.hasNext()){
                key=(String) it.next();
                nuevo_elemento.setAttribute(new Attribute(key,atributos.get(key)));
            }
            doc.getRootElement().addContent(nuevo_elemento);
        }
        return doc;
    }
    
    public static void main(String[] params){
        Document doc=crearXML(obtenerDatos());
        Format format = Format.getPrettyFormat(); 
        XMLOutputter xmloutputter = new XMLOutputter(format);  
        String docStr = xmloutputter.outputString(doc);  
        System.out.println("\nXML generado:\n\n"+docStr);
    }
}
