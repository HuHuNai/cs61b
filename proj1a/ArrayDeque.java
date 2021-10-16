public class ArrayDeque<T> {
    T[] array;
    int nextFirst;
    int nextLast;
    int size;

    public ArrayDeque(){
        array=(T[])new Object[8];
        size=0;
        nextFirst=3;
        nextLast=4;
    }

    private void resize(){
        T[] a=(T[])new Object[array.length*2];
        int l= array.length;
        for (int c=nextLast;c!=nextFirst;c=(c+1)% array.length) {
            a[l]=array[c];
            l+=1;
        }
        nextFirst= array.length-1;
        nextLast=0;
        array=a;
    }

    public void sizeLimit(){
        T[] a=(T[])new Object[array.length/2];
        int l=a.length/2;
        for (int c=nextLast;c!=nextFirst;c=(c+1)% array.length) {
            a[l]=array[c];
            l+=1;
        }
        array=a;
        nextLast= array.length;
        nextFirst=array.length/2-1;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        for (int c=nextFirst;(c+1)% array.length!=nextLast;c=(c+1)% array.length){
            c=(c+1)% array.length;
            System.out.print(array[c]+" ");
        }
    }

    public void addFirst(T value){
        if (size== array.length){
            resize();
        }
        array[nextFirst]=value;
        nextFirst=(nextFirst-1+ array.length)% array.length;
        size+=1;
    }

    public void addLast(T value){
        if (size== array.length){
            resize();
        }
        array[nextLast]=value;
        nextLast=(nextLast+1)%array.length;
        size+=1;
    }

    public T removeFirst(){
        nextFirst=(nextFirst+1)% array.length;
        T c=array[nextFirst];
        array[nextFirst]=null;
        return c;
    }

    public T removeLast(){
        nextLast=(nextLast-1+ array.length)% array.length;
        T c=array[nextLast];
        array[nextLast]=null;
        return c;
    }

    public T get(int index){
        T out=null;
        if (index<size&&index>=0){
            out=array[(nextFirst+1+index)% array.length];
        }
        return out;
    }
}
