package Prog_III_2023.tp_02.ej_03;

import Prog_III_2023.tp_02.SortingAlgorithms.SortingAlgorithm;
import Prog_III_2023.util.Timer;

import java.util.Arrays;

public class TimeComplexityTest {

    private Timer timer;

    public TimeComplexityTest() {
        this.timer = new Timer();
    }

    private int[] getRandomNumbersArray(int n) {
        int[] tmp = new int[n];
        for (int i = 0; i < tmp.length; i++) {
            int randomNumber = (int) (Math.random()*100+1);
            tmp[i] = randomNumber;
        }
        return tmp;
    }

    private void print(int[] arr) {
        String st = "[ ";
        for(int el: arr) st += " " + el;
        System.out.println(st + " ]");
    }

    public double run(SortingAlgorithm sortingAlgorithm, int n) {
        int[] arr;
        timer.start();
        for (int i = 0; i <= 10000; i++) {
            arr = this.getRandomNumbersArray(n);
            sortingAlgorithm.sort(arr);

//            print(arr);

        }
        return timer.stop();
    }

    public double runArraysSort(int n) {
        int[] arr;
        timer.start();
        for (int i = 0; i <= 10000; i++) {
            arr = this.getRandomNumbersArray(n);
            Arrays.sort(arr);

//            print(arr);

        }
        return timer.stop();
    }

}
