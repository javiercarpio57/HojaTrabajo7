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
        Association<String, String> valor;
        
        System.out.println("Ingrese la direccion o el nombre del documento .txt (en el caso está en la misma carpeta que el programa): ");
        Scanner teclado = new Scanner(System.in);
        String file = teclado.nextLine();
        BufferedReader br = new BufferedReader(new FileReader(file));     

        try {                
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while ((line=br.readLine())!=null) {
                String palabraIngles = "";
                String palabraEspanol = "";
                sb.append(line);
                sb.append(System.lineSeparator()); 
                line = line + " "; //Concatenado para que el ultimo valor sea leido sin problemas
                                   //por substring
                for(int i=1;i<line.length();i++){
                    String iter = line.substring((i-1), i); 
                    if(iter.equals(",")){
                        palabraIngles = line.substring(i, line.length()).toUpperCase(); //se obtiene la subcadena luego de ","
                        palabraEspanol = line.substring(0, i-1).toUpperCase(); //se obtiene la subcadena antes de ","       
                    }
                }
                valor = new Association (palabraIngles, palabraEspanol); //se crea el "nodo" que se pondrá en el tree
            }
        }
        finally{
            br.close();
        }
    }
    
}
