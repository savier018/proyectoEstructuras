package TDA;

public interface List<E> {
    
    public int size();
    
    public boolean isEmpty();

    public void clear();
    
    public boolean addFirst(E element);
    
     public boolean add(E element, int index);
    
    public boolean addLast(E element);
    
    public E get(int index);
    
    public boolean removeFirst();
    
    public boolean removeLast();
    
    public boolean remove(int index);
    
    @Override
    public String toString();
    
}
