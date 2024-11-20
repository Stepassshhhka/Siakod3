package task_3;

import java.util.ArrayList;

public class PriorityQueueBinaryHeap<T> implements PriorityQueue<T> {
    private ArrayList<Pair<T, Integer>> heap;  // (элемент, приоритет)

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return 2 * i + 1;
    }

    private int rightChild(int i) {
        return 2 * i + 2;
    }

    public PriorityQueueBinaryHeap() {
        heap = new ArrayList<>();
        heap.add(null); // доп. элемент для простоты индексации
    }

    public void insert(T x, int p) {  // O(log(n)) добавление элемента x с приоритетом p
        heap.add(new Pair<>(x, p));
        shiftUp(heap.size() - 1);
    }

    public Pair<T, Integer> extractMax() {  // O(log(n)) удаление максимального элемента и возвращение его
        if (heap.size() == 1) { // если куча пуста
            return null;
        }
        Pair<T, Integer> maxElement = heap.get(1);
        swap(1, heap.size() - 1);
        heap.remove(heap.size() - 1);
        shiftDown(1);
        return maxElement;
    }

    public boolean isEmpty() {
        return heap.size() == 1;
    }

    private void swap(int i, int j) {
        Pair<T, Integer> temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    private int getMaxChild(int i) {
        if (leftChild(i) == heap.size() - 1) {
            return leftChild(i);
        } else {
            return heap.get(leftChild(i)).getValue() > heap.get(rightChild(i)).getValue() ? leftChild(i) : rightChild(i);
        }
    }

    private void shiftUp(int i) {
        while (parent(i) > 0) {
            if (heap.get(i).getValue() > heap.get(parent(i)).getValue()) {
                swap(i, parent(i));
            }
            i = parent(i);
        }
    }

    private void shiftDown(int i) {
        while (leftChild(i) <= heap.size() - 1) {
            int maxChild = getMaxChild(i);
            if (heap.get(i).getValue() < heap.get(maxChild).getValue()) {
                swap(i, maxChild);
            }
            i = maxChild;
        }
    }
}
