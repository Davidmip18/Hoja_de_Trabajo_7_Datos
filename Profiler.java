import java.util.Random;

public class Profiler {
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> tree = new BinaryTree<>();
        int numElements = 100000; // Dataset grande: 100,000 elementos
        Random random = new Random();
        String[] wordsToSearch = new String[100]; // Guardar 100 palabras para probar la búsqueda

        System.out.println("Iniciando Profiling con " + numElements + " asociaciones...\n");

        // ==========================================
        // 1. PROFILING DE INSERCIÓN
        // ==========================================
        long startTimeInsert = System.nanoTime();
        
        for (int i = 0; i < numElements; i++) {
            // Generar una "palabra" aleatoria en francés simulada
            String randomFrenchWord = "mot" + random.nextInt(2000000); 
            tree.insert(new Association<>(randomFrenchWord, "traduccion_dummy"));
            
            // Guardar las primeras 100 palabras para buscarlas después
            if (i < 100) {
                wordsToSearch[i] = randomFrenchWord;
            }
        }
        
        long endTimeInsert = System.nanoTime();
        long durationInsertMs = (endTimeInsert - startTimeInsert) / 1_000_000; // Convertir a milisegundos

        System.out.println("Tiempo total de Inserción (" + numElements + " elementos): " + durationInsertMs + " ms");


        // ==========================================
        // 2. PROFILING DE BÚSQUEDA
        // ==========================================
        long startTimeSearch = System.nanoTime();
        
        for (String word : wordsToSearch) {
            tree.search(new Association<>(word, "")); // Buscar la llave
        }
        
        long endTimeSearch = System.nanoTime();
        // Calcular el promedio por cada búsqueda en nanosegundos
        long durationSearchNs = (endTimeSearch - startTimeSearch) / wordsToSearch.length; 

        System.out.println("Tiempo promedio de Búsqueda (por elemento): " + durationSearchNs + " ns");
        System.out.println("\nProfiling completado exitosamente.");
    }
}
