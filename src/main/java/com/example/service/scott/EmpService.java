package com.example.service.scott;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.scott.EmpEntity;
import com.example.mapper.scott.EmpMapper;
import com.github.pagehelper.PageHelper;

@Service
public class EmpService {

	@Autowired
	private EmpMapper empMapper;

	@Transactional
	public void save(EmpEntity t) {
		empMapper.save(t);
	}

	public void delete(EmpEntity t) {
		empMapper.delete(t);
	}

	public List<EmpEntity> list(EmpEntity emp){
		//设置分页参数,只需设置分页参数便可自动
		PageHelper.startPage(emp.getPageNum(), emp.getPageSize());
		return empMapper.list(emp);
	}

	@Transactional
	public EmpEntity saveOrUpdate(EmpEntity t) {
		empMapper.saveOrUpdate(t);
		return t;
	}
}
