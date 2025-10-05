package com.zorofchi.universitytrain.controller;


import com.zorofchi.universitytrain.model.Employee;
import com.zorofchi.universitytrain.model.Student;
import com.zorofchi.universitytrain.repositoy.EmoloyeeRepository;
import com.zorofchi.universitytrain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmoloyeeController {

    @Autowired
    EmoloyeeRepository emoloyeeRepository;

    @Autowired
    EmployeeService employeeService;


    @GetMapping
    public List<Employee> employees(){return emoloyeeRepository.findAll();}

    @GetMapping("{id}")
    public Employee employee(@PathVariable int id){return emoloyeeRepository.findById(id).get();}

    @PostMapping
    public Employee save(@RequestBody Employee employeeRequest){return emoloyeeRepository.save(employeeRequest);}

    @DeleteMapping("{id}")
    public void delete (@PathVariable int id){emoloyeeRepository.deleteById(id);}


    @PutMapping("{id}")
    public Employee update(@PathVariable("id") int id , @RequestBody Employee employeeRequest){
        return employeeService.update(id, employeeRequest);
    }

}
