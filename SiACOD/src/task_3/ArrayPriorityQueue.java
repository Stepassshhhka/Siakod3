package task_3;

import java.util.ArrayList;
import java.util.Comparator;

public class ArrayPriorityQueue<T>  implements PriorityQueue<T>{
    private ArrayList<Node<T, Integer>> queue;  // (элемент, приоритет)

    public ArrayPriorityQueue() {
        queue = new ArrayList<>();
    }

    @Override
    public void insert(T x, int p) {
        queue.add(new Node<>(x, p));
        queue.sort(Comparator.comparingInt(Node::getValue));
    }

    @Override
    public Node<T, Integer> extractMax() {
        if (queue.size() == 1) { // если куча пуста
            return null;
        }
        Node<T, Integer> maxElement = queue.get(queue.size() - 1);
        queue.remove(queue.size() - 1);
        return maxElement;
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }


}
