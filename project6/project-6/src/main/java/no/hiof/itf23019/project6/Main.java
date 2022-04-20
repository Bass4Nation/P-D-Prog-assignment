package no.hiof.itf23019.project6;

import no.hiof.itf23019.project6.parallel.MinMaxParallel;
import no.hiof.itf23019.project6.serial.MinMaxSerial;

import java.util.Arrays;

public class Main
{
    public static void main( String[] args ) {

//        Test numbers before file reader
        int[] testArr = {1,2,3,4,5,6,7,81,5,6,8};

//        Timer for Serial and Parallel
        double starttime,endtime, serialTime, parallelTime;

//        Serial
        System.out.println("Serial running -----------");
        starttime = System.currentTimeMillis();
        int[] serial = new MinMaxSerial().calculate(testArr);
        endtime = System.currentTimeMillis();
        serialTime = (endtime - starttime);
        System.out.println(Arrays.toString(serial));
        System.out.println("Serial time = "+serialTime + "ms");

//          Parallel

        System.out.println("Parallel running -----------");
        starttime = System.currentTimeMillis();
        int[] parallel = new MinMaxParallel().minMaxPar(testArr);
        endtime = System.currentTimeMillis();
        parallelTime = (endtime - starttime);
        System.out.println(Arrays.toString(parallel));
        System.out.println("Parallel time = "+parallelTime + "ms");



    }
   
}
