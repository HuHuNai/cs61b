public class ArrayDeque<T> {
    private T[] array;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        nextFirst = 3;
        nextLast = 4;
    }

    private int getLength() {
        return array.length;
    }

    private void resize() {
        int l = array.length;
        T[] a = (T[]) new Object[l * 2];
        int c = nextLast;
        do {
            a[l] = array[c];
            l += 1;
            c = (c + 1) % array.length;
        }
        while (c != nextLast);
        nextFirst = array.length - 1;
        nextLast = 0;
        array = a;
    }

    private void sizeLimit() {
        if (size * 4 >= array.length || array.length < 16) {
            return;
        }
        T[] a = (T[]) new Object[array.length / 2];
        int l = a.length / 2;
        for (int c = (nextFirst + 1) % array.length; c != nextLast; c = (c + 1) % array.length) {
            a[l] = array[c];
            l += 1;
        }
        array = a;
        nextLast = l;
        nextFirst = array.length / 2 - 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int c = nextFirst; (c + 1) % array.length != nextLast; c = (c + 1) % array.length) {
            c = (c + 1) % array.length;
            if (array[c] != null) {
                System.out.print(array[c] + " ");
            }
        }
    }

    public void addFirst(T value) {
        if (size == array.length) {
            resize();
        }
        array[nextFirst] = value;
        nextFirst = (nextFirst - 1 + array.length) % array.length;
        size += 1;
    }

    public void addLast(T value) {
        if (size == array.length) {
            resize();
        }
        array[nextLast] = value;
        nextLast = (nextLast + 1) % array.length;
        size += 1;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        nextFirst = (nextFirst + 1) % array.length;
        T c = array[nextFirst];
        array[nextFirst] = null;
        size -= 1;
        sizeLimit();
        return c;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        nextLast = (nextLast - 1 + array.length) % array.length;
        T c = array[nextLast];
        array[nextLast] = null;
        size -= 1;
        sizeLimit();
        return c;
    }

    public T get(int index) {
        T out = null;
        if (index < size && index >= 0) {
            out = array[(nextFirst + 1 + index) % array.length];
        }
        return out;
    }
}
