package no.hiof.itf23019.project6.parallel;

import no.hiof.itf23019.project6.serial.MinMaxSerial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class MinMaxTask extends RecursiveAction {


    private int[] arr;
    private static int count = 0;
//    private static int[][] num = new int[1][100];
    private static List <int[]> num = new ArrayList<>();



    public MinMaxTask(int[] arr){
        this.arr = arr;
    }

    @Override
    protected void compute() {

        int threshold = 100;


        if(arr.length < threshold){

            num.add(getMinMax(arr));
//            count++;

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

            invokeAll(t1,t2);


        }

    }

    public static int[] getMinMax (int[] arr){
        int[] minMax = new int[2];
        int min = 100_000_000;
        int max = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
            if(arr[i] > max){
                max = arr[i];
            }
        }
        minMax[0] = min;
        minMax[1] = max;

        return minMax;
    }

    public static List<int[]> getNum() {
        return num;
    }
}
