import java.util.Collections;

public class Demo {
    public static void main(String[] args) {
       printPattern(6);
    }

    public static void printPattern(int size) {
        int n = size;
        boolean upper = true;
        for(int i = 0; size%2 == 0? i< size-1 : i<size; i++){
            String str = String.join("", Collections.nCopies(n, "*"));
            String pad = String.join("", Collections.nCopies((size-n)/2 , " "));
            System.out.println(pad+str+pad);
            if(n-2>0 && upper){
                n-=2;
            }
            else {
                n+=2;
                upper = false;
            }
        }
    }
}





