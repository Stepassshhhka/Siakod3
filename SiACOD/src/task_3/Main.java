package task_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {




        for (int i = 0; i < 500; i++) {
            PriorityQueue<Integer> heapQueue1 = new PriorityQueueBinaryHeap<>();
            PriorityQueue<Integer> lazyQueue1 = new ArrayPriorityQueue<>();
            heapQueue1.insert(10, 10);
            lazyQueue1.insert(10,10);
            heapQueue1.extractMax();
            lazyQueue1.extractMax();
        }

        List<Integer> sizes = new ArrayList<>();
        List<Double> heapTimes = new ArrayList<>();
        List<Double> lazyTimes = new ArrayList<>();
        Random random = new Random();


        for (int i = 1000; i <= 6000; i += 1000) {
            sizes.add(i);
            PriorityQueue<Integer> heapQueue = new PriorityQueueBinaryHeap<>();
            PriorityQueue<Integer> lazyQueue = new ArrayPriorityQueue<>();

            for (int j = 0; j < i; j++) {
                int value = random.nextInt(1000);
                heapQueue.insert(value, value);
                lazyQueue.insert(value, value);
            }


            int value1 = random.nextInt(100);
            long startHeap = System.nanoTime();
            heapQueue.insert(value1, value1);
            long endHeap = System.nanoTime();
            heapTimes.add((double) (endHeap - startHeap) / 1000000);


            int value2 = random.nextInt(100);
            long startLazy = System.nanoTime();
            lazyQueue.insert(value2, value2);
            long endLazy = System.nanoTime();
            lazyTimes.add((double) (endLazy - startLazy) / 1000000);


            /*long startHeap = System.nanoTime();
            heapQueue.extractMax();
            long endHeap = System.nanoTime();
            heapTimes.add((double) (endHeap - startHeap) / 1000000);

            // Измерение времени выполнения extractMax для ленивого списка
            long startLazy = System.nanoTime();
            lazyQueue.extractMax();
            long endLazy = System.nanoTime();
            lazyTimes.add((double) (endLazy - startLazy) / 1000000);*/

            System.out.println("Размер очереди: " + i);
            System.out.println("Время бинарной кучи: " + heapTimes.get(heapTimes.size() - 1) + " мс");
            System.out.println("Время раннего массива: " + lazyTimes.get(lazyTimes.size() - 1) + " мс");
            System.out.println();
        }
    }
}
