package com.kma.scheduler.universityscheduler;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomCacheManager implements CacheManager {
    ConcurrentMapCache cacheHashMap = new ConcurrentMapCache("student-cache");

    @Override
    public Cache getCache(String name) {
        System.out.println("Get cache");

        return (Cache) cacheHashMap.get(name);
    }

    @Override
    public Collection<String> getCacheNames() {
        return Set.of("student-cache");
    }
}
