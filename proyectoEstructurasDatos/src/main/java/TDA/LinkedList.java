package TDA;

import java.util.Iterator;

public class LinkedList<E> implements List<E>, Iterable<E> {
   
    private Node<E> cabeza;
    private Node<E> currentNodeNext;
    private Node<E> currentNodePrev;

    public LinkedList() {
        this.cabeza = null;
    }

    @Override
    public int size() {
        if (isEmpty()){
            return 0;
        }
        int contador = 1;
        Node<E> nodoViajero = cabeza.getNext();
        while (nodoViajero != cabeza) {
            contador++;
            nodoViajero = nodoViajero.getNext();
        }

        return contador;
    }

    @Override
    public boolean isEmpty() {
        return this.cabeza == null;
    }

    @Override
    public void clear() {
        this.cabeza = null;
    }

    @Override
    public boolean addFirst(E element) {
        Node<E> nuevoNode = new Node<>(element);
        if (isEmpty()) {
            this.cabeza = nuevoNode;
            nuevoNode.setNext(nuevoNode);
            nuevoNode.setPrev(nuevoNode);
        } else {
            nuevoNode.setNext(this.cabeza);
            nuevoNode.setPrev(this.cabeza.getPrev());
            this.cabeza.getPrev().setNext(nuevoNode);
            this.cabeza.setPrev(nuevoNode);
            cabeza = nuevoNode;
        }
        return true;
    }

    @Override
    public boolean addLast(E element) {
        Node<E> nuevoNode = new Node<>(element);
        if (isEmpty()){
           this.cabeza = nuevoNode;
           nuevoNode.setNext(nuevoNode);
           nuevoNode.setPrev(nuevoNode);
        } else {
            nuevoNode.setNext(this.cabeza);
            nuevoNode.setPrev(this.cabeza.getPrev());
            this.cabeza.getPrev().setNext(nuevoNode);
            this.cabeza.setPrev(nuevoNode);
        }
        return true;
    }

    @Override
    public boolean removeFirst() {
        if (isEmpty()){
           return false;
        } else if (this.cabeza.getNext() == cabeza) {
            this.cabeza = null;
        } else {
            Node<E> nodoSiguiente = this.cabeza.getNext();
            Node<E> nodoAnterior = this.cabeza.getPrev();
            
            nodoSiguiente.setPrev(nodoAnterior);
            nodoAnterior.setNext(nodoSiguiente);
        }
        return true;
    }

    @Override
    public boolean removeLast() {
        if (isEmpty()){
            return false;
        } else if (this.cabeza.getNext() == this.cabeza) {
            this.cabeza = null;
        } else {
            Node<E> nodoAnterior = this.cabeza.getPrev();
            Node<E> nodoPenultimo = nodoAnterior.getPrev();
            
            nodoPenultimo.setNext(cabeza);
            this.cabeza.setPrev(nodoPenultimo);
        }
        return true;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> nodoActual = cabeza;


            @Override
            public boolean hasNext() {
                return nodoActual != null;
            }

            @Override
            public E next() {
               E contenido = nodoActual.getContent();
               nodoActual = nodoActual.getNext();            
               return contenido;              
            }                      
        };
    }
    
    @Override
    public String toString(){
        if (isEmpty()) {
            return "La LinkedList está vacía";
        }

        String contenidoLinkedList = "";
        Node<E> nodoActual = cabeza;

        do {
            contenidoLinkedList += nodoActual.getContent() + ", ";
            nodoActual = nodoActual.getNext();
        } while (nodoActual != cabeza);

        return contenidoLinkedList.substring(0, contenidoLinkedList.length() - 1);
    }

    @Override
    public boolean add(E element, int indice) {
        Node<E> nuevoNode = new Node<>(element);
        if (indice < 0 || indice> size()){
           throw new IndexOutOfBoundsException("Índice fuera de rango"); 
        } else if (indice == 0 || cabeza == null){
            addFirst(element);
        } else if (indice == size()){
            addLast(element);
        }
        
        Node<E> nodoActual = cabeza;
        for (int i = 0; i < indice -1; i++) {
            nodoActual = nodoActual.getNext();
        }
        
        nuevoNode.setNext(nodoActual.getNext());
        nuevoNode.setPrev(nodoActual);
        nodoActual.getNext().setPrev(nuevoNode);
        nodoActual.setNext(nuevoNode);
        return true;
    }

    @Override
    public E get(int indice) {
        if (cabeza != null){
            Node<E> nodoActual = cabeza;
            for (int i = 0; i < indice; i++) {
                nodoActual = nodoActual.getNext();
            }
            return nodoActual.getContent();
        }
        throw new IndexOutOfBoundsException("Índice fuera de rango");
    }
    
    public void set(int indice, E elemento){
       if (isEmpty()){
           throw new IndexOutOfBoundsException("La lista está vacía");
       } else if (indice == 0){
          cabeza.setContent(elemento);
           
       } else if (indice == size()){
           Node<E> nA= cabeza;
           for(int i=0;size()>i;i++){
               nA.getNext();
           }
           nA.setContent(elemento);
       }
       Node<E> nodoActual = cabeza;
       int contador = 0;
       
       do{
         
           if (contador == indice){
               nodoActual.setContent(elemento);
           }
           nodoActual = nodoActual.getNext();
           contador++;
       }while(nodoActual != cabeza);
       
    }
    
    public E getNext(){
        if (isEmpty()) {
            return null;  
        } else if (currentNodeNext == null) {
            currentNodeNext = cabeza.getNext();  
        } else {
            currentNodeNext = currentNodeNext.getNext();  
            if (currentNodeNext == null) {
                currentNodeNext = cabeza.getNext();  
            }
        }
        return currentNodeNext.getContent();
    }
    
    public E getPrev(){
        if (isEmpty()) {
            return null;  
        } else if (currentNodePrev == null) {
            currentNodePrev = cabeza.getPrev();  
        } else {
            currentNodePrev = currentNodePrev.getPrev();  
            if (currentNodePrev== null) {
                currentNodePrev = cabeza.getPrev();  
            }
        }
        return currentNodePrev.getContent();
    }
    
}
