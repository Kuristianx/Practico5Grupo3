
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
