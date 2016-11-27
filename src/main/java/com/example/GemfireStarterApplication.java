package com.example;

import com.gemstone.gemfire.cache.Cache;
import com.gemstone.gemfire.cache.GemFireCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.support.GemfireCacheManager;

import java.util.Properties;

@SpringBootApplication
@EnableCaching
public class GemfireStarterApplication {

	@Bean
	Properties gemfireProperties() {
		Properties gemfireProperties = new Properties();
		gemfireProperties.setProperty("name", "DataGemFireCachingApplication");
		gemfireProperties.setProperty("mcast-port", "0");
		gemfireProperties.setProperty("log-level", "config");
		return gemfireProperties;
	}

	@Bean
	CacheFactoryBean gemfireCache() {
		CacheFactoryBean gemfireCache = new CacheFactoryBean();
		gemfireCache.setClose(true);
		gemfireCache.setProperties(gemfireProperties());
		return gemfireCache;
	}

	@Bean
	LocalRegionFactoryBean<Integer, Integer> cacheDataRegion(GemFireCache cache) {
		LocalRegionFactoryBean<Integer, Integer> cacheDataRegion = new LocalRegionFactoryBean<>();
        cacheDataRegion.setCache(cache);
        cacheDataRegion.setClose(false);
        cacheDataRegion.setName("CachedData");
        cacheDataRegion.setPersistent(false);
		return cacheDataRegion;
	}

	@Bean
	GemfireCacheManager cacheManager(Cache gemfireCache) {
		GemfireCacheManager cacheManager = new GemfireCacheManager();
		cacheManager.setCache(gemfireCache);
		return cacheManager;
	}

	public static void main(String[] args) {
		SpringApplication.run(GemfireStarterApplication.class, args);
	}
}
