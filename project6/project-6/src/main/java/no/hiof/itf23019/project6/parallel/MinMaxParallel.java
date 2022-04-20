package no.hiof.itf23019.project6.parallel;

import java.util.concurrent.ForkJoinPool;

public class MinMaxParallel {

    public int[] minMaxPar(int[] arr){

        MinMaxTask task = new MinMaxTask(arr);
        ForkJoinPool.commonPool().invoke(task);

        return arr;
    }
}
