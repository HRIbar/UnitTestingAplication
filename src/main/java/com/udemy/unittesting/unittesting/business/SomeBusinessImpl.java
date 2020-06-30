package com.udemy.unittesting.unittesting.business;

import com.udemy.unittesting.unittesting.data.SomeDataService;

import java.util.Arrays;
import java.util.OptionalInt;

public class SomeBusinessImpl {

    private SomeDataService someDataService;

    public void setSomeDataService(SomeDataService someDataService){
        this.someDataService = someDataService;
    }

    /*
    public int calculateSum(int[] data) {
    int sum = 0;
    for(int value:data) {
        sum += value;}
        return sum;
    }

    public int calculateSumUsingDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAllData();
        for(int value:data) {
            sum += value;}
        return sum;
    }
    */
    public int calculateSum(int[] data) {
        return Arrays.stream(data).reduce(Integer::sum).orElse(0);
    }

    public int calculateSumUsingDataService() {
        return Arrays.stream(someDataService.retrieveAllData()).reduce(Integer::sum).orElse(0);
    }


}

