/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diccionario;

/**
 *
 * @author anahernandez
 */
public class Node<E> {
    private Association<String, String> value; // value associated with node
    private Node<E> parent; // parent of node
    private Node<E> left, right; // children of node
    
    public Node(String ingles, String espanol)
    {
        value = new Association<>(ingles, espanol);
        parent = null; 
        left = right = null;
    }
    public Association<String, String> getValue()
    {
        return value; //devuelve la palabra en español
    }
    public String getEspanol()
    {
        return value.theValue;
    }
    public String getKey()
    {
        return value.theKey; //devuelve la palabra en ingles
    }
    public Node<E> getLeft()
    {
        return left;
    }
    public Node<E> getRight()
    {
        return right;
    }
    public Node<E> getParent()
    {
        return parent;
    }
    public void setLeft(Node left)
    {
        this.left = left;
    }
    public void setRight(Node right)
    {
        this.right = left;
    }
    public void setParent(Node newParent)
    // post: re-parents this node to parent reference, or null
    {
            parent = newParent;
    }
    
    
}
