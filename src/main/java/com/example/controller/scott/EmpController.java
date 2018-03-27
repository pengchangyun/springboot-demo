package com.example.controller.scott;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.scott.EmpEntity;
import com.example.service.scott.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;
	
	@RequestMapping("list")
	public List<EmpEntity> list(EmpEntity emp){
		return empService.list(emp);
	}
	
	@RequestMapping("/save")
	public EmpEntity save(EmpEntity emp) {
		empService.save(emp);
		return emp;
	}
}
