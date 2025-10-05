package com.zorofchi.universitytrain.controller;

import com.zorofchi.universitytrain.model.Student;
import com.zorofchi.universitytrain.repositoy.CourseRepository;
import com.zorofchi.universitytrain.repositoy.StudentRepository;
import com.zorofchi.universitytrain.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/student")
@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @Autowired
    StudentService studentService;


    @GetMapping
    public List<Student> students() {
        return studentRepository.findAll();
    }


    @GetMapping("{id}")
    public Student student(@PathVariable("id") int id) {
        return studentRepository.findById(id).get();
    }


    @PostMapping
    public Student save(@RequestBody Student studentReguest) {
        return studentRepository.save(studentReguest);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") int id) {
        studentRepository.deleteById(id);
    }


    @PutMapping("/{id}")
    public Student update(@PathVariable(value = "id") int id, @RequestBody Student studentRequest) {
        return studentService.update(id, studentRequest);
    }


    @PutMapping("/{studentId}/{courseId}")
    public Student addCourse(
            @PathVariable(value = "studentId") int studentId,
            @PathVariable(value = "courseId") int courseId) {
        Student student = studentRepository.findById(studentId).get();
        student.addCourse(courseRepository.findById(courseId).get());
        studentRepository.save(student);
        return student;
    }


}
