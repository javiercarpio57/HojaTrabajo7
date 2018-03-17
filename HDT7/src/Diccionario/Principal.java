
package Diccionario;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author javie
 */
public class Principal {

    /**
     * 
     * @param args the command line arguments
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"));    
        StringBuilder sb = new StringBuilder();
        String line;
        Node<Association<String,String>> nuevoNodo;
        BinarySearchTree<Node<Association<String, String>>> bst = new BinarySearchTree<>(); //se crea nuevo arbol null

        Scanner teclado = new Scanner(System.in);

        try {
            while ((line=br.readLine())!=null) {
                String palabraIngles;
                String palabraEspanol;
                sb.append(line);
                sb.append(System.lineSeparator()); 
                line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                   //por substring
                for(int i=1;i<line.length();i++){
                    
                    String iter = line.substring((i-1), i); 
                    if(iter.equals(","))
                    {
                        palabraEspanol = line.substring(i, line.length()-1).toUpperCase(); //se obtiene la subcadena luego de ","
                        palabraIngles = line.substring(0, i-1).toUpperCase(); //se obtiene la subcadena antes de "," 
                        //System.out.println(palabraIngles+ ","+palabraEspanol);
                        nuevoNodo = new Node<>(palabraIngles, palabraEspanol); //se crea el "nodo" que se pondrá en el tree
                        bst.insert(nuevoNodo); //se agrega el nodo al arbol
                    }
                }
            }
            System.out.println("Imprimiendo diccionario - InOrder: ");
            bst.inorder();
        }
        finally{
            br.close();
        }
    }
    
}
