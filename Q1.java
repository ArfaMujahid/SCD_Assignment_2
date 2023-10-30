public class Q1 {
    public static void main(String[] args) {
        System.out.println("Testing For String: ");
        GenericStack<String> strStack = new GenericStack<>();
        strStack.pop();
        strStack.printStack();
        strStack.push("Hello1");
        strStack.push("Hello2");
        strStack.push("Hello3");
        strStack.printStack();
        System.out.println("Size: " + strStack.getSize());
        System.out.println("Popped: " + strStack.pop());
        strStack.printStack();

        System.out.println();
        System.out.println();
        System.out.println("Testing For Integer: ");
        GenericStack<Integer> intStack = new GenericStack<Integer>();
        intStack.pop();
        for (int i = 1; i < 7; i++) {
            intStack.push(i);
        }
        intStack.printStack();
        System.out.println("Size: " + intStack.getSize());
        System.out.println("Popped: " + intStack.pop());
        intStack.printStack();
        // GenericStack<int> primitiveStack = new GenericStack<int>();

    }
}

class StackEmptyException extends Exception {
    public StackEmptyException(String message) {
        super(message);
    }
}

class InvalidCharacterException extends Exception {
    public InvalidCharacterException(String message) {
        super(message);
    }
}

class GenericStack<T> {

    private class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            next = null;
        }
    }

    private Node<T> Top;
    private int size;

    GenericStack() {
        Top = null;
        size = 0;
    }

    int getSize() {
        try {
            if (size == 0) {
                throw new StackEmptyException("Stack is empty.");
            }
        } catch (StackEmptyException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return size;
    }

    void push(T data) {
        Node<T> newNode = new Node(data);
        if (size == 0) {
            Top = newNode;
        } else {
            newNode.next = Top;
            Top = newNode;
        }
        size++;
    }

    T pop() {
        try {
            if (size == 0) {
                throw new StackEmptyException("Stack is empty.");
            } else {
                T data = Top.data;
                Top = Top.next;
                size--;
                return data;
            }
        } catch (StackEmptyException e) {
            System.out.println("Error Popping: " + e.getMessage());
        }
        return null;
    }

    boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    void printStack() {
        try {
            if (!isEmpty()) {
                System.out.print("Stack Data: ");
                Node<T> current = Top;
                while (current != null) {
                    System.out.print(current.data + " ");
                    current = current.next;
                }
                System.out.println();
                return;
            } else {
                throw new StackEmptyException("Stack Empty");
            }
        } catch (Exception e) {
            System.out.println("Error Printing: " + e.getMessage());
        }

    }
}
