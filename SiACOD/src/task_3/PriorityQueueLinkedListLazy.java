package task_3;

import java.util.ArrayList;

public class PriorityQueueLinkedListLazy<T> implements PriorityQueue<T>{
    private ArrayList<Pair<T, Integer>> queue;  // (элемент, приоритет)

    public PriorityQueueLinkedListLazy() {
        queue = new ArrayList<>();
    }

    public void insert(T x, int p) {  // O(1) вставка элемента х с приоритетом р
        queue.add(new Pair<>(x, p));
    }

    public Pair<T, Integer> extractMax() {  // O(n) удаление и возвращение максимального элемента
        if (queue.isEmpty()) {
            return null;
        }
        Pair<T, Integer> max = queue.get(0);
        int maxIndex = 0;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getValue() > max.getValue()) {
                max = queue.get(i);
                maxIndex = i;
            }
        }
        queue.remove(maxIndex);
        return max;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
