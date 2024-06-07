package com.jewan.learnspringframework.examples.c1;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// @Component
@Repository // 데이터와 통신
@Primary
public class MongoDbDataService implements DataService {

    @Override
    public int[] retrieveData() {
        return new int[] {11, 22, 33, 44, 55};
    }

}
