import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> dictionary = new BinaryTree<>();

        // Cargar el diccionario
        try (Scanner scanner = new Scanner(new File("diccionario.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    line = line.replace("(", "").replace(")", "");
                    String[] parts = line.split(",");
                    if (parts.length == 2) {
                        String french = parts[0].trim().toLowerCase(); // Guardar en minúscula
                        String spanish = parts[1].trim();
                        dictionary.insert(new Association<>(french, spanish));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró diccionario.txt");
        }

        System.out.println("Recorrido In-Order del diccionario:");
        dictionary.inOrder(); 
        System.out.println("\n--- Traducción del texto ---");

        // Procesar y traducir el texto
        try (Scanner scanner = new Scanner(new File("texto.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(" ");
                
                for (String word : words) {
                    String cleanWord = word.replaceAll("[^a-zA-ZáéíóúÁÉÍÓÚñÑ]", "").toLowerCase();
                    
                    if (!cleanWord.isEmpty()) {
                        Association<String, String> searchDummy = new Association<>(cleanWord, "");
                        Association<String, String> result = dictionary.search(searchDummy);
                        
                        if (result != null) {
                            System.out.print(word.replaceFirst(cleanWord, result.getValue()) + " ");
                        } else {
                            System.out.print("*" + word + "* ");
                        }
                    } else {
                        System.out.print(word + " ");
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró texto.txt");
        }
    }
}
