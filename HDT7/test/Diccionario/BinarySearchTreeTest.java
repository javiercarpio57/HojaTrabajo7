
package Diccionario;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author javie
 */
public class BinarySearchTreeTest {
    
    public BinarySearchTreeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of insert method, of class BinarySearchTree.
     */
    @Test
    public void testInsert() {
        System.out.println("INSERT TEST");
        
        Node<Association<String,String>> nuevoNodo;
        BinarySearchTree<Node<Association<String, String>>> bst = new BinarySearchTree<>();
        
        nuevoNodo = new Node<>("CAT", "GATO");
        bst.insert(nuevoNodo);
        
        Node actual1 = bst.getRoot();
        String expected1 = "(CAT, GATO)";
        
        if(actual1 != null){
            
        }else{
            assertEquals(expected1, actual1);
        }
        
        
        
    }

    /**
     * Test of search method, of class BinarySearchTree.
     */
    @Test
    public void testSearch() {
        System.out.println("SEARCH TEST");
        
        Node<Association<String,String>> nuevoNodo;
        BinarySearchTree<Node<Association<String, String>>> bst = new BinarySearchTree<>();
        
        nuevoNodo = new Node<>("DOG", "PERRO");
        bst.insert(nuevoNodo);
        String actual1 = bst.search("DOG");
        String expected1 = "PERRO";
        
        assertEquals(expected1, actual1);
    }
    
}
