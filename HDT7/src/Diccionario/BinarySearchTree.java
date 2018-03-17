


/**
 *
 * @author anahernandez
 */
package Diccionario;

public class BinarySearchTree<E> 
{
    private Node root;
    
    public BinarySearchTree()
    // post: constructor that generates an empty node
    {
        root = null;
    }
    /**
     * Funcion que llama a la función recursiva (establece el punto de comienzo - raíz del árbol - para empezar a revisar y determinar en 
     * dónde se inserta un nuevo nodo en el árbol).
     * @param newNode: nodo que se desea 
     * 
     * Obtenido de: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     */
    public void insert(Node newNode) 
    {
        root = insertRec(root, newNode);
    }
     
    /**
     * Funcion recursiva para insertar un nuevo nodo en el árbol
     * @param root: conforme se revisa el árbol, root toma el valor del nodo (que ya está en el árbol) que se compara con el 
     * nodo que se quiere insertar.
     * @param nodo: el que se quiere insertar
     * @return Node: referencia a la posición del árbol del nodo insertado.
     * 
     * Obtenido y modificado de: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     */
    public Node insertRec(Node root, Node nodo) 
    {
 
        /* Si el árbol está vacío, establece el nodo argumento como la raíz del árbol */
        if (root == null) 
        {
            root = nodo;
            return root;
        }
 
        /* De lo contrario, busca en el árbol la posición que le corresponde al nodo del argumento */
        else if ((root.getKey()).compareTo(nodo.getKey()) > 0) //devuelve positivo si el primer string es menor que el segundo
        {
            root.setLeft(insertRec(root.getLeft(), nodo)); //al nodo actual, le pone el nodo del argumento como hijo izquierdo
            root.getLeft().setParent(root); //crea el vinculo padre-hijo entre nodos
        }
        else if ((root.getKey().compareTo(nodo.getKey()) < 0))
        {
            root.setRight(insertRec(root.getRight(), nodo));//al nodo actual, le pone el nodo del argumento como hijo izquierdo
            root.getRight().setParent(root); //crea el vinculo padre-hijo entre nodos
        }
 
        /* Devuelve referencia a nodo */
      return root;
    }
    /**
     * Método que busca si una palabra en inglés existe en el árbol y su traducción.
     * @param root: nodo actual
     * @param key: valor que se está buscando en el árbol
     * @return Node: nodo que contiene la referencia buscada.
     * 
     * Obtenido de: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     */
    public Node search(Node root, String key)
    {
        // Base Cases: root is null or key is present at root
        if (root==null || root.getKey().equals(key))
            return root;

        // val is greater than root's key
        if (root.getKey().compareTo(key) < 0)
            return search(root.getLeft(), key);

        // val is less than root's key
        return search(root.getRight(), key);
    }
    /**
     * Funcion que llama a la función recursiva (establece el punto de comienzo - raíz del árbol - para empezar a revisar y 
     * comparar nodos).
     * Obtenido de: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     */
    public void inorder()  {
       inorderRec(root);
    }
 
    /**
     * Función que va cambiando de nodos e imprimiéndolos en Inorder.
     * @param root: nodo que actualmente se está comparando
     * Obtenido y modificado de: https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
     */
    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.println(root.toString());
            inorderRec(root.getRight());
        }
    }
}

