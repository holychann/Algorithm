package src.Graph;

public class QueueMaded<T> {
    private T[] queue;
    private int front;
    private int end;
    private int capacity;

    public QueueMaded(int size){
        queue = (T[]) new Object[size];
        front = 0;
        end = 0;
        capacity = size;
    }

    public void enqueue(T el){
        // 추가사항: 용량이 꽉 차면 에러 발생

        queue[end] = el;

        end++;

        if(end == capacity) end = 0;
    }

    public T dequeue(){
        // 추가사항: 비어있다면 에러 발생
        T data = queue[front];
        front++;
        if(front == capacity) front = 0;

        return data;
    }

    public boolean isEmpty(){
        return front == end;
    }

    public boolean isFull(){
        if(((end + 1 == capacity) && front == 0) || (end + 1 == front)) {
            return true;
        } else {
            return false;
        }
    }

}