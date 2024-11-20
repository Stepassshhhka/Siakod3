package task_3;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayPriorityQueue<T>  implements PriorityQueue<T>{
    private ArrayList<Pair<T, Integer>> queue;  // (элемент, приоритет)

    public ArrayPriorityQueue() {
        queue = new ArrayList<>();
    }

    @Override
    public void insert(T x, int p) {
        queue.add(new Pair<>(x, p));
        queue.sort(Comparator.comparingInt(Pair::getValue));
    }

    @Override
    public Pair<T, Integer> extractMax() {
        if (queue.size() == 1) { // если куча пуста
            return null;
        }
        Pair<T, Integer> maxElement = queue.get(queue.size() - 1);
        queue.remove(queue.size() - 1);
        return maxElement;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }


}
