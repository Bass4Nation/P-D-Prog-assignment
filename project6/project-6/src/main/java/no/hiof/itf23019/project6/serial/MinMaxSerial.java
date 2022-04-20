package no.hiof.itf23019.project6.serial;

import java.util.Arrays;

public class MinMaxSerial {

    public int[] calculate(int[] arr){
        int min = 100_000_000;
        int max = 0;
        int[] arrMinMax = new int[2];

        for (int i = 0; i < arr.length; i++){
            if ( arr[i] > max){
                max = arr[i];
                arrMinMax[1] = arr[i];
            }
            if ( arr[i] < min){
                min = arr[i];
                arrMinMax[0] = arr[i];
            }
        }

        return arrMinMax;
    }
}
