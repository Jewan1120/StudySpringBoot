package com.jewan.learnspringframework.examples.c1;

import java.util.Arrays;
import org.springframework.stereotype.Component;

@Component
public class BusinessCalculationService {

    private DataService dataService; // 이걸 사용하려면 의존성을 주입해줘야함.

    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
