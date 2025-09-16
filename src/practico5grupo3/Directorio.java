/* agregarContacto() que permite registrar un nuevo contacto con su respectivo nro. de 
teléfono. Siendo el nro. del teléfono la clave del mismo. 
B. buscarContacto() que en base al nro. de teléfono retorna el Contacto asociado al mismo. 
C. buscarTeléfono() que en base a un apellido nos devuelve un Set<Long> con los números 
de teléfono asociados a dicho apellido.  
D. buscarContactos() que en base a una ciudad nos devuelve un ArrayList con los 
Contactos asociados a dicha ciudad.  
E. borrarContacto() que en base al número de teléfono elimina el contacto del directorio. */
package practico5grupo3;

import java.util.*;
import java.util.Set;
import java.util.TreeMap;
import vistas.MenuPrincipal;

public class Directorio {
    
    private TreeMap<Long, Contacto> contactos;

    public Directorio() {
        contactos = new TreeMap<>();
    }

    // A. Agregar
    public boolean agregarContacto(Long telefono, Contacto c) {
        if(!contactos.containsKey(telefono)) {
            contactos.put(telefono, c);
            return true;
        }
        return false; // ya existía ese número
    }

    // B. Buscar por número
    public Contacto buscarContacto(Long telefono) {
        return contactos.get(telefono);
    }

    // C. Buscar teléfonos por apellido
    public Set<Long> buscarTelefono(String apellido) {
        Set<Long> telefonos = new TreeSet<>();
        for(Map.Entry<Long, Contacto> entry : contactos.entrySet()) {
            if(entry.getValue().getApellido().equalsIgnoreCase(apellido)) {
                telefonos.add(entry.getKey());
            }
        }
        return telefonos;
    }

    // D. Buscar contactos por ciudad
    public ArrayList<Contacto> buscarContactos(ArrayList <Ciudad> ciudades) {
        ArrayList<Contacto> lista = new ArrayList<>();
        for(Contacto c : contactos.values()) {
            if(c.getCiudades().equals(ciudades)) {
                lista.add(c);
            }
        }
        return lista;
    }

    // E. Borrar por teléfono
    public boolean borrarContacto(Long telefono) {
        if(contactos.containsKey(telefono)) {
            contactos.remove(telefono);
            return true;
        }
        return false;
    }
}
