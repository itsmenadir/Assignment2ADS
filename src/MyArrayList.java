import java.util.Iterator;
public class MyArrayList<T>{
    private Object[] array;
    private int size = 0;
    private int capacity = 10;
    public MyArrayList(){
        array = new Object[capacity];
    }

    public T get(int index){
        return (T) array[index];

    }


    public void add(T element){
        if (size == capacity){
            increasesofarray();
        }
        array[size++] = element;

    }
    private void increasesofarray(){
        capacity = 2 * capacity;
        Object[] array2 = new Object[capacity];
        for (int i = 0; i < capacity; i++){
            array2[i] = array[i];

        }
        array2 = array;
    }
    public int getSize(){
        return size;
    }
    public void set(int index, T item){
        array[index] = item;

        }
    public void removeLast(){
        size--;
    }
    public void removeFirst(){
        for (int i = 0; i < size-1; i++){
            array[i] = array[i+1];
        }
        size--;
    }
    public T getLast(){
        return (T) array[size-1];

    }
    public T getfirst(){
        if(size == 0){
            throw new IllegalArgumentException("array is emplty");

        }
        return (T) array[0];
    }
    public void addFirst(T item){
        if (size == capacity){
            increasesofarray();
        }
        for (int i = size; i > 0; i--){
            array[i] = array[i-1];

        }
        size++;
        array[0] = item;

    }
    public void addLast(T item){
        add(item);
    }
    public void remove(int index){
        for(int i = index; i < size; i++){
            array[i] = array[i+1];
        }
    }


    public int lastIndexOf(Object object){
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(object)) {
                return i;
            }
        }
        return -1;
    }



    
    public Object[] toArray(){
        Object[] array = new Object[size];
        System.arraycopy(array, 0, array, 0, size);
        return array;
    }

    
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }








}






