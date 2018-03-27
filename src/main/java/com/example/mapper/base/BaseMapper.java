package com.example.mapper.base;

import java.util.List;

public interface BaseMapper<T> {
	void save(T t);
	
	void delete(T t);
	
	List<T> list();
	
	T saveOrUpdate(T t);
}
