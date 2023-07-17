package com.Jpa_playground.smy.cacheDemo;

import java.util.Collections;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;

@EnableCaching
@SpringBootApplication
public class CacheConfig {


    @Bean
    public CacheManager cacheManager() {

        Cache cache = new ConcurrentMapCache("byCompanyName");

        var manager = new SimpleCacheManager();
        manager.setCaches(Collections.singletonList(cache));

        return manager;
    }

}
