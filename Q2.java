import java.util.LinkedList;
import java.util.Queue;

public class Q2 {
    public static void main(String[] args) {
        FirstNonRepeatingStream stream = new FirstNonRepeatingStream();

        stream.add('a');
        stream.add('b');
        stream.add('a');

        char result = stream.getFirstNonRepeating();
        System.out.println("First non-repeating character: " + result);

        FirstNonRepeatingStream stream1 = new FirstNonRepeatingStream();

        stream1.add('a');
        stream1.add('b');
        stream1.add('a');
        stream1.add('b');

        result = stream1.getFirstNonRepeating();
        System.out.println("First non-repeating character: " + result);
    }

}

class FirstNonRepeatingStream {
    int[] charCount;
    Queue<Character> queue;

    FirstNonRepeatingStream() {
        queue = new LinkedList<Character>();
        charCount = new int[26];
    }

    void add(Character c) {
        int index = c - 'a';
        charCount[index]++;
        queue.offer(c);
    }

    char getFirstNonRepeating() {
        while (!queue.isEmpty()) {
            char element = queue.poll();
            int index = element - 'a';
            if (charCount[index] == 1) {
                return element;
            }
        }
        return '-';
    }
}
