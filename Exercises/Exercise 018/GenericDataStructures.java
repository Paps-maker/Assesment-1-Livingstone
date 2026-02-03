import java.util.ArrayList;
import java.util.LinkedList;


class Stack<T> {
    private ArrayList<T> elements = new ArrayList<>();

    public ArrayList<T> getElements() {
        return elements;
    }

    public void setElements(ArrayList<T> elements) {
        this.elements = elements;
    }

    public void push(T item) {
        elements.add(item);
    }

    public T pop() {
        if (elements.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (elements.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}


class Queue<T> {
    private LinkedList<T> elements = new LinkedList<>();

    public LinkedList<T> getElements() {
        return elements;
    }

    public void setElements(LinkedList<T> elements) {
        this.elements = elements;
    }

    public void enqueue(T item) {
        elements.addLast(item);
    }

    public T dequeue() {
        if (elements.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return elements.removeFirst();
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}


class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

/* ========= CUSTOM OBJECT ========= */
class Student {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @SuppressWarnings("override")
    public String toString() {
        return id + " - " + name;
    }
}


public class GenericDataStructures {

    public static void main(String[] args) {

        //  STACK TEST 
        Stack<Integer> intStack = new Stack<>();
        intStack.push(10);
        intStack.push(20);
        System.out.println("Stack Peek (Integer): " + intStack.peek());
        System.out.println("Stack Pop (Integer): " + intStack.pop());

        Stack<String> stringStack = new Stack<>();
        stringStack.push("Java");
        stringStack.push("Generics");
        System.out.println("Stack Peek (String): " + stringStack.peek());

        //  QUEUE TEST 
        Queue<String> stringQueue = new Queue<>();
        stringQueue.enqueue("A");
        stringQueue.enqueue("B");
        System.out.println("Queue Dequeue (String): " + stringQueue.dequeue());

        Queue<Student> studentQueue = new Queue<>();
        studentQueue.enqueue(new Student(1, "Stone"));
        studentQueue.enqueue(new Student(2, "oduor"));
        System.out.println("Queue Dequeue (Student): " + studentQueue.dequeue());

        // ---- TREE TEST ----
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(15);

        System.out.println("Tree Root: " + root.data);
        System.out.println("Left Child: " + root.left.data);
        System.out.println("Right Child: " + root.right.data);
    }
}
