package com.example.mapper.scott;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.example.entity.scott.EmpEntity;
import com.example.mapper.base.BaseMapper;

@CacheConfig(cacheNames = "emp")
public interface EmpMapper extends BaseMapper<EmpEntity>{
	
	@Cacheable
	List<EmpEntity> list(EmpEntity emp);
	
	@CacheEvict(allEntries = true)
	void save(EmpEntity t);
}
