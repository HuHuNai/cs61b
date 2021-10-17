public class Test {
    public static void main(String[] args){
        ArrayDeque<Integer> a1=new ArrayDeque<Integer>();
        for (int i=0;i<1000;i++){
            a1.addLast(i);
        }
        System.out.println(a1.get(999));
        a1.removeLast();

        LinkedListDeque<Integer> l1=new LinkedListDeque<Integer>();
        l1.addFirst(0);
        l1.addLast(1);
        System.out.println(l1.getRecursive(0));
    }
}
