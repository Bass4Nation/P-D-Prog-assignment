package no.hiof.itf23019.project6.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class MinMaxParallel {

    public int[] minMaxPar(int[] arr){
//        Int Array with indexes
        int[] minMaxPar = new int[2];


        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MinMaxTask task = new MinMaxTask(arr);

        forkJoinPool.invoke(task);

//        Assigning to each index in Integer Array
//        Getting Min and Max value from Task
        minMaxPar[0] = MinMaxTask.getMIN();
        minMaxPar[1] = MinMaxTask.getMAX();

        return minMaxPar;
    }

}
