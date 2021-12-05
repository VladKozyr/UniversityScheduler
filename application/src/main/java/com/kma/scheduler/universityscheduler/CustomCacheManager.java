package com.kma.scheduler.universityscheduler;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomCacheManager implements CacheManager {
    HashMap<String, Cache> cacheHashMap = Stream.of(
            new AbstractMap.SimpleEntry<>("student-cache", null))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    @Override
    public Cache getCache(String name) {
        System.out.println("Get cache");
        if (cacheHashMap.containsKey(name))
            return cacheHashMap.get(name);
        return null;
    }

    @Override
    public Collection<String> getCacheNames() {
        return cacheHashMap.keySet();
    }
}
