/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Diccionario;

import java.util.*;

/**
 *
 * @author anahernandez
 */
public class BinaryTree<E>
{

    protected Association<String, String> val; // value associated with node
    protected BinaryTree<E> parent; // parent of node
    protected BinaryTree<E> left, right; // children of node

    public BinaryTree()
    // post: constructor that generates an empty node
    {
            val = null;
            parent = null; left = right = this;
    }

    public BinaryTree(Association<String, String> value)
    // post: returns a tree referencing value and two empty subtrees
    {
            val = value;
            right = left = new BinaryTree<E>();
            setLeft(left);
            setRight(right);
    }

    public BinaryTree(Association<String, String> value, BinaryTree<E> left, BinaryTree<E> right)
    // post: returns a tree referencing value and two subtrees
    {
            val = value;
            if (left == null) { left = new BinaryTree<E>(); }
            setLeft(left);
            if (right == null) { right = new BinaryTree<E>(); }
            setRight(right);
    }

    public BinaryTree<E> left()
    // post: returns reference to (possibly empty) left subtree
    // post: returns reference to (possibly empty) left subtree
    {
            return left;
    }

    public BinaryTree<E> parent()
    {
        return parent;
    }
    // post: returns reference to parent node, or null

    public void setLeft(BinaryTree<E> newLeft)
    // post: sets left subtree to newLeft
    // re-parents newLeft if not null
    {
            if (isEmpty()) return;
            if (left != null && left.parent() == this) left.setParent(null);
            left = newLeft;
            left.setParent(this);
    }

    protected void setParent(BinaryTree<E> newParent)
    // post: re-parents this node to parent reference, or null
    {
            if (!isEmpty()) {
            parent = newParent;
            }
    }

    public boolean isLeftChild()
    // post: returns true if this is a left child of parent
    {
        return (parent.left().equals(this)); //si este objeto es igual al objeto guardado en el hijo izquierdo de su padre
    }

    public Association<String, String> value()
    // post: returns value associated with this node
    {
            return val;
    }

    public void setValue(Association<String, String> value)
    // post: sets the value associated with this node
    {
            val = value;
    }

    private void setRight(BinaryTree<E> right) {
        if (isEmpty()) return;
        if (right != null && right.parent() == this) right.setParent(null);
	this.right = right;
	right.setParent(this);
    }

    private boolean isEmpty() {
        return (parent == null);
    }
	
}

