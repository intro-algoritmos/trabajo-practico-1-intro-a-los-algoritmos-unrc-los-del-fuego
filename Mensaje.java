import java.util.ArrayList;

/**
 * Clase Mensaje: representa un mensaje en formato texto. 
 * El texto está almacenado en una lista de strings, donde cada
 * elemento de la lista representa una línea (renglón) del mensaje.
 * Ninguna línea excede los 80 caracteres (81 considerando el fin de
 * línea implícito al final de cada línea). Los mensajes sólo
 * contienen caracteres ASCII (es decir, el código ASCII de cada 
 * caracter del mensaje es menor a 128).
 * 
 * @author N. Aguirre
 * @version 0.1
 */
public class Mensaje
{
    /**
     * Longitud máxima de línea del mensaje
     */
    public static final int LONG_MAX_LINEA = 80;
    
    /**
     * líneas del mensaje
     */ 
    private ArrayList<String> lineas;
       
    /**
     * Constructor por defecto de la clase Mensaje().
     * Crea un mensaje vacío.
     */
    public Mensaje()
    {
        lineas = new ArrayList<String>();
    }
    private ArrayList<String> getLineas() {
        //return new ArrayList<>(lineas);
        return lineas;
    }
     public void asignarLineas(ArrayList<String> lineas) {
        if (lineas==null){
            throw new IllegalArgumentException("Las líneas no deben ser nulas");
        }
        for (String linea : lineas) {
            if(linea==null){
                throw new IllegalArgumentException("La línea no debe ser nula");
            }
            this.lineas.add(linea);
            }
        }
    /**
     * Retorna la cantidad de lineas del mensaje.
     * @return cantidad de lineas del mensaje.
     */
    public int cantLineas()
    {
        return lineas.size();
    }
    
    /**
     * Agrega una nueva línea al final del mensaje.
     * Precondición: la línea a agregar no debe ser null,
     * sólo puede contener caracteres ascii, y 
     * su longitud debe ser menor o igual a 80.
     * Postcondición: la línea 'linea' se agrega al final 
     * de la lista de líneas.
     * @param linea es la línea a agregar.
     */
    public void agregarLinea(String linea)
    {
        if (linea == null)
            throw new IllegalArgumentException("La linea a agregar no debe ser null.");
        if (linea.length() > LONG_MAX_LINEA)
            throw new IllegalArgumentException("Longitud invalida. La linea no debe tener más de 80 caracteres.");
        if (!esAscii(linea)) 
            throw new IllegalArgumentException("La linea a agregar contiene caracteres no ascii.");
        lineas.add(linea);
    }
    
    /**
     * Agrega una nueva línea al mensaje, en una posición específica.
     * Precondición: la línea a agregar no debe ser null,
     * sólo puede contener caracteres ascii, y 
     * su longitud debe ser menor o igual a 80.
     * La posición debe estar entre 0 y la cantidad de líneas del mensaje
     * Postcondición: la línea 'linea' se agrega a la lista de líneas, en la posición indicada.
     * @param linea es la línea a agregar.
     * @param pos es la posición en la cual se desea agregar la línea.
     */
    public void agregarLinea(int pos, String linea)
    {
        // TODO: Implementar este método 
        if (linea == null)
            throw new IllegalArgumentException("La línea a agregar no debe ser null.");
        if (linea.length() > LONG_MAX_LINEA)
            throw new IllegalArgumentException("Longitud inválida. La línea no debe tener más de 80 caracteres.");
        if (!esAscii(linea))
            throw new IllegalArgumentException("La línea a agregar contiene caracteres no ascii.");
        if (pos < 0 || pos > lineas.size())
            throw new IllegalArgumentException("Posición inválida. Debe estar entre 0 y " + lineas.size() + ".");
        
        lineas.add(pos, linea);
    }
    
