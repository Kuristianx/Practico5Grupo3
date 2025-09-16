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
    
    private long telefono;

    private static TreeMap<Long, Contacto> informacion = new TreeMap<>();

    public static boolean agregarContacto(long telefono, Contacto cont) {
        if (telefono <= 0 || cont == null) {
            return false;
        }

        if (informacion.containsKey(telefono)) {
            return false;
        }

        informacion.put(telefono, cont);

        return true;

    }

    public static Set<Long> todosLosTelefonos() {
        return new TreeSet<>(informacion.keySet());
    }

    public static Contacto buscarContacto(long telefono) {
        return informacion.get(telefono);

    }

    public static Set<Long> buscarTelefonoPorApellido(String apellido) { 
        TreeSet<Long> numeroEncontrado = new TreeSet<>();
        for (Map.Entry<Long, Contacto> c : informacion.entrySet()) { 
            if (c.getValue().getApellido().equalsIgnoreCase(apellido)) { 
                numeroEncontrado.add(c.getKey()); 
            }
        }
        return numeroEncontrado;
    }

    public static Contacto buscarContactoPorDNI(int dni){
       for (Contacto c: informacion.values()){
           if(c.getDni() == dni){
               
               return c;
           }
       }
       return null;

       
    }

    public static Set<Integer> TodosLosDni() {
        Set<Integer> listaDni = new TreeSet<>();

        for (Contacto dni : informacion.values()) {
            listaDni.add(dni.getDni());
        }
        return listaDni;
    }
    // NO SABEMOS SI LO VAMOS A USAR
    public static boolean borrarContacto(Long telefono) {
       if(telefono== null)return false;

       // busca el telefono lo elimina si no lo encuentra devuelve false
       
       if(informacion.remove(telefono)!= null){
           return true;
       }else{
           return false;
       }
    }
    
  
    
    public static Long BuscarTlefonoPorContacto(Contacto cont){
        for(Map.Entry<Long, Contacto> entry : informacion.entrySet()){
            if(entry.getValue().equals(cont)){
                return entry.getKey();
            }
        }
        return null;
    }
    //metodo que devuelve todas las ciudaddes q tienen contacto NO LAS CIUDADES CREADAS
    public static Set <String> todasLasCiudades(){
        Set <String> listaCiudades = new TreeSet<>();
        for(Contacto ciudad : informacion.values()){
            listaCiudades.add(ciudad.getCiudad());
        }
        return listaCiudades;
    }
    
    //metodo que nos devuelva todos los contactos q esten en una misma ciudad
    
    public static ArrayList <Contacto> contactosPorCiudad(String ciudad){
        ArrayList<Contacto> lista = new ArrayList<>();
        for(Contacto c: informacion.values()){
            if(c.getCiudad().equalsIgnoreCase(ciudad)){
                lista.add(c);
            }
        }
        return lista;
    }
    
    public List<Object[]> buscarContactosPorApellido(String apellido){
        List<Object[]> resultados = new ArrayList<>();
        for (Map.Entry<Long, Contacto> var : informacion.entrySet()) {
                Long telefono = var.getKey();
                Contacto c = var.getValue();
                
                if(c.getApellido().equalsIgnoreCase(apellido)){
                    resultados.add(new Object[]{c.getDni(), c.getApellido(), c.getNombre(), c.getDireccion(), c.getCiudad(), telefono});
                
                }
            }
        return resultados;
    }
    
    public Set<String> obtenerTodosLosApellidos(){
        Set<String> apellidos = new HashSet<>();
        
        for (Contacto c : informacion.values()) {
            apellidos.add(c.getApellido());
        }
        return apellidos;
    }
    
}
