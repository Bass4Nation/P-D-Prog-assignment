package no.hiof.itf23019.project6.serial;

public class MinMaxSerial {

    public int[] calculate(int[] arr){
        int min = 100_000_000; // Min
        int max = 0; // Max
        int[] arrMinMax = new int[2]; // Return Integer array for calculate

        for (int i = 0; i < arr.length; i++){
//            Max
            if ( arr[i] > max){
                max = arr[i];
                arrMinMax[1] = arr[i];
            }
//            Min
            if ( arr[i] < min){
                min = arr[i];
                arrMinMax[0] = arr[i];
            }
        }

        return arrMinMax;
    }
}
