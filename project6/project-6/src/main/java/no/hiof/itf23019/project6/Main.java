package no.hiof.itf23019.project6;

import no.hiof.itf23019.project6.parallel.MinMaxParallel;
import no.hiof.itf23019.project6.serial.MinMaxSerial;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class Main
{
    public static void main( String[] args ) throws FileNotFoundException {

//        Test numbers before file reader
        int[] testArr = {1,2,3,4,5,6,7,81,5,6,8};
        File file = new File("numbers5000.txt");
        int[] numbers = readFile_ToNumbers(file);
//        System.out.println(Arrays.toString(numbers));



//        Timer for Serial and Parallel
        double starttime,endtime, serialTime, parallelTime;

//        Serial
        System.out.println("Serial running -----------");
        starttime = System.currentTimeMillis();
        int[] serial = new MinMaxSerial().calculate(numbers);
        endtime = System.currentTimeMillis();
        serialTime = (endtime - starttime);
        System.out.println(Arrays.toString(serial));
        System.out.println("Serial time = "+serialTime + "ms");

//          Parallel

        System.out.println("Parallel running -----------");
        starttime = System.currentTimeMillis();
        int[] parallel = new MinMaxParallel().minMaxPar(numbers);
        endtime = System.currentTimeMillis();
        parallelTime = (endtime - starttime);
        System.out.println(Arrays.toString(parallel));
        System.out.println("Parallel time = "+parallelTime + "ms");


    }
    private static int[] readFile_ToNumbers(File numbers) throws FileNotFoundException {

        Scanner scanner1 = new Scanner(numbers);
        Scanner scanner2 = new Scanner(numbers);
//        System.out.println(scanner1.nextInt());
        int Rows = 0;


        while(scanner1.hasNextLine()){ // Find rows
            scanner1.nextInt();
            Rows++;
        }


        int[] k = new int[Rows];

        for (int i = 0; i < Rows; i++)
            k[i] = scanner2.nextInt();

        return k;
    }


}
