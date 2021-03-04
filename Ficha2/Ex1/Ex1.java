package Ex1;


public class Ex1 {
    public int minimo(int[] a){
        int min = a[0];
        for(int elem: a){
            if(elem < min){
                min = elem;
            }
        }
        return min;
    }
}
