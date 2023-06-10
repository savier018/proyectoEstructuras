package TDA;

public interface List<E> {
    
    public int size();
    
    public boolean isEmpty();

    public void clear();
    
    public boolean addFirst(E element);
    
    public boolean addLast(E element);
    
    public boolean removeFirst();
    
    public boolean removeLast();
    
    @Override
    public String toString();
    
}
