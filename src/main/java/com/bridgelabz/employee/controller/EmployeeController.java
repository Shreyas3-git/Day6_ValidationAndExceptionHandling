package com.bridgelabz.employee.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bridgelabz.employee.dto.EmployeeDTO;
import com.bridgelabz.employee.dto.ResponseDTO;
import com.bridgelabz.employee.model.EmployeeEntity;
import com.bridgelabz.employee.service.IEmployeeService;


@RestController

public class EmployeeController 
{
	@Autowired
	private IEmployeeService employeeService;
	

	@RequestMapping(value = "/retrive",method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO> getEmployeePayRollData()
	{
	
		List<EmployeeEntity> entity = employeeService.getEmployeePayRollData();
		ResponseDTO dto = new ResponseDTO("Data retrived successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/retrive/{id}",method = RequestMethod.GET)
	public ResponseEntity<ResponseDTO> getEmployeePayRollData(@PathVariable int id)
	{
		EmployeeEntity entity = employeeService.getEmployeePayRollData(id);
		ResponseDTO dto = new ResponseDTO("Data retrived successfully (: for id"+id,entity);
		return new ResponseEntity(dto,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/insert",method = RequestMethod.POST)

	public ResponseEntity<ResponseDTO> addEmployeePayRollData(@Valid @RequestBody EmployeeDTO employeeDTO)
	{
		EmployeeEntity entity = employeeService.addRecord(employeeDTO);
		ResponseDTO dto = new ResponseDTO("Record added successfully",entity);
		return new ResponseEntity(dto,HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
	public ResponseEntity<ResponseDTO> updateEmployeePayRollData(@Valid @RequestBody EmployeeDTO employeeDTO,@PathVariable int id)
	{
		EmployeeEntity entity = employeeService.updateRecord(id, employeeDTO);
		ResponseDTO dto = new ResponseDTO("Record updated successfully (: ",entity);
		return new ResponseEntity<ResponseDTO>(dto,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
	public ResponseEntity<ResponseDTO> deleteById(@PathVariable int id)
	{
		EmployeeEntity entity = employeeService.deleteRecord(id);
		ResponseDTO dto = new ResponseDTO("Record deleted successfully (:",entity);
		return new ResponseEntity(dto,HttpStatus.ACCEPTED);
	}
}
