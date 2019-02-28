/**
 * Simple stack implementation
 *
 * @author Mike Adamenko (mnadamenko@gmail.com)
 */
public class Stack<T> {
    final T[] stack;
    private int top = 0;

    public Stack(int size) {
        this.stack = (T[]) new Object[size];
    }

    public void push(T el) {
        if (top == stack.length) return;
        stack[top++] = el;
    }

    public T pull() {
        if (top == 0) return null;
        return stack[--top];
    }

    @Override
    public String toString() {
        String result = "";
        for (T el : stack) {
            result += el + "\n";
        }
        return result;
    }

    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<>(5);
        intStack.push(1);
        intStack.push(2);
        intStack.push(3);
        intStack.push(4);
        intStack.push(5);
        intStack.push(6);
        System.out.println(intStack);

        System.out.println(intStack.pull());
        System.out.println(intStack.pull());
        System.out.println(intStack.pull());
        System.out.println(intStack.pull());
        System.out.println(intStack.pull());
        System.out.println(intStack.pull());


    }
}
