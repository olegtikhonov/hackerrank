package datastructures.interfase;


public class StaticArray<T> implements Operations<T>{
    private int capacity;
    private T [] array;

    public StaticArray(int size) {
        this.capacity = size;
        this.array = (T[]) new Object[capacity];
    }
    @Override
    public boolean add(T element) {
        return false;
    }

    @Override
    public boolean remove(T element) {
        return false;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T set(int index) {
        return null;
    }

    @Override
    public int indexAt(T element) {
        return 0;
    }
}
