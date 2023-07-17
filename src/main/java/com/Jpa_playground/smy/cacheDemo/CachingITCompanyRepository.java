package com.Jpa_playground.smy.cacheDemo;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;

public interface CachingITCompanyRepository extends CrudRepository<ITCompany, Long> {

    @Override
    @CacheEvict(value = "byCompanyName", key = "#p0.companyname")
    <S extends ITCompany> S save(S entity);

    @Cacheable("byCompanyName")
    ITCompany findByCompanyName(String companyName);
}
