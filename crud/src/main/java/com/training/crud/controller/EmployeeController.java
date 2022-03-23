package com.training.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.crud.beans.EmployeeRequestBean;
import com.training.crud.beans.GenricResponse;
import com.training.crud.entity.EmployeeEntity;
import com.training.crud.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	@PostMapping("/create")
	public GenricResponse createEmployee(@RequestBody EmployeeRequestBean employeeRequestBean) {
		GenricResponse response=employeeService.createEmployee(employeeRequestBean);
		return response;
	}
	
	@PutMapping("/update")
	public GenricResponse updateEmployee(@RequestBody EmployeeRequestBean employeeRequestBean) {
		GenricResponse response=employeeService.updateEmployee(employeeRequestBean);
		return response;
	}
	
	@GetMapping("/get")
	public EmployeeEntity updateEmployee(@RequestParam Long id) {
		EmployeeEntity response=employeeService.getEmployee(id);
		return response;
	}
	
	@GetMapping("/getall")
	public List<EmployeeEntity> updateEmployee() {
		List<EmployeeEntity> response=employeeService.getAllEmployee();
		return response;
	}
	
	@DeleteMapping("/delete")
	public GenricResponse deleteEmployee(@RequestParam Long id) {
		GenricResponse response=employeeService.deleteEmployee(id);
		return response;
	}

}
