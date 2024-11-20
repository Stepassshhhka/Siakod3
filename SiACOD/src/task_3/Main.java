package task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 666; i++) {
            PriorityQueue<Integer> HeapQueue0 = new PriorityQueueBinaryHeap<>();
            PriorityQueue<Integer> EarlyQueue0 = new ArrayPriorityQueue<>();
            HeapQueue0.insert(10, 10);
            EarlyQueue0.insert(10,10);
            HeapQueue0.extractMax();
            EarlyQueue0.extractMax();
        }

        List<Integer> sizes = new ArrayList<>();
        List<Double> HeapTimes_insert = new ArrayList<>();
        List<Double> EarlyTimes_insert = new ArrayList<>();
        List<Double> HeapTimes_max = new ArrayList<>();
        List<Double> EarlyTimes_max = new ArrayList<>();
        Random random = new Random();


        for (int i = 1000; i <= 6000; i += 1000) {
            sizes.add(i);
            PriorityQueue<Integer> HeapQueue_insert = new PriorityQueueBinaryHeap<>();
            PriorityQueue<Integer> EarlyQueue_insert = new ArrayPriorityQueue<>();

            PriorityQueue<Integer> HeapQueue_max = new PriorityQueueBinaryHeap<>();
            PriorityQueue<Integer> EarlyQueue_max = new ArrayPriorityQueue<>();

            for (int j = 0; j < i; j++) {
                int value = random.nextInt(1000);
                HeapQueue_insert.insert(value, value);
                EarlyQueue_insert.insert(value, value);

                HeapQueue_max.insert(value, value);
                EarlyQueue_max.insert(value, value);
            }


            int value1 = random.nextInt(100);
            long startHeap = System.nanoTime();
            HeapQueue_insert.insert(value1, value1);
            long endHeap = System.nanoTime();
            HeapTimes_insert.add((double) (endHeap - startHeap) / 1000000);


            int value2 = random.nextInt(100);
            long startEarly_insert = System.nanoTime();
            EarlyQueue_insert.insert(value2, value2);
            long endEarly_insert = System.nanoTime();
            EarlyTimes_insert.add((double) (endEarly_insert - startEarly_insert) / 1000000);

            System.out.println("Размер очереди: " + i);
            System.out.println("Вставка элемента");
            System.out.println("Время бинарной кучи: " + HeapTimes_insert.get(HeapTimes_insert.size() - 1) + " мс");
            System.out.println("Время раннего массива: " + EarlyTimes_insert.get(EarlyTimes_insert.size() - 1) + " мс");
            System.out.println();



            long startHeap_max = System.nanoTime();
            HeapQueue_max.extractMax();
            long endHeap_max = System.nanoTime();
            HeapTimes_max.add((double) (endHeap_max - startHeap_max) / 1000000);

            long startEarly_max = System.nanoTime();
            EarlyQueue_max.extractMax();
            long endEarly_max = System.nanoTime();
            EarlyTimes_max.add((double) (endEarly_max - startEarly_max) / 1000000);

            System.out.println("Удаление максимального элемента");
            System.out.println("Время бинарной кучи: " + HeapTimes_max.get(HeapTimes_max.size() - 1) + " мс");
            System.out.println("Время раннего массива: " + EarlyTimes_max.get(EarlyTimes_max.size() - 1) + " мс");
            System.out.println();
            System.out.println("---------------------------------");
        }
    }
}
