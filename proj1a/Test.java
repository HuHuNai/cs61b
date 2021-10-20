public class Test {
    public static void main(String[] args){
        ArrayDeque<Integer> a1=new ArrayDeque<Integer>();
        for (int i=0;i<64;i++){
            a1.addLast(i);
        }
        for (int i=0;i<64;i++){
            a1.removeFirst();
        }


    }
}
