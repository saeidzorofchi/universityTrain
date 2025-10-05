package com.zorofchi.universitytrain.service;


import com.zorofchi.universitytrain.model.Employee;
import com.zorofchi.universitytrain.repositoy.EmoloyeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmoloyeeRepository emoloyeeRepository;

    public Employee update(int id, Employee employeeRequest) {
        Employee employeeData = emoloyeeRepository.findById(id).get();
        if (employeeRequest.getFirstname() != null)
            employeeData.setFirstname(employeeRequest.getFirstname());
        if (employeeRequest.getLastname() != null)
            employeeData.setLastname(employeeRequest.getLastname());
        if (employeeRequest.getAge() != 0)
            employeeData.setAge(employeeRequest.getAge());
        if (employeeRequest.getGender() != null)
            employeeData.setGender(employeeRequest.getGender());
        if (employeeRequest.getAddress() != null)
            employeeData.setAddress(employeeRequest.getAddress());
        return emoloyeeRepository.save(employeeData);

    }

}
