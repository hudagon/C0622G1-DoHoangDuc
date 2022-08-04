package ss4_oop.exercise.build_stop_watch_class;

public class Main {
    public static void selectionSort(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=i+1;j<a.length;j++){
                if(a[j]<a[i]){
                    int tempt = a[i];
                    a[i]=a[j];
                    a[j]=tempt;
                }
            }
        }
    }

    public static void main(String[] args) {
        StopWatch sW = new StopWatch();
        int[] a = new int[100000];
        for (int i = 0; i < a.length; i++) {
            a[i]=(int)(Math.random()*1000);
        }
        sW.start();
        selectionSort(a);
        sW.end();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + ",");
            if (i % 100 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Total times it takes to operates this problem: " + sW.getElapsedTime() + " miliseconds");
    }
}
