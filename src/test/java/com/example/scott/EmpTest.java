package com.example.scott;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.scott.EmpEntity;
import com.example.service.scott.EmpService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpTest {

	@Autowired
	private EmpService empService;
	
	@Test
	public void saveEmp() {
		EmpEntity emp = new EmpEntity();
		emp.setEname("pcy");
		emp.setComm(600f);
		emp.setEmpno(1001);
		emp.setSal(12000f);
		emp.setJob("it");
		emp.setMgr(6666);
		emp.setHiredate(new Date());
		empService.save(emp);
	}
}
