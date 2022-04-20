package no.hiof.itf23019.project6.parallel;

import no.hiof.itf23019.project6.serial.MinMaxSerial;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class MinMaxTask extends RecursiveTask {


    private int[] arr;

    public MinMaxTask(int arr[]){
        this.arr = arr;
    }

    @Override
    protected int[] compute() {

        int threshold = 5;

        if(arr.length < threshold){
           return new MinMaxSerial().calculate(arr);
        }else{
//            Find midpoint
            int mid = arr.length / 2 ;

//            Arrays size with of mid
            int[] arr1 = Arrays.copyOfRange(arr, 0, mid);
            int[] arr2 = Arrays.copyOfRange(arr, mid, arr.length);


//            System.out.println(Arrays.toString(arr));
//            System.out.println(Arrays.toString(arr1));
//            System.out.println(Arrays.toString(arr2));


            MinMaxTask t1 = new MinMaxTask(arr1);
            MinMaxTask t2 = new MinMaxTask(arr2);

            t1.fork();
            t2.fork();

            t1.join();
            t2.join();

            int[] test = new int[0];

            return test;
        }

    }
}
