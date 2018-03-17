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
public class BinarySearchTree<E> 
{

    private Node root;

    public BinarySearchTree()
    // post: constructor that generates an empty node
    {
        root = null;
    }
    void insert(Node newNode) 
    {
        root = insertRec(root, newNode);
    }
     
    /* A recursive function to insert a new key in BST */
    public Node insertRec(Node root, Node newNode) {
 
        /* If the tree is empty, return a new node */
        if (this.root == null) {
            this.root = newNode;
            return this.root;
        }
 
        /* Otherwise, recur down the tree */
        else if (root.getKey().compareTo(newNode.getKey()) < 0) //devuelve positivo si el primer string es menor que el segundo
        {
            root.setLeft(insertRec(root.getLeft(), newNode));
            root.getLeft().setParent(root);
        }
        else if ((root.getKey().compareTo(newNode.getKey()) > 0) || (root.getKey().compareTo(newNode.getKey()) ==0))
        {
            root.setRight(insertRec(root.getRight(), newNode));
            root.getRight().setParent(root);
        }
 
        /* return the (unchanged) node pointer */
      return root;
    }
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
    void inorder()  {
       inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.getLeft());
            System.out.println("("+ root.getKey()+ ", " + root.getEspanol()+ ")");
            inorderRec(root.getRight());
        }
    }
}

