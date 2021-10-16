public class Test {
    public static void main(String[] args){
        ArrayDeque<Integer> a1=new ArrayDeque<Integer>();
        a1.addFirst(123);
        System.out.println(a1.removeFirst());
        a1.addLast(444);
        System.out.println(a1.get(0));
        System.out.println(a1.removeLast());
    }
}
