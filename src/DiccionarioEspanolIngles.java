import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class DiccionarioEspanolIngles {

    public static void main(String[] args) {
        // HashMap para almacenar el diccionario con las palabras ingles y español.
        HashMap<String, String> DICCIONARIO = new HashMap<>();

        // Aqui se llenar el diccionario con una serie de palabras.
        DICCIONARIO.put("Hola", "Hello");
        DICCIONARIO.put("Adiós", "Goodbye");
        DICCIONARIO.put("Gracias", "Thank you");
        DICCIONARIO.put("Por favor", "Please");
        DICCIONARIO.put("Sí", "Yes");
        DICCIONARIO.put("¿Cómo estás?", "How are you?");
        DICCIONARIO.put("Estoy bien", "I'm fine");
        DICCIONARIO.put("¿De dónde eres?", "Where are you from?");
        DICCIONARIO.put("Soy estudiante", "I'm a student");
        DICCIONARIO.put("¿Hablas inglés?", "Do you speak English?");


        // Aqui se Seleccionan 5 palabras al azar, donde el usuario ingresara la traducion al ingles.
        Random RANDOM = new Random();
        String[] palabrasEspanol = DICCIONARIO.keySet().toArray(new String[0]);
        String[] palabrasAleatorias = new String[5];

        for (int i = 0; i < 5; i++) {
            int indiceAleatorio = RANDOM.nextInt(palabrasEspanol.length);
            palabrasAleatorias[i] = palabrasEspanol[indiceAleatorio];

            // Eliminar la palabra ya seleccionada para evitar repeticiones
            palabrasEspanol[indiceAleatorio] = palabrasEspanol[palabrasEspanol.length - 1];
            palabrasEspanol = Arrays.copyOf(palabrasEspanol, palabrasEspanol.length - 1);
        }

        // Pedir al usuario las traducciones
        Scanner SCANNER = new Scanner(System.in);
        int respuestasCorrectas = 0;
        for (String palabraEspanol : palabrasAleatorias) {
            System.out.println("¿Cuál es la traducción al inglés de: " + palabraEspanol + "?");
            String respuestaUsuario = SCANNER.nextLine();

            // Validar la respuesta
            String traduccionIngles = DICCIONARIO.get(palabraEspanol);
            if (respuestaUsuario.equalsIgnoreCase(traduccionIngles)) {
                respuestasCorrectas++;
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto. La traducción correcta es: " + traduccionIngles);
            }
        }

        // Mostrar resultados
        System.out.println("Respuestas correctas: " + respuestasCorrectas);
        System.out.println("Respuestas incorrectas: " + (palabrasAleatorias.length - respuestasCorrectas));
    }
}