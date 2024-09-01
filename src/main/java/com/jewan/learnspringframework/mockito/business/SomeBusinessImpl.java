package com.jewan.learnspringframework.mockito.business;

public class SomeBusinessImpl {

    private DataService dataService;

    public SomeBusinessImpl(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findTheGreatestFromAllData() {
        int[] data = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int value : data) {
            greatestValue = Math.max(greatestValue, value);
        }
        return greatestValue;
    }
}

interface DataService {
    int[] retrieveAllData();
}