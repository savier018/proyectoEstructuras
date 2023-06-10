package TDA;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CDLinkedList<E> implements List<E>, Iterable<E> {
   
    private Node<E> first;
    private Node<E> last;

    public CDLinkedList() {
        this.first = null;
        this.last = null;
    }

    @Override
    public int size() {
        int contador = 0;
        Node<E> viajero = first;
        
        do {
            contador++;
            viajero = viajero.getNext();
        } while (viajero!= first);
        return contador;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public void clear() {
        this.first = null;
        this.last = null;
    }

    @Override
    public boolean addFirst(E element) {
        Node<E> nuevoNode = new Node<>(element);
        if (isEmpty()) {
            nuevoNode.setNext(nuevoNode);
            nuevoNode.setPrev(nuevoNode);
            this.first = nuevoNode;
            this.last = nuevoNode;
        } else {
            nuevoNode.setNext(this.first);
            nuevoNode.setPrev(this.first.getPrev());
            this.first.getPrev().setNext(nuevoNode);
            this.first.setPrev(nuevoNode);
            this.first = nuevoNode;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> nuevoNode = new Node<>(element);
        if (isEmpty()){
           nuevoNode.setNext(nuevoNode);
           nuevoNode.setPrev(nuevoNode);
           this.first = nuevoNode;
           this.last = nuevoNode;
        } else {
            nuevoNode.setNext(this.first);
            nuevoNode.setPrev(this.first.getPrev());
            this.first.getPrev().setNext(nuevoNode);
            this.first.setPrev(nuevoNode);
            this.last = nuevoNode;
        }
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()){
           return false;
        } else if (first.getNext() == last) {
            first = null;
            last = null;
        } else {
            Node<E> nuevoNode = first.getNext();
            nuevoNode.setPrev(last);
            last.setNext(nuevoNode);
            first = nuevoNode;
        }
        return true;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()){
            return false;
        } else if (last.getNext() == first) {
            first = null;
            last = null;
        } else {
            Node<E> nuevoNode = last.getPrev();
            nuevoNode.setNext(first);
            first.setPrev(nuevoNode);
            last = nuevoNode;
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> nodoActual = first;
            private boolean esPrimero = false;

            @Override
            public boolean hasNext() {
                return !isEmpty() && (nodoActual != null) && (!esPrimero || nodoActual != first);
            }

            @Override
            public E next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                } 
                E contenido = nodoActual.getContent();
                nodoActual = nodoActual.getNext();
                esPrimero = true;
                return contenido;
                
            }                      
        };
    }
    
    @Override
    public String toString(){
        if (isEmpty()) {
            return "Empty LinkedList";
        }

        String result = "";
        Node<E> current = first;

        do {
            result += current.getContent() + " ";
            current = current.getNext();
        } while (current != first);

        return result.trim();
    }
    
}
