/* agregarContacto() que permite registrar un nuevo contacto con su respectivo nro. de 
teléfono. Siendo el nro. del teléfono la clave del mismo. 
B. buscarContacto() que en base al nro. de teléfono retorna el Contacto asociado al mismo. 
C. buscarTeléfono() que en base a un apellido nos devuelve un Set<Long> con los números 
de teléfono asociados a dicho apellido.  
D. buscarContactos() que en base a una ciudad nos devuelve un ArrayList con los 
Contactos asociados a dicha ciudad.  
E. borrarContacto() que en base al número de teléfono elimina el contacto del directorio. */
package practico5grupo3;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import vistas.MenuPrincipal;

public class Directorio {
    
    TreeMap <Long,Contacto> directorioTelefono = new TreeMap<>();

    public TreeMap<Long, Contacto> getDirectorioTelefono() {
        return directorioTelefono;
    }

    public void setDirectorioTelefono(TreeMap<Long, Contacto> directorioTelefono) {
        this.directorioTelefono = directorioTelefono;
    }
    
    public boolean agregarContacto(Contacto contacto, long numeroTelefono){
        if(directorioTelefono.containsKey(numeroTelefono)){
            return false;
        } 
        directorioTelefono.put(numeroTelefono, contacto);
            return true;
    }
    public Contacto buscarContacto(long numeroTelefono){
        return directorioTelefono.get(numeroTelefono);
    }
    public void buscarTelefono(){
    
       
    }
    public void buscarContactos(){
        
        
    }
    public void borrarContactos(){
        
    //public void borrarContacto(Long numeroTelefono) {
    //if (contactos.containsKey(numeroTelefono)) {
      //  contactos.remove(numeroTelefono);
    //}
}
}
