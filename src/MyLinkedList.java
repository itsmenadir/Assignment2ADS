
import java.util.Iterator;

public class MyLinkedList<E> {
    private class MyNode {
        E element;
        MyNode next;
        MyNode prev;

        MyNode(E element) {
            this.element = element;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    
    public void add(E item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
        MyNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.element;
    }

    
    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    
    public void set(int index, E item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
        MyNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.element = item;
    }

    
    public void addFirst(E item) {
        MyNode newNode = new MyNode(item);
        if (head == null) {
            head = newNode;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    
    public void addLast(E item) {
        add(item);
    }

    
    public E getFirst() {
        Iterator<E> iterator = iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            throw new IllegalStateException("List is empty");
        }
    }

    
    public E getLast() {
        Iterator<E> iterator = iterator();
        E last = null;
        while (iterator.hasNext()) {
            last = iterator.next();
        }
        if (last != null) {
            return last;
        } else {
            throw new IllegalStateException("List is empty");
        }
    }

    
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + " Size: " + size);
        }
        MyNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if (cur.prev != null) {
            cur.prev.next = cur.next;
        } else {
            head = cur.next;
        }
        if (cur.next != null) {
            cur.next.prev = cur.prev;
        } else {
            tail = cur.prev;
        }
        size--;
    }

    
    public void removeFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        head = head.next;
        if (head == null) {
            tail = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    
    public void removeLast() {
        if (tail == null) {
            throw new IllegalStateException("List is empty");
        }
        tail = tail.prev;
        if (tail == null) {
            head = null;
        } else {
            head.prev = null;
        }
        size--;
    }

    
    public void sort() {
        if (size <= 1) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            MyNode cur = head;
            while (cur.next != null) {
                if (((Comparable<E>) cur.element).compareTo(cur.next.element) > 0) {
                    E temp = cur.element;
                    cur.element = cur.next.element;
                    cur.next.element = temp;
                    swapped = true;
                }
                cur = cur.next;
            }
        } while (swapped);
    }

    
    public int indexOf(Object object) {
        int index = 0;
        MyNode cur = head;
        while (cur != null) {
            if (cur.element.equals(object)) {
                return index;
            }
            cur = cur.next;
        }
        return -1;
    }

    
    public int lastIndexOf(Object object) {
        int lastIndex = -1;
        int index = 0;
        MyNode cur = head;
        while (cur != null) {
            if (cur.element.equals(object)) {
                lastIndex = index;
            }
            cur = cur.next;
            index++;
        }
        return lastIndex;
    }

    
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    
    public Object[] toArray() {
        Object[] array = new Object[size];
        MyNode cur = head;
        int index = 0;
        while (cur != null) {
            array[index++] = cur.element;
            cur = cur.next;
        }
        return array;
    }

    
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private MyNode cur = head;

            
            public boolean hasNext() {
                return cur != null;
            }

            
            public E next() {
                if (!hasNext()) {
                    throw new IllegalStateException("No next element");
                }
                E element = cur.element;
                cur = cur.next;
                return element;
            }
        };
    }

    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            sb.append(iterator.next());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();

    }
}







