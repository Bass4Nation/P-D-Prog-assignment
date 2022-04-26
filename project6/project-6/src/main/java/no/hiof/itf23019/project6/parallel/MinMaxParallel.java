package no.hiof.itf23019.project6.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MinMaxParallel {

    public int[] minMaxPar(int[] arr){

        ForkJoinPool.commonPool().invoke(new MinMaxTask(arr));
        List<int[]> numbers = MinMaxTask.getNum();

        return getMinMax(numbers);
    }

    public int[] getMinMax(List<int[]> arr){
        int[] minMax = new int[2];

        int min = 100_000_000;
        int max = 0;
        try{
            for (int i = 0; i < arr.size(); i++){
                int[] test = arr.get(i);
                if(test[0] < min) {
                    min = test[0];
                }
                if(test[1] > max) {
                    max = test[1];
                }
            }
            minMax[0] = min;
            minMax[1] = max;

        } catch (Exception e){
            System.out.println("Error: " + e);
        }

        return minMax;
    }
}
