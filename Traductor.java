import java.io.*;
import java.util.*;

public class Traductor {
    public static void main(String[] args) {
        BinaryTree<Association<String, String>> dictionaryTree = new BinaryTree<>();
        try (Scanner sc = new Scanner(new File("diccionario.txt"))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().replace("(", "").replace(")", "");
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    dictionaryTree.insert(new Association<>(parts[0].trim().toLowerCase(), parts[1].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("no se encontro el archivo");
        }
        System.out.println("ordenado, In-order");
        dictionaryTree.inOrder();
        System.out.println("\ntraduccion");
        try (Scanner sc = new Scanner(new File("texto.txt"))) {
            while (sc.hasNext()) {
                String word = sc.next();
                String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
                
                Association<String, String> searchResult = 
                    dictionaryTree.search(new Association<>(cleanWord, ""));

                if (searchResult != null) {
                    System.out.print(searchResult.getValue() + " ");
                } else {
                    System.out.print("*" + word + "* ");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("no se encontro el archivo");
        }
    }
}