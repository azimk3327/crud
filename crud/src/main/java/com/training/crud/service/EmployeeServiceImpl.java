package com.training.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.crud.beans.EmployeeRequestBean;
import com.training.crud.beans.GenricResponse;
import com.training.crud.dao.EmployeeRepository;
import com.training.crud.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public GenricResponse createEmployee(EmployeeRequestBean employeeRequestBean) {
		GenricResponse response = new GenricResponse();

		EmployeeEntity entity = new EmployeeEntity();

		entity.setFirstName(employeeRequestBean.getFirstName());
		entity.setLastName(employeeRequestBean.getLastName());
		entity.setEmail(employeeRequestBean.getEmail());
		try {
			employeeRepository.save(entity);
			response.setStatus("SUCESS");
		} catch (Exception e) {
			response.setStatus("FAILURE");
			response.setReason(e.getMessage());
		}
		return response;
	}

	@Override
	public GenricResponse updateEmployee(EmployeeRequestBean employeeRequestBean) {
		GenricResponse response = new GenricResponse();
		Optional<EmployeeEntity> entityOp = employeeRepository.findById(employeeRequestBean.getEmpId());
		if (entityOp.isPresent()) {
			EmployeeEntity entity = entityOp.get();
			entity.setEmail(employeeRequestBean.getEmail());
			entity.setFirstName(employeeRequestBean.getFirstName());
			entity.setLastName(employeeRequestBean.getLastName());
			employeeRepository.save(entity);
			response.setStatus("SUCESS");
		} else {
			response.setStatus("FAILURE");
			response.setReason("error");
		}
		return response;
	}

	@Override
	public EmployeeEntity getEmployee(Long id) {
		Optional<EmployeeEntity> entityOp = employeeRepository.findById(id);
		if (entityOp.isPresent()) {
			EmployeeEntity entity = entityOp.get();
			return entity;
		}
		return null;
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {
		List<EmployeeEntity> list = employeeRepository.findAll();
		return list;
	}

	@Override
	public GenricResponse deleteEmployee(Long id) {
		GenricResponse response = new GenricResponse();
		if(employeeRepository.existsById(id)){
		employeeRepository.deleteById(id);
		response.setStatus("SUCESS");
		return response;
		}else {
		response.setStatus("FAILURE");
		response.setReason("incorrect id");
		return response;
		}
	}

}
