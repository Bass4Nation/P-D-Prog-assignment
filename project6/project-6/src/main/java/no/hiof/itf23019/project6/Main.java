package no.hiof.itf23019.project6;

import no.hiof.itf23019.project6.parallel.MinMaxParallel;
import no.hiof.itf23019.project6.serial.MinMaxSerial;


import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main
{
    public static void main( String[] args ) throws FileNotFoundException {

//        Test numbers before file reader
        int[] testArr = {1,2,3,4,5,6,7,81,5,6,8};
        File file = new File("numbers100_000.txt");
        int[] numbers = readFile_ToNumbers(file);



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

        // Comparing serial with parallel, both min and max values
        if(serial[0] == parallel[0] && serial[1] == parallel[1]){
            printData(serialTime,parallelTime);
        }



//        fileWriter(1_000_000, "numbers1_000_000.txt");

    }
//    Filereader
    private static int[] readFile_ToNumbers(File numbers) throws FileNotFoundException {

        Scanner scanner1 = new Scanner(numbers);
        Scanner scanner2 = new Scanner(numbers);
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

// Output print
    private static void printData (double serial, double parallel){
        double core = Runtime.getRuntime().availableProcessors();
        double speedupPar = serial/parallel;
        double effPar = ((speedupPar * core) * 100);


        System.out.printf("-----------------------\n" +
                "Serial Time: %f ms \n" +
                "Parallel Time: %f ms\n" +
                "----- Speedup -------\n" +
                "Parallel is %f times faster then serial\n" +
                "----- Efficiency ------\n" +
                "Parallel Efficiency: %f %%\n" +
                "----------------------------------------\n",serial,parallel, speedupPar, effPar);
    }

    private static void fileWriter(int num, String filename) throws FileNotFoundException {
        Random ran = new Random();
        int number = 0;
        try (PrintWriter file = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(filename)));
        ) {

            for (int i = 1; i <= num; i++) {
                number = ran.nextInt(num);
                file.println(number);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("File test1.txt has been created!");


    }
}
