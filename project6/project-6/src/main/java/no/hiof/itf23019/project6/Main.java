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
//        File file = new File("numbers1000.txt");
//        File file = new File("numbers10_000.txt");
//        File file = new File("numbers100_000.txt");
//        File file = new File("numbers1_000_000.txt");
        File file = new File("numbers10_000_000.txt");
//        File file = new File("numbers100_000_000.txt");
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



//        fileWriter(100_000_000, "numbers100_000_000.txt");

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
        if(parallel < serial){
//            If parallel is faster than serial
            double core = Runtime.getRuntime().availableProcessors();
            System.out.println(core);
            double speedupPar = serial/parallel;
            double effPar = ((speedupPar / core) * 100);


            System.out.printf("-----------------------\n" +
                    "Serial Time: %.1f ms \n" +
                    "Parallel Time: %.1f ms\n" +
                    "----- Speedup -------\n" +
                    "Parallel is %.2f times faster then serial\n" +
                    "----- Efficiency ------\n" +
                    "Parallel Efficiency: %.1f %%\n" +
                    "----------------------------------------\n",serial,parallel, speedupPar, effPar);
        }else {
//            If serial is faster than parallel

            double core = Runtime.getRuntime().availableProcessors(); // Gets available processors on your pc

            double speedupSer = parallel / serial;
            double effPar = ((speedupSer / core) * 100);


            System.out.printf("-----------------------\n" +
                    "Serial Time: %.1f ms \n" +
                    "Parallel Time: %.1f ms\n" +
                    "----- Speedup -------\n" +
                    "Serial is %.2f times faster then Parallel\n" +
                    "----- Efficiency ------\n" +
                    "Serial Efficiency: %.1f %%\n" +
                    "----------------------------------------\n", serial, parallel, speedupSer, effPar);
        }
    }

    private static void fileWriter(int num, String filename) throws FileNotFoundException {
//        Just a filewriter that writes out numbers to a file.
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