    /**
     * Elimina la línea de una posición determinada del mensaje.
     * Precondición: pos debe estar entre cero y longitud (numero de líneas) menos uno del mensaje.
     * @param pos es la posición (índice) de la línea a eliminar.
     */
    public void eliminarLinea(int pos)
    {
        if (pos < 0 || pos >= cantLineas())
            throw new IllegalArgumentException("Posición inválida. No existe línea con esa posición.");
        lineas.remove(pos);
    }
    
    /**
     * Retorna la línea de una posición determinada del mensaje.
     * Precondición: pos debe estar entre cero y longitud (numero de líneas) menos uno del mensaje.
     * @param pos es la posición (índice) de la línea a retornar.
     * @return la línea en la posición (índice) indicada.
     */
    public String obtenerLinea(int pos)
    {
        if (pos < 0 || pos >= cantLineas())
            throw new IllegalArgumentException("Posición inválida. No existe línea con esa posición.");
        return lineas.get(pos);
    }
    
    
    /**
     * Comprueba si una cadena está compuesta exclusivamente de caracteres ASCII.
     * Los caracteres ASCII tienen código entre 0 y 127.
     * Precondición: la línea a chequear no debe ser null.
     * @param linea es la linea a chequear.
     * @return true ssi la cadena linea está compuesta exclusivamente de caracteres ASCII.
     */
    public boolean esAscii(String linea)
    {
        if (linea == null) 
            throw new IllegalArgumentException("La linea a chequear no debe ser null.");
        boolean esAscii = true;
        for (int i = 0; i < linea.length() && esAscii; i++) {
            if (linea.charAt(i) > 127) {
                esAscii = false;
            }
        }
        return esAscii;
    }
    
    /**
     * Comprueba si un mensaje es igual a otro mensaje.
     * Un mensaje es igual a otro si tiene el mismo número de líneas, y cada
     * línea de cada mensaje coincide.
     * Precondición: otro debe ser distinto de null.
     * @param otro es el mensaje con el cual comparar el mensaje actual.
     * @return true ssi el mensaje es igual a otro (el parámetro).
     */
    public boolean equals(Mensaje otro)
    {
       if(otro==null){
           throw new IllegalArgumentException("Las lineas de los mensajes deben tener almenos un caracter.");
        }
       //if (this.lineas.isEmpty()) {
         //   throw new IllegalArgumentException("No se puede comparar un mensaje si el otro esta vacio.");
        //}
       if (otro.getLineas().isEmpty()) {
         throw new IllegalArgumentException("No se puede comparar un mensaje si el otro esta vacio.");
        }
        ArrayList<String> lineasActual = this.getLineas();
        ArrayList<String> lineasOtro = otro.getLineas();
        // Verificamos que ambos mensajes tengan el mismo número de líneas
        if (lineasActual.size() != lineasOtro.size()) {
            return false;
        }
        // Comprobamos que cada línea en ambos mensajes sea igual
        for (int i = 0; i < lineasActual.size(); i++) {
            if (!lineasActual.get(i).equals(lineasOtro.get(i)) ||!esAscii(lineasActual.get(i))) {
                return false;
            }
        }
        // Si todas las líneas coinciden, devolvemos true
        return true;
    }
    
    /**
     * Genera una representación de cadena de caracteres del mensaje completo.
     * @return una cadena conteniendo el mensaje completo.
     */
    public String toString()
    {
        String result = "";
        for (String linea: lineas) {
            result = result + linea + "\n";
        }
        return result;
    }
    
    /**
     * Invariante de clase Mensaje. Chequea que la lista no sea nula, y todas sus líneas
     * cumplan con las restricciones de longitud y contenido.
     * @return true ssi el mensaje no es nulo, ninguna de sus lineas es nula, y todas son 
     * ascii, de hasta 80 caracteres.
     */
    public boolean repOK() 
    {
        if (lineas == null) 
            return false;
        else {
            boolean ok = true;
            for (int i = 0; i < lineas.size() && ok; i++) {
                String corriente = lineas.get(i);
                if (corriente == null || !esAscii(corriente) || corriente.length() > LONG_MAX_LINEA) {
                    ok = false;
                }
            }
            return ok;
        }
    }
    
}
