import java.util.ArrayList;
/**
 * Clase DecodificadorMensajes: representa una componente capaz de descifrar
 * un mensaje en formato texto, dado el mensaje y el código usado para la 
 * encripción. El mensaje a descifrar/decodificar debe ser un objeto
 * de tipo Mensaje (básicamente, una lista de strings, donde cada string
 * representa una línea). Se asume que el mensaje es ASCII, es decir, todos
 * los caracteres del mensaje tienen códigos en el rango [0, 127].
 * 
 * La codificación/decodificación utiliza una variante de Cifrado Cesar, en 
 * el cual el desplazamiento se basa en una código de encripción múltiple. 
 * Véase Cifrado de Vigenère para más detalles.
 * 
 * @author N. Aguirre
 * @version 0.1
 */
public class DecodificadorMensajes
{
    /**
     * Mensaje codificado
     */
    private Mensaje mensajeADecodificar;
    
    /**
     * Código a utilizar
     */
    private int[] codigoEncripcion;
    
    /**
     * Mensaje decodificado
     */
    private Mensaje mensajeDecodificado;

    /**
     * Constructor de la clase DecodificadorMensajes.
     * Inicializa el mensaje a desencriptar/decodificar con el parámetro pasado, 
     * junto con el código de desencripción. 
     * Precondición: tanto el mensaje msg como el código codigo no pueden ser nulos
     * @param msg es el mensaje a desencriptar.
     * @param codigo es el código de desencripción.
     */
    public DecodificadorMensajes(Mensaje msg, int[] codigo)
    {
        if (msg == null)
            throw new IllegalArgumentException("Mensaje nulo");
        if (codigo == null)
            throw new IllegalArgumentException("Código inválido.");
        mensajeADecodificar = msg;
        codigoEncripcion = codigo;
        mensajeDecodificado = null;
    }

    /**
     * Desencripta el mensaje. El mensaje no debe estar desencriptado.
     * Precondición: El mensaje aún no fue descifrado (i.e., el campo 
     * mensajeDecodificado es null).
     */
    public Mensaje decodificarMensaje() 
    {
        // TODO: Implementar este método
      if (mensajeADecodificar == null) {
            System.out.println("No hay mensaje para decodificar");
            return null;
        }
        if(mensajeADecodificar !=null){
            System.out.println("El mensaje ya fue decodificado");
            return mensajeDecodificado;
       }
       // Obtener las líneas del mensaje encriptado
        ArrayList<String> lineasEncriptadas = mensajeADecodificar.getLineas();   
        // Convertir el arreglo de clave a un solo entero (asumiendo que es un arreglo de dígitos)
        int clave = 0;
        for (int i = 0; i < codigoEncripcion.length; i++) {
            clave = clave * 10 + codigoEncripcion[i];
        }
        // Desencriptar cada línea del mensaje usando la clave
        ArrayList<String> lineasDesencriptadas = new ArrayList<String>();
        for (String lineaEncriptada : lineasEncriptadas) {
            char[] lineaDesencriptada = new char[lineaEncriptada.length()];
            for (int i = 0; i < lineaEncriptada.length(); i++) {
                char c = lineaEncriptada.charAt(i);
                if (Character.isLetter(c)) {
                    char base = Character.isLowerCase(c) ?'a' : 'A';
                    c = (char) ((c - base - clave + 26) % 26 + base);
                }
                lineaDesencriptada[i] = c;
            }
            lineasDesencriptadas.add(new String(lineaDesencriptada));
        }
        // Crear un nuevo Mensaje con las líneas desencriptadas y asignarlo a mensajeDecodificado
        mensajeDecodificado = new Mensaje();
        mensajeDecodificado.asignarLineas(lineasDesencriptadas);
        return mensajeDecodificado;
      }

    /**
     * Retorna el mensaje ya decodificado/descifrado.
     * Precondición: el mensaje debe haber sido decodificado previamente (i.e., 
     * se debe haber llamado a decodificarMensaje()).
     * Postcondicion: se retorna el mensaje descifrado/decodificado.
     * @return el mensaje descifrado.
     */
    public Mensaje obtenerMensajeDecodificado() {
        if (mensajeDecodificado == null)
            throw new IllegalStateException("Mensaje aún no decodificado");
        return mensajeDecodificado;
    }
    
    /**
     * Desencripta una cadena, dado un código numérico. Se usan los dígitos del código
     * para reemplazar cada caracter de la cadena por el caracter correspondiente a 
     * "trasladar" el mismo el número de lugares que indica el código, en sentido inverso
     * al de encripción (es decir, se resta el código al caracter). El código tiene
     * múltiples valores: se usa el primero para el primer caracter, el segundo para el 
     * segundo, y así sucesivamente. Si se agota el código, se vuelve al comienzo del mismo, 
     * hasta desencriptar toda la cadena.
     * Precondición: tanto str como codigo no deben ser nulos.
     * @param str es la cadena a desencriptar
     * @param codigo es el código a utilizar para la desencripción
     */
    private String desencriptarCadena(String str, int[] codigo) {
        // TODO: Implementar este método, sustituyendo la línea
        // debajo con el código correspondiente a la funcionalidad
        return null;
    }
    
}
