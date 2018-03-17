/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("diccionario.txt"));    
        StringBuilder sb = new StringBuilder();
        String line;
        Node<Association<String,String>> nuevoNodo = null;
        BinarySearchTree<Node<Association<String, String>>> bst = new BinarySearchTree<>(); //se crea nuevo arbol null

        Scanner teclado = new Scanner(System.in);

        try {
            while ((line=br.readLine())!=null) {
                String palabraIngles = "";
                String palabraEspanol = "";
                sb.append(line);
                sb.append(System.lineSeparator()); 
                line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                   //por substring
                for(int i=1;i<line.length();i++){
                    
                    String iter = line.substring((i-1), i); 
                    if(iter.equals(","))
                    {
                        palabraEspanol = line.substring(i, line.length()).toUpperCase(); //se obtiene la subcadena luego de ","
                        palabraIngles = line.substring(0, i-1).toUpperCase(); //se obtiene la subcadena antes de "," 
                        //System.out.println(palabraIngles+ ","+palabraEspanol);
                    }
                    nuevoNodo = new Node<>(palabraIngles, palabraEspanol); //se crea el "nodo" que se pondrá en el tree
                    bst.insert(nuevoNodo); 
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
