package no.hiof.itf23019.project6.parallel;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MinMaxTask extends RecursiveAction {


    private final int[] arr;
    private static int MIN = 100_000_000;
    private static int MAX = 0;



    public MinMaxTask(int[] arr){
        this.arr = arr;
    }

    @Override
    protected void compute() {

        int threshold = 500;


        if(arr.length < threshold){
            getMinMax(arr);
        }else{
//            Find midpoint
            int mid = arr.length / 2 ;


//            Arrays size with of mid
            int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
            int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);

            MinMaxTask t1 = new MinMaxTask(arr1);
            MinMaxTask t2 = new MinMaxTask(arr2);

            t1.fork();
            t2.fork();

            t1.join();
            t2.join();
        }

    }

    public static void getMinMax (int[] arr){
//        For each number in array
        for (int number : arr) {
//            Check if smaller/larger than MIN and MAX. If so set that number to their value
            if (number < MIN) {
                setMIN(number);
            }
            if (number > MAX) {
                setMAX(number);
            }
        }
    }

    public static int getMIN() {
        return MIN;
    }

    public static void setMIN(int MIN) {
        MinMaxTask.MIN = MIN;
    }

    public static int getMAX() {
        return MAX;
    }

    public static void setMAX(int MAX) {
        MinMaxTask.MAX = MAX;
    }
}
