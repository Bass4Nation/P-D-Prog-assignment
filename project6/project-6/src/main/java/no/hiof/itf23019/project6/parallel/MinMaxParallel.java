package no.hiof.itf23019.project6.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MinMaxParallel {

    public int[] minMaxPar(int[] arr){

        ForkJoinPool.commonPool().invoke(new MinMaxTask(arr));

        return getMinMax(MinMaxTask.getNum());
    }

    public int[] getMinMax(List<int[]> arr){
        int[] minMax = new int[2];

        int min = 100_000_000;
        int max = 0;

        for (int i = 0; i < arr.size(); i++){
            if(arr.get(i)[0] < min) {
                min = arr.get(i)[0];
            }
            if(arr.get(i)[1] > max) {
                max = arr.get(i)[1];
            }
        }
        minMax[0] = min;
        minMax[1] = max;

        return minMax;
    }
}
