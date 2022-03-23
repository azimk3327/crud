package com.training.crud.service;

import java.util.List;

import com.training.crud.beans.EmployeeRequestBean;
import com.training.crud.beans.GenricResponse;
import com.training.crud.entity.EmployeeEntity;

public interface EmployeeService {

	GenricResponse createEmployee(EmployeeRequestBean employeeRequestBean);

	GenricResponse updateEmployee(EmployeeRequestBean employeeRequestBean);

	EmployeeEntity getEmployee(Long id);

	List<EmployeeEntity> getAllEmployee();

	GenricResponse deleteEmployee(Long id);

}
