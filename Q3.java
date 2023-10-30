import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        ArrayList<Integer[]> intervals = new ArrayList<Integer[]>();

        intervals.add(new Integer[] { 1, 3 });
        intervals.add(new Integer[] { 2, 6 });
        intervals.add(new Integer[] { 8, 10 });
        intervals.add(new Integer[] { 15, 18 });
        System.out.println("Integer Intervals:");
        for (Integer[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        System.out.println();
        mergeIntervals(intervals);

        for (Integer[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        System.out.println();
        System.out.println();

        ArrayList<String[]> stringIntervals = new ArrayList<String[]>();

        stringIntervals.add(new String[] { "A", "C" });
        stringIntervals.add(new String[] { "B", "D" });
        stringIntervals.add(new String[] { "E", "F" });
        stringIntervals.add(new String[] { "X", "Z" });

        System.out.println("String Intervals:");
        for (String[] interval : stringIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        System.out.println();
        mergeIntervals(stringIntervals);

        System.out.println("Merged String Intervals:");
        for (String[] interval : stringIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

        System.out.println();
        System.out.println();

        ArrayList<Float[]> floatIntervals = new ArrayList<Float[]>();

        floatIntervals.add(new Float[] { 1.5f, 3.5f });
        floatIntervals.add(new Float[] { 2.0f, 6.0f });
        floatIntervals.add(new Float[] { 8.2f, 10.1f });
        floatIntervals.add(new Float[] { 15.3f, 18.5f });
        System.out.println("Float Intervals:");
        for (Float[] interval : floatIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        System.out.println();
        mergeIntervals(floatIntervals);

        System.out.println("Merged Float Intervals:");
        for (Float[] interval : floatIntervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }

    }

    public static <T extends Comparable<T>> void mergeIntervals(List<T[]> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            System.out.println("Invalid Input");
            return;
        }

        for (int i = 0; i < intervals.size() - 1; i++) {
            T[] currentInterval = intervals.get(i);
            T[] nextInterval = intervals.get(i + 1);
            if (currentInterval[1].compareTo(nextInterval[0]) >= 0) {
                currentInterval[1] = nextInterval[1];
                intervals.set(i, currentInterval);
                intervals.remove(i + 1);
            } else {
                i++;
            }

        }

    }
}
