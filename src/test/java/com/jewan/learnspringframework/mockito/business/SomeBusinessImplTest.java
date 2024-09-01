package com.jewan.learnspringframework.mockito.business;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SomeBusinessImplTest {

    @Test
    void findTheGreatestFromAllData_basic() {
        DataServiceStub dataServiceStub = new DataServiceStub();
        SomeBusinessImpl businessImpl = new SomeBusinessImpl(dataServiceStub);
        int result = businessImpl.findTheGreatestFromAllData();
        assertEquals(25, result);
    }

}

class DataServiceStub implements DataService { // Stub 데이터 생성 -> 유지 보수가 어려움

    @Override
    public int[] retrieveAllData() {
        return new int[] { 25, 15, 5 };
    }
}