package task_3;

public interface PriorityQueue<T> {
    void insert(T x, int p);
    Pair<T, Integer> extractMax();
    boolean isEmpty();
}
