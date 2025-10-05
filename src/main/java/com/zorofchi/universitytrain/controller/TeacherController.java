package com.zorofchi.universitytrain.controller;


import com.zorofchi.universitytrain.model.Student;
import com.zorofchi.universitytrain.model.Teacher;
import com.zorofchi.universitytrain.repositoy.StudentRepository;
import com.zorofchi.universitytrain.repositoy.TeacherRepository;
import com.zorofchi.universitytrain.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    TeacherRepository teacherRepository;

    TeacherService teacherService;


    @GetMapping
    public List<Teacher> teachers() {
        return teacherRepository.findAll();
    }


    @GetMapping("{id}")
    public Teacher teacher(@PathVariable("id") int id) {
        return teacherRepository.findById(id).get();
    }


    @PostMapping
    public Teacher save(@RequestBody Teacher TeacherReguest) {
        return teacherRepository.save(TeacherReguest);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        teacherRepository.deleteById(id);
    }


    @PutMapping("{id}")
    public Teacher update(@PathVariable(value = "id") int id, @RequestBody Teacher teacherReguest) {
        return teacherService.update(id, teacherReguest);
    }

}
