import java.util.EmptyStackException;

/**
 * Simple stack implementation
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class StackWithoutArray<T> {
    private Node<T> top;
    private int lenght = 0;

    public void push(T value) {
        Node<T> node = new Node(value);
        node.next = top;
        top = node;
        lenght++;
    }

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T result = top.value;
        top = top.next;
        lenght--;
        return result;
    }

    @Override
    public String toString() {
        return top.toString();
    }

    public int size(){
        return lenght;
    }

    public static void main(String[] args) {
        StackWithoutArray<Integer> intStack = new StackWithoutArray<>();
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);
        intStack.push(6);
        System.out.println(intStack);
        System.out.println("size = "+intStack.size());

        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());


    }
}

class Node<T> {
    Node<T> next;
    T value;

    public Node(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", value=" + value +
                '}';
    }
}
