package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        var arrList = new ArrayList<Integer>();
        for (int i = 1000; i < 2000; i++) {
            arrList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        var linkList = new LinkedList<Integer>(arrList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        var lastIdx = arrList.size() - 1;
        var prev = arrList.set(0, arrList.get(lastIdx));
        arrList.set(lastIdx, prev);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer x : arrList) {
            System.out.println(x);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        final int elemToAdd = 100_000;

        long time = System.nanoTime();
        for (int i = 0; i < elemToAdd; i++) {
            arrList.add(i);
        }
        time = System.nanoTime() - time;
        var arrListMs = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println(// NOPMD
        "Adding "
            + elemToAdd
            + " elements in an ArrayList took "
            + time
            + "ns ("
            + arrListMs
            + "ms)"
        );

        time = System.nanoTime();
        for (int i = 0; i < elemToAdd; i++) {
            linkList.add(i);
        }
        time = System.nanoTime() - time;
        var linkListMs = TimeUnit.NANOSECONDS.toMillis(time);

        System.out.println(// NOPMD
        "Adding "
            + elemToAdd
            + " elements in a LinkedList took "
            + time
            + "ns ("
            + linkListMs
            + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        lastIdx = arrList.size() - 1;
        var middleIdx = lastIdx / 2;

        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrList.get(middleIdx);
        }
        time = System.nanoTime() - time;
        arrListMs = TimeUnit.NANOSECONDS.toMillis(time);
        
        System.out.println(// NOPMD
        "Reading the middle ("
            + middleIdx
            + " th) element in an ArrayList took "
            + time
            + "ns ("
            + arrListMs
            + "ms)"
        );

        lastIdx = linkList.size() - 1;
        middleIdx = lastIdx / 2;

        time = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkList.get(middleIdx);
        }
        time = System.nanoTime() - time;
        linkListMs = TimeUnit.NANOSECONDS.toMillis(time);
        
        System.out.println(// NOPMD
        "Reading the middle ("
            + middleIdx
            + " th) element in a LinkedList took "
            + time
            + "ns ("
            + linkListMs
            + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        var worldMap = new HashMap<String,Long>();
        worldMap.put("Africa", 1_110_635_000L);
        worldMap.put("Americas", 972_005_000L);
        worldMap.put("Antarctica", 0L);
        worldMap.put("Asia", 4_298_723_000L);
        worldMap.put("Europe", 742_452_000L);
        worldMap.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        for (String k : worldMap.keySet()) {
            System.out.println(k + " has " + worldMap.get(k) + " habitants.");
        }
    }
}
