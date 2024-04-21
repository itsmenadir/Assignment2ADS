public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list1 = new MyArrayList<>();
        list1.add(52);
        list1.set(5, 5);
        System.out.println(list1.get(5));
        System.out.println(list1.getLast());
        MyLinkedList<Integer> list = new MyLinkedList<>();

        // Add elements to the list
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(2);

        // Print the initial list
        System.out.println("Initial list: " + list);

        // Test get, set, and size methods
        System.out.println("Element at index 2: " + list.get(2));
        list.set(1, 10);
        System.out.println("List after setting index 1 to 10: " + list);
        System.out.println("Size of list: " + list.size());

        // Test addFirst and addLast methods
        list.addFirst(1);
        list.addLast(15);
        System.out.println("List after adding first and last elements: " + list);

        // Test getFirst and getLast methods
        System.out.println("First element: " + list.getFirst());
        System.out.println("Last element: " + list.getLast());

        // Test remove, removeFirst, and removeLast methods
        list.remove(3);
        System.out.println("List after removing element at index 3: " + list);
        list.removeFirst();
        System.out.println("List after removing first element: " + list);
        list.removeLast();
        System.out.println("List after removing last element: " + list);

        // Test sorting
        list.sort();
        System.out.println("List after sorting: " + list);

        // Test indexOf, lastIndexOf, and exists methods
        System.out.println("Index of element 8: " + list.indexOf(8));
        System.out.println("Last index of element 10: " + list.lastIndexOf(10));
        System.out.println("Does 15 exist in the list? " + list.exists(15));

        // Test toArray method
        Object[] array = list.toArray();
        System.out.print("Array representation of list: [");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        // Test clear method
        list.clear();
        System.out.println("List after clearing: " + list);

        MyStack<Integer> stack = new MyStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.peek()); // Print the top element
            stack.pop(); // Remove the top element
        }

        // Test MyQueue
        MyQueue<String> queue = new MyQueue<>();
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");

        System.out.println("\nQueue:");
        while (!queue.isEmpty()) {
            System.out.println(queue.peek()); // Print the front element
            queue.dequeue(); // Remove the front element
        }

        // Test MyMinHeap
        MyMinHeap<Integer> heap = new MyMinHeap<>();
        heap.insert(5);
        heap.insert(3);
        heap.insert(8);
        heap.insert(1);

        System.out.println("Min Heap (extracting min until empty):");
        while (!heap.isEmpty()) {
            System.out.println(heap.extractMin());

        }

    }
}
