package com.example;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


/**
 * Created by nasruddin on 27/11/16.
 */
@Service
public class DataService {

    protected Map<Integer, DataModel> cacheData = new HashMap<>();

    @CachePut(cacheNames = "CachedData", key = "#result.id")
    public DataModel cacheData(int i, String data) {

        Random rand = new Random();
        int  n = rand.nextInt(50) + 1;

        cacheData.put(i, new DataModel(n, data));
        return cacheData.get(i);

    }

    @Cacheable("CachedData")
    public DataModel getData(int i) {
        DataModel dataModel = cacheData.get(i);
        return dataModel;
    }

}
